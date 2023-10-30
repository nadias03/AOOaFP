package pl.pw.edu.mini.zpoif.task1.mafia;

public class DepartamentHandlowy extends Departament {
    private int iloscPieniedzy;

    public DepartamentHandlowy() {
        double randKolor = random.nextDouble();
        if (randKolor < 0.5) {
            this.kolorSciany = KolorSciany.ZIELONY;
        } else {
            this.kolorSciany = KolorSciany.NIEBIESKI;
        }
        this.iloscPieniedzy = random.nextInt(100000, 550001);
    }

    @Override
    public void work() {
        double rand = random.nextDouble();
        if (rand < 0.9) {
            SprzedawcaLegalny sprzedawcaLegalny = new SprzedawcaLegalny();
            sprzedawcaLegalny.makeDeal();
        } else {
            System.out.println("Dealu nie bedzie!");
        }
    }

    @Override
    public void internalControl() {
        Kontroler kontroler = new Kontroler();
        kontroler.check();
    }
}
