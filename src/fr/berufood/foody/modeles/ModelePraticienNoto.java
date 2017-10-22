package fr.berufood.foody.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.berufood.foody.entites.Praticien;
import fr.berufood.foody.entites.Visiteur;
import fr.berufood.foody.techniques.DateFr;




public class ModelePraticienNoto extends AbstractTableModel {
	
	private List<Praticien> lesPraticiensNoto = ModeleFoody.getPraticienNoto() ;
	
	/*om=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville="
			+ ville + ", coefnoto=" + coefnoto + ", code=" + code + "]";*/
	
	private final String[] entetes = { "Nom" , "Prenom" , "Coef Notoriete"} ;

	/*public ModeleListeLivreurs() {
		super();
	}*/

	@Override
	public int getRowCount() {
		// VOTRE CODE ICI - Question 5
		return lesPraticiensNoto.size();
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
		              
				
		case 2:return Float.class;
		
				
		
		
		
		}
		return null;	
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// VOTRE CODE ICI - Question 5
		switch (columnIndex){
			
			case 0:
				
					return lesPraticiensNoto.get(rowIndex).getNom();
					
					
				
				
			case 1:
				return lesPraticiensNoto.get(rowIndex).getPrenom();
					
				
				
			case 2:
				return lesPraticiensNoto.get(rowIndex).getCoefnoto();
			
					
					
			
		}	
		return null;
	}
	
	public void actualiser(){
		this.fireTableDataChanged();
	}

}
