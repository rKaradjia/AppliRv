package fr.berufood.foody.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import fr.berufood.foody.modeles.ModeleFoody;
import fr.berufood.foody.modeles.ModeleVisiteur;


public class VueVisiteur extends JPanel {
	private final String[] entetes = { "Nom" , "Lieu" } ;
	// VOTRE CODE ICI - Question 10----->https://stackoverflow.com/questions/6644922/jtable-cell-renderer
	private ModeleVisiteur modele ;
	private JTable tabVisiteur;
	//private RenduCelluleRestaurant renduCellRestaurants;
	
	public VueVisiteur(){
		super() ;
		modele = new ModeleVisiteur() ;
		this.creerInterfaceVisiteurs() ;
	}
		// VOTRE CODE ICI - Question 10
private void creerInterfaceVisiteurs(){
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTable = Box.createHorizontalBox() ;
		
		boxEtiquette.add( new JLabel( "Liste des Visiteurs" ) ) ;
		
		// VOTRE CODE ICI - Question 6
		
		this.tabVisiteur=new JTable(modele);
		this.tabVisiteur.setRowHeight(30);//hauteur de chaques lignes
		JScrollPane spRestaurant= new JScrollPane(this.tabVisiteur);
		//tabVisiteur.setDefaultRenderer(String.class, new RenduCelluleRestaurant());
		spRestaurant.setPreferredSize(new Dimension(1090,420));// y integre un srool d'une dimension de 1090*420

		boxTable.add(spRestaurant);
		boxPrincipale.add(boxTable);
	   
		
		
		boxPrincipale.add( boxEtiquette ) ;
		boxPrincipale.add( boxTable ) ;
		
		this.add( boxPrincipale ) ;
	}
	
	
	
	
	
	public ModeleVisiteur getModeleListeVisiteur() {
		return modele;
	}

	public JTable getTabVisiteur() {
		return tabVisiteur;
	}
	
	// VOTRE CODE ICI - Question 10

}