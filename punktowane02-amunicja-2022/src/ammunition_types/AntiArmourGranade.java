package ammunition_types;

import ammunition_types.random_supplier.RandomSupplier;

public class AntiArmourGranade extends Grenade {
    private int co2Emission;

    public AntiArmourGranade() {
        this.co2Emission = RandomSupplier.provideRandomCO2EmissionGenerator(220, 250);
    }

    public int getCo2Emission() {
        return co2Emission;
    }
}
