package adapter;

import java.util.Comparator;

import domain.Symptom;

public class SymptomComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Symptom s1 = (Symptom) o1;
		Symptom s2 = (Symptom) o2;
		String n1 = s1.getName();
		String n2 = s2.getName();
		return n1.compareTo(n2);
	}
}