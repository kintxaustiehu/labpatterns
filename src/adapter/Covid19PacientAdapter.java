package adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientAdapter implements InvertedIterator {

    protected Covid19Pacient pacient;
    protected List<Symptom> symptomsList;
    private int currentIndex;

    public Covid19PacientAdapter(Covid19Pacient p) {
        this.pacient = p;
        this.symptomsList = new ArrayList<>(this.pacient.getSymptoms());
        goLast();  // Start at the last element for reverse iteration
    }
    
    @Override
    public Object previous() {
        if (hasPrevious()) {
            return symptomsList.get(currentIndex--);  // Return current symptom and then decrement index
        }
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex >= 0;
    }

    @Override
    public void goLast() {
        currentIndex = symptomsList.size() - 1;  // Set index to the last element
    }
}