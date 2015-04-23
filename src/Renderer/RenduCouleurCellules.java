package Renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


/** Rendu des cellules du tableau
*
* @author ndiaye
*
*/
public class RenduCouleurCellules extends DefaultTableCellRenderer{

	
	private TableCellRenderer tcr;
	

	public RenduCouleurCellules(TableCellRenderer tcr) {
	super();
	this.tcr = tcr;
}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		Component cell = this.tcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		
		if ((row % 2) == 0){ // Une ligne sur 2 (ligne paire)
				cell.setBackground(new Color(0xb0c4de));
		} 
		else {
			cell.setBackground(Color.WHITE);
	
		}
		return cell;
	}
}
