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
import fr.berufood.foody.modeles.ModeleLireRapport;
import fr.berufood.foody.modeles.ModelePraticienNoto;
import fr.berufood.foody.modeles.ModeleRapportDateVisiteur;
import fr.berufood.foody.rendus.RenduBoutonSelectionVisiteur;
import fr.berufood.foody.techniques.ConnexionException;

public class VueLireRapport extends JFrame {
	private int numRapport;
	
	
	private ModeleLireRapport modele ;
	private JTable tabRapport;
	
	//private RenduCelluleRestaurant renduCellRestaurants;
	
	public VueLireRapport(int numRapport) {
		super() ;
		this.numRapport=numRapport;
		System.out.println("Verification de la recuperation des informations"
				+ " VueLireRapport" + this.getNumRapport());
		modele = new ModeleLireRapport(this.getNumRapport());
		this.creerInterfaceVisiteurs() ;
	}
		
	

	// VOTRE CODE ICI - Question 10
    private void creerInterfaceVisiteurs(){
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTable = Box.createHorizontalBox() ;
		
		boxEtiquette.add( new JLabel( "Lecture du rapport" ) ) ;
		
		// VOTRE CODE ICI - Question 6
		
		this.tabRapport=new JTable(modele);
		this.tabRapport.setRowHeight(30);//hauteur de chaques lignes
		JScrollPane spLivreurs= new JScrollPane(this.tabRapport);
		spLivreurs.setPreferredSize(new Dimension(1090,420));// y integre un srool d'une dimension de 1090*420
		
		
		
		
		boxTable.add(spLivreurs);
		boxPrincipale.add(boxTable);
		
	   
		
		
		boxPrincipale.add( boxEtiquette ) ;
		boxPrincipale.add( boxTable ) ;
		
		this.add( boxPrincipale ) ;
	}
	
	
	
	
	
	public ModeleLireRapport getModele() {
		return modele;
	}

	public JTable getTabRapport() {
		return tabRapport;
	}
	
	
	
	public int getNumRapport() {
		return numRapport;
	}

	public void setNumRapport(int numRapport) {
		this.numRapport = numRapport;
	}
	
	
}	
