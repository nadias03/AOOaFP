package station;

import interrogated_people.Interrogated;
import interrogated_people.SecretAgent;
import interrogated_people.Suspect;
import interrogated_people.Witness;
import investigating_people.Investigator;
import investigating_people.Prosecutor;

import java.util.*;

public class MyPoliceStation extends PoliceStation {

    final static Random random = new Random();

    @Override
    protected void handleInterrogatedPeople(List<Interrogated> interrogators) {
        // sortowanie
        Collections.sort(interrogators, new Comparator<Interrogated>() {
            @Override
            public int compare(Interrogated o1, Interrogated o2) {
                boolean o1w = o1 instanceof Witness;
                boolean o2w = o2 instanceof Witness;
                if ((o1w & o2w) || (!o1w & !o2w)) return 0;
                else if(o1w) return -1;
                else return 1;
            }
        });

        // iteracja
        Iterator<Interrogated> iterator = interrogators.iterator();
        double rand = random.nextDouble();   // do sprawdzania specyficznych przypadkow
        while (iterator.hasNext()) {
            if (iterator instanceof Witness) {
                // obiekt jest swiadkiem
                if (rand < 0.1) {
                    Investigator investigator = new Investigator() {
                        @Override
                        public void interrogate(Interrogated interrogated) {
                            super.interrogate(interrogated);
                            System.out.println("Ja też umiem przesłuchiwać...");
                        }
                    };
                } else {
                    double randInterrogationRoom = random.nextDouble();
                    double randInvestigatingPerson = random.nextDouble();
                    if (randInterrogationRoom < 0.5) {   // interrogationRoom1
                        if (randInvestigatingPerson < 0.5) {   // policjant
                            interrogationRoom1((Interrogated) iterator, new Policeman());
                        } else {   // prokurator
                            interrogationRoom1((Interrogated) iterator, new Prosecutor());
                        }
                    } else {   // interrogationRoom2
                        if (randInvestigatingPerson < 0.5) {   // policjant
                            interrogationRoom2((Interrogated) iterator, new Policeman());
                        } else {   // prokurator
                            interrogationRoom2((Interrogated) iterator, new Prosecutor());
                        }
                    }
                }
            } else if (iterator instanceof Suspect) {
                // obiekt jest podejrzanym
                if (rand < 0.05) {
                    interrogationRoom2((Interrogated) iterator, (new MyPoliceStation()).new Policeman());
                } else {
                    interrogationRoom2((Interrogated) iterator, new Prosecutor());
                }
            } else if (iterator instanceof SecretAgent) {
                secretInterrogationRoom((Interrogated) iterator);
            }
        }

        this.summary(new Summaryable() {
            @Override
            public int getNumberOfInterrogatedPeople() {
                return interrogators.size();
            }
        });
    }

    @Override
    protected void interrogationRoom1(Interrogated interrogated, Investigator investigator) {
        investigator.interrogate(interrogated);
    }

    @Override
    protected void interrogationRoom2(Interrogated interrogated, Investigator investigator) {
        investigator.interrogate(interrogated);
    }

    @Override
    protected void secretInterrogationRoom(Interrogated interrogated) {
        Interrogated crypto = new Interrogated() {
            @Override
            public void interrogateMe() {
                interrogated.interrogateMe();
            }
        };
    }

    @Override
    protected void interrogationRoom3(Interrogated interrogated, Investigator investigator) {
        investigator.interrogate(interrogated);
    }

    @Override
    protected void summary(Summaryable summaryable) {
        System.out.println("Interrogated " + summaryable.getNumberOfInterrogatedPeople() + " people");
    }
}
