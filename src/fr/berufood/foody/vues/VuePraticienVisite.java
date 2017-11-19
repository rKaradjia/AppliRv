package fr.berufood.foody.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import fr.berufood.foody.modeles.ModeleFoody;

import fr.berufood.foody.modeles.ModelePraticienVisite;
import fr.berufood.foody.modeles.ModeleVisiteur;

//import fr.berufood.foody.rendus.RendusBoutonVoirVisiteur;


public class VuePraticienVisite extends JPanel {
	

	private ModelePraticienVisite modeleTabPraticienVisite ;
	private JTable tabPraticienVisite;
	
	
	public VuePraticienVisite(){
		super() ;
		modeleTabPraticienVisite = new ModelePraticienVisite() ;
		this.creerInterfaceVisiteurs() ;
	}	
	
	
	
private void creerInterfaceVisiteurs(){
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTable = Box.createHorizontalBox() ;
		
		boxEtiquette.add( new JLabel( "Derniere visite " ) ) ;
		
		// VOTRE CODE ICI - Question 6
		
		this.tabPraticienVisite=new JTable(modeleTabPraticienVisite);
		this.tabPraticienVisite.setRowHeight(30);//hauteur de chaques lignes
		JScrollPane spLivreurs= new JScrollPane(this.tabPraticienVisite);
		spLivreurs.setPreferredSize(new Dimension(1090,420));// y integre un srool d'une dimension de 1090*420
		//tabPraticienNoto.getColumn("").setCellRenderer(new RendusBoutonVoirVisiteur());
		
		
		boxTable.add(spLivreurs);
		boxPrincipale.add(boxTable);
		
		boxPrincipale.add( boxEtiquette ) ;
		boxPrincipale.add( boxTable ) ;
		
		this.add( boxPrincipale ) ;
	}
	
	
	
	public ModelePraticienVisite getModeleListePraticienVisite() {
		return modeleTabPraticienVisite;
	}

	public JTable getTabPraticien() {
		return tabPraticienVisite;
	}
}
	
	// VOTRE CODE ICI - Question 10

