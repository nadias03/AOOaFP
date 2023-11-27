package pl.edu.pw.mini.zpoif.task5.people.special;

import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.solution.DoIt;
import pl.edu.pw.mini.zpoif.task5.solution.MafiaValidator;

public class ButtonMan extends MafiaWorker {

	public ButtonMan() {
		super();
	}

	public ButtonMan(String name, String surname) {
		super(name, surname);
	}

	public ButtonMan(@MafiaValidator String name) {
		this.name = name;
	}

	@DoIt(times = 4)
	public void killHim() {
		System.out.println("Killed!");
	}

	@DoIt(times = 7)
	public void killThemAll() {
		System.out.println("Done!");
	}
	
	public void killRetread() {
		System.out.println("Bye!");
	}

}
