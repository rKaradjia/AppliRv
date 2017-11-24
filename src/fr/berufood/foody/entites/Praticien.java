package fr.berufood.foody.entites;

import java.sql.Date;

import fr.berufood.foody.techniques.DateFr;

public class Praticien {

	private int num;
	private String nom ;
	private String prenom ;
	private String adresse ; 
	private String cp;
	private String ville;
	private float coefnoto;
	private String code;
	private Date derniereVisite;
	private Date dateVisite;
	private int rapportConf;
	private String nomVisiteur;
	
	
    public Praticien(){
    	
    }

	public Praticien(int num,String nom, String prenom, String adresse, String cp, String ville, float coefnoto, String code,
			Date derniereVisite) {
		super();
		this.num=num;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.coefnoto = coefnoto;
		this.code = code;
		this.derniereVisite=derniereVisite;
	}

	public Praticien(String nomVisiteur,String nom ,String prenom, Date dateVisite, int rapportConf) {
		super();
		this.nomVisiteur=nomVisiteur;
		this.nom = nom;
		this.prenom = prenom;
		this.dateVisite = dateVisite; 
		this.rapportConf = rapportConf;
		
		
	}
	



	public Praticien(String nom, String prenom, Date derniereVisite) {
		this.nom = nom;
		this.prenom = prenom;
		this.derniereVisite=derniereVisite;
	}
	
	public String getNomVisiteur(){
		return nomVisiteur;
	}
	
	public void setNomVisiteur(String nomVisiteur){
		this.nomVisiteur = nomVisiteur;
	}
	
	
	
	public int getNum() {
		return num;
	}






	public void setNom(int num) {
		this.num = num;
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
	public Date getDernDateVisite() {
		return derniereVisite;
	}

	/**
	 * @param derniereVisite the derniereVisite to set
	 */
	public void setDernDateVisite(Date derniereVisite) {
		this.derniereVisite = derniereVisite;
	}
	
	public Date getDateVisite() {
		return dateVisite;
	}
	
	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}
	
	public int getRapportConf() {
		return rapportConf;
	}
	
	public void setRapportConf(int rapportConf) {
		this.rapportConf= rapportConf;
	}
	
	

	@Override
	public String toString() {
		return "Praticien [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville="
				+ ville + ", coefnoto=" + coefnoto + ", code=" + code + ", derniereVisite=" + derniereVisite + "]";
	}


	



	
}
