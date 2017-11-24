package fr.berufood.foody.modeles;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.berufood.foody.controleurs.*;
import fr.berufood.foody.entites.RapportVisite;
import fr.berufood.foody.techniques.ConnexionException;
import fr.berufood.foody.vues.*;




public class ModeleLireRapport extends AbstractTableModel {
	
	//private ControleurBoutonSelectionVisiteur controleur;
	//private VueVoirSelectionDate vue;
	private VueLireRapport vue;
	
	private int numRapport;
	private List<RapportVisite> unRapport ;
			
	
	public ModeleLireRapport(int numRapport){
		this.numRapport=numRapport;
		
		unRapport = ModeleFoody.getLeRapport(this.getNumRapport());
		
	}
	
	

	private final String[] entetes = { "Le Bilan"} ;


	@Override
	public int getRowCount() {
		
		return unRapport.size();
	}

	@Override
	public int getColumnCount() {
		
		return entetes.length;
	}
	
	@Override
	public String getColumnName(int column) {
		
		return entetes[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		switch (columnIndex){
		case 0: return String.class;
				
		
				
		
		
		
		}
		return null;	
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch (columnIndex){
			
			case 0:
				
				return unRapport.get(rowIndex).getBilan();
					
					
				
				
						
			
		}	
		return null;
	}
	
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		if(columnIndex == 5){
			
			return true ;
		}
		else{
			
			return false;
		}
		
	}
	
	
	public void actualiser(){
		this.fireTableDataChanged();
	}

	public int getNumRapport() {
		return numRapport;
	}

	public void setNumRapport(int numRapport) {
		this.numRapport = numRapport;
	}
	

}	

	