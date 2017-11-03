package fr.berufood.foody.vues;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import javax.swing.border.EmptyBorder;

import fr.berufood.foody.controleurs.ControleurBoutonSelectionVisiteur;
import fr.berufood.foody.editeur.EditeurBoutonSelectionVisiteur;
import fr.berufood.foody.modeles.ModeleVisiteur;
import fr.berufood.foody.rendus.RenduBoutonSelectionVisiteur;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VueVoirSelectionDate extends JFrame {
	
	private JPanel contentPane;
	private ControleurBoutonSelectionVisiteur controleurParent;
	/*private JComboBox comboBox;
	private JComboBox comboBox_1;*/
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueVoirSelectionDate frame = new VueVoirSelectionDate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public VueVoirSelectionDate() {
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,511,310);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setBackground(Color.GRAY);
		setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		
		
		String[] mois = new String[]{"...","01","02","03","04","05","06","07","08","09","10","11","12"};
		JComboBox comboBox = new JComboBox(mois);
		comboBox.setBounds(259, 119, 145, 24);
		contentPane.add(comboBox);
		
		String[] annee = new String[]{"...","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"};
		JComboBox comboBox_1 = new JComboBox(annee);
		comboBox_1.setBounds(259, 168, 145, 24);
		contentPane.add(comboBox_1);
		
		JLabel lblMois = new JLabel("Mois ");
		lblMois.setBounds(101, 124, 70, 15);
		contentPane.add(lblMois);
		
		JLabel lblAnnee = new JLabel("Annee");
		lblAnnee.setBounds(101, 173, 70, 15);
		contentPane.add(lblAnnee);
		
		JLabel lblVeuillezChoisirUne = new JLabel("Veuillez choisir une date");
		lblVeuillezChoisirUne.setBounds(259, 46, 215, 45);
		contentPane.add(lblVeuillezChoisirUne);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnValider.setBounds(115, 232, 117, 25);
		contentPane.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(306, 232, 117, 25);
		contentPane.add(btnAnnuler);
	}




	/**
	 * @return the controleurParent
	 */
	public ControleurBoutonSelectionVisiteur getControleurParent() {
		return controleurParent;
	}




	/**
	 * @param controleurParent the controleurParent to set
	 */
	public void setControleurParent(ControleurBoutonSelectionVisiteur controleurParent) {
		this.controleurParent = controleurParent;
	}
}