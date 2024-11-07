package adapter;

import java.util.Iterator;

import domain.Covid19Pacient;
import domain.Symptom;

public class Main {

	public static void main(String[] args) {
		// Step 2: Create the patient object with 5 symptoms
		Covid19Pacient	p1 = new Covid19Pacient("aitor", 35);
		p1.addSymptomByName("disnea", 3);
		p1.addSymptomByName("cefalea", 3);
		p1.addSymptomByName("astenia", 5);
		p1.addSymptomByName("tos seca", 5);
		p1.addSymptomByName("nauseas", 1);
		
		// Step 2: Create the Covid19PacientAdapter for reverse iteration
        Covid19PacientAdapter adapter = new Covid19PacientAdapter(p1);


        // Step 3: Sort symptoms by severity index using SeverityComparator
        System.out.println("\nSorted symptoms by severity index:");
        SeverityComparator severityComparator = new SeverityComparator();
        Iterator<Object> sortedBySeverity = Sorting.sortedIterator(adapter, severityComparator);
        while (sortedBySeverity.hasNext()) {
            Symptom symptom = (Symptom) sortedBySeverity.next();
            System.out.println("Symptom: " + symptom.getName() + ", Severity: " + symptom.getSeverityIndex());
        }

        // Step 4: Sort symptoms alphabetically by name using SymptomComparator
        System.out.println("\nSorted symptoms alphabetically by name:");
        SymptomComparator nameComparator = new SymptomComparator();
        Iterator<Object> sortedByName = Sorting.sortedIterator(adapter, nameComparator);
        while (sortedByName.hasNext()) {
            Symptom symptom = (Symptom) sortedByName.next();
            System.out.println("Symptom: " + symptom.getName() + ", Severity: " + symptom.getSeverityIndex());
        }
    }
}