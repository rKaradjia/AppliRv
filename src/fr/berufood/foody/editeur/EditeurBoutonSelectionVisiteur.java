package fr.berufood.foody.editeur;
import javax.swing.*;
import javax.swing.table.TableCellEditor;

import fr.berufood.foody.controleurs.ControleurBoutonSelectionVisiteur;


import java.awt.*;



public class EditeurBoutonSelectionVisiteur extends DefaultCellEditor{
	
	protected JButton button = new JButton();
	private ControleurBoutonSelectionVisiteur ctrl = new ControleurBoutonSelectionVisiteur() ;
	public EditeurBoutonSelectionVisiteur(){
		
		super(new JCheckBox());
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

}
