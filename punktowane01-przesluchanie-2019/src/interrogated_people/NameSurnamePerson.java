package interrogated_people;

public abstract class NameSurnamePerson extends Interrogated {
    protected String name;
    protected String surname;

    public NameSurnamePerson(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


}
