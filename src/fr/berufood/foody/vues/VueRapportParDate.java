package fr.berufood.foody.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.berufood.foody.controleurs.ControleurBoutonSelectionVisiteur;
import fr.berufood.foody.modeles.ModelePraticienNoto;
import fr.berufood.foody.modeles.ModeleRapportDateVisiteur;

public class VueRapportParDate extends JFrame {
	
	
	private ControleurBoutonSelectionVisiteur controleurParent;
	private VueVoirSelectionDate vueParente;
	private ModeleRapportDateVisiteur modele ;
	private JTable tabRapport;
	
	//private RenduCelluleRestaurant renduCellRestaurants;
	
	public VueRapportParDate(){
		super() ;
		modele = new ModeleRapportDateVisiteur() ;
		this.creerInterfaceVisiteurs() ;
	}
		// VOTRE CODE ICI - Question 10
    private void creerInterfaceVisiteurs(){
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTable = Box.createHorizontalBox() ;
		
		boxEtiquette.add( new JLabel( "Coeficient de notoriete" ) ) ;
		
		// VOTRE CODE ICI - Question 6
		
		this.tabRapport=new JTable(modele);
		this.tabRapport.setRowHeight(30);//hauteur de chaques lignes
		JScrollPane spLivreurs= new JScrollPane(this.tabRapport);
		spLivreurs.setPreferredSize(new Dimension(1090,420));// y integre un srool d'une dimension de 1090*420
		//tabPraticienNoto.getColumn("").setCellRenderer(new RendusBoutonVoirVisiteur());
		
		
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
	
	// VOTRE CODE ICI - Question 10

}

