package fr.berufood.foody.modeles;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import java.sql.Connection;
import java.sql.Statement;

import fr.berufood.foody.controleurs.ControleurAuthentification;
import fr.berufood.foody.entites.Utilisateur;
import fr.berufood.foody.vues.VueAuthentification;
import fr.berufood.foody.vues.VueFoody;



public class ModeleFoody extends AbstractTableModel {
	
	//Se Connecter a la base
	public static boolean seConnecter(String TfLogin,String Pfmdp,VueAuthentification vue){
		
		
		
		String url= "jdbc:mysql://localhost/GsbCRSlamV2015";
		String login="root";
		String mdp="azerty";
		java.sql.Connection cn=null;
		java.sql.Statement st=null;
		ResultSet rs=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");	
			cn=DriverManager.getConnection(url,login,mdp);
			st=cn.createStatement();
			String sql="select VIS_NOM,VIS_CP from VISITEUR where VIS_NOM='"+TfLogin+"' && VIS_MDP='"+Pfmdp+"'";
			rs= st.executeQuery(sql);
			System.out.println(rs);
			if(rs.next()){//tant que il y a des resultats a afficher BOOLEAN
				System.out.println("coucou");
				System.out.println(rs.getString("VIS_CP"));
				
				rs.getString("VIS_NOM");                       //colonne a afficher 
				rs.getString("VIS_CP");
					
					JOptionPane connexionResult=new JOptionPane();
					connexionResult.showMessageDialog(connexionResult,"ca marche");
					connexionResult.setVisible(false);
					vue.setVisible(false);
			//		vue2.creerBarreAuthentifie();
					return true;
				
			}else{
				JOptionPane fails=new JOptionPane();
				fails.showMessageDialog(fails,"Veuillez reesayé");
			
				
					
					/*ControleurAuthentification controleur=new ControleurAuthentification(vue);
					controleur.reinitialiser();*/
					fails.setVisible(false);
					vue.initialiser();
					return false;
				
			}
			
		  }	
		 catch(SQLException e){
			 
			 e.printStackTrace();
			
		}
		
		catch(ClassNotFoundException e){
			
			e.printStackTrace();
			
		}
		
		finally{
			
			try{
				
				cn.close();
				st.close();
				
			}catch(SQLException e){
				
				e.printStackTrace();
				
			}
			
		}
		return false;
		
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
	
	
/*	public static void ListeVisiteur(){
		
		
		
		String url= "jdbc:mysql://localhost/GsbCRSlamV2015";
		String login="root";
		String mdp="azerty";
		java.sql.Connection cn=null;
		java.sql.Statement st=null;
		ResultSet rs=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");	
			cn=DriverManager.getConnection(url,login,mdp);
			st=cn.createStatement();
			String sql="select VIS_NOM,VIS_PRENOM from VISITEUR ";
			rs= st.executeQuery(sql);
			System.out.println(rs);
			if(rs.next()){//tant que il y a des resultats a afficher BOOLEAN
				  System.out.println("coucou");
				  System.out.println(rs.getString("VIS_CP"));
				
				  rs.getString("VIS_NOM");                       //colonne a afficher 
				  rs.getString("VIS_PRENOM");
			 }
			
		 }
					
				catch(SQLException e){
					 
					 e.printStackTrace();
					
				}
				
				catch(ClassNotFoundException e){
					
					e.printStackTrace();
					
				}
				
				finally{
					
					try{
						
						cn.close();
						st.close();
						
					}catch(SQLException e){
						
						e.printStackTrace();
						
					}
					
				}
					
				
	}*/


	
		   
}	

		




