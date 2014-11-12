package gsb;

public class AppliCR {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModeleAppliCR modele = new ModeleAppliCR() ;
		Controleur controleur = new Controleur(modele) ;
		new GuiAppliCR(modele,controleur) ;
		
	}

}
