package fr.berufood.foody.modeles;

import java.sql.Date;
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
	private List<RapportVisite> lesRapports = ModeleFoody.getRapportVisite(this.controleur.getMatricule(),this.vue.getMois(),this.vue.getAnnee()) ;
	
	
	/*Note localisation des informations suivantes Matricule : ControleurBoutonSelectionVisiteur variable matricule 
	 * 											    Mois et annee : VueVoirSelectionDate 
	 */
	
	/*+---------------+--------------+------+-----+---------+-------+
	| Field         | Type         | Null | Key | Default | Extra |
	+---------------+--------------+------+-----+---------+-------+
	| VIS_MATRICULE | varchar(20)  | NO   | PRI |         |       |
	| RAP_NUM       | int(11)      | NO   | PRI | 0       |       |
	| PRA_NUM       | int(11)      | YES  | MUL | NULL    |       |
	| RAP_BILAN     | varchar(510) | YES  |     |         |       |
	| RAP_DATE      | date         | YES  |     | NULL    |       |
	| RAP_DATEREDAC | date         | YES  |     | NULL    |       |
	+---------------+--------------+------+-----+---------+-------+*/

	private final String[] entetes = { "Numero du rapport" , "Nom du praticien" , "Bilan","Date de la visite","Date de la redaction"} ;

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
		case 0: return Integer.class;
				
		case 1:return String.class;
		              
				
		case 2:return String.class;
		
		case 3:return Date.class;
		
		case 4:return Date.class;
		
				
		
		
		
		}
		return null;	
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// VOTRE CODE ICI - Question 5
		switch (columnIndex){
			
			case 0:
				
					return lesRapports.get(rowIndex).getNumRapport();
					
					
				
				
			case 1:
				return lesRapports.get(rowIndex).getLePraticien().getNom();
					
				
				
			case 2:
				return lesRapports.get(rowIndex).getBilan();
				
			case 3:
				return lesRapports.get(rowIndex).getDateVisite();
				
			case 4:
				return lesRapports.get(rowIndex).getDateRedac();	
			
					
					
			
		}	
		return null;
	}
	
	public void actualiser(){
		this.fireTableDataChanged();
	}

}
