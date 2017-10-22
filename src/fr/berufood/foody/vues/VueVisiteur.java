package fr.berufood.foody.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import fr.berufood.foody.editeur.EditeurBoutonSelectionVisiteur;
import fr.berufood.foody.modeles.ModeleFoody;
import fr.berufood.foody.modeles.ModeleVisiteur;
import fr.berufood.foody.rendus.RenduBoutonSelectionVisiteur;


public class VueVisiteur extends JPanel {
	
	// VOTRE CODE ICI - Question 10----->https://stackoverflow.com/questions/6644922/jtable-cell-renderer
	private ModeleVisiteur modeleTabVisiteur ;
	private JTable tabVisiteur;
	//private RenduCelluleRestaurant renduCellRestaurants;
	
	public VueVisiteur(){
		super() ;
		modeleTabVisiteur = new ModeleVisiteur() ;
		this.creerInterfaceVisiteurs() ;
	}
		// VOTRE CODE ICI - Question 10
private void creerInterfaceVisiteurs(){
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTable = Box.createHorizontalBox() ;
		
		boxEtiquette.add( new JLabel( "Liste des Visiteurs" ) ) ;
		
		
		this.tabVisiteur=new JTable(modeleTabVisiteur);
		this.tabVisiteur.setRowHeight(30);//hauteur de chaques lignes
		JScrollPane spLivreurs= new JScrollPane(this.tabVisiteur);
		spLivreurs.setPreferredSize(new Dimension(1090,420));// y integre un srool d'une dimension de 1090*420
		//tabVisiteur.setDefaultRenderer(Object.class, new RenduCelluleCourse());
		tabVisiteur.getColumn("Lecture rapports").setCellRenderer(new RenduBoutonSelectionVisiteur());
		tabVisiteur.getColumn("Lecture rapports").setCellEditor(new EditeurBoutonSelectionVisiteur());
		
		boxTable.add(spLivreurs);
		boxPrincipale.add(boxTable);
		
	   
		
		
		boxPrincipale.add( boxEtiquette ) ;
		boxPrincipale.add( boxTable ) ;
		
		this.add( boxPrincipale ) ;
	}
	
	
	
	
	
	public ModeleVisiteur getModeleListeVisiteur() {
		return modeleTabVisiteur;
	}

	public JTable getTabVisiteur() {
		return tabVisiteur;
	}
	
	
}