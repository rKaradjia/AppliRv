package fr.berufood.foody.controleurs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;

import fr.berufood.foody.entites.RapportVisite;
import fr.berufood.foody.entites.Visiteur;
import fr.berufood.foody.modeles.ModeleFoody;
import fr.berufood.foody.modeles.ModeleRapportDateVisiteur;
import fr.berufood.foody.modeles.ModeleVisiteur;
import fr.berufood.foody.techniques.ConnexionException;
import fr.berufood.foody.vues.*;

public class ControleurLireRapport implements ActionListener {
	
	private int row ;
	private int column ;
	private JTable table ;
	
	private String matricule;
	private String mois;
	private String annee;
	
	private VueRapportParDate vueparente;
	ArrayList<RapportVisite> lesRapports;// = new ArrayList<RapportVisite>(ModeleFoody.getRapportsVisite(this.vueparente.getMatricule(), this.vueparente.getMois(), this.vueparente.getAnnee()));
	/*public ControleurBoutonSelectionVisiteur() {
		super();
		System.out.println("ControleurBoutonVisiteurs::ControleurBoutonVisiteurs");
	}*/

	
	public ControleurLireRapport(String matricule, String mois, String annee) {
		this.matricule=matricule;
		this.mois=mois;
		this.annee=annee;
		
		System.out.println(this.getMatricule());
		System.out.println(this.getMois());
	lesRapports= new ArrayList<RapportVisite>(ModeleFoody.getRapportsVisite(this.getMatricule(), this.getMois(), this.getAnnee()));

	}
	public ControleurLireRapport() {
		System.out.println("vuedurapport BILLLAAANNN " +this.vueparente.getAnnee());
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	
	
	
	
	
	public int getRow() {
		return row;
	}

	
	public int getColumn() {
		return column;
	}

	
	public JTable getTable() {
		return table;
	}

	
	
	public void setRow(int row) {
		this.row = row;
	}


	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	
	public void setTable(JTable table) {
		this.table = table;
	}

	
	
	public int getNumRapport(){
		
		int numRapport = lesRapports.get(getRow()).getNumRapport();
		System.out.println(numRapport +"Appel du modeleTabRapport");
		return numRapport;
	}
	
	
	
	public void getVueLireRapport() {
		
		VueLireRapport vuelire = new VueLireRapport(this.getNumRapport());
		vuelire.setVisible(true);
		vuelire.setSize(800,400);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
			 System.out.println(this.getRow());            
				
				
				this.getVueLireRapport();
		
		
		
		
		
	}
	
		    
		 
	
		
	    
						
}
