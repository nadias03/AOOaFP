package interrogated_people;

public class StringSuspect {
    private String name;
    private String surname;

    public StringSuspect(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String generateDescription() {
        String firstLetterOfSurname = this.surname.substring(0, 1);
        return this.name + ' ' + firstLetterOfSurname + '.';
    }
}
