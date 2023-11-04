import ammunition_types.*;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class AmmoChest {
    protected HashSet <Ammunition> ammunitionChest;
    final static Random random = new Random();

    public AmmoChest() {
        this.ammunitionChest = new HashSet<>();

        // 20 granades each type
        for (int i = 0; i < 20; i++) {
            this.ammunitionChest.add(new Grenade());
            this.ammunitionChest.add(new AntiArmourGranade());
            this.ammunitionChest.add(new AggresiveGranade());
        }

        // 2000 bullets
        for (int i = 0; i < 2000; i++) {
            this.ammunitionChest.add(new Bullet());
        }
    }

    public HashSet<Ammunition> getEcoArmourPiercingGrenades() {
        HashSet<Ammunition> result = new HashSet<>();
        Consumer<Ammunition> lambda = (ammo) -> {
            if (ammo instanceof AntiArmourGranade) {
                if (((AntiArmourGranade) ammo).getCo2Emission() <= 225) {
                    result.add(ammo);
                }
            }
        };
        ammunitionChest.forEach(lambda);
        return result;
    }

    public void findUnlockedGrenades() {
        Consumer<Ammunition> lambda = (ammo) -> {
            if (ammo instanceof DefensiveGranade | ammo instanceof AggresiveGranade) {
                if (!((Grenade) ammo).isSecured()) {
                    System.out.println("Beware!");
                }
            }
        };
        ammunitionChest.forEach(lambda);
    }

    public void getSummarizedCaliber() {
        AtomicInteger calibreSum = new AtomicInteger();   // nw o co cho
        Consumer<Ammunition> lambda = (ammo) -> {
            if (ammo instanceof Bullet) {
                calibreSum.addAndGet((int) ((Bullet) ammo).getCalibre().getCalibreValue());
            }
        };
        ammunitionChest.forEach(lambda);
        System.out.println(calibreSum);
    }




}
