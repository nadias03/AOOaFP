package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.solution;

public class Demonstrator {

    public static void main(String[] args) {
        Implementation demo = new Implementation();

        System.out.println(demo.getNajszybciejWznoszacySieStatek());
        System.out.println(demo.getSamolotONajwPowierzchniNosnej());
        System.out.println(demo.getSmiglowiecONajmniejszejMasie());
        System.out.println(demo.getSamolotyLubSmiglowceBezPierwszych4());
        System.out.println(demo.get4SmiglowceONajwiekszymZasiegu());
        System.out.println(demo.getSiedzeniowySpadochron());
        System.out.println(demo.getMapaSzybowcowPerDoskonalosc());
        System.out.println(demo.getSumePredkosciWznoszeniaSamolotow());
        System.out.println(demo.getPosortowaneSmiglowceLubSamoloty());
        System.out.println(demo.zwrocNazwy());
        demo.modyfikujNazwy();
    }
}
