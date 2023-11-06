package doctor;

import pacjenci.Pacjent;
import pacjenci.Problem;
import patient_holder.PatientHolder;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Doctor {
    private PatientHolder patientHolder;

    static final Random random = new Random();
    private Object isCovidPositive;

    public Doctor(PatientHolder patientHolder) {
        this.patientHolder = patientHolder;
    }

    public void diagnoseAll() {
        List<Pacjent> pacjentList = this.patientHolder.getPatients();

        for (Pacjent pacjent : pacjentList) {
            HashSet<Problem> problemyPacjenta = pacjent.getProblemy();
            for (Problem problem : problemyPacjenta) {
                Pacjent.Diagnose diagnose = null;
                
                if (problem == Problem.POGRYZIENIEPRZEZKLESZCZA) {
                    diagnose = (p) -> {
                        if (p.getWiek() < 40) {
                            if (random.nextDouble() < 0.7) {
                                System.out.println("Borelioza!");
                            }
                        } else {
                            if (random.nextDouble() < 0.3) {
                                System.out.println("Pacjent zdrowy!");
                            }
                        }
                    };
                } else if (problem == Problem.GORACZKA) {
                    diagnose = (p) -> {
                        patientHolder.isCovidPositive(p);
                    };
                } else if (problem == Problem.SPIACZKA) {
                    // nie zdazylam napisac generalDiagnose
                } else {
                    //
                }

                if (diagnose != null) {
                    pacjent.applyDiagnose(diagnose);
                }
            }

        }
    }

}
