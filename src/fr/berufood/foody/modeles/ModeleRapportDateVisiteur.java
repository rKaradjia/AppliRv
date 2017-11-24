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
	
	private String mois;
	private String annee;
	private String matricule;
	private List<RapportVisite> lesRapports ;
			
	
	public ModeleRapportDateVisiteur(String matricule, String mois, String annee) {
		this.matricule=matricule;
		this.annee=annee;
		this.mois=mois;
		System.out.println("ModeleRapportDateVisite" + "" +this.getMatricule() + " " + this.getMois() + " "+this.getAnnee());
		lesRapports = ModeleFoody.getRapportsVisite(this.getMatricule(),this.getMois(),this.annee);
	}
	
	

	private final String[] entetes = { "Numero du rapport" , "Nom du praticien" ,"Prenom du praticien","Date de la visite","Date de la redaction" ,"Lire"} ;


	@Override
	public int getRowCount() {
		
		return lesRapports.size();
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
		case 0: return Integer.class;
				
		case 1:return String.class;
		              
		case 2:return String.class;	
		
		case 3:return Date.class;
		
		case 4:return Date.class;
		
		case 5:return String.class;
				
		
		
		
		}
		return null;	
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch (columnIndex){
			
			case 0:
				
					return lesRapports.get(rowIndex).getNumRapport();
					
					
				
				
			case 1:
				return lesRapports.get(rowIndex).getNomPraticien();
					
			case 2:
				return lesRapports.get(rowIndex).getPrenomPraticien();
					
					
				
			
				
			case 3:
				return lesRapports.get(rowIndex).getDateVisite();
				
			case 4:
				return lesRapports.get(rowIndex).getDateRedac();	
			
			case 5:return "Lire";				
			
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
	public ControleurBoutonSelectionVisiteur getControleur() {
		System.out.println("Recuperation du controleur selectionVisiteur oour les rapports"+ this.getControleur().getMatricule());
		return controleur;
	}

	public VueRapportParDate getVue() {
		
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
