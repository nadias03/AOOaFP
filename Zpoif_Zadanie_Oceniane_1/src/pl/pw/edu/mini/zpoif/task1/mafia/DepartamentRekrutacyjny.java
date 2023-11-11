package pl.pw.edu.mini.zpoif.task1.mafia;

import pl.pw.edu.mini.zpoif.task1.mafia.worker.MafiaWorker;

import java.util.ArrayList;
import java.util.List;

public class DepartamentRekrutacyjny extends Departament {
    private final int limitDzienny = 5;

    public DepartamentRekrutacyjny() {
        this.kolorSciany = KolorSciany.BIALY;
    }

    @Override
    public void work() {
        class Rekruter extends MafiaWorker {
            public void recruit() {
                double rand = random.nextDouble();
                if (rand < 0.5) {
                    System.out.println("Zrekrutowalem!");
                } else {
                    System.out.println("Porazka! :(");
                }
            }
        }

        // stworzenie rekruterow
        List<Rekruter> rekruterzy = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Rekruter rekruter = new Rekruter();
            rekruterzy.add(rekruter);
        }

        // wywolanie metody recruit() na wszystkich stworzonych rekruterach
        for (Rekruter rekruter : rekruterzy) {
            rekruter.recruit();
        }
    }

    @Override
    public void internalControl() {
        Kontroler kontroler = new Kontroler();
        kontroler.check();
    }
}
