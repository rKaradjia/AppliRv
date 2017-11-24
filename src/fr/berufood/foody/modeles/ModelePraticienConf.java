package fr.berufood.foody.modeles;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.berufood.foody.entites.Praticien;

public class ModelePraticienConf extends AbstractTableModel {
	
	private List<Praticien> lesPraticiensConf = ModeleFoody.getPraticienConf() ;
	
	
	private final String[] entetes = { "Nom du Visiteur" , "Nom" , "Prenom" , "Date de Rapport", "Coef de confiance"} ;
	
	@Override
	public int getRowCount() {
		// VOTRE CODE ICI - Question 5
		return lesPraticiensConf.size();
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
		              
		case 2:return String.class;

		case 3:return Date.class;
		
		case 4:return Integer.class;
			
		}
		return null;	
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// VOTRE CODE ICI - Question 5
		switch (columnIndex){
			
			case 0: 
				
					return lesPraticiensConf.get(rowIndex).getNomVisiteur();
		
		
			case 1:
				
					return lesPraticiensConf.get(rowIndex).getNom();
					
					
				
				
			case 2:
				return lesPraticiensConf.get(rowIndex).getPrenom();
					
				
				
			case 3:
				return lesPraticiensConf.get(rowIndex).getDateVisite();
				
			case 4:
				return lesPraticiensConf.get(rowIndex).getRapportConf();
			
					
					
			
		}	
		return null;
	}
	
	public void actualiser(){
		this.fireTableDataChanged();
	}
	

}
