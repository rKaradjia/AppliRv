package fr.berufood.foody.modeles;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.PreparedStatement;

import fr.berufood.foody.controleurs.ControleurAuthentification;
import fr.berufood.foody.entites.Praticien;
import fr.berufood.foody.entites.RapportVisite;
import fr.berufood.foody.entites.Utilisateur;
import fr.berufood.foody.entites.Visiteur;
import fr.berufood.foody.rendus.TablePanelRapportDateVisiteur;
import fr.berufood.foody.techniques.ConnexionBD;
import fr.berufood.foody.techniques.ConnexionException;
import fr.berufood.foody.vues.VueAuthentification;
import fr.berufood.foody.vues.VueFoody;



public class ModeleFoody extends AbstractTableModel {
	
	
	
	
	private static ModeleFoody modele = null ;
	
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>() ;
	
	
	
	
	/** Constructeur
	 * 
	 */
	public ModeleFoody(){
		super() ;
		
		
	}
	
	// Implémentation du DP Singleton (méthode)
	
	/*public static ModeleFoody getModele(){
		if( modele == null ){
			modele = new ModeleFoody() ;
		}
		return modele ;
	}*/
	
	//Se Connecter a la base
	public static boolean seConnecter(String TfLogin,String Pfmdp,VueAuthentification vue) throws ConnexionException,SQLException{
		
		Connection connexion = ConnexionBD.getConnexion();
			
		
			String sql="select VIS_NOM,VIS_CP from VISITEUR where VIS_NOM='"+TfLogin+"' && VIS_MDP='"+Pfmdp+"'";
		
		PreparedStatement requetePreparee=(PreparedStatement) connexion.prepareStatement(sql);	
		
		ResultSet resultat = requetePreparee.executeQuery();
			
		boolean connexionOk;
			if(resultat.next()){//tant que il y a des rsats a afficher BOOLEAN
				
					
					JOptionPane connexionrs=new JOptionPane();
					connexionrs.showMessageDialog(connexionrs,"Cliquez pour continuer","Connexion Réussie ", 1);
					connexionrs.setVisible(false);
					vue.setVisible(false);
			//		vue2.creerBarreAuthentifie();
					connexionOk=true;
				
			}else{
				JOptionPane fails=new JOptionPane();
				fails.showMessageDialog(fails,"Identifiant ou mot de passe incorect","Veuillez réesayé",0);
			
				
					
					/*ControleurAuthentification controleur=new ControleurAuthentification(vue);
					controleur.reinitialiser();*/
					fails.setVisible(false);
					vue.initialiser();
					connexionOk=false;
				
			}
			requetePreparee.close();
			return connexionOk;
			
		  }	
		
		
	  

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}


	public static List<Visiteur> getVisiteur() {
		List<Visiteur> visiteurs = new ArrayList<Visiteur>() ;
		ResultSet resultat = null;
		Connection connexion = null;
		PreparedStatement requetePreparee = null;
		
		try {
		
			try {
				connexion = ConnexionBD.getConnexion();
			} catch (ConnexionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			String sql="select VIS_MATRICULE,VIS_NOM,VIS_PRENOM,VIS_DATEEMBAUCHE,VIS_VILLE from VISITEUR order by VIS_NOM";
			
			requetePreparee = (PreparedStatement) connexion.prepareStatement(sql);
			
			resultat = requetePreparee.executeQuery();
			
				
			
			
			
				while(resultat.next()){//tant que il y a des rsats a afficher BOOLEAN
					Visiteur visiteur = new Visiteur();
					visiteur.setMatricule(resultat.getString("VIS_MATRICULE"));
				    visiteur.setNom(resultat.getString("VIS_NOM"));
				    visiteur.setPrenom(resultat.getString("VIS_PRENOM"));
			       visiteur.setDateEmbauche(resultat.getDate("VIS_DATEEMBAUCHE"));
				    visiteur.setVille(resultat.getString("VIS_VILLE"));
				    
				    visiteurs.add(visiteur);
					
					//	return visiteurs;
					
				}
				
		    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 return visiteurs;
	}
	
	public static List<Praticien> getPraticienConf() {
		List<Praticien> lesPraticiens = new ArrayList<Praticien>() ;
		ResultSet resultat = null ;
		Connection connexion = null;
		PreparedStatement requetePreparee = null;
		
		try {
			try {
				connexion = ConnexionBD.getConnexion();
			} catch (ConnexionException e) {
				e.printStackTrace();
			}
			String sql ="select VISITEUR.VIS_NOM, PRA_NOM, PRA_PRENOM, RAPPORT_VISITE.RAP_DATE, RAPPORT_VISITE.RAP_CONF from PRATICIEN inner join RAPPORT_VISITE"
					+ " on PRATICIEN.PRA_NUM = RAPPORT_VISITE.PRA_NUM"
					+ " inner join VISITEUR on RAPPORT_VISITE.VIS_MATRICULE = VISITEUR.VIS_MATRICULE";
			
			requetePreparee = (PreparedStatement) connexion.prepareStatement(sql);
			
			resultat = requetePreparee.executeQuery();
				
			while(resultat.next()){//tant que il y a des rsats a afficher BOOLEAN
				
				String nomVisiteur = resultat.getString("VIS_NOM");
			    String nomPraticien = resultat.getString("PRA_NOM");
			    String prenomPraticien = resultat.getString("PRA_PRENOM");
		       // visiteur.setDateEmbauche(resultat.getDateFr("VIS_DATEEMBAUCHE"));
			    Date rapportDate = resultat.getDate("RAP_DATE");
			    int rapportConf = resultat.getInt("RAP_CONF");
			    
			     lesPraticiens.add(new Praticien(nomVisiteur,nomPraticien,prenomPraticien,rapportDate,rapportConf));
				
				//	return visiteurs;
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			return lesPraticiens;		
			
		}

	
	
	
	

	public static List<Praticien> getPraticienNoto() {
		List<Praticien> lesPraticiens = new ArrayList<Praticien>() ;
		ResultSet resultat = null;
		Connection connexion = null;
		PreparedStatement requetePreparee = null;
		
		try {
		
			try {
				connexion = ConnexionBD.getConnexion();
			} catch (ConnexionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			String sql="select PRA_NOM,PRA_PRENOM,PRA_COEFNOTORIETE from PRATICIEN order by PRA_COEFNOTORIETE DESC";
			
			requetePreparee = (PreparedStatement) connexion.prepareStatement(sql);
			
			resultat = requetePreparee.executeQuery();
			
				
			
			
			
				while(resultat.next()){//tant que il y a des rsats a afficher BOOLEAN
					Praticien praticien = new Praticien();
				    praticien.setNom(resultat.getString("PRA_NOM"));
				    praticien.setPrenom(resultat.getString("PRA_PRENOM"));
			       // visiteur.setDateEmbauche(resultat.getDateFr("VIS_DATEEMBAUCHE"));
				    praticien.setCoefnoto(resultat.getFloat("PRA_COEFNOTORIETE"));
				    
				     lesPraticiens.add(praticien);
					
					//	return visiteurs;
					
				}
				
		    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 return lesPraticiens;
	}

	public static List<Praticien> getPraticienVisite() {
		List<Praticien> lesPraticiens = new ArrayList<Praticien>() ;
		ResultSet resultat = null;
		Connection connexion = null;
		PreparedStatement requetePreparee = null;
		
		try {
		
			try {
				connexion = ConnexionBD.getConnexion();
			} catch (ConnexionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			String sql = "select PRA_NOM,PRA_PRENOM, RAP_DATE from RAPPORT_VISITE "
					+ "as R1 INNER JOIN PRATICIEN ON R1.PRA_NUM=PRATICIEN.PRA_NUM"
					+ " where RAP_DATE = (SELECT MAX(RAP_DATE) "
					+ "FROM RAPPORT_VISITE as R2 WHERE R1.PRA_NUM=R2.PRA_NUM group by R2.PRA_NUM)"; 
			requetePreparee = (PreparedStatement) connexion.prepareStatement(sql);
			
			resultat = requetePreparee.executeQuery();
			
			
				
			System.out.println(resultat);
			
			
				while(resultat.next()){//tant que il y a des rsats a afficher BOOLEAN
		/*
					String nomPraticien = resultat.getString("PRA_NOM");
					String prenomPraticien = resultat.getString("PRA_PRENOM");
					
					Date dateVisite = resultat.getDate("RAP_DATE");
				    
				     lesPraticiens.add(new Praticien(nomPraticien,prenomPraticien,dateVisite));*/
					
					Praticien praticien = new Praticien();
				    praticien.setNom(resultat.getString("PRA_NOM"));
				    praticien.setPrenom(resultat.getString("PRA_PRENOM"));
			       // visiteur.setDateEmbauche(resultat.getDateFr("VIS_DATEEMBAUCHE"));
				    praticien.setDateVisite(resultat.getDate("RAP_DATE"));
				    
				    
				     lesPraticiens.add(praticien);
					
					//	return visiteurs;
					
				}
				
		    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 return lesPraticiens;
	}

	public static List<RapportVisite> getRapportsVisite(String matricule, String jtDateMois,String jtDateAnnee){
		System.out.println(matricule +"Dans modele");
		System.out.println(jtDateMois +"Dans modele");
		System.out.println(jtDateAnnee +"Dans modele");
        List<RapportVisite> lesRapportVisites = new ArrayList<RapportVisite>() ;
        ResultSet resultat = null;
        Connection connexion = null;
        //Statement st = connexion.createStatement();
        PreparedStatement requetePreparee = null;
       
        try {
            try {
                connexion = ConnexionBD.getConnexion();
            } catch (ConnexionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
       
            String sql = "Select RAP_NUM, PRA_NOM, PRA_PRENOM,RAP_DATE,RAP_DATEREDAC from RAPPORT_VISITE "
            		+ "inner join PRATICIEN ON RAPPORT_VISITE.PRA_NUM=PRATICIEN.PRA_NUM where VIS_MATRICULE = ? and RAP_DATE like ?";
            PreparedStatement pst = (PreparedStatement) connexion.prepareStatement(sql);
       
            pst.setString(1,matricule);
            Integer dateMois = Integer.parseInt(jtDateMois);
            Integer dateAnnee = Integer.parseInt(jtDateAnnee);
            
            if(dateMois<10){
            	 
                String dateEntiere = dateAnnee +"-0"+ dateMois + "%";
                System.out.println(dateEntiere);
                
                pst.setString(2, dateEntiere);
            }
            else{
            
            	String dateEntiere = dateAnnee +"-"+ dateMois + "%";
            	System.out.println(dateEntiere);
            	pst.setString(2, dateEntiere);
       
            }
            resultat= pst.executeQuery();
           
            while(resultat.next()){
            	
            	int numRapport = resultat.getInt("RAP_NUM");
				String nomPraticien = resultat.getString("PRA_NOM");
				String prenomPraticien = resultat.getString("PRA_PRENOM");
				
				Date dateVisite = resultat.getDate("RAP_DATE");
				Date dateRedac = resultat.getDate("RAP_DATEREDAC");
				System.out.println("boucle while");
            	//tant que il y a des rsats a afficher BOOLEAN
        	/*private Visiteur 	Visiteur;          RAP_NUM       | int(11)      | NO   | PRI | 0       |       |
| PRA_NUM       | int(11)      | YES  | MUL | NULL    |       |
| RAP_BILAN     | varchar(510) | YES  |     |         |       |
| RAP_DATE      | date         | YES  |     | NULL    |       |
| RAP_DATEREDAC | date         | YES  |     | NULL    |       |

	private int 		numRapport;
	private Praticien 	lePraticien;	
	private String 		bilan;
	private Date 		dateVisite;
	private Date 		dateRedac;*/	
				
			    
			     lesRapportVisites.add(new RapportVisite(numRapport,nomPraticien, prenomPraticien,dateVisite,dateRedac));
				
				//	return visiteurs;
				
			}
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); 
            
        
        
           }
		return lesRapportVisites;  
        }
	
	
	
    public static List<RapportVisite> getLeRapport(int numRapport) {
 		System.out.println("recuperation du modele numero"+ numRapport);
         List<RapportVisite> unRapport = new ArrayList<RapportVisite>() ;
        // ResultSet resultat = null;
       //  ResultSet resultat2 = null;RAPPORT_VISITE RAP_VUE
         Connection connexion = null;
         //Statement st = connexion.createStatement();
    //     PreparedStatement requetePreparee = null;
    //     PreparedStatement requetePreparee2 = null;//RAPPORT_VISITE RAP_VUE   BOOLEAN
         try {
             try {
                 connexion = ConnexionBD.getConnexion();
             } catch (ConnexionException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
        
             Statement st =connexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,       
						ResultSet.CONCUR_READ_ONLY);
				String req = "SELECT RAP_BILAN FROM RAPPORT_VISITE where RAP_NUM = '"+numRapport+"' ";
				ResultSet rs = st.executeQuery(req);
	    
				while(rs.next()){
	    	   	
					String bilan =rs.getString("RAP_BILAN");

					unRapport.add(new RapportVisite(bilan));
			
				}
 				
				 String req2 = "UPDATE RAPPORT_VISITE SET RAP_VUE = 1 where RAP_NUM = '"+numRapport+"' ";
				 Statement st2 =connexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,       
							ResultSet.CONCUR_READ_ONLY);;
				 
				 
				 
							int rs2 = st.executeUpdate(req2);
					System.out.println(rs2);
            
         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();     
            }
 		return unRapport;  
         }
    
    
    /*public void Lue(int numRapport) {
	
		ResultSet resultat = null;
		Connection connexion = null;
		PreparedStatement pst = null;
		
		try {
		
			try {
				connexion = ConnexionBD.getConnexion();
			} catch (ConnexionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			String sql = "Update RAPPORT_VISITE set RAP_VUE = true where RAP_NUM = ? "; 
			pst = (PreparedStatement) connexion.prepareStatement(sql);
			 pst.setInt(1,numRapport);
			resultat = pst.executeQuery();
			
				
		    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
	}*/
}






	



	   


	
	

	
		   


		




