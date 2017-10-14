package fr.berufood.foody.techniques;

import java.sql.DriverManager;
import java.util.Calendar;

import com.mysql.jdbc.Connection;



public class ConnexionBD {
	
	private static String dbURl="jdbc:mysql://localhost:3306/GsbCRSlamV2015";
	private static String user = "root";
	private static String password = "azerty";
	
	private static Connection connexion = null;
	
	
	private ConnexionBD() throws ConnexionException{
		
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			connexion = (Connection) DriverManager.getConnection(dbURl,user,password);
			
			
			
		}
		catch(Exception e){
			
			
			System.out.println("Erreur ! :" + e.getMessage());
			throw new ConnexionException();
			
		}
		
	}
	
	public static Connection getConnexion() throws ConnexionException{
		
		if(connexion == null){
			
			new ConnexionBD();
			
		}
		
		
		return connexion;
		
		
	}
}