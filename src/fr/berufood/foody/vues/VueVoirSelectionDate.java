package fr.berufood.foody.vues;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import fr.berufood.foody.editeur.EditeurBoutonSelectionVisiteur;
import fr.berufood.foody.modeles.ModeleVisiteur;
import fr.berufood.foody.rendus.RenduBoutonSelectionVisiteur;


public class VueVoirSelectionDate extends JPanel {
	
private static final long serialVersionUID = 1L;
	
	//private ControleurVueComboCR controleur ;
	
	private JComboBox cbMois = new JComboBox() ;
	private JComboBox cbAnnees = new JComboBox() ;
	
	private JButton bValider = new JButton("Valider") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	/** Constructeur
	 * @param vueParente
	 */


	public VueVoirSelectionDate() {
		System.out.println("VueComboCR::VueComboCR()") ;
		
		this.creerInterfaceUtilisateur() ;
	}

	


	public VueVoirSelectionDate(VueAccueil vue) {
		// TODO Auto-generated constructor stub
	}




	/** Créer l'interface utilisateur
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueComboCR::creerInterfaceUtilisateur()") ;
		
		
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxMois = Box.createHorizontalBox() ;
		Box boxAnnee = Box.createHorizontalBox() ;
		Box boxEtiquetteMois = Box.createHorizontalBox() ;
		Box boxEtiquetteAnnee = Box.createHorizontalBox() ;

		Box boxLigne = Box.createHorizontalBox() ;
		Box boxActions = Box.createHorizontalBox() ;
		
		boxEtiquetteMois.add(new JLabel("Mois : ")) ;
		boxEtiquetteAnnee.add(new JLabel("Année : ")) ;
		
		boxMois.add(boxEtiquetteMois);
		boxMois.add(this.cbMois) ;
		
		boxAnnee.add(boxEtiquetteAnnee);
		boxAnnee.add(this.cbAnnees) ;
	
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		boxLigne.add(new JSeparator()) ;
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bValider) ;
		bValider.setActionCommand("bValider");
		boxActions.add(Box.createHorizontalStrut(5)) ;

		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bAnnuler) ;
		bAnnuler.setActionCommand("bValider");
		boxActions.add(Box.createHorizontalStrut(5)) ;
		
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxMois) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxAnnee) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxLigne) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxActions) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		
		
		}
	
	/** 
	* Remplir La liste déroulante des Mois
	*/
	private void insererItemMois(){
		System.out.println("VueComboCR::insererItemMois()") ;
			
		for(int lesMois = 1 ; lesMois <=12 ; lesMois++ ){
				cbMois.addItem(new Integer(lesMois));
			}
	}
		
	/** 
	* Remplir La liste déroulante des Années
	*/
	private void insererItemAnnee(){
		System.out.println("VueComboCR::insererItemAnnee()") ;
			
		GregorianCalendar annee = new GregorianCalendar() ;
			
		int anneeCourante = annee.get(Calendar.YEAR);
			
		for(int lesAnnees = anneeCourante ; lesAnnees >=2010 ; lesAnnees-- ){
				cbAnnees.addItem(new Integer(lesAnnees));
			}
	}


	/**
	 * @return the controleur
	 */
	


	/**
	 * @return the cbMois
	 */
	public JComboBox getCbMois() {
		return cbMois;
	}


	/**
	 * @return the cbAnnees
	 */
	public JComboBox getCbAnnees() {
		return cbAnnees;
	}

	

	/**
	 * @return the bValider
	 */
	public JButton getbValider() {
		return bValider;
	}


	/**
	 * @return the bAnnuler
	 */
	public JButton getbAnnuler() {
		return bAnnuler;
	}
}