package fr.berufood.foody.modeles;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.berufood.foody.entites.Praticien;





public class ModelePraticienVisite extends AbstractTableModel {
	
	private List<Praticien> lesPraticiensVisite = ModeleFoody.getPraticienVisite() ;
	
	/*om=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville="
			+ ville + ", coefnoto=" + coefnoto + ", code=" + code + "]";*/
	
	private final String[] entetes = { "Nom" , "Prenom" , "Derniere Visite"} ;

	/*public ModeleListeLivreurs() {
		super();
	}*/

	@Override
	public int getRowCount() {
		// VOTRE CODE ICI - Question 5
		return lesPraticiensVisite.size();
	}

	@Override
	public int getColumnCount() {
		// VOTRE CODE ICI - Question 5
		return entetes.length;
	}
	
	@Override
	public String getColumnName(int column) {
		// VOTRE CODE ICI - Question 5
		return entetes[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// VOTRE CODE ICI - Question 5
		switch (columnIndex){
		case 0: return String.class;
				
		case 1:return String.class;
		              
				
		case 2:return Date.class;
		
				
		
		
		
		}
		return null;	
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// VOTRE CODE ICI - Question 5
		switch (columnIndex){
			
			case 0:
				
					return lesPraticiensVisite.get(rowIndex).getNom();
					
					
				
				
			case 1:
				return lesPraticiensVisite.get(rowIndex).getPrenom();
					
				
				
			case 2:
				return lesPraticiensVisite.get(rowIndex).getDateVisite();
			
					
					
			
		}	
		return null;
	}
	
	public void actualiser(){
		this.fireTableDataChanged();
	}

}
