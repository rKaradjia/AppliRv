package fr.berufood.foody.rendus;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class TablePanelRapportDateVisiteur extends JPanel
{
  private JTable table;

  public TablePanelRapportDateVisiteur(TableModel model) {
    
  	 table = new JTable(model);
       setLayout(new BorderLayout());
       add(new JScrollPane(table),BorderLayout.CENTER );
   }
}