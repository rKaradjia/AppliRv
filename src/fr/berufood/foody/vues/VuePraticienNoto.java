package fr.berufood.foody.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import fr.berufood.foody.modeles.ModeleFoody;
import fr.berufood.foody.modeles.ModelePraticienNoto;
import fr.berufood.foody.modeles.ModeleVisiteur;

//import fr.berufood.foody.rendus.RendusBoutonVoirVisiteur;


public class VuePraticienNoto extends JPanel {
	
	// VOTRE CODE ICI - Question 10----->https://stackoverflow.com/questions/6644922/jtable-cell-renderer
	private ModelePraticienNoto modeleTabPraticienNoto ;
	private JTable tabPraticienNoto;
	
	//private RenduCelluleRestaurant renduCellRestaurants;
	
	public VuePraticienNoto(){
		super() ;
		modeleTabPraticienNoto = new ModelePraticienNoto() ;
		this.creerInterfaceVisiteurs() ;
	}
		// VOTRE CODE ICI - Question 10
private void creerInterfaceVisiteurs(){
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTable = Box.createHorizontalBox() ;
		
		boxEtiquette.add( new JLabel( "Coeficient de notoriete" ) ) ;
		
		// VOTRE CODE ICI - Question 6
		
		this.tabPraticienNoto=new JTable(modeleTabPraticienNoto);
		this.tabPraticienNoto.setRowHeight(30);//hauteur de chaques lignes
		JScrollPane spLivreurs= new JScrollPane(this.tabPraticienNoto);
		spLivreurs.setPreferredSize(new Dimension(1090,420));// y integre un srool d'une dimension de 1090*420
		//tabPraticienNoto.getColumn("").setCellRenderer(new RendusBoutonVoirVisiteur());
		
		
		boxTable.add(spLivreurs);
		boxPrincipale.add(boxTable);
		
	   
		
		
		boxPrincipale.add( boxEtiquette ) ;
		boxPrincipale.add( boxTable ) ;
		
		this.add( boxPrincipale ) ;
	}
	
	
	
	
	
	public ModelePraticienNoto getModeleListePraticienNoto() {
		return modeleTabPraticienNoto;
	}

	public JTable getTabPraticien() {
		return tabPraticienNoto;
	}
	
	// VOTRE CODE ICI - Question 10

}