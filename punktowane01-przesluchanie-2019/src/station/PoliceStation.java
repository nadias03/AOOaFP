package station;

import interrogated_people.Interrogated;
import investigating_people.Investigator;

import java.util.List;


public abstract class PoliceStation {

    protected int interrogationTime = 25;
    public static final String MOTTO = "To protect and serve";

    protected interface Summaryable {
        public abstract int getNumberOfInterrogatedPeople();
    }

    protected abstract void handleInterrogatedPeople(List<Interrogated> interrogators);
    protected abstract void interrogationRoom1(Interrogated interrogated, Investigator investigator);
    protected abstract void interrogationRoom2(Interrogated interrogated, Investigator investigator);
    protected abstract void interrogationRoom3(Interrogated interrogated, Investigator investigator);
    protected abstract void secretInterrogationRoom(Interrogated interrogated);
    protected abstract void summary(Summaryable summaryable);

    public class Policeman extends Investigator {
        @Override
        public void interrogate(Interrogated interrogated) {
            super.interrogate(interrogated);
            System.out.println("We have " + interrogationTime + " minutes.");
        }
    }

    class Intern extends Investigator {

    }



}
