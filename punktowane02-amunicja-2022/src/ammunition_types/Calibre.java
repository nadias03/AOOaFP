package ammunition_types;

public enum Calibre {
    FOUR(4),
    FIVEPOINTFIFTYSIX(5.56),
    SEVENPOINTSIXTYTWO(7.62),
    NINE(9),
    TWELVEPOINTSEVEN(12.7);

    private final double calibreValue;

    Calibre(double calibreValue) {
        this.calibreValue = calibreValue;
    }

    public double getCalibreValue() {
        return calibreValue;
    }
}
