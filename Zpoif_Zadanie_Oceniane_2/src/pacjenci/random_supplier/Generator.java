package pacjenci.random_supplier;

import pacjenci.Problem;
import pacjenci.StopienRozczeniowosci;

import java.util.HashSet;
import java.util.Random;

public class Generator {
    static final Random random = new Random();

    // Generator numeru ubezpieczenia
    @FunctionalInterface
    public interface GenerateIdUbezpieczenia {
        int generateInsuranceId();
    }

    public static int idUbezpieczeniaGenerator() {
        GenerateIdUbezpieczenia lamda = () -> {
            int id = 10440000;
            for (int i = 1; i <= 1000; i *= 10) {
                id += (random.nextInt(0, 10) * i);
            }
            return id;
        };
        return lamda.generateInsuranceId();
    }

    // Generator stopnia rozczeniowości
    @FunctionalInterface
    public interface GenerateStopienRozczeniowosci {
        StopienRozczeniowosci generateDemandingLevel();
    }

    public static StopienRozczeniowosci stopienRozczeniowosciGenerator() {
        GenerateStopienRozczeniowosci lambda = () -> {
            if (random.nextDouble() < 0.9) {
                if (random.nextDouble() < 0.5) {
                    return StopienRozczeniowosci.SMALL;
                } else {
                    return StopienRozczeniowosci.AVERAGE;
                }
            } else {
                return StopienRozczeniowosci.BIG;
            }
        };
        return lambda.generateDemandingLevel();
    }

    // Generator wieku
    @FunctionalInterface
    public interface GenerateWiek {
        int generateLimitedAge(int limit);
    }

    public static int wiekGenerator(int limit) {
        GenerateWiek lambda = (maks) -> random.nextInt(maks + 1);
        return lambda.generateLimitedAge(limit);
    }

    // Generator problemów
    @FunctionalInterface
    public interface GenerateProblem {
        HashSet<Problem> generateProblem(boolean tick);
    }

    public static HashSet<Problem> problemGenerator(boolean tick) {
        GenerateProblem lambda = (flaga) -> {
            HashSet<Problem> result = new HashSet<>();
            Problem[] problems = Problem.values();
            Problem wylosowanyProblem = problems[random.nextInt(problems.length)];
            result.add(wylosowanyProblem);

            if (flaga) {
                result.add(Problem.POGRYZIENIEPRZEZKLESZCZA);
            }

            return result;
        };
        return lambda.generateProblem(tick);
    }
}
