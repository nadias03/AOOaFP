package interrogated_people;

public class Witness extends NameSurnamePerson {

    public Witness(String name, String surname) {
        super(name, surname);
    }

    @Override
    public void interrogateMe() {
        System.out.println("Jestem przesluchiwany.");
        System.out.println(this.getClass().getName());
        toString();
    }

    @Override
    public String toString() {
        return "This witness name and surname is " + this.name + " " + this.surname;
    }
}
