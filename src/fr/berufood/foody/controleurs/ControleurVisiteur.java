package fr.berufood.foody.controleurs;

import fr.berufood.foody.vues.VueAuthentification;
import fr.berufood.foody.vues.VueFoody;
import fr.berufood.foody.vues.VueVisiteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fr.berufood.foody.entites.Visiteur;
import fr.berufood.foody.modeles.ModeleFoody;
import fr.berufood.foody.modeles.ModeleVisiteur;


public class ControleurVisiteur implements ActionListener{
	
	// VOTRE CODE :
	// Déclarer et initialiser l'attribut modele
	private ModeleVisiteur modele ;			
	
	private VueFoody vue ;		
	private Visiteur visiteur;
	private VueVisiteur vueVisiteur;
	
	/** Constructeur
	 * @param vue Vue associée
	 */
	public ControleurVisiteur(VueAuthentification vue){
		super() ;
		System.out.println("ControleurVisiteur::ControleurVisiteur()") ;
		
		this.vueVisiteur = vueVisiteur ;
		this.enregistrerEcouteur() ;
	}
	
	/** Enregistrer le contrôleur en tant qu'écouteur
	 * 
	 */
	private void enregistrerEcouteur(){
		/
		this.vue.getItemLire().addActionListener(this);
			
	}

	
	// VOTRE CODE :
	// Méthode de traitement des événements
	public void actionPerformed(ActionEvent e) {
		// Obtient le composant graphique source de l'événement ("clic")
		Object sourceEvenement = e.getSource() ;
		
		
		if( sourceEvenement == this.vue.getItemLire() ){
			this.afficherRapport();
			}
		
		
	}
	

	private void afficherRapport(){
		System.out.println("L'utilisateur veut afficher la fenêtre À propos...");
		JOptionPane.showMessageDialog(this.vue, "Bouton lecture les rapports","Page de lecture...",JOptionPane.INFORMATION_MESSAGE) ;
	}

	
	
	
}