package fr.berufood.foody.modeles;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.berufood.foody.entites.Visiteur;
import fr.berufood.foody.techniques.DateFr;




public class ModeleVisiteur extends AbstractTableModel {
	
	private List<Visiteur> lesVisiteurs = ModeleFoody.getVisiteur() ;
	//Course(int numero, DateFr date, Client leClient, Restaurant leRestaurant, Livreur leLivreur)
	private final String[] entetes = { "Matricule","Nom" , "Prenom" , "Date embauche" , "Ville","Lecture rapports" } ;

	/*public ModeleListeLivreurs() {
		super();
	}*/

	@Override
	public int getRowCount() {
		
		return lesVisiteurs.size();
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
		  case 1: return String.class;
		  case 2:return String.class;
		              
				
		case 3:return Date.class;
		case 4:return String.class;
		case 5:return String.class;
				
		
		
		
		}
		return null;	
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// VOTRE CODE ICI - Question 5
		switch (columnIndex){
			
			case 0:{
			
			return lesVisiteurs.get(rowIndex).getMatricule();
				}
			case 1:{
				
					return lesVisiteurs.get(rowIndex).getNom();
				
					}
			case 2:{
				return lesVisiteurs.get(rowIndex).getPrenom();}
					
		case 3:{
				return lesVisiteurs.get(rowIndex).getDateEmbauche();}
				
		case 4:{return lesVisiteurs.get(rowIndex).getVille();}
			
		case 5:{return "Voir";}
			
		     	
					
					
			
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

	/*public String getMatriculeVisiteur(int index) {
		
			String resultat = lesVisiteurs.get(index).getMatricule() ;
			 
			return resultat;
	
	}*/

}
