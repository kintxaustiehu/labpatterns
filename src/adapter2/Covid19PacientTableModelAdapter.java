package adapter2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
	protected Covid19Pacient pacient;
	protected String[] columnNames = new String[] { "Symptom", "Weight" };

	public Covid19PacientTableModelAdapter(Covid19Pacient p) {
		this.pacient = p;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int i) {
		return columnNames[i];
	}

	@Override
	public int getRowCount() {
		return this.pacient.getSymptoms().size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		List<Symptom> symptomList = new ArrayList<>(this.pacient.getSymptoms());
		Symptom symp = symptomList.get(row);
		
		if(col == 0) return symp.getName();
		if(col == 1) return symp.getCovidImpact();
		
		return null;
	}
}
