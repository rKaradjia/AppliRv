package fr.berufood.foody.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import fr.berufood.foody.entites.Visiteur;
import fr.berufood.foody.modeles.ModeleFoody;
import fr.berufood.foody.vues.VueAuthentification;
import fr.berufood.foody.vues.VueFoody;

public class ControleurPraticien implements ActionListener {
	
	// Vue associée au contrôleur
	private VueFoody vue ;					
	private ModeleFoody modele ;
	
	
	
	
	public ControleurPraticien(VueFoody vue){
		super() ;
		// Mémorise sa vue associée
		this.vue = vue ;
		
		// Se met à l'écoute des items de menu
		this.enregistrerEcouteur();
	}
	
	private void enregistrerEcouteur(){
		// Se met à l'écoute de l'item de menu "Se connecter"
		
		// Se met à l'écoute de l'item de menu "A propos..."
		this.vue.getItemSelectPraticienConf().addActionListener(this) ;
		this.vue.getItemSelectPraticienNotoriete().addActionListener(this);
		this.vue.getItemSelectPraticienVisite().addActionListener(this);
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		// Obtient le composant graphique source de l'événement ("clic")
		Object sourceEvenement = e.getSource() ;
		
		
		
		if( sourceEvenement == this.vue.getItemSelectPraticienConf() ){
			this.afficherPraticienConf();
		}
		if( sourceEvenement == this.vue.getItemSelectPraticienNotoriete() ){
			this.afficherPraticienNoto();
		}
		
		if( sourceEvenement == this.vue.getItemSelectPraticienVisite() ){
			this.afficherPraticienVisite();
		}
		
		/*else if( sourceEvenement == this.vue.getItemModifier() ){
			this.modifierRapport();
			}*/
		
	}
	

	
	private void afficherPraticienConf(){
		this.vue.changerVue("vuePraticienConf");
		}
		
	private void afficherPraticienNoto(){
		this.vue.changerVue("vuePraticienNoto");
		}
	
	private void afficherPraticienVisite(){
		this.vue.changerVue("vuePraticienVisite");
		}
	}
/*	
	private void modifierRapport(){
		System.out.println("L'utilisateur veut afficher la fenêtre À propos...");
		JOptionPane.showMessageDialog(this.vue, "Bouton modifier les rapports","Page de modification...",JOptionPane.INFORMATION_MESSAGE) ;
	}
	
	private void afficherApropos(){
		System.out.println("L'utilisateur veut afficher la fenêtre À propos...");
		JOptionPane.showMessageDialog(this.vue, "Foody v2017","A Propops...",JOptionPane.INFORMATION_MESSAGE) ;
	}*/

