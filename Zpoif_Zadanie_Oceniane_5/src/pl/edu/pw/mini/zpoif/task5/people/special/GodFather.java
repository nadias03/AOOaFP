package pl.edu.pw.mini.zpoif.task5.people.special;

import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.solution.ImportantWorker;
import pl.edu.pw.mini.zpoif.task5.solution.InitMe;
import pl.edu.pw.mini.zpoif.task5.solution.PrimaryMafiaWorker;

@ImportantWorker
@PrimaryMafiaWorker(priority = 1)
public class GodFather extends MafiaWorker {

	@InitMe
	protected Wallet wallet;

	protected class Wallet {

		private int value;

		public Wallet(int value) {
			this.value = value;
		}

	}

	public GodFather() {
		super();
	}

	public GodFather(String name, String surname) {
		super(name, surname);
	}

	public GodFather(String name) {
		super(name);
	}

}
