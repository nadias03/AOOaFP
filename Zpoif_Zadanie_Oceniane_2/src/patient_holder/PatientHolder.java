package patient_holder;

import pacjenci.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class PatientHolder {
    private List<Pacjent> listaPacjentow;

    static final Random random = new Random();

    public PatientHolder() {
        this.listaPacjentow = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            this.listaPacjentow.add(new PacjentRozczeniowy());
            this.listaPacjentow.add(new PacjentWspolpracujacy());
            this.listaPacjentow.add(new PacjentNiepelnoletni());
            this.listaPacjentow.add(new PacjentNieubezpieczony());
        }

        Collections.shuffle(this.listaPacjentow);
    }

    public List<Pacjent> getPatients() {
        return listaPacjentow;
    }

    public void isCovidPositive(Pacjent pacjent) {
        if (random.nextDouble() < 0.1) {
            System.out.println("Tak");
        } else {
            System.out.println("Nie");
        }
    }

//    public void generalDiagnose(Pacjent pacjent) {
//        Consumer<Pacjent> lambda = (obecnyPacjent) -> {
//
//        }
//    }

    public List<Pacjent> extractDemandingPatients() {
        List<Pacjent> result = new ArrayList<>();
        Consumer<Pacjent> lambda = (pacjent) -> {
            if (pacjent instanceof PacjentRozczeniowy) {
                if (((PacjentRozczeniowy) pacjent).getStopienRozczeniowosci() == StopienRozczeniowosci.SMALL | ((PacjentRozczeniowy) pacjent).getStopienRozczeniowosci() == StopienRozczeniowosci.AVERAGE) {
                    result.add(pacjent);
                }
            }
        };
        listaPacjentow.forEach(lambda);
        return result;
    }

    public void detectNotInsuredPatients() {
        Consumer<Pacjent> lambda = (pacjent) -> {
            if (pacjent instanceof PacjentNieubezpieczony) {
                System.out.println("Brak ubezpieczenia!");
            }
        };
        listaPacjentow.forEach(lambda);
    }

    public void detectTickBiten() {
        AtomicInteger licznik = new AtomicInteger();
        Consumer<Pacjent> lambda = (pacjent) -> {
            if (pacjent.getProblemy().contains(Problem.POGRYZIENIEPRZEZKLESZCZA)) {
                licznik.addAndGet(1);
                if (licznik.get() == 3) {
                    System.out.println("To juz kolejna trojka pacjentow pogryzionych przez kleszcze w tym tygodniu");
                    licznik.set(0);
                }
            }
        };
        listaPacjentow.forEach(lambda);
    }
}
