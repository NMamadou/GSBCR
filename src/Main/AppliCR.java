package Main;

import java.sql.SQLException;

import Controller.Controleur;
import Model.ModeleAppliCR;
import Utils.ConnexionBD;
import Views.GuiAppliCR;

/** Main de l'application GSB
 * 
 * @author ndiaye
 */
public class AppliCR {
	

	/** MŽthode main de l'application GSB
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		ConnexionBD db = new ConnexionBD();
		 
		ModeleAppliCR modele = new ModeleAppliCR() ;
		
		Controleur controleur = new Controleur(modele) ;
		
		new GuiAppliCR(modele,controleur) ;
		
		
		db.attachShutDownHook();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}

}
