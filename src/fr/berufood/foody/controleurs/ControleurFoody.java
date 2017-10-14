package fr.berufood.foody.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.berufood.foody.vues.VueAuthentification;
import fr.berufood.foody.vues.VueFoody;

public class ControleurFoody implements ActionListener {
	
	// Vue associée au contrôleur
	private VueFoody vue ;					
	
	public ControleurFoody(VueFoody vue){
		super() ;
		// Mémorise sa vue associée
		this.vue = vue ;
		
		// Se met à l'écoute des items de menu
		this.enregistrerEcouteur();
	}
	
	private void enregistrerEcouteur(){
		// Se met à l'écoute de l'item de menu "Se connecter"
		this.vue.getItemSeConnecter().addActionListener(this) ;
		
		// Se met à l'écoute de l'item de menu "Se déconnecter"
		this.vue.getItemSeDeconnecter().addActionListener(this) ;
		
		// Se met à l'écoute de l'item de menu "Quitter"
		this.vue.getItemQuitter().addActionListener(this) ;
		
		// Se met à l'écoute de l'item de menu "A propos..."
		this.vue.getItemApropos().addActionListener(this) ;
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		// Obtient le composant graphique source de l'événement ("clic")
		Object sourceEvenement = e.getSource() ;
		
		if( sourceEvenement == this.vue.getItemSeConnecter() ){
			this.seConnecter();
		}
		// Si la source est l'item de menu "Se déconnecter"
		else if( sourceEvenement == this.vue.getItemSeDeconnecter() ){
			this.seDeconnecter();
		}
		// Si la source est l'item de menu "Quitter"
		else if( sourceEvenement == this.vue.getItemQuitter() ){
			this.quitter();
		}
		// VOTRE CODE :
		// Si la source est l'item "À propos", afficher la boîte de dialogue associée
		
		
		/*else if( sourceEvenement == this.vue.getItemApropos() ){
			this.afficherApropos();
			}*/
		
		/*else if( sourceEvenement == this.vue.getItemLire() ){
			this.afficherRapport();
			}*/
		
		/*else if( sourceEvenement == this.vue.getItemModifier() ){
			this.modifierRapport();
			}*/
		
	}
	
	private void seConnecter(){
		System.out.println("L'utilisateur veut se connecter.");
		// Affiche la vue dédiée à la connexion (formulaire de connexion)
		new VueAuthentification(this.vue) ;
	}
	
	private void seDeconnecter(){
		System.out.println("L'utilisateur veut se déconnecter.");
		// Demande confirmation à l'utilisateur au moyen d'une boîte de dialogue
		int reponse = JOptionPane.showConfirmDialog(this.vue, "Voulez-vous vraiment vous déconnecter ?","Déconnexion",JOptionPane.YES_NO_OPTION) ;
		
		// Si l'utilateur confirme...
		if( reponse == JOptionPane.YES_OPTION ){
				
			// Bascule la barre de menus dans le "Mode Non connecté"
			this.vue.setBarreMenusModeDeconnecte();
			
			JOptionPane.showMessageDialog(null, "Vous êtes maintenant déconnecté.","Déconnexion",JOptionPane.INFORMATION_MESSAGE) ;
		}
	}
	
	private void quitter(){
		System.out.println("L'utilisateur veut quitter.");
		// Demande confirmation à l'utilisateur au moyen d'une boîte de dialogue
		int reponse = JOptionPane.showConfirmDialog(this.vue, "Voulez-vous vraiment quitter ?","Quitter",JOptionPane.YES_NO_OPTION) ;
		
		// Si l'utilateur confirme...
		if( reponse == JOptionPane.YES_OPTION ){
			// Met fin à l'application
			System.exit(0) ;
		}
	}
	
/*	private void afficherRapport(){
		try {
			//Boolean co = this.modele.seConnecter(TfLogin, Pfmdp,vue);
			System.out.println("co ==true");
			if(co==true){
				System.out.println("yes");
				VueFoody vueParente = (VueFoody) this.vue.getParent() ;
			
			    vueParente.setBarreMenusModeConnecte() ;
			    }
			
			}
		 catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
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

