package fr.berufood.foody.modeles;

import java.sql.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.berufood.foody.entites.Praticien;
import fr.berufood.foody.entites.RapportVisite;
import fr.berufood.foody.entites.Visiteur;
import fr.berufood.foody.techniques.DateFr;




public class ModeleRapportDateVisiteur extends AbstractTableModel {
	
	private List<RapportVisite> lesRapports = ModeleFoody.getLesRapportDateVisiteur() ;
	
	
	/*+---------------+---------+---------+--------------------------------------+------------+
	| VIS_MATRICULE | RAP_NUM | PRA_NUM | RAP_BILAN                            | RAP_DATE   |
	+---------------+---------+---------+--------------------------------------+------------+

	*/
	private final String[] entetes = { "Matricule" , "Numero du rapport " , "numero du praticien" , "Date du rapport"} ;

	/*public ModeleListeLivreurs() {
		super();
	}*/

	@Override
	public int getRowCount() {
		// VOTRE CODE ICI - Question 5
		return lesRapports.size();
	}

	@Override
	public int getColumnCount() {
		// VOTRE CODE ICI - Question 5
		return entetes.length;
	}
	
	@Override
	public String getColumnName(int column) {
		// VOTRE CODE ICI - Question 5
		return entetes[column];
	}
/*	Field         | Type         | Null | Key | Default | Extra |
	+---------------+--------------+------+-----+---------+-------+
	| VIS_MATRICULE | varchar(20)  | NO   | PRI |         |       |
	| RAP_NUM       | int(11)      | NO   | PRI | 0       |       |
	| PRA_NUM       | int(11)      | YES  | MUL | NULL    |       |
	| RAP_BILAN     | varchar(510) | YES  |     |         |       |
	| RAP_DATE      | date         | YES  |     | NULL    |       
	@Override*/
	public Class<?> getColumnClass(int columnIndex) {
		// VOTRE CODE ICI - Question 5
		switch (columnIndex){
		case 0: return String.class;
				
		case 1:return int.class;
		              
				
		case 2:return int.class;
		
		case 3:return 	String.class;	
		
		case 4:return   Date.class;
		
		}
		return null;	
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// VOTRE CODE ICI - Question 5
		switch (columnIndex){
			
			case 0:
				
					return lesRapports.get(rowIndex).getLeVisiteur().getMatricule();
					
					
				
				
			case 1:
				return lesRapports.get(rowIndex).getNumRapport();
					
				
				
			case 2:
				return lesRapports.get(rowIndex).getLePraticien().getNum();
			
			case 3:return 	lesRapports.get(rowIndex).getBilan();	
			
			case 4:return   lesRapports.get(rowIndex).getDateRapport();
				
					
			
		}	
		return null;
	}
	
	public void actualiser(){
		this.fireTableDataChanged();
	}

}
