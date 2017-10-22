package fr.berufood.foody.controleurs;
import javax.swing.*;

import fr.berufood.foody.rendus.RenduBoutonSelectionVisiteur;
import fr.berufood.foody.vues.*;

import java.awt.*;
import java.awt.event.*;
public class ControleurBoutonSelectionVisiteur implements ActionListener{
	
	private int row;
	private VueVoirSelectionDate vue = new VueVoirSelectionDate() ;//vu a creer ulterieurement

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Selection de la date rapport visiteur");
		this.vue.setVisible(true);
	}
	
}
