package people;

import java.util.Random;

public abstract class Guest {
    protected int resilience;
    protected State state;
    static final Random random = new Random();

    public Guest() {
        this.resilience = random.nextInt(10, 21);
        this.state = State.NORMAL;
    }

    @Override
    public String toString() {
        return "This guest's current state is " + this.state;
    }

    public void scareMe(int force) {

    }

    public State getState() {
        return this.state;
    }

}
