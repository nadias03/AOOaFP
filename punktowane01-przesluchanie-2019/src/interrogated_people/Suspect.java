package interrogated_people;

public class Suspect extends NameSurnamePerson {
    public Suspect(String name, String surname) {
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
        StringSuspect stringSuspect = new StringSuspect(this.name, this.surname);   // czemu to nie dziala
        return stringSuspect.generateDescription();
    }
}
