package haunted_places;

import people.Guest;
import scary_things.ScaryCreature;

public class OldCastle extends HauntedPlace {
    static private int whiteLadiesForce = 20;

    @Override
    public void haunt(Guest guest) {
        WhiteLady whiteLady = new WhiteLady();
        whiteLady.scareSomeone(guest);
        GhostOfCastleOwner ghostOfCastleOwner1 = new GhostOfCastleOwner();
        GhostOfCastleOwner ghostOfCastleOwner2 = new GhostOfCastleOwner();
        ghostOfCastleOwner1.scareSomeone(guest);
        ghostOfCastleOwner2.scareSomeone(guest);
    }

    static class WhiteLady extends ScaryCreature {   // static: działa tylko w Starym Zamku ale można ją instancjonować również i poza tym miejscem
        @Override
        public void scareSomeone(Guest guest) {
            guest.scareMe(whiteLadiesForce);
        }
    }

    class GhostOfCastleOwner extends ScaryCreature {   // zwykla klasa lokalna: działa tylko w obrębie metody nastraszKogos(Gosc gosc) należącej do Zamku i nigdzie indziej
        @Override
        public void scareSomeone(Guest guest) {
            guest.scareMe(0);
        }
    }
}
