package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.solution;

import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Strumienie {

    NapedzanyStatekPowietrzny getNajszybciejWznoszacySieStatek();
    StatekPowietrzny getSamolotONajwPowierzchniNosnej();
    Smiglowiec getSmiglowiecONajmniejszejMasie();
    Set<StatekPowietrzny> getSamolotyLubSmiglowceBezPierwszych4();
    List<NapedzanyStatekPowietrzny> get4SmiglowceONajwiekszymZasiegu();
    Spadochron getSiedzeniowySpadochron();
    Map<Integer, Szybowiec> getMapaSzybowcowPerDoskonalosc();
    double getSumePredkosciWznoszeniaSamolotow();
    Map<String, StatekPowietrzny> getPosortowaneSmiglowceLubSamoloty();
    List<String> zwrocNazwy();
    void modyfikujNazwy();
}
