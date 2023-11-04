package ammunition_types.random_supplier;

@FunctionalInterface
public interface Arming {
    boolean run(boolean alwaysUnlocked);
}
