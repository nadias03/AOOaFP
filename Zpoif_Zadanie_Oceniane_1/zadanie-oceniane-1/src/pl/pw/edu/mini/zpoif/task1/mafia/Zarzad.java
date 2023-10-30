package pl.pw.edu.mini.zpoif.task1.mafia;

import pl.pw.edu.mini.zpoif.task1.mafia.worker.MafiaWorker;

public class Zarzad extends MafiaOrganization {
    private boolean czyPosiadaOjcaChrzestnego;

    public Zarzad() {
        this.czyPosiadaOjcaChrzestnego = random.nextBoolean();
    }

    @Override
    public void work() {
        OjciecChrzestny ojciecChrzestny = new OjciecChrzestny();
        double rand = random.nextDouble();
        if (rand < 0.4) {
            ojciecChrzestny.bless();
        }
    }

    private static class OjciecChrzestny extends MafiaWorker {
        public void bless() {
            System.out.println("Popieram!");
        }
    }
}
