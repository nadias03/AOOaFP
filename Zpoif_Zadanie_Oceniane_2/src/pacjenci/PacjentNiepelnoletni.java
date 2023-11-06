package pacjenci;

import pacjenci.random_supplier.Generator;

public class PacjentNiepelnoletni extends PacjentId {

    public PacjentNiepelnoletni() {
        this.wiek = Generator.wiekGenerator(17);
    }
}
