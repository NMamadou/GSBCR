package Controller;

import Model.ModeleAppliCR;
import Utils.Authentification;
import Views.GuiAppliCR;

/** Contr�leur de l'application
* @author ndiaye
*/
public class Controleur {

	private GuiAppliCR vuePrincipale ;
	private ModeleAppliCR modele ;
	
	
	/** Cr�er le contr�leur
	*
	* @param modele Le mod�le
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
	
	/** Se d�connecter 
	* 
	*/
	public void seDeconnecter(){
		System.out.println("ControleurSeDeconnecter");
		this.vuePrincipale.changerDeVue("Se d�connecter") ;
	}
	
	/** Quitter l'application 
	* 
	*/
	public void quitterApplication(){
		System.out.println("ControleurQuitter");
		this.vuePrincipale.changerDeVue("Quitter") ;
	}
	
	/** M�thode permettant de visualiser la liste des visiteurs
	*
	*/
	public void visualiserVisiteurs(){
		System.out.println("Controleur::visualiserVisiteurs");
		this.vuePrincipale.changerDeVue("Liste visiteurs") ;
	}
	
	/** M�thode permettant de visualiser la liste des praticiens h�sitants
	*
	*/
	public void visualiserPraticiensHesitants(){
		System.out.println("Controleur::visualiserPraticiensHesitants()") ;
		this.vuePrincipale.changerDeVue("Liste praticiens h�sitants");
	}
	
	/** M�thode permettant de visualiser la liste des comptes-rendus 
	*
	*/
	public void visualiserComptesRendus(){
		System.out.println("Controleur::visualiserCompteRendus");
		this.vuePrincipale.changerDeVue("Liste comptes-rendus") ;
	}
	
	/** M�thode permettant de visualiser le compte-rendu selectionn�
	*
	*/
	public void visualiserComptesRenduChoisi(){
		this.vuePrincipale.changerDeVue("Le compte-rendu") ;
	}
	
	/** Tentative de connexion d'un d�l�gu� r�gional
	*
	* @param login Le login du d�l�gu�
	* @param mdp Le mot de passe du d�l�gu�
	* @return Vrai si il existe un d�l�gu� avec ce login et ce mot de passe , false dans le cas contraire
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

	/** M�thode permettant de visualiser la vue A Propos
	*
	*/
	public void visualiserApropos(){
		System.out.println("Controleur::visualiserApropos");
		this.vuePrincipale.changerDeVue("A propos") ;
	}
	
	
}
