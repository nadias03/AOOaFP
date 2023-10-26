package haunted_places;

import people.Guest;
import scary_things.ScaryCreature;

public class WaterIndebtedFlat extends IndebtedFlat {

    public WaterIndebtedFlat() {
    }

    @Override
    public void haunt(Guest guest) {
        double rand = random.nextDouble();

        if (rand > 0.5) {
            hauntBathroom(guest);
        } else {
            huntWashingRoom(guest);
        }
    }

    class SwimmerGhost extends ScaryCreature {
        @Override
        public void scareSomeone(Guest guest) {
            guest.scareMe(random.nextInt(10, 31));
        }
    }

    @Override
    protected void hauntBathroom(Guest guest) {
        SwimmerGhost swimmerGhost1 = new SwimmerGhost();
        SwimmerGhost swimmerGhost2 = new SwimmerGhost();
        swimmerGhost1.scareSomeone(guest);
        swimmerGhost2.scareSomeone(guest);
    }
}
