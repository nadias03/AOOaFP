import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

//        @SuppressWarnings("unused")
//        Cat myCat = new Cat("Stella");

        Cat myCat = new Cat("Stella");
        Random random = new Random();

        if (random.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("This thing is very important");
        } else {
            System.out.println("This thing is not very important");
        }

        for (Method method : myCat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {   // wywolujemy tylko ta metody ktora ma adnotacje RunImmediately
                method.setAccessible(true);
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);

                for (int i = 0; i < annotation.times(); i++) {
                    method.invoke(myCat);
                }
            }
        }

        for (Field field : myCat.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ImportantString.class)) {
                Object objectValue = field.get(myCat);

                if (objectValue instanceof String stringValue) {  // zcastuje do stringa i zapisze pod zmienna stringValue
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }
    }
}