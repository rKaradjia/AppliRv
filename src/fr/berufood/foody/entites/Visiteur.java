package fr.berufood.foody.entites;

import fr.berufood.foody.techniques.DateFr;

public class Visiteur {

	private String nom ;
	private String prenom ;
	private String ville ; 
	private DateFr dateEmbauche;
	
	public Visiteur(){
		
	}
	 
	public Visiteur(String nom, String prenom,String ville,DateFr dateEmbauche) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.ville=ville;
		this.dateEmbauche=dateEmbauche;
	}

	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public DateFr getDateEmbauche() {
		return dateEmbauche;
	}


	public void setDateEmbauche(DateFr dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}


	@Override
	public String toString() {
		return "Visiteur [nom=" + nom + ", prenom=" + prenom + ", ville=" + ville + ", dateEmbauche=" + dateEmbauche
				+ "]";
	}
	
}
