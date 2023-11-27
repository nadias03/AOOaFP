package pl.edu.pw.mini.zpoif.task5.machine;

import pl.edu.pw.mini.zpoif.task5.machine.exceptions.MafiaException;
import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.people.special.*;
import pl.edu.pw.mini.zpoif.task5.solution.*;

import java.lang.reflect.*;
import java.util.*;

import static java.lang.Math.max;

public class MyMafiaMachine extends MafiaMachine {

    private List<Class<?>> mafiaWorkersClasses;

    public MyMafiaMachine() {
        mafiaWorkersClasses = List.of(Accountant.class, ButtonMan.class, Controller.class, GodFather.class, Recruiter.class, Spy.class);
    }


    @Override
    protected Set<MafiaWorker> createImportantMafiaWorkers() {
        Set<MafiaWorker> importantWorkers = new HashSet<>();

        for (Class<?> clazz : mafiaWorkersClasses) {
            if (clazz.isAnnotationPresent(ImportantWorker.class)) {
                ImportantWorker annotation = clazz.getAnnotation(ImportantWorker.class);

                if (annotation.quantity() > 1) {
                    try {
                        for (int i = 0; i < annotation.quantity(); i++) {
                            importantWorkers.add((MafiaWorker) clazz.getDeclaredConstructor().newInstance());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return importantWorkers;
    }

    @Override
    protected MafiaWorker createPrimaryMafiaWorker() {
        List<MafiaWorker> mafiaWorkers = new ArrayList<>();

        for (Class<?> clazz : mafiaWorkersClasses) {
            if (clazz.isAnnotationPresent(PrimaryMafiaWorker.class)) {
                try {
                    MafiaWorker mafiaWorkerInstance = (MafiaWorker) clazz.getDeclaredConstructor().newInstance();
                    mafiaWorkers.add(mafiaWorkerInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (mafiaWorkers.size() == 0) {
            return null;
        } else {
            return mafiaWorkers.get(new Random().nextInt(mafiaWorkers.size()));
        }
    }

    @Override
    protected MafiaWorker createPrioritizedPrimaryMafiaWorker() {
        List<Class<?>> primaryClasses = new ArrayList<>();

        for (Class<?> clazz : mafiaWorkersClasses) {
            if (clazz.isAnnotationPresent(PrimaryMafiaWorker.class)) {
                primaryClasses.add(clazz);
            }
        }

        if (primaryClasses.size() > 1) {
            int maxPriority = 0;

            for (Class<?> clazz : primaryClasses) {
                PrimaryMafiaWorker annotaion = clazz.getAnnotation(PrimaryMafiaWorker.class);
                maxPriority = max(maxPriority, annotaion.priority());
            }

            for (Class<?> clazz : primaryClasses) {
                PrimaryMafiaWorker annotaion = clazz.getAnnotation(PrimaryMafiaWorker.class);

                if (annotaion.priority() == maxPriority) {
                    try {
                        MafiaWorker mafiaWorkerInstance = (MafiaWorker) clazz.getDeclaredConstructor().newInstance();
                        return mafiaWorkerInstance;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    @Override
    protected void encryptFields(Set<MafiaWorker> workers) {
        for (MafiaWorker mafiaWorker : workers) {
            Class<?> clazz = mafiaWorker.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                if (field.getType() == String.class && field.isAnnotationPresent(FillIfEmptyIt.class)) {
                    field.setAccessible(true);

                    try {
                        field.setAccessible(true);
                        String value = (String) field.get(clazz);
                        if (value != null) {
                            String generatedString = Base64.getEncoder().encodeToString(value.getBytes());
                            field.set(clazz, generatedString);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    protected ButtonMan getKiller(String name, String surname) throws MafiaException {
        try {
            Constructor<ButtonMan> constructor = ButtonMan.class.getDeclaredConstructor(String.class, String.class);
            Parameter[] parameters = constructor.getParameters();

            for (Parameter parameter : parameters) {
                if (parameter.isAnnotationPresent(MafiaValidator.class) && parameter.getName().equals("name")) {
                    MafiaValidator validator = parameter.getAnnotation(MafiaValidator.class);
                    if (validator.notEmpty() && (name == null || name.isEmpty())) {
                        throw new MafiaException("Imie nie moze byc nullem :))");
                    }
                    if (name.length() > validator.maxLength()) {
                        throw new MafiaException("Za dlugie imie");
                    }
                }
            }

            return constructor.newInstance(name, surname);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new MafiaException("Error: " + e.getMessage());
        }
    }

    @Override
    protected void init(MafiaWorker mafiaWorker) {
        for (Class<?> mafiaWorkerClass : mafiaWorkersClasses) {
            Field[] fields = mafiaWorkerClass.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(InitMe.class)) {
                    field.setAccessible(true);

                    try {
                        Class<?> fieldType = field.getType();
                        Constructor<?>[] constructors = fieldType.getDeclaredConstructors();
                        Constructor<?> constructor = constructors[0];

                        Object localInstance = constructor.newInstance();
                        field.set(mafiaWorker, localInstance);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    protected void goButtonMan(Set<MafiaWorker> buttonMan) {
        for (MafiaWorker worker : buttonMan) {
            if (worker instanceof ButtonMan) {
                Method[] methods = worker.getClass().getDeclaredMethods();

                for (Method method : methods) {
                    if (method.isAnnotationPresent(DoIt.class)) {
                        DoIt annotation = method.getAnnotation(DoIt.class);
                        int timesToInvoke = annotation.times();

                        for (int i = 0; i < timesToInvoke; i++) {
                            String victimFieldName = findVictimFieldName(worker.getClass());
                            if (victimFieldName != null) {
                                try {
                                    Field victimField = worker.getClass().getDeclaredField(victimFieldName);
                                    victimField.setAccessible(true);
                                    String victim = (String) victimField.get(worker);

                                    method.invoke(worker, victim);
                                } catch (NoSuchFieldException | IllegalAccessException | InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private String findVictimFieldName(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == String.class && field.getName().endsWith("victim")) {
                return field.getName();
            }
        }
        return null;
    }

    @Override
    protected void retreat(ButtonMan buttonMan) {

    }
}
