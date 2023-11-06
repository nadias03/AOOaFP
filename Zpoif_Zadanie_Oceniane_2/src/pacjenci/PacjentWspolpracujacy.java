package pacjenci;

import pacjenci.random_supplier.Generator;

public class PacjentWspolpracujacy extends PacjentId {

    public PacjentWspolpracujacy() {
        this.wiek = Generator.wiekGenerator(100);
    }
}
