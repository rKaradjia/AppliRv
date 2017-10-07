package fr.berufood.foody.controleurs;

import fr.berufood.foody.vues.VueAuthentification;
import fr.berufood.foody.vues.VueFoody;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import fr.berufood.foody.modeles.ModeleFoody;


public class ControleurAuthentification implements ActionListener{
	
	// VOTRE CODE :
	// Déclarer et initialiser l'attribut modele
	private ModeleFoody modele ;			
	
	
	private VueAuthentification vue ;
	
	
	
	/** Constructeur
	 * @param vue Vue associée
	 */
	public ControleurAuthentification(VueAuthentification vue){
		super() ;
		System.out.println("ControleurAuthentification::ControleurAuthentification()") ;
		
		this.vue = vue ;
		this.enregistrerEcouteur() ;
	}
	
	/** Enregistrer le contrôleur en tant qu'écouteur
	 * 
	 */
	private void enregistrerEcouteur(){
		System.out.println("ControleurAuthentification::enregistrerEcouteur()") ;
		
		// VOTRE CODE : 
		// Enregistrer l'écouteur du bouton "Se connecter"
		this.vue.getbAnnuler().addActionListener(this);
		// Enregistrer l'écoureur du bouton "Annuler"
		this.vue.getbConnecter().addActionListener(this);
	}
	
	// VOTRE CODE :
	// Méthode de traitement des événements
	
	public void actionPerformed(ActionEvent e){
		
		Object sourceEvenement = e.getSource();
		
		if(sourceEvenement==this.vue.getbAnnuler()){
			
			this.vue.initialiser();
			
		}
		
		if(sourceEvenement==this.vue.getbConnecter()){
				JTextField Login = this.vue.getTfLogin();
				JTextField Mdp = this.vue.getPfMdp();
			
				String TfLogin = Login.getText();
				String Pfmdp = Mdp.getText();
				System.out.println(Pfmdp);
				System.out.println(TfLogin);
				
				//this.modele.seConnecter(TfLogin,Pfmdp);
				Boolean co=this.modele.seConnecter(TfLogin, Pfmdp,vue);
				
				if(co==true){
					VueFoody vueParente = (VueFoody) this.vue.getParent() ;
					vueParente.setBarreMenusModeConnecte() ;
				}
		
	    }
	}

	public void reinitialiser(){
		
		this.vue.initialiser();
		
		
	}
	

	
	
	
}