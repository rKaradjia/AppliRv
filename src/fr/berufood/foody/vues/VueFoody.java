package fr.berufood.foody.vues;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import fr.berufood.foody.controleurs.ControleurFoody;
import fr.berufood.foody.controleurs.ControleurVisiteur;

import javax.swing.JTable;
import java.awt.BorderLayout;

public class VueFoody extends JFrame {

	// Contrôleur associé à la vue
	private ControleurFoody controleur ;	
	private ControleurVisiteur controleurVisiteur;
	
	// Les menus
	private JMenu menuFichier = new JMenu("Fichier") ;	
	private JMenu menuAide = new JMenu("Aide") ;
	private JMenu menuRapport = new JMenu("Rapport") ;
	private JMenu menuPraticiens = new JMenu("Praticiens") ;
	
	
	// Les items de menu
	private JMenuItem itemSeConnecter = new JMenuItem("Se connecter") ;			
	private JMenuItem itemSeDeconnecter = new JMenuItem("Se déconnecter") ;
	private JMenuItem itemQuitter = new JMenuItem("Quitter") ;
	
	private JMenuItem itemLire = new JMenuItem("Lire") ;
	private JMenuItem itemModifier = new JMenuItem("Modifier") ;
	
	private JMenuItem itemSelectPraticien = new JMenuItem("Selectionner");
	
	private JMenuItem itemSelectMedica = new JMenuItem("Selectionner");
	
	
	private JMenuBar barreMenus = new JMenuBar() ;
	
	public VueFoody(){
		super() ;
		
		// Donne un titre à la fenêtre
		this.setTitle("Foody") ;
		
		// Définit le largeur et la hauteur de la fenêtre
		this.setSize(500,400) ;
		
		// Positionne la fenêtre au centre de l'écran
		this.setLocationRelativeTo(null) ;
		
		// Empêche l'utilisateur de fermer la fenêtre à l'aide de la croix
		// qui se trouve en haut à droite
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		// Empêche le redimensionnement par l'utilisateur
		this.setResizable(false);
		
		// Crée la barre de menus
		this.creerBarreMenus();
		
		// Bascule la barre de menus dans le "Mode non connecte"
		this.setBarreMenusModeDeconnecte();
		
		// Crée le controleur associé et lui indique que le vue qui lui
		// est associée est elle-même
		this.controleur = new ControleurFoody(this) ;
	//	this.controleurVisiteur=new ControleurVisiteur(this);
		
		// Affiche la fenêtre
		this.setVisible(true) ;
	}
	
	private void creerBarreMenus(){
		
		// Crée une barre de menu vide
		//JMenuBar barreMenus = new JMenuBar() ;
		
		// Ajoute les items de menu dans leur menu respectif
		this.menuFichier.add(this.itemSeConnecter) ;
		this.menuFichier.add(this.itemSeDeconnecter) ;
		this.menuFichier.add( new JSeparator() ) ;
		this.menuFichier.add(this.itemQuitter) ;
		
		this.menuRapport.add(this.itemLire) ;
		this.menuRapport.add(this.itemModifier) ;
		
		this.menuPraticiens.add(itemSelectPraticien );
		
		
		// Ajoute les menus dans la barre de menu
		barreMenus.add(menuFichier) ;
		barreMenus.add(menuAide) ;
		barreMenus.add(menuRapport);
		barreMenus.add(menuPraticiens);
		
		
		// Ajoute la barre de menus à la fenêtre
		this.setJMenuBar(barreMenus) ;
	}
	
	
	/*public void creerBarreAuthentifie(){
	//	JMenuBar barreMenus2 = new JMenuBar() ;
		this.menuRapport.add(this.itemLire) ;
		this.menuRapport.add(this.itemModifier) ;
		
		this.menuPraticiens.add(itemSelectPraticien );
		
		this.menuMedicaments.add(itemSelectMedica);
		
		barreMenus.add(menuFichier) ;
		barreMenus.add(menuAide) ;
		barreMenus.add(menuRapport);
		barreMenus.add(menuPraticiens);
		barreMenus.add(menuMedicaments);
		
		this.setJMenuBar(barreMenus) ;
		
	}*/
	
	
	
	public void setBarreMenusModeConnecte(){
		// Désactive l'item de menu "Se connecter"
		this.itemSeConnecter.setEnabled(false) ;
		
		// Active l'item de menu "Se déconnecter"
		this.itemSeDeconnecter.setEnabled(true) ;
	}
	
	public void setBarreMenusModeDeconnecte(){
		
		// Active l'item de menu "Se connecter"
		this.itemSeConnecter.setEnabled(true) ;
		
		// Désactive l'item de menu "Se déconnecter"
		this.itemSeDeconnecter.setEnabled(false) ;
		
	}

	public ControleurFoody getControleur() {
		return controleur;
	}

	public JMenuItem getItemSeConnecter() {
		return itemSeConnecter;
	}

	public JMenuItem getItemSeDeconnecter() {
		return itemSeDeconnecter;
	}

	public JMenuItem getItemQuitter() {
		return itemQuitter;
	}

	public JMenuItem getItemApropos() {
		return itemLire;
	}
	
	public JMenuItem getItemLire() {
		return itemLire;
	}
	
	public JMenuItem getItemModifier() {
		return itemModifier;
	}
	
	public JMenuItem getItemSelectPraticien() {
		return itemSelectMedica;
	}
	
	public JMenuItem getItemSelectMedica() {
		return itemSelectPraticien;
	}


}
