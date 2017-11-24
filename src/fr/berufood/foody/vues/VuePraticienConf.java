package fr.berufood.foody.vues;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.berufood.foody.modeles.ModelePraticienConf;
import fr.berufood.foody.modeles.ModelePraticienNoto;

public class VuePraticienConf extends JPanel {

	private ModelePraticienConf modeleTabPraticienConf ;
	private JTable tabPraticienConf;
	
	public VuePraticienConf(){
		super() ;
		modeleTabPraticienConf = new ModelePraticienConf() ;
		this.creerInterfaceVisiteurs() ;
	}
	
	private void creerInterfaceVisiteurs(){
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTable = Box.createHorizontalBox() ;
		
		boxEtiquette.add( new JLabel( "Coeficient de confiance" ) ) ;
			
		this.tabPraticienConf=new JTable(modeleTabPraticienConf);
		this.tabPraticienConf.setRowHeight(30);//hauteur de chaques lignes
		JScrollPane spLivreurs= new JScrollPane(this.tabPraticienConf);
		spLivreurs.setPreferredSize(new Dimension(1090,420));// y integre un srool d'une dimension de 1090*420
		//tabPraticienNoto.getColumn("").setCellRenderer(new RendusBoutonVoirVisiteur());
		
		boxTable.add(spLivreurs);
		boxPrincipale.add(boxTable);

		boxPrincipale.add( boxEtiquette ) ;
		boxPrincipale.add( boxTable ) ;
		
		this.add( boxPrincipale ) ;
		
	}
	
	public ModelePraticienConf getModeleListePraticienConf() {
		return modeleTabPraticienConf;
	}

	public JTable getTabPraticien() {
		return tabPraticienConf;
	}
	
	
	
	
}
