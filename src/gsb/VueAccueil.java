package gsb;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueAccueil extends JPanel {
	private JLabel pin = new JLabel(new ImageIcon("/Users/jam/PPE3/workspace/logo.jpg"));
	
	public VueAccueil(){
		super() ;
		//JPanel panel = new JPanel();
		this.setLayout(new GridLayout(1,0));
		this.add(pin);
		//panel.add(pin);
	}
	
	public void actualiser(){
		
	}
	
}
