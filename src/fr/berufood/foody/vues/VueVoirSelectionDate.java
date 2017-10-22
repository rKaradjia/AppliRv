package fr.berufood.foody.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VueVoirSelectionDate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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

	/**
	 * Create the frame.
	 */
	public VueVoirSelectionDate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectionDeLa = new JLabel("Selection de la date ");
		lblSelectionDeLa.setBounds(163, 22, 157, 15);
		contentPane.add(lblSelectionDeLa);
		
		textField = new JTextField("01");
		textField.setBounds(240, 75, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("2000");
		textField_1.setBounds(240, 109, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMois = new JLabel("Mois");
		lblMois.setBounds(77, 77, 98, 15);
		contentPane.add(lblMois);
		
		JLabel lblAnne = new JLabel("Année");
		lblAnne.setBounds(77, 111, 70, 15);
		contentPane.add(lblAnne);
		
		JButton btnValider = new JButton("VALIDER");
		btnValider.setBounds(124, 181, 117, 25);
		contentPane.add(btnValider);
		
		JButton btnAnnuler = new JButton("ANNULER");
		btnAnnuler.setBounds(291, 181, 117, 25);
		contentPane.add(btnAnnuler);
	}
}
