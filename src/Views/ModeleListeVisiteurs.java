package Views;


import java.util.* ;

import javax.swing.JButton;
import javax.swing.table.* ;

import Controller.Controleur;
import Entities.Visiteur;
import Model.ModeleAppliCR;

/** Modèle de la liste des visiteurs
*
* @author ndiaye
*
*/
public class ModeleListeVisiteurs extends AbstractTableModel {
	
	private List<Visiteur> visiteurs ;
	private final String[] entetes = { "Matricule", "Nom", "Prénom", "Adresse", "Code postal", "Ville", "Date d'embauche","Sélectionner" };
	private ModeleAppliCR modele ;
	private Controleur controleur ;
	
	/** Créer le modèle de la liste des visiteurs
	*
	* @param modele Le modèle de l'application
	*/
	public ModeleListeVisiteurs(ModeleAppliCR modele){
		super() ;
		System.out.println("ModeleListeVisiteurs::ModeleListeVisiteurs()") ;
		this.modele = modele ;
		visiteurs = modele.getVisiteurs() ;
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
	
	
	
	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}

	/** Obtenir le matricule du visiteur
	 * 
	 * @return Le matricule du visiteur
	 */
	public String getMatricule(int row){
		return visiteurs.get(row).getMatricule();
	
	}
	
	/** Obtenir le nom du visiteur
	 * 
	 * @return Le nom du visiteur
	 */
	public String getNom(int row){
		return visiteurs.get(row).getNom();
	}
	
	/** Obtenir le prénom du visiteur
	 * 
	 * @return Le prénom du visiteur
	 */
	public String getPrenom(int row){
		return visiteurs.get(row).getPrenom();
	}

	
	 /** Obtenir le nombre de colonnes en fonction des entêtes
	 *
	 * @return Le nombre de colonnes
	 */
	@Override
    public int getColumnCount() {
        return entetes.length;
    }
 
	 /** Obtenir le nombre de lignes de la liste
    *
    * @return Le nombre de lignes
    */
    @Override
    public int getRowCount() {
        return visiteurs.size();
    }
 
    /** Obtenir le nom d'une colonne
    *
    * @param column L'indice de la colonne
    * @return Le nom de la colonne
    */
    @Override
    public String getColumnName(int column) {
        return entetes[column];
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
	    		return String.class ;
	    	case 6 :
	    		return String.class ;
	    	case 7 :
	    		return JButton.class ;
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
    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
        case 0:
            return visiteurs.get(row).getMatricule();
        case 1:
            return visiteurs.get(row).getNom();
        case 2:
            return visiteurs.get(row).getPrenom();
        case 3:
            return visiteurs.get(row).getAdresse();
        case 4:
            return visiteurs.get(row).getCp();
        case 5:
            return visiteurs.get(row).getVille();
        case 6:
            return visiteurs.get(row).getDateEmbauche();
        case 7:
        	return "Choisir";
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
    		case 7 :
    			return true;
    		default :
    			return false;
    	}
    }
}