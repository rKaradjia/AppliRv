package fr.berufood.foody.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.berufood.foody.controleurs.ControleurBoutonSelectionVisiteur;
import fr.berufood.foody.editeur.EditeurBoutonSelectionVisiteur;
import fr.berufood.foody.modeles.ModelePraticienNoto;
import fr.berufood.foody.modeles.ModeleRapportDateVisiteur;
import fr.berufood.foody.rendus.RenduBoutonSelectionVisiteur;

public class VueRapportParDate extends JFrame {
	private String mois;
	private String annee;
	private String matricule;
	
	private ControleurBoutonSelectionVisiteur controleurParent;
	private VueVoirSelectionDate vueParente;
	private ModeleRapportDateVisiteur modele ;
	private JTable tabRapport;
	
	//private RenduCelluleRestaurant renduCellRestaurants;
	
	public VueRapportParDate(String mois,String annee,String matricule){
		super() ;
		this.matricule=matricule;
		this.mois=mois;
		this.annee=annee;
		System.out.println("Verification de la recuperation des informations"
				+ " VueRapportParDate" + this.getMatricule() +" "+ this.getMois() + " " +this.getAnnee());
		modele = new ModeleRapportDateVisiteur(this.getMatricule(),this.getMois(),this.getAnnee()) ;
		this.creerInterfaceVisiteurs() ;
	}
		
	// VOTRE CODE ICI - Question 10
    private void creerInterfaceVisiteurs(){
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTable = Box.createHorizontalBox() ;
		
		boxEtiquette.add( new JLabel( "Liste des rapports du visiteur pour la date donnée" ) ) ;
		
		// VOTRE CODE ICI - Question 6
		
		this.tabRapport=new JTable(modele);
		this.tabRapport.setRowHeight(30);//hauteur de chaques lignes
		JScrollPane spLivreurs= new JScrollPane(this.tabRapport);
		spLivreurs.setPreferredSize(new Dimension(1090,420));// y integre un srool d'une dimension de 1090*420
		tabRapport.getColumn("Lire").setCellRenderer(new RenduBoutonSelectionVisiteur());
		tabRapport.getColumn("Lire").setCellEditor(new EditeurBoutonSelectionVisiteur());
		
		
		boxTable.add(spLivreurs);
		boxPrincipale.add(boxTable);
		
	   
		
		
		boxPrincipale.add( boxEtiquette ) ;
		boxPrincipale.add( boxTable ) ;
		
		this.add( boxPrincipale ) ;
	}
	
	
	
	
	
	public ModeleRapportDateVisiteur getModele() {
		return modele;
	}

	public JTable getTabRapport() {
		return tabRapport;
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
	// VOTRE CODE ICI - Question 10

}

