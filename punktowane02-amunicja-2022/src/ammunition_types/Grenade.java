package ammunition_types;

import ammunition_types.random_supplier.RandomSupplier;

public class Grenade extends Ammunition {
    protected int id;
    private static int counter = 0;
    protected boolean secured;

    public Grenade() {
        counter += 1;
        this.id = counter;
        this.secured = RandomSupplier.provideRandomSafeGenerator(false);
    }

    public boolean isSecured() {
        return secured;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }
}
