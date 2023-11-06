package pacjenci;

import pacjenci.random_supplier.Generator;

public class PacjentNieubezpieczony extends Pacjent {

    public PacjentNieubezpieczony() {
        this.wiek = Generator.wiekGenerator(100);
    }
}
