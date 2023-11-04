package ammunition_types;

import ammunition_types.random_supplier.RandomSupplier;

public class Bullet extends Ammunition {
    private int id;
    private static int counter = 0;
    private Calibre calibre;

    public Bullet() {
        counter += 1;
        this.id = counter;
        this.calibre = RandomSupplier.provideRandomCaliberGenerator().get();
    }

    public Calibre getCalibre() {
        return calibre;
    }

    public void setCalibre(Calibre calibre) {
        this.calibre = calibre;
    }


}
