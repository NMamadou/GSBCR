package Views;

import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Controller.Controleur;
import Entities.Praticien;
import Model.ModeleAppliCR;

/** Modèle de la liste des praticiens hésitants
*
* @author ndiaye
*
*/
public class ModeleListePraticiensHesitants extends AbstractTableModel {
	

	private static final long serialVersionUID = 1L;
	private List<Praticien> praticiensHesitants ;
	private final String[] entetes = {"Numero","Nom","Prénom","Adresse","Cp","Ville", "Coefficient de notoriété", "Coefficient de confiance","Date de visite","Temps écoulé"} ;
	private ModeleAppliCR modele;
	private Controleur controleur;
	
	/** Créer le modèle de la liste des praticiens hésitants
	*
	* @param modele Le modèle de l'application
	* @param controleur Le contrôleur de l'application
	*/
	public ModeleListePraticiensHesitants(ModeleAppliCR modele, Controleur controleur) {
		super();
		this.modele = modele;
		this.controleur = controleur;
		praticiensHesitants = modele.getPraticiensHesitants() ;
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
	public Controleur getControleur() {
		return controleur;
	}
	
	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}
	
	/** Obtenir le numero du praticien
	 * 
	 * @return Le numero du praticien
	 */
	public int getNumero(int row){
		return praticiensHesitants.get(row).getNumero();
	
	}
	
	/** Obtenir le nom du praticien
	 * 
	 * @return Le nom du praticien
	 */
	public String getNom(int row){
		return praticiensHesitants.get(row).getNom();
	}
	
	/** Obtenir la ville du praticien
	 * 
	 * @return La ville du praticien
	 */
	public String getVille(int row){
		return praticiensHesitants.get(row).getVille();
	}
	
	/** Obtenir le coefficient de notoriété
	 * 
	 * @return Le coefficient de notoriété
	 */
	public float getCoefnotoriete(int row) {
		return praticiensHesitants.get(row).getCoefnotoriete();
	}
	
	/** Obtenir le coefficient de confiance
	 * 
	 * @return Le coefficient de confiance
	 */
	public float getCoefconfiance(int row) {
		return praticiensHesitants.get(row).getCoefconfiance();
	}
	
	/** Obtenir la date de visite 
	 * 
	 * @return la date de visite 
	 */
	public Date getDateVisite(int row) {
		return praticiensHesitants.get(row).getDateVisite();
	}
	
	 /** Obtenir le nombre de lignes de la liste
    *
    * @return Le nombre de lignes
    */
	public int getRowCount() {
		return praticiensHesitants.size();
	}
	
	 /** Obtenir le nombre de colonnes en fonction des entêtes
	 *
	 * @return Le nombre de colonnes
	 */
	public int getColumnCount() {
		return entetes.length;
	}
	
	  /** Obtenir le nom d'une colonne
    *
    * @param column L'indice de la colonne
    * @return Le nom de la colonne
    */
	public String getColumnName(int column){
		return entetes[column] ;
	}

	
	  /** Obtenir la valeur d'une cellule
    *
    * @param row L'indice de la ligne
    * @param column L'indice de la colonne
    * @return La valeur de la cellule
    */
	public Object getValueAt(int row, int column) {
		switch(column){
			case 0 :
				return praticiensHesitants.get(row).getNumero() ;
			case 1 :
				return praticiensHesitants.get(row).getNom() ;
			case 2 :
				return praticiensHesitants.get(row).getPrenom() ;
			case 3 :
				return praticiensHesitants.get(row).getAdresse() ;
			case 4 :
				return praticiensHesitants.get(row).getCp() ;
			case 5 :
				return praticiensHesitants.get(row).getVille() ;
			case 6 :
				return praticiensHesitants.get(row).getCoefnotoriete();
			case 7 :
				return praticiensHesitants.get(row).getCoefconfiance();
			case 8 :
				return praticiensHesitants.get(row).getDateVisite() ;
			case 9 :
				return praticiensHesitants.get(row).getTempsEcoule() ;
			default :
				return null ;
		}
		
		
		
		
	}
}

