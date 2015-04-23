package Entities;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

import Utils.Dates;



/** Représenter un praticien 
 * 
 * @author ndiaye
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
	private long tempsEcoule ;
	private long dateAujourdhui = new GregorianCalendar().getTimeInMillis();
	private String nbJours = "jours";
	
	/** Créer un praticien 
	 * @param numero Le numéro
	 * @param nom Le nom
	 * @param prenom Le prénom
	 * @param adresse L'adresse
	 * @param cp Le code postal
	 * @param ville La ville
	 * @param coefnotoriete Le coefficient de notoriété
	 * @param coefconfiance Le coefficient de confiance
	 */
	public Praticien(int numero, String nom, String prenom, String adresse, String cp, String ville, float coefnotoriete, float coefconfiance, Date dateVisite) {
		super();
		this.numero = numero ;
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
	 * @param numero Le numero du praticien
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

	/** Obtenir le prénom du praticien
	 * 
	 * @return Le prénom du praticien
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Modifier le prénom du praticien
	 * 
	 * @param prenom Le prénom du praticien
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
	 * @param coefnotoriete le coefficient de notoriété
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

	/** Modifier le coefficient de confiance
	 * 
	 * @param coefconfiance Le coefficient de confiance
	 */
	public void setCoefconfiance(float coefconfiance) {
		this.coefconfiance = coefconfiance;
	}
	
	/** Obtenir la date de visite 
	 * 
	 * @return la date de visite 
	 */
	public Date getDateVisite() {
		return dateVisite;
	}
	
	/** Modifier la date de visite 
	 * 
	 * @param dateVisite
	 */
	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}
	
	/** Obtenir le temps ecoulé depuis la dernière visite
	 * 
	 * @return le temps ecoulé 
	 */
	public String getTempsEcoule() {
		Calendar dateRapport = Dates.DateToCalendar(dateVisite);
		long derniereVisite = dateRapport.getTimeInMillis();
		long tempsEcoule = (((dateAujourdhui-derniereVisite) /3600000))/24; //Conversion en jours
		return tempsEcoule+" "+nbJours;
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

