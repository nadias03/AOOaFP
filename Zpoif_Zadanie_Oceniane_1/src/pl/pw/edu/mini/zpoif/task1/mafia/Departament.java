package pl.pw.edu.mini.zpoif.task1.mafia;

import pl.pw.edu.mini.zpoif.task1.mafia.worker.MafiaWorker;
import pl.pw.edu.mini.zpoif.task1.mafia.worker.Sprzedawca;

public abstract class Departament extends MafiaOrganization {
    protected  KolorSciany kolorSciany;
    public enum KolorSciany {
        ZIELONY, NIEBIESKI, BIALY, CZERWONY;
    }

    public abstract void internalControl();

    protected class SprzedawcaLegalny extends Sprzedawca {
        @Override
        protected void makeDeal() {
            System.out.println("legalna transakcja dokonana");
            this.transactionSummary += (2 * VALUE_OF_SINGLE_LEGAL_TRANSACTION);
        }
    }

    protected class Kontroler extends MafiaWorker {
        public void check() {
            if (kolorSciany == KolorSciany.ZIELONY) {
                System.out.println("Nie trzeba kontrolowac!");
            } else {
                System.out.println("Kontroluje");
            }
        }
    }
}
