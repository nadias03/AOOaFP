package pacjenci;

import pacjenci.random_supplier.Generator;

public class PacjentRozczeniowy extends PacjentId {
    private StopienRozczeniowosci stopienRozczeniowosci;

    public PacjentRozczeniowy() {
        this.stopienRozczeniowosci = Generator.stopienRozczeniowosciGenerator();
        this.wiek = Generator.wiekGenerator(100);
    }

    public StopienRozczeniowosci getStopienRozczeniowosci() {
        return stopienRozczeniowosci;
    }
}
