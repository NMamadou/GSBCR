package gsb;

public class Controleur {

	private GuiAppliCR vuePrincipale ;
	private ModeleAppliCR modele ;
	
	
	public Controleur(ModeleAppliCR modele) {
		super();
		this.modele = modele;
	}

	public GuiAppliCR getVuePrincipale() {
		return vuePrincipale;
	}

	public void setVuePrincipale(GuiAppliCR vuePrincipale) {
		this.vuePrincipale = vuePrincipale;
	}

	public ModeleAppliCR getModele() {
		return modele;
	}

	public void setModele(ModeleAppliCR modele) {
		this.modele = modele;
	}
	
	public void seConnecter(){
		System.out.println("ControleurSeConnecter");
		this.vuePrincipale.changerDeVue("Se connecter") ;
	}
	
	public void seDeconnecter(){
		System.out.println("ControleurSeDeconnecter");
		this.vuePrincipale.changerDeVue("Se déconnecter") ;
	}
	
	public void quitterApplication(){
		System.out.println("ControleurQuitter");
		this.vuePrincipale.changerDeVue("Quitter") ;
	}
	
	public void visualiserVisiteurs(){
		System.out.println("Controleur::visualiserVisiteurs");
		this.vuePrincipale.changerDeVue("Liste visiteurs") ;
	}
	
	public void visualiserPraticiensHesitants(){
		System.out.println("Controleur::visualiserPraticiensHesitants()") ;
		this.vuePrincipale.changerDeVue("Liste praticiens hésitants");
	}
	
	public void visualiserComptesRendus(){
		System.out.println("Controleur::visualiserCompteRendus");
		this.vuePrincipale.changerDeVue("Liste comptes-rendus") ;
	}
	
	public boolean tenterConnexion(String login, String mdp){
		 return Authentification.seConnecter(login, mdp);
	}
	
	public void quitter(){
		System.exit(0) ;
	}
}
