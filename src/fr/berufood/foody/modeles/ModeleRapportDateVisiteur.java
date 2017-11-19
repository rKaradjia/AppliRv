package fr.berufood.foody.modeles;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.berufood.foody.controleurs.*;
import fr.berufood.foody.entites.RapportVisite;
import fr.berufood.foody.vues.*;




public class ModeleRapportDateVisiteur extends AbstractTableModel {
	
	private ControleurBoutonSelectionVisiteur controleur;
	//private VueVoirSelectionDate vue;
	private VueRapportParDate vue;
	//private String matricule= this.getControleur().getMatricule(); ==> mise en commentaire par AKA
	private String mois/* = this.getVue().getMois()*/;
	private String annee/*= this.getVue().getAnnee()*/;
	private String matricule/*= this.getVue().getMatricule()*/;
	private List<RapportVisite> lesRapports ;
			
	
	public ModeleRapportDateVisiteur(String matricule, String mois, String annee) {
		this.matricule=matricule;
		this.annee=annee;
		this.mois=mois;
		System.out.println("ModeleRapportDateVisite" + "" +this.getMatricule() + " " + this.getMois() + " "+this.getAnnee());
		lesRapports = ModeleFoody.getRapportVisite(this.getMatricule(),this.getMois(),this.annee);
	}
	
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

	private final String[] entetes = { "Numero du rapport" , "Nom du praticien" ,"Prenom du praticien", "Bilan","Date de la visite","Date de la redaction" ,"Lire"} ;

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
		
		case 3:return String.class;
		
		case 4:return Date.class;
		
		case 5:return Date.class;
		
		case 6:return String.class;
				
		
		
		
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
				return lesRapports.get(rowIndex).getNomPraticien();
					
			case 2:
				return lesRapports.get(rowIndex).getPrenomPraticien();
					
					
				
			case 3:
				return lesRapports.get(rowIndex).getBilan();
				
			case 4:
				return lesRapports.get(rowIndex).getDateVisite();
				
			case 5:
				return lesRapports.get(rowIndex).getDateRedac();	
			
			case 6:return "Lire";				
			
		}	
		return null;
	}
	
	public void actualiser(){
		this.fireTableDataChanged();
	}
	public ControleurBoutonSelectionVisiteur getControleur() {
		System.out.println("Recuperation du controleur selectionVisiteur oour les rapports"+ this.getControleur().getMatricule());
		return controleur;
	}

	public VueRapportParDate getVue() {
		//System.out.println("Recuperation de la date saisie par utilisateur" + this.getVue().getAnnee());
		return vue;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
