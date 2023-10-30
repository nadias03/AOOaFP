package pl.pw.edu.mini.zpoif.task1.mafia;

import pl.pw.edu.mini.zpoif.task1.mafia.worker.MafiaWorker;
import pl.pw.edu.mini.zpoif.task1.mafia.worker.Sprzedawca;

import java.util.ArrayList;

public class DepartamentOperacjiSpecjalnych extends Departament {
    private int illegalTransactionValue;

    public DepartamentOperacjiSpecjalnych() {
        this.kolorSciany = KolorSciany.CZERWONY;
        this.illegalTransactionValue = random.nextInt(10, 21);
    }

    @Override
    public void work() {
        class CzowiekOdMokrejRoboty extends MafiaWorker {
            public void doJob() {
                System.out.println("Wykonuje mokra robote!");
            }
        }

        // dodanie 3 obiektow CzowiekOdMokrejRoboty do listy
        ArrayList<CzowiekOdMokrejRoboty> ludzieOdMokrejRoboty = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            CzowiekOdMokrejRoboty czowiekOdMokrejRoboty = new CzowiekOdMokrejRoboty();
            ludzieOdMokrejRoboty.add(czowiekOdMokrejRoboty);
        }

        // wybor losowego CzowiekOdMokrejRoboty z listy i wywolanie na nim metody
        int randIndex = random.nextInt(ludzieOdMokrejRoboty.size());
        CzowiekOdMokrejRoboty losowyCzlowiekOdMokrejRoboty = ludzieOdMokrejRoboty.get(randIndex);
        losowyCzlowiekOdMokrejRoboty.doJob();

    }

    @Override
    public void internalControl() {
        System.out.println("Kontrolaniejestmożliwa.");
    }

    class SprzedawcaNielegalny extends Sprzedawca {
        @Override
        protected void makeDeal() {
            System.out.println("nielegalna transakcja dokonana");
            this.transactionSummary += illegalTransactionValue;
        }
    }
}
