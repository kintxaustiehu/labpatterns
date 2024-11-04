package factory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.DigestiveSymptom;
import domain.NeuroMuscularSymptom;
import domain.RespiratorySymptom;
import domain.Symptom;

public class SymptomFactory {
	private static final Map<String, Symptom> symptomsCache = new HashMap<>();
	
	private static final List<String> impact5 = Arrays.asList("fiebre", "tos seca", "astenia","expectoracion");
	private static final List<Double> index5 = Arrays.asList(87.9, 67.7, 38.1, 33.4);
	private static final List<String> impact3 = Arrays.asList("disnea", "dolor de garganta", "cefalea","mialgia","escalofrios");
	private static final List<Double> index3 = Arrays.asList(18.6, 13.9, 13.6, 14.8, 11.4);
	private static final List<String> impact1 = Arrays.asList("nauseas", "vómitos", "congestión nasal","diarrea","hemoptisis","congestion conjuntival", "mareos");
	private static final List<Double> index1 = Arrays.asList(5.0, 4.8, 3.7, 0.9, 0.8, 0.5);

	private static final List<String> digestiveSymptom = Arrays.asList("nauseas", "vómitos", "diarrea");
	private static final List<String> neuroMuscularSymptom = Arrays.asList("fiebre", "astenia", "cefalea", "mialgia", "escalofrios");
	private static final List<String> respiratorySymptom = Arrays.asList("tos seca", "expectoracion", "disnea", "dolor de garganta", "congestión nasal", "hemoptisis", "congestion conjuntival");

    public static Symptom createSymptom(String symptomName) {
        if (symptomsCache.containsKey(symptomName)) {
            return symptomsCache.get(symptomName);
        }

        Symptom symptom = null;
        
        int impact = 0;
        double index = 0;

        if (impact5.contains(symptomName)) {
            impact = 5;
            index = index5.get(impact5.indexOf(symptomName));
        } else if (impact3.contains(symptomName)) {
            impact = 3;
            index = index3.get(impact3.indexOf(symptomName));
        } else if (impact1.contains(symptomName)) {
            impact = 1;
            index = index1.get(impact1.indexOf(symptomName));
        }

        if (impact != 0) {
            if (digestiveSymptom.contains(symptomName)) {
                symptom = new DigestiveSymptom(symptomName, (int) index, impact);
            } else if (neuroMuscularSymptom.contains(symptomName)) {
                symptom = new NeuroMuscularSymptom(symptomName, (int) index, impact);
            } else if (respiratorySymptom.contains(symptomName)) {
                symptom = new RespiratorySymptom(symptomName, (int) index, impact);
            }
        }

        if (symptom != null) {
            symptomsCache.put(symptomName, symptom);
        }

        return symptom;
    }
}
