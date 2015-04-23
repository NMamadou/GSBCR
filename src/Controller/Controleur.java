package Controller;

import Model.ModeleAppliCR;
import Utils.Authentification;
import Views.GuiAppliCR;

/** Contrôleur de l'application
* @author ndiaye
*/
public class Controleur {

	private GuiAppliCR vuePrincipale ;
	private ModeleAppliCR modele ;
	
	
	/** Créer le contrôleur
	*
	* @param modele Le modèle
	*/
	public Controleur(ModeleAppliCR modele) {
		super();
		this.modele = modele;
	}

	/** Obtenir la vue principale
	*
	* @return La vue principale
	*/
	public GuiAppliCR getVuePrincipale() {
		return vuePrincipale;
	}

	/** Modifier la vue principale
	*
	* @param vuePrincipale La nouvelle vue principale
	*/
	public void setVuePrincipale(GuiAppliCR vuePrincipale) {
		this.vuePrincipale = vuePrincipale;
	}
	
	/** Se connecter 
	* 
	*/
	public void seConnecter(){
		System.out.println("ControleurSeConnecter");
		this.vuePrincipale.changerDeVue("Se connecter") ;
	}
	
	/** Se déconnecter 
	* 
	*/
	public void seDeconnecter(){
		System.out.println("ControleurSeDeconnecter");
		this.vuePrincipale.changerDeVue("Se déconnecter") ;
	}
	
	/** Quitter l'application 
	* 
	*/
	public void quitterApplication(){
		System.out.println("ControleurQuitter");
		this.vuePrincipale.changerDeVue("Quitter") ;
	}
	
	/** Méthode permettant de visualiser la liste des visiteurs
	*
	*/
	public void visualiserVisiteurs(){
		System.out.println("Controleur::visualiserVisiteurs");
		this.vuePrincipale.changerDeVue("Liste visiteurs") ;
	}
	
	/** Méthode permettant de visualiser la liste des praticiens hésitants
	*
	*/
	public void visualiserPraticiensHesitants(){
		System.out.println("Controleur::visualiserPraticiensHesitants()") ;
		this.vuePrincipale.changerDeVue("Liste praticiens hésitants");
	}
	
	/** Méthode permettant de visualiser la liste des comptes-rendus 
	*
	*/
	public void visualiserComptesRendus(){
		System.out.println("Controleur::visualiserCompteRendus");
		this.vuePrincipale.changerDeVue("Liste comptes-rendus") ;
	}
	
	/** Méthode permettant de visualiser le compte-rendu selectionné
	*
	*/
	public void visualiserComptesRenduChoisi(){
		this.vuePrincipale.changerDeVue("Le compte-rendu") ;
	}
	
	/** Tentative de connexion d'un délégué régional
	*
	* @param login Le login du délégué
	* @param mdp Le mot de passe du délégué
	* @return Vrai si il existe un délégué avec ce login et ce mot de passe , false dans le cas contraire
	*/
	public boolean tenterConnexion(String login, String mdp){
		 return Authentification.seConnecter(login, mdp);
	}
	
	
	/** Fermer l'application 
	* 
	*/
	public void quitter(){
		System.exit(0) ;
	}

	/** Méthode permettant de visualiser la vue A Propos
	*
	*/
	public void visualiserApropos(){
		System.out.println("Controleur::visualiserApropos");
		this.vuePrincipale.changerDeVue("A propos") ;
	}
	
	
}
