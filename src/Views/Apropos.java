package Views;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/** Vue A Propos de l'application GSB
*
* @author ndiaye
*
*/
public class Apropos extends JPanel{


		private JLabel label = new JLabel("Cette application a été développé par M.NDIAYE.",SwingConstants.CENTER);
				
		public Apropos() {
			super();
			
			this.setLayout(new GridLayout(1,0));
			this.add(label);
		}
}
