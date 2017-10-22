package fr.berufood.foody.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.berufood.foody.entites.Visiteur;
import fr.berufood.foody.techniques.DateFr;




public class ModeleVisiteur extends AbstractTableModel {
	
	private List<Visiteur> lesVisiteurs = ModeleFoody.getVisiteur() ;
	//Course(int numero, DateFr date, Client leClient, Restaurant leRestaurant, Livreur leLivreur)
	private final String[] entetes = { "Nom" , "Prenom" , "Date embauche" , "Ville","Lecture rapports" } ;

	/*public ModeleListeLivreurs() {
		super();
	}*/

	@Override
	public int getRowCount() {
		// VOTRE CODE ICI - Question 5
		return lesVisiteurs.size();
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
		case 3:return String.class;
		case 4:return String.class;
				
		
		
		
		}
		return null;	
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// VOTRE CODE ICI - Question 5
		switch (columnIndex){
			
			case 0:
				
					return lesVisiteurs.get(rowIndex).getNom();
					
					
				
				
			case 1:
				return lesVisiteurs.get(rowIndex).getPrenom();
					
				
				
			case 2:
				return lesVisiteurs.get(rowIndex).getDateEmbauche();
			case 3:return lesVisiteurs.get(rowIndex).getVille();
			case 4:return "Voir";
					
					
			
		}	
		return null;
	}
	
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		if(columnIndex == 4){
			
			return true ;
		}
		else{
			
			return false;
		}
		
	}
	
	public void actualiser(){
		this.fireTableDataChanged();
	}

}
