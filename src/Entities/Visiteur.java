package Entities;


import java.util.Date;
import java.util.GregorianCalendar;

/** Représenter un visiteur
 * 
 * @author ndiaye
 *
 */
public class Visiteur {
	
	private String matricule ;
	private String nom ;
	private String prenom ;
	private String adresse ;
	private String cp ;
	private String ville ;
	private Date dateEmbauche ;

	
	/** Créer un visiteur
	 * 
	 * @param matricule Le matricule
	 * @param nom Le nom
	 * @param prenom Le prénom
	 * @param adresse L'adresse
	 * @param cp Le code postal
	 * @param ville La ville
	 * @param dateEmbauche La date d'embauche
	 */
	public Visiteur(String matricule, String nom, String prenom, String adresse, String cp, String ville, Date dateEmbauche) {
		super();
		this.matricule = matricule ;
		this.nom = nom ;
		this.prenom = prenom ;
		this.adresse = adresse ;
		this.cp = cp ;
		this.ville = ville ;
		this.dateEmbauche = dateEmbauche ;
	}
	

	/** Obtenir le matricule du visiteur
	 * 
	 * @return Le matricule du visiteur
	 */
	public String getMatricule() {
		return matricule;
	}

	/** Modifier le matricule du visiteur
	 * 
	 * @param matricule Le matricule du visiteur
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	/** Obtenir le nom du visiteur
	 * 
	 * @return Le nom du visiteur
	 */
	public String getNom() {
		return nom;
	}

	/** Modifier le nom du visiteur
	 * 
	 * @param nom Le nom du visiteur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/** Obtenir le prénom du visiteur
	 * 
	 * @return Le prénom du visiteur
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Modifier le prénom du visiteur
	 * 
	 * @param prenom Le prénom du visiteur
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/** Obtenir l'adresse du visiteur
	 * 
	 * @return L'adresse du visiteur
	 */
	public String getAdresse() {
		return adresse;
	}

	/** Modifier l'adresse du visiteur
	 * 
	 * @param adresse L'adresse du visiteur
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/** Obtenir le code postal du visiteur
	 * 
	 * @return Le code postal du visiteur
	 */
	public String getCp() {
		return cp;
	}

	/** Modifier le code postal du visiteur
	 * 
	 * @param cp Le code postal du visiteur
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	/** Obtenir la ville du visiteur
	 * 
	 * @return La ville du visiteur
	 */
	public String getVille() {
		return ville;
	}

	/** Modifier la ville du visiteur
	 * 
	 * @param ville La ville du visiteur
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/** Obtenir la date d'embauche du visiteur
	 * 
	 * @return La date d'embauche du visiteur
	 */
	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	/** Modifier la date d'embauche du visiteur
	 * 
	 * @param dateEmbauche La date d'embauche du visiteur
	 */
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Visiteurs [matricule=" + matricule + ", nom=" + nom
				+ ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville + ", dateEmbauche=" + dateEmbauche + "]";
	}

}
