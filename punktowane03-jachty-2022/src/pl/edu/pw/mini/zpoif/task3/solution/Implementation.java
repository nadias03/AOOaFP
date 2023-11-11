package pl.edu.pw.mini.zpoif.task3.solution;

import pl.edu.pw.mini.zpoif.task3.generator.GeneratorStatkow;
import pl.edu.pw.mini.zpoif.task3.model.StatekNawodny;
import pl.edu.pw.mini.zpoif.task3.model.jacht.*;

import java.util.*;
import java.util.stream.Collectors;

public class Implementation implements Statki1 {
	List<StatekNawodny> ships;

	// inicjacja pola
	public Implementation() {
		ships = GeneratorStatkow.generujStatkiNawodne();
	}

	@Override
	public StatekNawodny getNajciezszyStatek() {
		return ships.stream()
				.max(Comparator.comparing(StatekNawodny::getMasa)).get();
	}

	@Override
	public StatekNawodny getStatekONajdluzszejNazwieProducentaNaR() {
		return ships.stream()
				.filter(statekNawodny -> statekNawodny.getNazwaProducenta().startsWith("R"))
				.max(Comparator.comparing(statekNawodny -> statekNawodny.getNazwaProducenta().length())).get();
	}

	@Override
	public JachtMotorowy getJachtMotorowyONajwiekszejMocySilnika() {
		return (JachtMotorowy) ships.stream()
				.filter(statekNawodny -> statekNawodny instanceof JachtMotorowy)
				.max(Comparator.comparing(statekNawodny -> ((JachtMotorowy) statekNawodny).getMocSilnika())).get();
	}

	@Override
	public JachtKabinowy getLekkiJachtKabinowyONajmniejszymOzaglowaniu() {
		return ships.stream()
				.filter(statekNawodny -> statekNawodny instanceof JachtKabinowy)
				.map(JachtKabinowy.class::cast)
				.filter(jachtKabinowy -> jachtKabinowy.getMasa() <= 1000)
				.min(Comparator.comparing(JachtKabinowy::getPowierzchniaZagla)).get();
	}

	@Override
	public Set<StatekNawodny> getCoNajwyzej11DlugichICiezkichJachtow() {
		Set<StatekNawodny> result = ships.stream()
				.filter(statekNawodny -> statekNawodny instanceof Jacht)
				.map(Jacht.class::cast)
				.filter(jacht -> jacht.getMasa() >= 1400)
				.filter(jacht -> jacht.getDlugosc() > 700)
				.limit(11)
				.collect(Collectors.toSet());

		return result;
	}

	@Override
	public List<StatekNawodny> getStatkiPosortowaneWzgledemDlugosciBez2() {
		return ships.stream()
				.skip(2)
				.sorted(Comparator.comparing(StatekNawodny::getDlugosc).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<JachtZaglowy> getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych() {
		return ships.stream()
				.filter(statekNawodny -> statekNawodny instanceof JachtZaglowy)
				.map(JachtZaglowy.class::cast)
				.sorted(Comparator.comparing(JachtZaglowy::getPowierzchniaZagla).reversed())
				.skip(2)
				.limit(8)
				.collect(Collectors.toList());
	}

	@Override
	public void oznaczJachtyDobreNaPlycizny() {
		ships.stream()
				.filter(statekNawodny -> statekNawodny instanceof JachtKabinowy)
				.map(JachtKabinowy.class::cast)
				.filter(jachtKabinowy -> jachtKabinowy.getZanurzenie() <= 30)
				.filter(jachtKabinowy -> jachtKabinowy.getMasa() <= 1300)
				.forEach(jachtKabinowy -> System.out.println("Jachtem " + jachtKabinowy.getTyp() + " wplyniesz na kazda plycizne!"));
	}

	@Override
	public String get12UnikalnychNazwTypow() {
		return ships.stream()
				.filter(statekNawodny -> statekNawodny instanceof Jacht)
				.map(Jacht.class::cast)
				.filter(jacht -> jacht.getMasa() > 2000)
				.distinct()   // wybiera unikalne rekordy
				.skip(3)   // zaczynamy od 4 rekordu (pomijamy 3 pierwsze)
				.limit(12)
				.map(Jacht::getTyp)   // mapowanie kazdego obiektu jachtu na jego nazwe typu
				.collect(Collectors.joining("-"));
	}

	@Override
	public Map<String, JachtMotorowy> getMapaJachtowMotorowych() {
		return ships.stream()
				.filter(statekNawodny -> statekNawodny instanceof JachtMotorowy)
				.map(JachtMotorowy.class::cast)
				.sorted(Comparator.comparing(jachtMotorowy -> jachtMotorowy.getNazwaProducenta().length()))   // o chuj tu chodzi
				.distinct()
				.collect(Collectors.toMap(JachtMotorowy::getTyp, jachtMotorowy -> jachtMotorowy));
	}

	@Override
	public List<Jacht> getJachtyOdkrytopokladoweIMotoroweJednePoDrugich() {
		List<JachtOdkrytopokladowy> jachtyOdkrytopokladowe = ships.stream()
				.filter(statekNawodny -> statekNawodny instanceof JachtOdkrytopokladowy)
				.map(JachtOdkrytopokladowy.class::cast)
				.limit(10)
				.collect(Collectors.toList());

		List<JachtMotorowy> jachtyMotorowe = ships.stream()
				.filter(statekNawodny -> statekNawodny instanceof JachtMotorowy)
				.map(JachtMotorowy.class::cast)
				.filter(jachtMotorowy -> jachtMotorowy.getNazwaProducenta().equalsIgnoreCase("regal"))
				.skip(4)
				.limit(4)
				.collect(Collectors.toList());

		List<Jacht> result = new LinkedList<>();
		result.addAll(jachtyOdkrytopokladowe);
		result.addAll(jachtyMotorowe);
		return result;
	}
}
