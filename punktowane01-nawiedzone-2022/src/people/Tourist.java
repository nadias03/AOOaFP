package people;

public class Tourist extends Guest {
    public Tourist() {
    }

    @Override
    public void scareMe(int force) {
        if (force > this.resilience) {
            if (this.state == State.NORMAL) {
                this.state = State.FRIGHTENED;
            } else if (this.state == State.FRIGHTENED) {
                this.state = State.PANIC;
            }
        } else if (force < this.resilience) {
            if (this.state == State.PANIC) {
                this.state = State.FRIGHTENED;
            } else if (this.state == State.FRIGHTENED) {
                this.state = State.NORMAL;
            }
        }
    }
}
