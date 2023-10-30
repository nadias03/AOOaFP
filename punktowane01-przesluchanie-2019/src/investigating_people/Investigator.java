package investigating_people;

import interrogated_people.Interrogated;

public abstract class Investigator {
    public void interrogate(Interrogated interrogated) {
        interrogated.interrogateMe();
        System.out.println("I have interrogated: " + interrogated);
    }
}
