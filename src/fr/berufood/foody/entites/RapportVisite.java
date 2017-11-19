/**
 * 
 */
package fr.berufood.foody.entites;

import java.sql.Date;

/**
 * @author Romain Venel & Maxime Genevier
 * 
 * La classe RapportVisite est une classe métier
 * Elle possède tous les attributs propres à un rapport de visite
 *
 */
public class RapportVisite {

	/*VIS_MATRICULE | RAP_NUM | PRA_NUM | RAP_BILAN                            | RAP_DATE   |RAP_DATEREDAC 
	+---------------+---------+---------+--------------------------------------+------------+
	| a17           |       1 |       1 | coucou                               | NULL       |
	| a93           |       2 |       3 | CONVAINCU                            | 2017-10-22 |
	| B50           |       3 |       5 | CONVAINCU                            | 2016-12-15 |
	| b59           |       4 |       8 | pas CONVAINCU                        | 2017-04-29 |
	| c14           |       5 |      10 | pas CONVAINCU                        | 2017-08-29 |
	| c54           |       6 |      11 | se pose des questions sur la formule | 2017-09-15 |
	+---------------+---------+---------+--------------------------------------+----
	*/
	
	
	private Visiteur 	Visiteur;
	private int 		numRapport;
	//private Praticien 	lePraticien;	
	private String nomPraticien;
	private String prenomPraticien;
	private String 		bilan;
	private Date 		dateVisite;
	private Date 		dateRedac;
	//private boolean 	lecture;
	
	/**
	 * Constructeur sans paramètre
	 * @param dateRedac2 
	 * @param dateVisite2 
	 * @param bilan2 
	 * @param numPraticien 
	 * @param numRapport2 
	 */
	public RapportVisite(int numRapport, String prenomPraticien,String nomPraticien, String bilan, Date dateVisite, Date dateRedac) {
		
		this.numRapport 	= numRapport;
		//this.lePraticien 	= lePraticien;
		this.prenomPraticien=prenomPraticien;
		this.nomPraticien=nomPraticien;
		this.dateVisite 	= dateVisite;
		this.bilan 			= bilan;
		this.dateRedac=dateRedac;
		
	}

	
	public String getNomPraticien() {
		return nomPraticien;
	}


	public void setNomPraticien(String nomPraticien) {
		this.nomPraticien = nomPraticien;
	}


	public RapportVisite(Visiteur leVisiteur, int numRapport,
			 String nomPraticien, String bilan, Date dateVisite,Date dateRedac) {
		
		super();
		this.Visiteur 	= Visiteur;
		this.numRapport 	= numRapport;
		this.nomPraticien=nomPraticien;
		//this.lePraticien 	= lePraticien;
		this.dateVisite 	= dateVisite;
		this.bilan 			= bilan;
		this.dateRedac=dateRedac;
		
	}

	
	

	public Visiteur getVisiteur() {
		return Visiteur;
	}


	public void setVisiteur(Visiteur visiteur) {
		Visiteur = visiteur;
	}


	public int getNumRapport() {
		return numRapport;
	}


	public void setNumRapport(int numRapport) {
		this.numRapport = numRapport;
	}


/*	public Praticien getLePraticien() {
		return lePraticien;
	}


	public void setLePraticien(Praticien lePraticien) {
		this.lePraticien = lePraticien;
	}
*/

	public String getBilan() {
		return bilan;
	}


	public void setBilan(String bilan) {
		this.bilan = bilan;
	}


	public Date getDateVisite() {
		return dateVisite;
	}


	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}


	public Date getDateRedac() {
		return dateRedac;
	}


	public void setDateRedac(Date dateRedac) {
		this.dateRedac = dateRedac;
	}


	@Override
	public String toString() {
		return "RapportVisite [Visiteur=" + Visiteur + ", numRapport=" + numRapport + ", nomPraticien=" + nomPraticien
				+ ", prenomPraticien=" + prenomPraticien + ", bilan=" + bilan + ", dateVisite=" + dateVisite
				+ ", dateRedac=" + dateRedac + "]";
	}


	public String getPrenomPraticien() {
		return prenomPraticien;
	}


	public void setPrenomPraticien(String prenomPraticien) {
		this.prenomPraticien = prenomPraticien;
	}


	


	

	
	
	
	
	
	
}