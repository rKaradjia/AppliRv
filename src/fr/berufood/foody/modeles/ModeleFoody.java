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
	
	public static ModeleFoody getModele(){
		if( modele == null ){
			modele = new ModeleFoody() ;
		}
		return modele ;
	}
	
	//Se Connecter a la base
	public static boolean seConnecter(String TfLogin,String Pfmdp,VueAuthentification vue) throws ConnexionException,SQLException{
		
		Connection connexion = ConnexionBD.getConnexion();
			
		
			String sql="select VIS_NOM,VIS_CP from VISITEUR where VIS_NOM='"+TfLogin+"' && VIS_MDP='"+Pfmdp+"'";
		
		PreparedStatement requetePreparee=(PreparedStatement) connexion.prepareStatement(sql);	
		
		ResultSet resultat = requetePreparee.executeQuery();
			
		boolean connexionOk;
			if(resultat.next()){//tant que il y a des rsats a afficher BOOLEAN
				
					
					JOptionPane connexionrs=new JOptionPane();
					connexionrs.showMessageDialog(connexionrs,"ca marche");
					connexionrs.setVisible(false);
					vue.setVisible(false);
			//		vue2.creerBarreAuthentifie();
					connexionOk=true;
				
			}else{
				JOptionPane fails=new JOptionPane();
				fails.showMessageDialog(fails,"Veuillez reesayé");
			
				
					
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
	
	
	
	
	
	

	public List<Visiteur> getVisiteur()  {
		List<Visiteur> visiteurs = new ArrayList<Visiteur>() ;
		Connection connexion = null;
		try {
			connexion = ConnexionBD.getConnexion();
		} catch (ConnexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			String sql="select VIS_NOM,VIS_PRENOM,VIS_DATEEMBAUCHE,VIS_VILLE from VISITEUR";
			
			PreparedStatement requetePreparee = null;
			try {
				requetePreparee = (PreparedStatement) connexion.prepareStatement(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			
			ResultSet resultat = null;
			try {
				resultat = requetePreparee.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			boolean connexionOk;
			
			try {
				if(resultat.next()){//tant que il y a des rsats a afficher BOOLEAN
					Visiteur visiteur = new Visiteur();
				    visiteur.setNom(resultat.getString("VIS_NOM"));
				    visiteur.setPrenom(resultat.getString("VIS_PRENOM"));
			       // visiteur.setDateEmbauche(resultat.getDateFr("VIS_DATEEMBAUCHE"));
				    visiteur.setVille(resultat.getString("VIS_VILLE"));
				    
				    visiteurs.add(visiteur);
					
						return visiteurs;
					
				}else{
					JOptionPane connexionrs=new JOptionPane();
					connexionrs.showMessageDialog(connexionrs,"Aucun visiteur avec ces parametres");
					
				}
			} catch (HeadlessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  
		 
		return visiteurs;
		
	}

	
	
	
	

	
		   
}	

		




