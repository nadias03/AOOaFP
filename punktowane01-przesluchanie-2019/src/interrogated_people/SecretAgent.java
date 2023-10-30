package interrogated_people;

public class SecretAgent extends Interrogated {
    private String nick;

    public SecretAgent(String nick) {
        this.nick = nick;
    }

    @Override
    public void interrogateMe() {
        System.out.println("Jestem przesluchiwany.");
        System.out.println(this.getClass().getName());
        toString();
    }

    @Override
    public String toString() {
        return "This secret agent nick is " + this.nick;
    }
}
