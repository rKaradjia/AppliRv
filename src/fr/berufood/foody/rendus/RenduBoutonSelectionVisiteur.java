package fr.berufood.foody.rendus;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import fr.berufood.foody.modeles.ModeleFoody;

public class RenduBoutonSelectionVisiteur extends JButton implements TableCellRenderer{
	
	public RenduBoutonSelectionVisiteur(){
		setForeground(Color.BLACK);
		setOpaque(true);
		setContentAreaFilled(false); 
		setHorizontalAlignment(SwingConstants.CENTER);
		setHorizontalTextPosition(SwingConstants.CENTER);
		
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		
		if(value != null){
			
			this.setText(value.toString());
			
		}else{
			
			this.setText("Voir");
		}
		
		return this;
	}
}
