package fr.berufood.foody.controleurs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;


import fr.berufood.foody.modeles.ModeleVisiteur;

import fr.berufood.foody.vues.*;

public class ControleurBoutonSelectionVisiteur implements ActionListener {
	
	private int row ;
	private int column ;
	private JTable table ;
	private ModeleVisiteur model;
	
	private VueAccueil vue ;
	private VueVoirSelectionDate vueVoirSelectionDate = new VueVoirSelectionDate();
	
	/*public ControleurBoutonSelectionVisiteur() {
		super();
		System.out.println("ControleurBoutonVisiteurs::ControleurBoutonVisiteurs");
	}*/

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}


	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	

	/**
	 * @return the vueComBoCR
	 */
	public VueVoirSelectionDate getVueSelectionDate() {
		return vueVoirSelectionDate;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("ControleurBoutonVisiteurs::actionPerformed()");
	    System.out.println(this.getRow());//ok 9
		
	    System.out.println(((ModeleVisiteur) this.table.getModel()).getValueAt(0,this.getRow()));//ok 9
	    
		//Object matriculeVisiteur =  ((ModeleVisiteur) this.table.getModel()).getValueAt(this.getRow(),0);//don't work
		                         
		
		
		//String matriculeVisiteurString = matriculeVisiteur.toString();
		
		//System.out.println(matriculeVisiteurString);
		
	  
	    vueVoirSelectionDate.setVisible(true);
						
					
	 }
}