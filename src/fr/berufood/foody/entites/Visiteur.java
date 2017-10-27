package fr.berufood.foody.entites;

import java.sql.Date;

import fr.berufood.foody.techniques.DateFr;

public class Visiteur {
	private String matricule;
	private String nom ;
	private String prenom ;
	private String ville ; 
	private Date dateEmbauche;
	
	public Visiteur(){
		
	}
	 
	public Visiteur(String matricule,String nom, String prenom,String ville,Date dateEmbauche) {
		
		this.matricule=matricule;
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


	public Date getDateEmbauche() {
		return dateEmbauche;
	}


	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	
	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
}


	@Override
	public String toString() {
		return "Visiteur [nom=" + nom + ", prenom=" + prenom + ", ville=" + ville + ", dateEmbauche=" + dateEmbauche
				+ "]";
	}

	
	
}
