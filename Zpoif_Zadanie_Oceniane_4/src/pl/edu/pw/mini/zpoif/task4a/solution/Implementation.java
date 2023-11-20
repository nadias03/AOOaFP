package pl.edu.pw.mini.zpoif.task4a.solution;

import pl.edu.pw.mini.zpoif.task4a.Generator;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.Szybowiec;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.Wywietrznik;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.uchwyt.Uchwyt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;
import java.util.Random;


public class Implementation {

    private Szybowiec szybowiec;

    public Implementation() {
        this.szybowiec = Generator.utworzPuchacza();
    }

    // 1
    public Wywietrznik task1() throws Exception {
        Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.Wywietrznik");
        Constructor[] constructors = klasa.getDeclaredConstructors();
        if (constructors.length == 1) {
            for (Constructor constructor : constructors) {
                if (constructor.getParameterCount() == 1) {
                    Wywietrznik wywietrznik = (Wywietrznik) klasa.newInstance();
                    return wywietrznik;
                }
            }
        }
        return null;
    }

    // 2
    public void task2() throws Exception {
        Field kabinaPole = szybowiec.getClass().getSuperclass().getDeclaredField("kabinaPierwsza");
        kabinaPole.setAccessible(true);
        Field tablicaPrzyrzadowPole = kabinaPole.getClass().getDeclaredField("tablicaPrzyrzadow");
        tablicaPrzyrzadowPole.setAccessible(true);
        Field wysokosciomierzPole = tablicaPrzyrzadowPole.getClass().getDeclaredField("wysokosciomierz");
        wysokosciomierzPole.setAccessible(true);
        Field qnhPole = wysokosciomierzPole.getClass().getDeclaredField("qnh");
        qnhPole.setAccessible(true);
        if (Integer.valueOf(0).equals(qnhPole.get(wysokosciomierzPole))) {
            Method metoda = wysokosciomierzPole.getClass().getDeclaredMethod("setQNH");
            metoda.setAccessible(true);
            metoda.invoke(wysokosciomierzPole, 1013);
        }
    }

    // 3
    public void task3() throws Exception {
        Field kabinaPole = szybowiec.getClass().getDeclaredField("kabinaPierwsza");
        kabinaPole.setAccessible(true);

        // aktualna wartosc
        Field uchwytPole = kabinaPole.getType().getDeclaredField("uchwytHamulcaKola");
        uchwytPole.setAccessible(true);
        Field hamulecKolaPole = uchwytPole.getType().getDeclaredField("hamulecKola");
        hamulecKolaPole.setAccessible(true);

        // nowa wartosc
        Class<?> nadklasa = hamulecKolaPole.getType().getSuperclass();
        Object nowyHamulecKolaObiekt = nadklasa.newInstance();

        // zmiana
        hamulecKolaPole.set(uchwytPole.get(kabinaPole.get(szybowiec)), nowyHamulecKolaObiekt);
    }

