package fr.berufood.foody.entites;

import java.sql.Date;

import fr.berufood.foody.techniques.DateFr;

public class Praticien {

	private String nom ;
	private String prenom ;
	private String adresse ; 
	private String cp;
	private String ville;
	private float coefnoto;
	private String code;
	private Date derniereVisite;
	
	
    public Praticien(){
    	
    }

	public Praticien(String nom, String prenom, String adresse, String cp, String ville, float coefnoto, String code,
			Date derniereVisite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.coefnoto = coefnoto;
		this.code = code;
		this.derniereVisite=derniereVisite;
	}

	
	



	public Praticien(String nom, String prenom, Date derniereVisite) {
		this.nom = nom;
		this.prenom = prenom;
		this.derniereVisite=derniereVisite;
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






	public String getAdresse() {
		return adresse;
	}






	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}






	public String getCp() {
		return cp;
	}






	public void setCp(String cp) {
		this.cp = cp;
	}






	public String getVille() {
		return ville;
	}






	public void setVille(String ville) {
		this.ville = ville;
	}






	public float getCoefnoto() {
		return coefnoto;
	}






	public void setCoefnoto(float coefnoto) {
		this.coefnoto = coefnoto;
	}






	public String getCode() {
		return code;
	}






	public void setCode(String code) {
		this.code = code;
	}




	/**
	 * @return the derniereVisite
	 */
	public Date getDateVisite() {
		return derniereVisite;
	}

	/**
	 * @param derniereVisite the derniereVisite to set
	 */
	public void setDateVisite(Date derniereVisite) {
		this.derniereVisite = derniereVisite;
	}

	@Override
	public String toString() {
		return "Praticien [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville="
				+ ville + ", coefnoto=" + coefnoto + ", code=" + code + ", derniereVisite=" + derniereVisite + "]";
	}






	
}
