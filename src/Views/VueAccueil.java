package Views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Vue de l'accueil de l'application GSB
*
* @author ndiaye
*
*/
public class VueAccueil extends JPanel {
	private JLabel pin = new JLabel(new ImageIcon("/Users/jam/PPE3/workspace/logo.jpg"));
	
	
	public VueAccueil(){
		super() ;

		this.setLayout(new GridLayout(1,0));
		this.add(pin);
		this.setBackground(Color.GRAY.brighter());
		
	}
	
	public void actualiser(){
		
	}
	
}