    // 4
    public void task4() throws Exception {
        Field kabinaPole = szybowiec.getClass().getDeclaredField("kabinaDruga");
        kabinaPole.setAccessible(true);
        Object kabinaObiekt = kabinaPole.get(szybowiec);
        Field[] fields = kabinaObiekt.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            if (Uchwyt.class.isAssignableFrom(field.getType())) {
                Field kolorPole = field.getType().getDeclaredField("kolorUchwytu");
                kolorPole.setAccessible(true);
                Uchwyt.Kolor kolorUchwytu = (Uchwyt.Kolor) kolorPole.get(field.get(kabinaObiekt));
                if (kolorUchwytu == Uchwyt.Kolor.ZOLTY) {
                    System.out.println(field.getName());
                }
            }
        }
    }

    // 5
    public void task5() throws Exception {
        Field kabinaPole = szybowiec.getClass().getSuperclass().getDeclaredField("kabinaPierwsza");
        kabinaPole.setAccessible(true);

        // aktualne motto ucznia
        Field uczenPole = kabinaPole.getType().getDeclaredField("pilot");
        uczenPole.setAccessible(true);
        Field mottoPole = uczenPole.getType().getDeclaredField("motto");
        mottoPole.setAccessible(true);

        // napis w tablicy przyrzadow
        Field tablicaPrzyrzadowPole = kabinaPole.getType().getDeclaredField("tablicaPrzyrzadow");
        tablicaPrzyrzadowPole.setAccessible(true);
        Field napisPole = tablicaPrzyrzadowPole.getType().getDeclaredField("napis");
        napisPole.setAccessible(true);
        Object napisWartosc = napisPole.get(kabinaPole.get(szybowiec));

        // zmiana
        mottoPole.set(uczenPole.get(kabinaPole.get(szybowiec)), napisWartosc);
    }

    // 6
    public void task6() throws Exception {
        Field kabinaPole = szybowiec.getClass().getDeclaredField("kabinaPierwsza");
        kabinaPole.setAccessible(true);
        Field uczenPole = kabinaPole.getType().getDeclaredField("pilot");
        uczenPole.setAccessible(true);

        if (Modifier.isAbstract(uczenPole.getType().getModifiers())) {
            Class klasaUczen = Class.forName("pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.inne.Uczen");
            Object uczenObiekt = klasaUczen.getDeclaredConstructor().newInstance();

            Field imiePole = klasaUczen.getDeclaredField("imie");
            imiePole.setAccessible(true);
            imiePole.set(uczenObiekt, "Ala");

            Field nazwiskoPole = klasaUczen.getDeclaredField("nazwisko");
            nazwiskoPole.setAccessible(true);
            nazwiskoPole.set(uczenObiekt, "Makota");

            Field mottoPole = klasaUczen.getDeclaredField("prywatneMotto");
            mottoPole.setAccessible(true);
            mottoPole.set(uczenObiekt, "zawsze mogło byc gorzej");

            Field licznikPole = klasaUczen.getDeclaredField("licznikLotowSamodzielnych");
            licznikPole.setAccessible(true);
            licznikPole.set(uczenObiekt, 59);

            // zmiana
            uczenPole.set(kabinaPole.get(szybowiec), uczenObiekt);
        }
    }

    // 7
    public void task7() throws Exception {
        Field kabinaPole = szybowiec.getClass().getDeclaredField("kabinaPierwsza");
        kabinaPole.setAccessible(true);
        Field uchwytPole = kabinaPole.getType().getDeclaredField("uchwytHamulcaKola");
        uchwytPole.setAccessible(true);
        Field hamulecKolaPole = uchwytPole.getType().getDeclaredField("hamulecKola");
        hamulecKolaPole.setAccessible(true);

        Class klasa = hamulecKolaPole.getType();
        int maxLiczbaMetod = 0;
        Class klasaMaxMetod = klasa;

        while (klasa != null) {
            int liczbaMetod = 0;
            for (Method method : klasa.getDeclaredMethods()) {
                if (Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers())) {
                    liczbaMetod++;
                }
            }

            if (liczbaMetod >= maxLiczbaMetod) {
                maxLiczbaMetod = liczbaMetod;
                klasaMaxMetod = klasa;
            }
            klasa = klasa.getSuperclass();
        }

        if (klasaMaxMetod != null) {
            System.out.println(klasaMaxMetod.getSimpleName());
        }
    }

    // 8
    public void task8() throws Exception {
        Field kabinaPole = szybowiec.getClass().getDeclaredField("kabinaDruga");
        kabinaPole.setAccessible(true);
        Field instruktorPole = kabinaPole.getClass().getSuperclass().getDeclaredField("pilot");
        instruktorPole.setAccessible(true);
        Method[] methodsInstruktor = instruktorPole.getClass().getDeclaredMethods();

        for (Method method : methodsInstruktor) {
            if (method.getDeclaringClass() != instruktorPole.getClass()) {
                Class[] klasyParametrow = method.getParameterTypes();
                if (klasyParametrow.length == 1 && klasyParametrow[0].equals(Boolean.class)) {
                    method.invoke(instruktorPole.get(kabinaPole.get(szybowiec)), new Random().nextBoolean());
                }
            }
        }
    }

    // 9
    public void task9() throws Exception {

    }

}
