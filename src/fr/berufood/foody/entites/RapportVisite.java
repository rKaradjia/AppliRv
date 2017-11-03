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

	/*VIS_MATRICULE | RAP_NUM | PRA_NUM | RAP_BILAN                            | RAP_DATE   |
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
	private Praticien 	lePraticien;	
	private Date 		dateRapport;
	private String 		bilan;
	//private boolean 	lecture;
	
	/**
	 * Constructeur sans paramètre
	 */
	public RapportVisite() {
		
		super();
		
	}

	
	public RapportVisite(Visiteur leVisiteur, int numRapport,
			Praticien lePraticien, Date dateRapport, String bilan, fr.berufood.foody.entites.Visiteur Visiteur) {
		
		super();
		this.Visiteur 	= Visiteur;
		this.numRapport 	= numRapport;
		this.lePraticien 	= lePraticien;
		this.dateRapport 	= dateRapport;
		this.bilan 			= bilan;
		
	}

	
	public Visiteur getLeVisiteur() {
		return Visiteur;
	}

	/**
	 * @param leVisiteur the leVisiteur to set
	 */
	public void setLeVisiteur(Visiteur Visiteur) {
		this.Visiteur = Visiteur;
	}

	/**
	 * @return the lePraticien
	 */
	public Praticien getLePraticien() {
		return lePraticien;
	}

	/**
	 * @param lePraticien the lePraticien to set
	 */
	public void setLePraticien(Praticien lePraticien) {
		this.lePraticien = lePraticien;
	}

	
	public int getNumRapport() {
		return numRapport;
	}

	/**
	 * @param numeroRapport the numeroRapport to set
	 */
	public void setNumRapport(int numRapport) {
		this.numRapport = numRapport;
	}
	
	/**
	 * @return the bilan
	 */
	public String getBilan() {
		return bilan;
	}

	/**
	 * @param bilan the bilan to set
	 */
	public void setBilan(String bilan) {
		this.bilan = bilan;
	}

	/**
	 * @return the motif
	 */
	
	/**
	 * @return the lecture
	 */
	/*public boolean isLecture() {
		return lecture;
	}

	
	
	public void setLecture(boolean lecture) {
		this.lecture = lecture;
	}

	/**
	 * @return the dateRapport
	 */
	public Date getDateRapport() {
		return dateRapport;
	}

	/**
	 * @param dateRapport the dateRapport to set
	 */
	public void setDateRapport(Date dateRapport) {
		this.dateRapport = dateRapport;
	}


	@Override
	public String toString() {
		return "RapportVisite [Visiteur=" + Visiteur + ", numRapport=" + numRapport + ", lePraticien=" + lePraticien
				+ ", dateRapport=" + dateRapport + ", bilan=" + bilan + "]";
	}

	
	
	
	
	
	
}