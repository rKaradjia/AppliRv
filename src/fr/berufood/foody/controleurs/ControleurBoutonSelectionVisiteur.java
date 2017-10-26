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
	
	private VueAccueil vue ;
	private VueVoirSelectionDate vueVoirSelectionDate ;
	
	public ControleurBoutonSelectionVisiteur() {
		super();
		System.out.println("ControleurBoutonVisiteurs::ControleurBoutonVisiteurs");
	}

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
		System.out.println("ControleurBoutonVisiteurs::actionPerformed()");
	
		Object matriculeVisiteur =  ((ModeleVisiteur) this.table.getModel()).getValueAt(this.row,this.column);
		
		System.out.println(matriculeVisiteur);
		
				switch(this.column){
		
				case 5 :
					vueVoirSelectionDate= new VueVoirSelectionDate(this.vue);
						break ;
			}		
	 }
}