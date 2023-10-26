package haunted_places;

import people.Guest;
import scary_things.ScaryCreature;

import java.util.Random;

public abstract class IndebtedFlat extends HauntedPlace {
    protected int debt;
    static final Random random = new Random();

    public IndebtedFlat() {
        this.debt = random.nextInt(1, 1001);
    }

    class RepoMan extends ScaryCreature {
        @Override
        public void scareSomeone(Guest guest) {
            guest.scareMe(debt / 200);
        }
    }

    protected void hauntBathroom(Guest guest) {

    }

    protected void huntWashingRoom(Guest guest) {
        RepoMan repoMan = new RepoMan();
        repoMan.scareSomeone(guest);
    }
}
