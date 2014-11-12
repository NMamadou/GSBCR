package gsb;

import java.util.Date;
import java.util.GregorianCalendar;

public class CompteRendu {
   
    private int numero;
    private Date dateRedac;
    private Date dateVisite;
    private String bilan;
    private String motif;
    private String nomPra;
    private String villePra;
    private String nomVis;
    private boolean read ;
    
   
    public CompteRendu(int numero, Date dateRedac, Date dateVisite, String bilan, String motif, String nomPra, String villePra, String nomVis, boolean read){
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


    /** Obtenir le numéro du rapport de visite
     *
     * @return le numero du rapport
     */
    public int getNumero() {
        return numero;
    }
   
    /** Modifier le numéro du rapport de visite
     *
     * @param numero le numero du rapport
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
   
    /** Obtenir la date du rapport de visite
     *
     * @return la date du rapport
     */
    public Date getDateRedac() {
        return dateRedac;
    }
   
    /** Modifier la date du rapport de visite
     *
     * @param date la date du rapport
     */
    public void setDateRedac(Date dateRedac) {
        this.dateRedac = dateRedac;
    }
    
    /** Obtenir la date du rapport de visite
    *
    * @return la date du rapport
    */
   public Date getDateVisite() {
       return dateVisite;
   }
  
   /** Modifier la date du rapport de visite
    *
    * @param date la date du rapport
    */
   public void setDateVisite(Date dateVisite) {
       this.dateVisite = dateVisite;
   }
   
    /** Obtenir le bilan du rapport de visite
     *
     * @return le bilan du rapport
     */
    public String getBilan() {
        return bilan;
    }
   
    /** Modifier le bilan du rapport de visite
     *
     * @param bilan le bilan du rapport
     */
    public void setBilan(String bilan) {
        this.bilan = bilan;
    }
   
    /** Obtenir le motif du rapport de visite
     *
     * @return
     */
    public String getMotif() {
        return motif;
    }
   
    /** Modifier le motif du rapport de visite
     *
     * @param motif le motif du rapport de visite
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }
    
    public String getNomPra() {
    	return nomPra;
    }
    	
    public void setNomPra(String nomPra) {
    	this.nomPra = nomPra;
    }
    
    public String getVillePra() {
    	return villePra;
    }
    
    public void setVillePra(String villePra) {
    	this.villePra = villePra;
    }

    
    public String getNomVis() {
    	return nomVis;
    }
    
    public void setNomVis(String nomVis) {
    	this.nomVis = nomVis;
    }
    
    public boolean getRead(){
    	return read ;
    }
    
    public void setRead(boolean read){
    	this.read = read ;
    }
}