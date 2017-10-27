package fr.berufood.foody.modeles;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.HeadlessException;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Statement;

import fr.berufood.foody.controleurs.ControleurAuthentification;
import fr.berufood.foody.entites.Praticien;
import fr.berufood.foody.entites.Utilisateur;
import fr.berufood.foody.entites.Visiteur;
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
	private ModeleFoody(){
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
			
			
				
			
			
			
				while(resultat.next()){//tant que il y a des rsats a afficher BOOLEAN
		
					String nomPraticien = resultat.getString("PRA_NOM");
					String prenomPraticien = resultat.getString("PRA_PRENOM");
					
					Date dateVisite = resultat.getDate("RAP_DATE");
				    
				     lesPraticiens.add(new Praticien(nomPraticien,prenomPraticien,dateVisite));
					
					//	return visiteurs;
					
				}
				
		    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 return lesPraticiens;
	}
	}

	



	   


	
	

	
		   


		




