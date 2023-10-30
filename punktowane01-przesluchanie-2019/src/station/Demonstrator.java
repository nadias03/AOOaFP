package station;

import interrogated_people.Interrogated;
import interrogated_people.SecretAgent;
import interrogated_people.Suspect;
import interrogated_people.Witness;
import station.MyPoliceStation;
import station.PoliceStation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Demonstrator {

    private static final byte numberOfInterrogatedPeople = 5;

    private static List<String> names = Arrays.asList("Alicja", "Maciek", "Piotrek", "Zbych", "Adam", "Joanna", "Zuzanna");
    private static List<String> surnames = Arrays.asList("Johnson", "Bryl", "Opala", "Tkaczyk", "Witkek", "Dzwon");
    private static List<String> pseudonyms = Arrays.asList("Halo", "Ogrodnik", "Halina", "Kapo", "Macho");

    static final Random random = new Random();

    public static void main(String[] args) {
        PoliceStation policeStation = new MyPoliceStation();//Tutaj nalezy zainicjowac stworzona podklase


        //Tutaj nalezy zainicjowac kolekcje za pomoca klasy opisanej w zadaniu
        ListCreator listCreator = new ListCreator();
        List<Interrogated> interrogatedPeople = listCreator.createList();

       //Odkomentowac, gdy komponenty zostana zainicjalizowane
        policeStation.handleInterrogatedPeople(interrogatedPeople);
    }

    static class ListCreator {

        public List<Interrogated> createList() {
            List<Interrogated> interrogatedList = new ArrayList<>();
            for (int i = 0; i < numberOfInterrogatedPeople; i++){
                Witness witness = new Witness(drawName(), drawSurname());
                Suspect suspect = new Suspect(drawName(), drawSurname());
                SecretAgent secretAgent = new SecretAgent(drawNick());
                interrogatedList.add(witness);
                interrogatedList.add(suspect);
                interrogatedList.add(secretAgent);
            }
            return interrogatedList;
        }

        private String drawName() {
            return names.get(random.nextInt(0, names.size()));
        }

        private String drawSurname() {
            return surnames.get(random.nextInt(0, surnames.size()));
        }

        private String drawNick() {
            return pseudonyms.get(random.nextInt(0, pseudonyms.size()));
        }
    }

}