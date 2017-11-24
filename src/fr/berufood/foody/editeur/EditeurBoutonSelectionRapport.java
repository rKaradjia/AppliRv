package fr.berufood.foody.editeur;
import javax.swing.*;
import javax.swing.table.TableCellEditor;

import fr.berufood.foody.controleurs.ControleurBoutonSelectionVisiteur;
import fr.berufood.foody.controleurs.ControleurLireRapport;
import fr.berufood.foody.vues.VueRapportParDate;

import java.awt.*;



public class EditeurBoutonSelectionRapport extends DefaultCellEditor{
	private String matricule;
	private String mois;
	private String annee;
	
	
	private VueRapportParDate vue;
	protected JButton button = new JButton();
	private ControleurLireRapport ctrl;
	public EditeurBoutonSelectionRapport(String matricule, String mois, String annee){
		
		super(new JCheckBox());
		this.matricule=matricule;
		this.mois=mois;
		this.annee=annee;

		ctrl = new ControleurLireRapport(this.getMatricule(),
				this.getMois(),this.getAnnee()) ;
		this.button.addActionListener(this.ctrl);
	
		
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		
		super.getTableCellEditorComponent(table, value, isSelected, row, column);
		
		this.ctrl.setRow(row);
		
		if(value == null){
			this.button.setText("");
		}
		
		else{
			this.button.setText(value.toString());
		}
		
		return this.button;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}
	
	
	
	

}
