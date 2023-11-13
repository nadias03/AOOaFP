package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.solution;

import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.*;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.generator.GeneratorStatkowPowietrznych;

import java.util.*;
import java.util.stream.Collectors;

public class Implementation implements Strumienie {
    private List<StatekPowietrzny> statki;
    private List<NapedzanyStatekPowietrzny> napedzaneStatki;

    static final Random random = new Random();

    public Implementation() {
        this.statki = GeneratorStatkowPowietrznych.generujWszystkieStatkiPowietrzne();
        this.napedzaneStatki = GeneratorStatkowPowietrznych.generujNapedzaneStatkiPowietrzne();
    }

    // 1
    @Override
    public NapedzanyStatekPowietrzny getNajszybciejWznoszacySieStatek() {
        return statki.stream()
                .filter(statekPowietrzny -> statekPowietrzny instanceof NapedzanyStatekPowietrzny)
                .map(NapedzanyStatekPowietrzny.class::cast)
                .max(Comparator.comparing(NapedzanyStatekPowietrzny::getPredkoscWznoszenia))
                .get();
    }

    // 2
    @Override
    public StatekPowietrzny getSamolotONajwPowierzchniNosnej() {
        return napedzaneStatki.stream()
                .skip(5)
                .filter(napedzanyStatekPowietrzny -> napedzanyStatekPowietrzny instanceof Samolot)
                .map(Samolot.class::cast)
                .max(Comparator.comparing(Samolot::getPowierzchniaNosna))
                .get();
    }

    // 3
    @Override
    public Smiglowiec getSmiglowiecONajmniejszejMasie() {
        return napedzaneStatki.stream()
                .filter(napedzanyStatekPowietrzny -> napedzanyStatekPowietrzny instanceof Smiglowiec)
                .map(Smiglowiec.class::cast)
                .skip(3)
                .filter(smiglowiec -> !smiglowiec.getTyp().startsWith("Mi"))
                .min(Comparator.comparing(StatekPowietrzny::getMasa))
                .get();
    }


    // 4
    @Override
    public Set<StatekPowietrzny> getSamolotyLubSmiglowceBezPierwszych4() {
        return statki.stream()
                .filter(statekPowietrzny -> statekPowietrzny instanceof Samolot | statekPowietrzny instanceof Smiglowiec)
                .map(NapedzanyStatekPowietrzny.class::cast)
                .filter(napedzanyStatekPowietrzny -> napedzanyStatekPowietrzny.getPredkoscWznoszenia() <= 15)
                .filter(napedzanyStatekPowietrzny -> napedzanyStatekPowietrzny.getMasa() >= 1300)
                .skip(4)
                .limit(3)
                .collect(Collectors.toSet());
    }


    // 5
    @Override
    public List<NapedzanyStatekPowietrzny> get4SmiglowceONajwiekszymZasiegu() {
        return napedzaneStatki.stream()
                .filter(napedzanyStatekPowietrzny -> napedzanyStatekPowietrzny instanceof Smiglowiec)
                .map(Smiglowiec.class::cast)
                .filter(smiglowiec -> smiglowiec.getSrednicaWirnika() >= 15)
                .sorted(Comparator.comparing(Smiglowiec::getZasieg).reversed())
                .limit(4)
                .collect(Collectors.toList());
    }


    // 6
    @Override
    public Spadochron getSiedzeniowySpadochron() {
        return statki.stream()
                .filter(statekPowietrzny -> statekPowietrzny instanceof SpadochronRatowniczy)
                .map(SpadochronRatowniczy.class::cast)
                .filter(spadochronRatowniczy -> spadochronRatowniczy.isSiedzeniowy())
                .max(Comparator.comparing(SpadochronRatowniczy::getMinimalnaWysokosc))
                .get();
    }

    // 7
    @Override
    public Map<Integer, Szybowiec> getMapaSzybowcowPerDoskonalosc() {
        return statki.stream()
                .filter(statekPowietrzny -> statekPowietrzny instanceof Szybowiec)
                .map(Szybowiec.class::cast)
                .skip(1)
                .sorted(Comparator.comparing(szybowiec -> szybowiec.getTyp().length()))
                .distinct()
                .collect(Collectors.toMap(Szybowiec::getDoskonalosc, szybowiec -> szybowiec));
    }

    // 8
    @Override
    public double getSumePredkosciWznoszeniaSamolotow() {
        return statki.stream()
                .skip(3)
                .filter(statekPowietrzny -> statekPowietrzny instanceof Samolot)
                .map(Samolot.class::cast)
                .filter(samolot -> samolot.getMasa() <= 15000)
                .mapToDouble(NapedzanyStatekPowietrzny::getPredkoscWznoszenia)
                .sum();
    }

    // 9
    @Override
    public Map<String, StatekPowietrzny> getPosortowaneSmiglowceLubSamoloty() {
        return statki.stream()
                .skip(10)
                .sorted(Comparator.comparing(StatekPowietrzny::getMasa))
                .limit(10)
                .filter(statekPowietrzny -> statekPowietrzny instanceof Samolot | statekPowietrzny instanceof Smiglowiec)
                .map(NapedzanyStatekPowietrzny.class::cast)
                .distinct()
                .collect(Collectors.toMap(NapedzanyStatekPowietrzny::getTyp, napedzanyStatekPowietrzny -> napedzanyStatekPowietrzny));
    }

    // 10
    @Override
    public List<String> zwrocNazwy() {
        return statki.stream()
                .filter(statekPowietrzny -> statekPowietrzny instanceof SpadochronRatowniczy)
                .map(SpadochronRatowniczy.class::cast)
                .limit(2)
                .map(SpadochronRatowniczy::toString)
                .collect(Collectors.toList());
    }

    // 11
    @Override
    public void modyfikujNazwy() {
        statki.stream()
                .filter(statekPowietrzny -> statekPowietrzny instanceof Samolot)
                .map(Samolot.class::cast)
                .sorted(Comparator.comparing(NapedzanyStatekPowietrzny::getPredkoscWznoszenia).reversed())
                .skip(5)
                .filter(samolot -> samolot.getMasa() > 5000)
                .limit(15)
                .filter(samolot -> random.nextDouble() < 0.1)
                .peek(samolot -> {
                    String nowaNazwa = "[" + samolot.getTyp() + "]";
                    samolot.setTyp(nowaNazwa);
                });
    }
}







