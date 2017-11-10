package fr.berufood.foody.controleurs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;

import fr.berufood.foody.entites.Visiteur;
import fr.berufood.foody.modeles.ModeleFoody;
import fr.berufood.foody.modeles.ModeleRapportDateVisiteur;
import fr.berufood.foody.modeles.ModeleVisiteur;

import fr.berufood.foody.vues.*;

public class ControleurBoutonSelectionVisiteur implements ActionListener {
	
	private int row ;
	private int column ;
	private JTable table ;
	
	private String matricule;
	

	private VueVisiteur vue ;
	private VueVoirSelectionDate vueVoirSelectionDate;
	private ModeleFoody modele;
	ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>(ModeleFoody.getVisiteur());
	/*public ControleurBoutonSelectionVisiteur() {
		super();
		System.out.println("ControleurBoutonVisiteurs::ControleurBoutonVisiteurs");
	}*/

	
	public int getRow() {
		return row;
	}

	
	public int getColumn() {
		return column;
	}

	
	public JTable getTable() {
		return table;
	}

	
	
	public void setRow(int row) {
		this.row = row;
	}


	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	
	public void setTable(JTable table) {
		this.table = table;
	}

	
	
	public String getMatricule(){
		
		String matricule = lesVisiteurs.get(getRow()).getMatricule();
		
		return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public void getVueSelectionDate(){
		
		VueVoirSelectionDate vueSelectDate = new VueVoirSelectionDate(vue);
		vueSelectDate.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("ControleurBoutonVisiteurs::actionPerformed()");
	    System.out.println(this.getRow());//ok 9
	    String test = this.getMatricule();
	    System.out.println(test);
	    this.setMatricule(test);
	   // System.out.println(((ModeleVisiteur) this.table.getModel()).getValueAt(0,this.getRow()));//ok 9
	    
	   
	    
	    
		//Object matriculeVisiteur =  ((ModeleVisiteur) this.table.getModel()).getValueAt(this.getRow(),0);//don't work
		                         
		
		
		//String matriculeVisiteurString = matriculeVisiteur.toString();
		
		//System.out.println(matriculeVisiteurString);
		
	    this.getVueSelectionDate();
						
					
	 }
}