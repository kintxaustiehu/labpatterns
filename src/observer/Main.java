package observer;

import java.util.Observable;

import domain.Covid19Pacient;

public class Main {
	public static void main(String	args[]){
		Observable	p1 = new CovidPacient("aitor", 35);
		new	PacientObserverGUI(p1);
		new	PacientSymptomGUI((CovidPacient) p1);
		new PacientThermometerGUI(p1);
		
		Observable	p2 = new CovidPacient("elene", 25);
		new	PacientObserverGUI(p2);
		new	PacientSymptomGUI((CovidPacient) p2);
		new PacientThermometerGUI(p2);
	}
}