package Views;

import java.awt.Color;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import Controller.Controleur;
import Entities.CompteRendu;
import Model.ModeleAppliCR;

/** Modèle de la liste des comptes-rendus
*
* @author ndiaye
*
*/
public class ModeleListeCompteRendus extends AbstractTableModel{
	
	
	private static final long serialVersionUID = 1L;
	private List<CompteRendu> comptesRendus ;
	private final String[] entetes = {"Numéro","Date de rédaction","Date de visite","Nom du praticien","Ville du praticien","Sélectionner","Consulté"} ;
	private ModeleAppliCR modele ;
	private Controleur controleur;

	
	
	/** Créer le modèle de la liste des comptes-rendus
	*
	* @param modele Le modèle de l'application
	* @param controleur Le contrôleur de l'application
	*/
	public ModeleListeCompteRendus(ModeleAppliCR modele, Controleur controleur){
		super() ;
		System.out.println("ModeleListeCompteRendus::ModeleListeCompteRendus()") ;
		this.modele = modele ;
		this.controleur = controleur ;
		comptesRendus = modele.getComptesRendus();
	
	}
	
	/** Obtenir le modèle
	*
	* @return modele
	*/
	public ModeleAppliCR getModele(){
		return modele ;
	}
	
	/** Obtenir le controleur
	*
	* @return controleur
	*/
	public Controleur getControleur(){
		return controleur;
	}
	
	 /** Obtenir le numéro du rapport 
    *
    * @return le numero du rapport
    */
	 public int getNumero(int row) {
	        return comptesRendus.get(row).getNumero();
	    }
	
	 /** Obtenir le nom du visiteur
	    *
	    * @return le nom du visiteur
	    */ 
	public String getNomVis(int row){
		return comptesRendus.get(row).getNomVis();
	}
	
	/** Obtenir le nom du praticien
    *
    * @return le nom du praticien
    */
	public String getNom(int row){
		return comptesRendus.get(row).getNomPra();
	}

	 /** Obtenir la ville du praticien
    *
    * @return la ville du praticien
    */
	public String getVille(int row){
		return comptesRendus.get(row).getVillePra();
	}
	
	 /** Obtenir le bilan du rapport 
    *
    * @return le bilan du rapport
    */
	public String getBilan(int row){
		return comptesRendus.get(row).getBilan();
	}
	
	/** Obtenir le motif du rapport 
    *
    * @return le motif du rapport
    */
	public String getMotif(int row){
		return comptesRendus.get(row).getMotif();
	}
	
	/** Obtenir la date de rédaction du rapport 
    *
    * @return la date de rédaction du rapport
    */
	public Date getDateRedac(int row){
		return comptesRendus.get(row).getDateRedac();
	}
	
	 /** Obtenir la date de visite du rapport 
    *
    * @return la date de visite du rapport
    */
	public Date getDateVisite(int row){
		return comptesRendus.get(row).getDateVisite();
	}
	
	 /** Obtenir l'état du rapport
    *
    * @return l'état du rapport
    */
	public String getRead(int row){
		return comptesRendus.get(row).getRead();
	}
	
	  
    /** Modifier l'état du rapport
    *
    * @param read l'état du rapport
    */
	 public void setRead(String read){
	    	read = read ;
	    }
	
	 /** Obtenir le nombre de colonnes en fonction des entêtes
	 *
	 * @return Le nombre de colonnes
	 */
    public int getColumnCount() {
        return entetes.length;
    }
 
    /** Obtenir le nombre de lignes de la liste
    *
    * @return Le nombre de lignes
    */
    public int getRowCount() {
    		return comptesRendus.size();
    }
   
    /** Obtenir le nom d'une colonne
    *
    * @param column L'indice de la colonne
    * @return Le nom de la colonne
    */
    public String getColumnName(int column) {
        return entetes[column];
    }
    
    /** Modifier la valeur d'une colonne
	*
	* @param value La valeur
	* @param row La ligne
	* @param column La colonne
	*/
    public void setValueAt(Object value, int row, int column) {
	    if(column == 6){
	    	comptesRendus.get(row).setRead("Oui");
	    }
	  
    }
    
    /** Obtenir la classe d'une colonne
    *
    * @param column L'indice de la colonne
    * @return La classe de la colonne
    */
    public Class getColumnClass(int column){
        switch(column){
	    	case 0 :
	    		return String.class ;
	    	case 1 :
	    		return String.class ;
	    	case 2 :
	    		return String.class ;
	    	case 3 :
	    		return String.class ;
	    	case 4 :
	    		return String.class ;
	    	case 5 :
	    		return JButton.class ;
	    	case 6 :
	    		return String.class ;
	    	default :
	    		return Object.class ;
    	}
    }
    
    /** Obtenir la valeur d'une cellule
    *
    * @param row L'indice de la ligne
    * @param column L'indice de la colonne
    * @return La valeur de la cellule
    */
    public Object getValueAt(int row, int column) {
        switch (column) {
        case 0:
            return comptesRendus.get(row).getNumero();
        case 1:
            return comptesRendus.get(row).getDateRedac();
        case 2:
        	return comptesRendus.get(row).getDateVisite();
        case 3:
             return comptesRendus.get(row).getNomPra();
        case 4:
           	return comptesRendus.get(row).getVillePra();
        case 5:
        	return "Choisir";
        case 6 :
        	if (comptesRendus.get(row).isRead()){
        		return "Oui";
        	}
        	else{
        			return "Non" ;
        		
        	}
        	
        default:
            return null;
        }
    }
    
    /** Déterminer si une cellule est éditable ou non
    *
    * @param row L'indice de la ligne
    * @param column L'indice de la colonne
    * @return true si la cellule est éditable, false dans le cas contraire
    */
    public boolean isCellEditable(int row, int column){
    	switch(column){
    		case 5 :
    			return true;
    		default :
    			return false;
    	}
    }
}

