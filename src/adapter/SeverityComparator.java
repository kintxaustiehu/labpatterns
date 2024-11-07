package adapter;

import java.util.Comparator;

import domain.Symptom;

public class SeverityComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Symptom s1 = (Symptom) o1;
		Symptom s2 = (Symptom) o2;
		Integer severityI1 = s1.getSeverityIndex();
		Integer severityI2 = s2.getSeverityIndex();
		return severityI1.compareTo(severityI2);
	}
}
