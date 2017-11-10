package fr.berufood.foody.modeles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.berufood.foody.controleurs.ControleurBoutonSelectionVisiteur;
import fr.berufood.foody.entites.Praticien;
import fr.berufood.foody.entites.RapportVisite;
import fr.berufood.foody.entites.Visiteur;
import fr.berufood.foody.techniques.DateFr;
import fr.berufood.foody.vues.VueVoirSelectionDate;




public class ModeleRapportDateVisiteur extends AbstractTableModel {
	
	private ControleurBoutonSelectionVisiteur controleur;
	private VueVoirSelectionDate vue;
	private List<RapportVisite> lesRapports = ModeleFoody.getRapportVisite(this.controleur.getMatricule(),this.vue.getAnneeString(),this.vue.getAnneeString()) ;
	
	
	/*Note localisation des informations suivantes Matricule : ControleurBoutonSelectionVisiteur variable matricule 
	 * 											    Mois et annee : VueVoirSelectionDate 
	 */
	
	
	private final String[] entetes = { "Nom" , "Prenom" , "Coef Notoriete"} ;

	/*public ModeleListeLivreurs() {
		super();
	}*/

	@Override
	public int getRowCount() {
		// VOTRE CODE ICI - Question 5
		return lesRapports.size();
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
				
					return lesRapports.get(rowIndex).getNom();
					
					
				
				
			case 1:
				return lesRapports.get(rowIndex).getPrenom();
					
				
				
			case 2:
				return lesRapports.get(rowIndex).getCoefnoto();
			
					
					
			
		}	
		return null;
	}
	
	public void actualiser(){
		this.fireTableDataChanged();
	}

}
