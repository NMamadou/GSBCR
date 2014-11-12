package gsb;

import java.util.Date;


/** Repr�senter un praticien 
 * 
 * @author xilim
 *
 */
public class Praticien {
	private int numero ;
	private String nom ;
	private String prenom ;
	private String adresse ;
	private String cp ;
	private String ville ;
	private float coefnotoriete ; 
	private float coefconfiance ; 
	private Date dateVisite ;
	
	/** Cr�er un praticien 
	 * @param numero Le numéro
	 * @param nom Le nom
	 * @param prenom Le pr�nom
	 * @param adresse L'adresse
	 * @param cp Le code postal
	 * @param ville La ville
	 * @param coefnotoriete Le coefficient de notoriété
	 * @param coefconfiance Le coefficient de confiance
	 */
	public Praticien(int numero, String nom, String prenom, String adresse, String cp, String ville, float coefnotoriete, float coefconfiance, Date dateVisite) {
		super();
		this.nom = nom;
		this.prenom = prenom ;
		this.adresse = adresse ;
		this.cp = cp ;
		this.ville = ville ;
		this.coefnotoriete = coefnotoriete ;
		this.coefconfiance = coefconfiance ;
		this.dateVisite = dateVisite;
	}
	
	/** Obtenir le numero du praticien
	 * 
	 * @return Le numero du praticien
	 */
	public int getNumero() {
		return numero;
	}

	/** Modifier le numero du praticien
	 * 
	 * @param matricule Le numero du praticien
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/** Obtenir le nom
	 * 
	 * @return Le nom
	 */
	public String getNom() {
		return nom;
	}

	/** Modifier le nom
	 * 
	 * @param nom Le nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Obtenir le pr�nom du praticien
	 * 
	 * @return Le pr�nom du praticien
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Modifier le pr�nom du praticien
	 * 
	 * @param prenom Le pr�nom du praticien
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/** Obtenir l'adresse du praticien
	 * 
	 * @return L'adresse du praticien
	 */
	public String getAdresse() {
		return adresse;
	}

	/** Modifier l'adresse du praticien
	 * 
	 * @param adresse L'adresse du praticien
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/** Obtenir le code postal du praticien
	 * 
	 * @return Le code postal du praticien
	 */
	public String getCp() {
		return cp;
	}

	/** Modifier le code postal du praticien
	 * 
	 * @param cp Le code postal du praticien
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	/** Obtenir la ville du praticien
	 * 
	 * @return La ville du praticien
	 */
	public String getVille() {
		return ville;
	}

	/** Modifier la ville du praticien
	 * 
	 * @param ville La ville du praticien
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/** Obtenir le coefficient de notoriété
	 * 
	 * @return Le coefficient de notoriété
	 */
	public float getCoefnotoriete() {
		return coefnotoriete;
	}

	/** Modifier le coefficient de notoriété
	 * 
	 * @param coefnotoriete Le numero du praticien
	 */
	public void setCoefnotoriete(float coefnotoriete) {
		this.coefnotoriete = coefnotoriete;
	}
	
	/** Obtenir le coefficient de confiance
	 * 
	 * @return Le coefficient de confiance
	 */
	public float getCoefconfiance() {
		return coefconfiance;
	}

	/** Modifier le coefficient de notoriété
	 * 
	 * @param coefnotoriete Le numero du praticien
	 */
	public void setCoefconfiance(float coefconfiance) {
		this.coefconfiance = coefconfiance;
	}
	
	public Date getDateVisite() {
		return dateVisite;
	}
	
	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PraticienHesitant [nom=" + nom + ", ville=" + ville + "]";
	}

}

