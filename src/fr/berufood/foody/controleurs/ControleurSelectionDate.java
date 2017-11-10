package fr.berufood.foody.controleurs;

import fr.berufood.foody.vues.VueAuthentification;
import fr.berufood.foody.vues.VueFoody;
import fr.berufood.foody.vues.VueRapportParDate;
import fr.berufood.foody.vues.VueRapportParDate;
import fr.berufood.foody.vues.VueVoirSelectionDate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import fr.berufood.foody.modeles.ModeleFoody;


public class ControleurSelectionDate implements ActionListener{
	
	// VOTRE CODE :
	// Déclarer et initialiser l'attribut modele
	private ModeleFoody modele ;			
	
	private VueVoirSelectionDate vue;
	
	private VueFoody vue1 ;
	
	
	
	/** Constructeur
	 * @param vue Vue associée
	 */
	public ControleurSelectionDate(VueVoirSelectionDate vue){
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
		this.vue.getbValider().addActionListener(this);
		// Enregistrer l'écoureur du bouton "Annuler"
		this.vue.getbAnnuler().addActionListener(this);
		this.vue.getCombobox().addActionListener(this);
		this.vue.getCombobox_1().addActionListener(this);
	}
	
	// VOTRE CODE :
	// Méthode de traitement des événements
	
	public void actionPerformed(ActionEvent e){
		
		Object sourceEvenement = e.getSource();
		
		if(sourceEvenement==this.vue.getbAnnuler()){
			
			this.vue.initialiser();
			
		}
		
		if(sourceEvenement==this.vue.getbValider()){
				String mois =this.vue.getCombobox().getSelectedItem().toString();
				System.out.println(mois);
				this.vue.setMoisString(mois);
				String annee = this.vue.getCombobox_1().getSelectedItem().toString();
				System.out.println(annee);
				this.vue.setAnneeString(annee);
				/*String TfLogin = Login.getText();
				String Pfmdp = Mdp.getText();*/
				System.out.println(mois);
				System.out.println(annee);
				
				//this.modele.seConnecter(TfLogin,Pfmdp);
				
				
				vue.dispose();
				
				VueRapportParDate vuerapport=new VueRapportParDate();
				vuerapport.setVisible(true);
				
		
	    }
	}

	public void reinitialiser(){
		
		this.vue.initialiser();
		
		
	}
	
}
	
	
	
