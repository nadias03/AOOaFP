package pl.edu.pw.mini.zpoif.task5.people;

import pl.edu.pw.mini.zpoif.task5.solution.FillIfEmptyIt;

public abstract class MafiaWorker {

	@FillIfEmptyIt
	protected String name;

	@FillIfEmptyIt
	protected String surname;
	
	protected MafiaWorker() {
		this.name = "no_name";
		this.surname = "no_surname";
	}

	protected MafiaWorker(String name) {
		this.name = name;
		this.surname = "no_surname";
	}

	protected MafiaWorker(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	
}
