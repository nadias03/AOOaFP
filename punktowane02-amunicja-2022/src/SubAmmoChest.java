import ammunition_types.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SubAmmoChest extends AmmoChest {

    public void upgradeCaliber(Calibre newCaliber) {
        ammunitionChest.forEach((ammo) -> {
            if (ammo instanceof Bullet) {
                if (((Bullet) ammo).getCalibre().getCalibreValue() < 5.56) {
                    ((Bullet) ammo).setCalibre(newCaliber);
                }
            }
        });
    }

    public void replaceLocked4All() {
        boolean newSecured = random.nextBoolean();
        ammunitionChest.forEach((ammo) -> {
            if (ammo instanceof Grenade) {
                ((Grenade) ammo).setSecured(newSecured);
            }
        });
    }

    public void getSummarizedCO2Emission() {
        AtomicInteger allEmissions = new AtomicInteger();
        ammunitionChest.forEach((ammo) -> {
            if (ammo instanceof AntiArmourGranade) {
                allEmissions.addAndGet(((AntiArmourGranade) ammo).getCo2Emission());
            }
        });
        System.out.println("Total CO2 emission is " + allEmissions);
    }

    @FunctionalInterface
    public interface MyAmmoGetter {
        Ammunition getGeneralAmmoByIndex(int index);
    }

    public MyAmmoGetter createMyAmmoGetter() {
        return this::getAmmunition;
    }

    private Ammunition getAmmunition(int index) {
        if (index > 0 & index < ammunitionChest.size()) {
            // konwersja hash seta na liste
            List<Ammunition> list = new ArrayList<>(ammunitionChest);
            return list.get(index);
        } else {
            throw new ArrayIndexOutOfBoundsException("Errrrrrrrorrrrrrr");
        }
    }

}
