package adapter2;

import java.awt.Component;
import java.awt.Font;
import java.util.List;

import javax.swing.*;
import javax.swing.table.TableModel;

import domain.Covid19Pacient;


public class ShowPacientTableGUI extends JFrame{
	
	JTable table;
	List<Covid19Pacient> patients;
	
  
  public ShowPacientTableGUI(List<Covid19Pacient> patients) {
	  	this.setTitle("Covid Symptoms");
	  	
	  	this.patients = patients;
	  	
	  	setFonts();
	  	
	  	JTabbedPane tabbedPane = new JTabbedPane();
	  	
	  	for(Covid19Pacient patient : this.patients) {	  		
	  		TableModel tm=new Covid19PacientTableModelAdapter(patient);
	  		table = new JTable(tm);
	  		table.setRowHeight(36);
	  		JScrollPane pane = new JScrollPane(table);
	  		pane.setPreferredSize(new java.awt.Dimension(300, 200));
	  		tabbedPane.addTab(patient.getName(), pane);
	  	}
	  	this.getContentPane().add(tabbedPane);
  }

  private static void setFonts() {
    Font font = new Font("Dialog", Font.PLAIN, 18);
    UIManager.put("Table.font", font);
    UIManager.put("TableHeader.font", font);
  }
}
