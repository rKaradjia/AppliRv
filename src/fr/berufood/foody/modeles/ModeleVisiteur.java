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
import fr.berufood.foody.entites.Visiteur;
import fr.berufood.foody.techniques.DateFr;
import fr.berufood.foody.vues.VueAuthentification;
import fr.berufood.foody.vues.VueFoody;

public class ModeleVisiteur extends AbstractTableModel{
	private final String[] entetes = { "Nom" , "Prenom" , "Ville" , "Date d'embauche" } ;
	private List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>() ;
	
	public static void getVisiteur(){
	
	
	
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
			String sql="select VIS_NOM,VIS_PRENOM,VIS_VILLE,VIS_DATEEMBAUCHE from VISITEUR ";
			rs= st.executeQuery(sql);
			System.out.println(rs);
			if(rs.next()){//tant que il y a des resultats a afficher BOOLEAN
				System.out.println("coucou");
				System.out.println(rs.getString("VIS_CP"));
			
				rs.getString("VIS_NOM");                       //colonne a afficher 
				rs.getString("VIS_PRENOM");
				rs.getString("VIS_VILLE");
				rs.getString("VIS_DATAEMBAUCHE");
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
		}		
	
	public ModeleListeRestaurants() {
		super();
	}

	@Override
	public int getRowCount() {
		// VOTRE CODE ICI - Question 8
		return lesRestaurants.size();
	}

	@Override
	public int getColumnCount() {
		// VOTRE CODE ICI - Question 8
		return entetes.length;
	}
	
	@Override
	public String getColumnName(int column) {
		// VOTRE CODE ICI - Question 8
		return entetes[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// VOTRE CODE ICI - Question 8
		switch (columnIndex){
		case 0: return String.class;
				
		case 1:return String.class;
		              
				
		case 2:return String.class;
		
		case 3:return DateFr.class;
				
		
		
		
		}
		return null;	
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// VOTRE CODE ICI - Question 8
		switch (columnIndex){
		
		case 0:
			
				return lesVisiteurs.get(rowIndex).getNom();
				
			
			
		case 1:
			return lesVisiteurs.get(rowIndex).getPrenom();
				
			
			
		case 2:
			return lesVisiteurs.get(rowIndex).getVille();
		case 3:
			return lesVisiteurs.get(rowIndex).getDateEmbauche();
		
	}	
	return null;
}
			
}

