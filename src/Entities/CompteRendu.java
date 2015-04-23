package Entities;

import java.util.Date;
import java.util.GregorianCalendar;

/** Représenter un compte-rendu
 * 
 * @author ndiaye
 *
 */
public class CompteRendu {
   
    
	private int numero;
    private Date dateRedac;
    private Date dateVisite;
    private String bilan;
    private String motif;
    private String nomPra;
    private String villePra;
    private String nomVis;
    private String read ;
    public static final String NOT_READ = "Non" ;
    public static final String READ = "Oui" ;
   
    
    /** Créer un compte-rendu
	 * 
	 * @param numero Le numéro
	 * @param dateRedac La date de rédaction
	 * @param dateVisite La date de visite
	 * @param bilan Le bilan
	 * @param motif Le motif
	 * @param nomPra Le nom du praticien
	 * @param villePra La ville du praticien
	 * @param nomVis Le nom du visiteur
	 * @param read L'état du compte-rendu
	 */
    public CompteRendu(int numero, Date dateRedac, Date dateVisite, String bilan, String motif, String nomPra, String villePra, String nomVis, String read){
        this.numero = numero;
        this.dateRedac = dateRedac;
        this.dateVisite = dateVisite;
        this.bilan = bilan;
        this.motif = motif;
        this.nomPra = nomPra ;
        this.villePra = villePra;
        this.nomVis = nomVis;
        this.read = read ;
        
    }


    /** Obtenir le numéro du rapport 
     *
     * @return le numero du rapport
     */
    public int getNumero() {
        return numero;
    }
   
    /** Modifier le numéro du rapport 
     *
     * @param numero le numero du rapport
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
   
    /** Obtenir la date de rédaction du rapport 
     *
     * @return la date de rédaction du rapport
     */
    public Date getDateRedac() {
        return dateRedac;
    }
   
    /** Modifier la date de rédaction du rapport 
     *
     * @param dateRedac la date de rédaction du rapport
     */
    public void setDateRedac(Date dateRedac) {
        this.dateRedac = dateRedac;
    }
    
    /** Obtenir la date de visite du rapport 
    *
    * @return la date de visite du rapport
    */
   public Date getDateVisite() {
       return dateVisite;
   }
  
   /** Modifier la date de visite du rapport 
    *
    * @param dateVisite la date de visite du rapport
    */
   public void setDateVisite(Date dateVisite) {
       this.dateVisite = dateVisite;
   }
   
    /** Obtenir le bilan du rapport 
     *
     * @return le bilan du rapport
     */
    public String getBilan() {
        return bilan;
    }
   
    /** Modifier le bilan du rapport 
     *
     * @param bilan le bilan du rapport
     */
    public void setBilan(String bilan) {
        this.bilan = bilan;
    }
   
    /** Obtenir le motif du rapport 
     *
     * @return le motif du rapport
     */
    public String getMotif() {
        return motif;
    }
   
    /** Modifier le motif du rapport 
     *
     * @param motif le motif du rapport 
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }
    
    /** Obtenir le nom du praticien
    *
    * @return le nom du praticien
    */
    public String getNomPra() {
    	return nomPra;
    }
    
    /** Modifier le nom du praticien
    *
    * @param nomPra le nom du praticien
    */
    public void setNomPra(String nomPra) {
    	this.nomPra = nomPra;
    }
    
    /** Obtenir la ville du praticien
    *
    * @return la ville du praticien
    */
    public String getVillePra() {
    	return villePra;
    }
    
    /** Modifier la ville du praticien
    *
    * @param villePra la ville du praticien
    */
    public void setVillePra(String villePra) {
    	this.villePra = villePra;
    }

    
    /** Obtenir le nom du visiteur
    *
    * @return le nom du visiteur
    */
    public String getNomVis() {
    	return nomVis;
    }
    
    /** Modifier le nom du visiteur
    *
    * @param nomVis le nom du visiteur
    */
    public void setNomVis(String nomVis) {
    	this.nomVis = nomVis;
    }
    
    /** Obtenir l'état du rapport
    *
    * @return l'état du rapport
    */
    public String getRead(){
    	return read ;
    }
    
    /** Modifier l'état du rapport
    *
    * @param read l'état du rapport
    */
    public void setRead(String read){
    	this.read = read ;
    }
    
    /** Indique si un compte-rendu n'est pas lu
    *
    * @return true si le compte-rendu n'est pas lu et false dans le cas contraire
    */
    public boolean isNotRead(){
	    if(this.read == "Non"){
	    	return true ;
	    }
	    else {
	    	return false ;
	    }
    }
    /** Indique si un compte-rendu est lu
    *
    * @return true si le compte-rendu est lu et false dans le cas contraire
    */
    public boolean isRead(){
	    if(this.read == "Oui"){
	    	return true ;
	    }
	    else {
	    	return false ;
	    }
    }
    
    @Override
	public String toString() {
		return "CompteRendu [numero=" + numero + ", dateRedac=" + dateRedac
				+ ", dateVisite=" + dateVisite + ", bilan=" + bilan
				+ ", motif=" + motif + ", nomPra=" + nomPra + ", villePra="
				+ villePra + ", nomVis=" + nomVis + ", read=" + read + "]";
	}
    
  
}