package pacjenci;

import pacjenci.random_supplier.Generator;

public abstract class PacjentId extends Pacjent {
    protected int idUbezpieczenia;

    public PacjentId() {
        this.idUbezpieczenia = Generator.idUbezpieczeniaGenerator();
    }
}
