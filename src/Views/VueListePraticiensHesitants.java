package Views;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Controller.Controleur;
import Model.ModeleAppliCR;
import Renderer.RenduCouleurCellules;


/** Vue de la liste des praticiens hésitants
*
* @author ndiaye
*
*/
public class VueListePraticiensHesitants extends JPanel  {
	
	
	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleAppliCR modele ;
	private JTable tPraticiensHesitants ;
	private ModeleListePraticiensHesitants modeleTableauPraticiensHesitants ;
	
	/** Création de la vue
	*
	* @param modele Le modèle
	* @param controleur Le contrôleur
	*/
	public VueListePraticiensHesitants(ModeleAppliCR modele, Controleur controleur) {
		super();
		this.controleur = controleur;
		this.modele = modele;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		Box boxEtiquetteTri = Box.createHorizontalBox();
		
		boxEtiquette.add(new JLabel("Praticiens :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		

		
		modeleTableauPraticiensHesitants = new ModeleListePraticiensHesitants(modele, controleur) ;
		tPraticiensHesitants = new JTable(modeleTableauPraticiensHesitants) ;
		tPraticiensHesitants.setRowHeight(30) ;
		
		this.appliquerRendu();
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tPraticiensHesitants.getModel());   
		tPraticiensHesitants.setRowSorter(sorter);
		//sorter.setSortable(1, false);
//		sorter.setComparator(6, new Comparer());
//		sorter.setComparator(7, new Comparer());
//		sorter.setSortsOnUpdates(true);
		


		JScrollPane spPraticiensHesitants = new JScrollPane(tPraticiensHesitants) ;
		spPraticiensHesitants.setPreferredSize(new Dimension(1090,420)) ;
		
		boxTableau.add(spPraticiensHesitants) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxEtiquetteTri);
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
	}

	/** Appliquer le rendu sur les cellules
	*
	*/
	private void appliquerRendu(){
		System.out.println("VueListePraticiensHesitants::appliquerRendu()") ;
		this.tPraticiensHesitants.setDefaultRenderer(Object.class, new RenduCouleurCellules(this.tPraticiensHesitants.getDefaultRenderer(Object.class))); //Appliquer le rendu
	}
	
	/** Actualiser le modèle du tableau
	*
	*/
	public void actualiser(){
		System.out.println("VuePraticiensHesitants::actualiser()") ;
		modele.getPraticiensHesitants().clear();
		modeleTableauPraticiensHesitants = new ModeleListePraticiensHesitants(modele, controleur) ;
		tPraticiensHesitants.setModel(modeleTableauPraticiensHesitants) ;
		tPraticiensHesitants.repaint();
	}
	
	
	
	

}
