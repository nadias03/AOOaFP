package haunted_places;

import people.Guest;
import people.State;
import scary_things.ScaryCreature;

public class AbandonedHospital extends HauntedPlace {

    @Override
    public void haunt(Guest guest) {
        ScaryCreature scaryCreature = new ScaryCreature() {
            @Override
            public void scareSomeone(Guest guest) {
                if (guest.getState() == State.NORMAL) {
                    guest.scareMe(15);
                }
            }
        };
        scaryCreature.scareSomeone(guest);   // troche nw co to robi
    }

}
