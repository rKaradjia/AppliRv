package fr.berufood.foody.vues;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import fr.berufood.foody.editeur.EditeurBoutonSelectionVisiteur;
import fr.berufood.foody.modeles.ModeleVisiteur;
import fr.berufood.foody.rendus.RenduBoutonSelectionVisiteur;
import java.awt.Color;


public class VueVoirSelectionDate extends JPanel {
	public VueVoirSelectionDate() {
		setBackground(Color.GRAY);
		setForeground(Color.WHITE);
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(329, 119, 145, 24);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(329, 168, 145, 24);
		add(comboBox_1);
		
		JLabel lblMois = new JLabel("Mois ");
		lblMois.setBounds(195, 124, 70, 15);
		add(lblMois);
		
		JLabel lblAnnee = new JLabel("Annee");
		lblAnnee.setBounds(195, 173, 70, 15);
		add(lblAnnee);
		
		JLabel lblVeuillezChoisirUne = new JLabel("Veuillez choisir une date");
		lblVeuillezChoisirUne.setBounds(259, 46, 215, 45);
		add(lblVeuillezChoisirUne);
	}
	
private static final long serialVersionUID = 1L;
}