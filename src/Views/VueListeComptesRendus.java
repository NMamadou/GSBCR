package Views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Controleur;
import Model.ModeleAppliCR;
import Renderer.RenduBoutonCompteRendus;
import Renderer.RenduCouleurCellules;

/** Vue de la liste des comptes-rendus
*
* @author ndiaye
*
*/
public class VueListeComptesRendus extends JPanel {


	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleAppliCR modele ;
	private ModeleListeCompteRendus modeleTableauCompteRendus ;
	private JTable tCompteRendus ;
	
	

	/** Création de la vue
	*
	* @param modele Le modèle
	* @param controleur Le contrôleur
	*/
	public VueListeComptesRendus(ModeleAppliCR modele, Controleur controleur) {
		super();
		this.controleur = controleur;
		this.modele = modele;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxEtiquette1 = Box.createHorizontalBox() ;
		Box boxEtiquette2 = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
		
		boxEtiquette.add(new JLabel("Rapports de visite")) ;
		
		
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		boxEtiquette1.add(Box.createHorizontalGlue()) ;
		boxEtiquette2.add(Box.createHorizontalGlue()) ;

		
		modeleTableauCompteRendus = new ModeleListeCompteRendus(modele,controleur) ;
		tCompteRendus = new JTable(modeleTableauCompteRendus) ;
		tCompteRendus.setRowHeight(30) ;
		
		this.appliquerRendu() ;
		
		JScrollPane spCompteRendus = new JScrollPane(tCompteRendus) ;
		spCompteRendus.setPreferredSize(new Dimension(1090,420)) ;
		
		boxTableau.add(spCompteRendus) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxEtiquette1) ;
		boxPrincipal.add(boxEtiquette2) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
	}
	
	

	/** Appliquer le rendu sur les cellules
	*
	*/
	private void appliquerRendu(){
		System.out.println("VueListeCompteRendus::appliquerRendu()") ;
		this.tCompteRendus.setDefaultRenderer(Object.class, new RenduCouleurCellules(this.tCompteRendus.getDefaultRenderer(Object.class))); //Appliquer le rendu
		this.tCompteRendus.getColumn("Sélectionner").setCellRenderer(new RenduBoutonCompteRendus()) ;
		this.tCompteRendus.getColumn("Sélectionner").setCellEditor(new BoutonCompteRendus(new JCheckBox())) ;
	}
	
		
	/** Actualiser le modèle du tableau
	*
	*/
	public void actualiser(){
		System.out.println("VueListeCompteRendus::actualiser()") ;
		modeleTableauCompteRendus = new ModeleListeCompteRendus(modele,controleur) ;
		tCompteRendus.setModel(modeleTableauCompteRendus) ;
		this.appliquerRendu();
	}
	
}
