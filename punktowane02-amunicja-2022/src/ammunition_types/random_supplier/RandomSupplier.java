package ammunition_types.random_supplier;

import ammunition_types.Calibre;

import java.util.Random;
import java.util.function.Supplier;

public class RandomSupplier {
    static final Random random = new Random();

    public static Supplier<Calibre> provideRandomCaliberGenerator() {
        Calibre[] calibres = Calibre.values();
        return () -> calibres[random.nextInt(calibres.length)];
    }

    public static boolean provideRandomSafeGenerator(boolean alwaysUnlocked) {
        Arming armingLambda = ((flag) -> {
            if (flag) {
                return false;
            }
            return (random.nextDouble() < 0.95);
        });
        return armingLambda.run(alwaysUnlocked);
    }

    public static int provideRandomCO2EmissionGenerator(int a, int b) {
        Emission emissionLambda = (x, y) -> random.nextInt(a, b + 1);
        return emissionLambda.run(a, b);
    }

}
