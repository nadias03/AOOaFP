package pacjenci;

import pacjenci.random_supplier.Generator;

import java.util.HashSet;
import java.util.Random;

public abstract class Pacjent {
    protected int wiek;
    protected HashSet<Problem> problemy;

    final static Random random = new Random();

    public Pacjent() {
        this.problemy = Generator.problemGenerator(random.nextBoolean());
    }

    @FunctionalInterface
    public interface Diagnose {
        void diagnoseMe(Pacjent pacjent);
    }

    public void applyDiagnose(Diagnose diagnose) {
        diagnose.diagnoseMe(this);
    }

    public HashSet<Problem> getProblemy() {
        return problemy;
    }

    public int getWiek() {
        return wiek;
    }
}
