package haunted_places;

import people.Guest;

public class LoanIndebtedFlat extends IndebtedFlat {

    public LoanIndebtedFlat() {
    }

    @Override
    public void haunt(Guest guest) {
        hauntBathroom(guest);
        huntWashingRoom(guest);
    }

    @Override
    protected void hauntBathroom(Guest guest) {
        RepoMan repoMan1 = new RepoMan();
        RepoMan repoMan2 = new RepoMan();
        repoMan1.scareSomeone(guest);
        repoMan2.scareSomeone(guest);
    }
}
