package adapter2;

import java.util.ArrayList;
import java.util.List;

import domain.Covid19Pacient;

public class Main {
	public static void main(String[] args) {
		List<Covid19Pacient> patients = new ArrayList<>();
		
		Covid19Pacient pacient1 = new Covid19Pacient("aitor", 35);

		pacient1.addSymptomByName("disnea", 2);
		pacient1.addSymptomByName("cefalea", 1);
		pacient1.addSymptomByName("astenia", 3);
		
		patients.add(pacient1);

		
		Covid19Pacient pacient2 = new Covid19Pacient("koldo", 23);
		pacient2.addSymptomByName("nauseas", 6);
		pacient2.addSymptomByName("mareos", 1);
		
		patients.add(pacient2);
		

		ShowPacientTableGUI gui = new ShowPacientTableGUI(patients);
		gui.setPreferredSize(new java.awt.Dimension(300, 200));
		gui.setVisible(true);
	}
}
