import haunted_places.AbandonedHospital;
import haunted_places.LoanIndebtedFlat;
import haunted_places.OldCastle;
import haunted_places.WaterIndebtedFlat;
import people.Guest;
import people.Student;
import people.Tourist;

import java.util.ArrayList;

public class Demonstrator {
    public static void main(String[] args) {
        // stworzenie listy gosci
        ArrayList<Guest> guests = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            Tourist tourist = new Tourist();
            guests.add(student);
            guests.add(tourist);
        }

        // stworzenie wszystkich miejsc
        AbandonedHospital abandonedHospital = new AbandonedHospital();
        LoanIndebtedFlat loanIndebtedFlat = new LoanIndebtedFlat();
        OldCastle oldCastle = new OldCastle();
        WaterIndebtedFlat waterIndebtedFlat = new WaterIndebtedFlat();

        // przeprowadzenie kazdego goscia po kazdym z miejsc
        for (Guest guest : guests) {
            System.out.println("New guest");
            abandonedHospital.haunt(guest);
            System.out.println(guest);
            loanIndebtedFlat.haunt(guest);
            System.out.println(guest);
            oldCastle.haunt(guest);
            System.out.println(guest);
            waterIndebtedFlat.haunt(guest);
            System.out.println(guest);
            System.out.println();
        }
    }
}