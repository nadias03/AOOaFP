import pl.pw.edu.mini.zpoif.task1.mafia.DepartamentHandlowy;
import pl.pw.edu.mini.zpoif.task1.mafia.DepartamentOperacjiSpecjalnych;
import pl.pw.edu.mini.zpoif.task1.mafia.DepartamentRekrutacyjny;
import pl.pw.edu.mini.zpoif.task1.mafia.Zarzad;

public class Demonstrator {
    public static void main(String[] args) {
        // stworzenie po jednej instancji każdej klasy dziedziczącej po MafiaOrganization
        DepartamentHandlowy departamentHandlowy = new DepartamentHandlowy();
        DepartamentOperacjiSpecjalnych departamentOperacjiSpecjalnych = new DepartamentOperacjiSpecjalnych();
        DepartamentRekrutacyjny departamentRekrutacyjny = new DepartamentRekrutacyjny();
        Zarzad zarzad = new Zarzad();

        // wywolanie na każdej z nich metodę void work()
        departamentHandlowy.work();
        departamentOperacjiSpecjalnych.work();
        departamentRekrutacyjny.work();
        zarzad.work();
    }
}