package fr.berufood.foody.vues;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import fr.berufood.foody.controleurs.ControleurAuthentification;
import fr.berufood.foody.controleurs.ControleurBoutonSelectionVisiteur;
import fr.berufood.foody.controleurs.ControleurSelectionDate;

public class VueVoirSelectionDate extends JDialog   {
	//VueFoody vueParente ;
	VueVisiteur vueParente ;
	//VueFoody vuePr ;
	ControleurSelectionDate controleur ;
	private String mois;
	private String annee;
	
	
	
	String [] month = {"...","01","02","03","04","05","06","07","08","09","10","11","12"};
	private JComboBox combobox = new JComboBox(month) ;
	String []year = {"...","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"};
	private JComboBox combobox_1 = new JComboBox(year) ;
	private JButton bValider = new JButton("Valider") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	public VueVoirSelectionDate(VueVisiteur vueParente){
		// Appel du constructeur de la super-classe
		//	Troisième argument : true pour indiquer que la boîte de dialogue est modale 
		super() ;
		
		// Mémorise la vue parente qui est la fenêtre principale de l'application
		this.vueParente = vueParente ;
		
		// Crée le formulaire de saisie
		this.creerInterfaceUtilisateur() ;
		
		// Redimensionne la boîte de dialogue (dimensions adaptées aux composants qui s'y trouvent)
		this.pack() ;
		
		// Positionne la boîte de dialogue au centre de l'écran
		this.setLocationRelativeTo(null) ;
		
		// Empêche le redimensionnement par l'utilisateur
		this.setResizable(false);
		
		// Crée le controleur associé et lui indique que le vue qui lui
		// est associée est elle-même
		//this.controleur = new ControleurAuthentification(this) ;
	//	ControleurBoutonSelectionVisiteur
		// Affiche la boîte de dialogue
		this.setVisible(true) ;
		
	}
	
	
	
	
	/** Initialiser les champs de saisie
	 * 
	 */
	public void initialiser(){
				
		// VOTRE CODE : 
		// Afficher une chaîne de caractères vide dans les deux
		// champs de saisie (login et MDP)
		//this.tfLogin.setText("");
		
		//this.pfMdp.setText("");
		
	}
	
	/** Créer l'interface utilisateur
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueAuthentification::creerInterfaceUtilisateur()") ;
		
		Container conteneur = this.getContentPane() ;
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxChamps = Box.createHorizontalBox() ;
		Box boxEtiquettes = Box.createVerticalBox() ;
		Box boxSaisies = Box.createVerticalBox() ;
		Box boxLigne = Box.createHorizontalBox() ;
		Box boxActions = Box.createHorizontalBox() ;
		
		boxEtiquettes.add(new JLabel("Login : ")) ;
		boxEtiquettes.add( Box.createVerticalStrut(10) ) ;
		boxEtiquettes.add(new JLabel("MDP : ")) ;
		
		boxSaisies.add( this.combobox) ;
		boxSaisies.add( Box.createVerticalStrut(10) ) ;
		boxSaisies.add( this.combobox_1) ;
		
		boxLigne.add( Box.createHorizontalStrut( 10 ) ) ;
		boxLigne.add( new JSeparator() ) ;
		boxLigne.add( Box.createHorizontalStrut( 10 ) ) ;
		
		// VOTRE CODE :
		// Agence les boutons "Se connecter" et "Annuler"
		boxActions.add( Box.createHorizontalStrut( 10 ) ) ;
		boxActions.add( this.bValider ) ;
		boxActions.add( Box.createHorizontalStrut( 10 ) ) ;
		boxActions.add( this.bAnnuler ) ;
		boxActions.add( Box.createHorizontalStrut( 10 ) ) ;
		
		
		
		
		boxChamps.add( Box.createHorizontalStrut( 10 ) ) ;
		boxChamps.add( boxEtiquettes ) ;
		boxChamps.add( Box.createHorizontalStrut( 10 ) ) ;
		boxChamps.add( boxSaisies ) ;
		boxChamps.add( Box.createHorizontalStrut( 10 ) ) ;
		
		boxPrincipale.add( Box.createVerticalStrut( 10 ) ) ;
		boxPrincipale.add( boxChamps ) ;
		boxPrincipale.add( Box.createVerticalStrut( 10 ) ) ;
		boxPrincipale.add( boxLigne ) ;
		boxPrincipale.add( Box.createVerticalStrut( 10 ) ) ;
		boxPrincipale.add( boxActions ) ;
		boxPrincipale.add( Box.createVerticalStrut( 10 ) ) ;
		
		conteneur.add(boxPrincipale) ;
		
		
		// Le code qui suit permet d'adapter la taille du bouton
		// "Annuler" par rapport à celle du bouton "Se connecter"
		
		Dimension dimensionBouton = this.bValider.getPreferredSize() ;
		
		this.bAnnuler.setPreferredSize(dimensionBouton) ;
		System.out.println(this.bAnnuler.getPreferredSize()) ;
		this.bAnnuler.setMaximumSize(dimensionBouton) ;
		System.out.println(this.bAnnuler.getPreferredSize()) ;
		this.bAnnuler.setMinimumSize(dimensionBouton) ;
		System.out.println(this.bAnnuler.getPreferredSize()) ;
		
	}

	public String getmois() {
		Object combo = combobox.getSelectedItem();
		String mois = combo.toString();
		System.out.println(mois);
		return mois;
	}

	public String getannee() {
		Object combo = combobox_1.getSelectedItem();
		String annee = combo.toString();
		System.out.println(annee);
		return annee;
	}

	public JComboBox getCombobox() {
		return combobox;
	}



	public JComboBox getCombobox_1() {
		return combobox_1;
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




	public JButton getbValider() {
		return bValider;
	}

	public JButton getbAnnuler() {
		return bAnnuler;
	}

}
