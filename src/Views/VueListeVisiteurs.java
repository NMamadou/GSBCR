package Views;

import java.awt.Component;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Controleur;
import Model.ModeleAppliCR;
import Renderer.RenduBoutonVisiteur;
import Renderer.RenduCouleurCellules;

/** Vue de la liste des visiteurs
*
* @author ndiaye
*
*/
public class VueListeVisiteurs extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleAppliCR modele ;
	private JTable tVisiteurs ;
	private ModeleListeVisiteurs modeleTableauVisiteurs ;
	
	/** Création de la vue
	*
	* @param modele Le modèle
	* @param controleur Le contrôleur
	*/
	public VueListeVisiteurs(ModeleAppliCR modele, Controleur controleur) {
		super();
		this.controleur = controleur;
		this.modele = modele;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;

		boxEtiquette.add(new JLabel("Visiteurs :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		modeleTableauVisiteurs = new ModeleListeVisiteurs(modele) ;
		tVisiteurs = new JTable(modeleTableauVisiteurs) ;
		tVisiteurs.setRowHeight(30) ;
		
		this.appliquerRendu() ;
		
		JScrollPane spVisiteurs = new JScrollPane(tVisiteurs) ;
		spVisiteurs.setPreferredSize(new Dimension(1090,420)) ;
		
		boxTableau.add(spVisiteurs) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
		
		
	}

	/** Appliquer le rendu sur les cellules
	*
	*/
	private void appliquerRendu(){
		System.out.println("VueListeVisiteurs::appliquerRendu()") ;
		this.tVisiteurs.setDefaultRenderer(Object.class, new RenduCouleurCellules(this.tVisiteurs.getDefaultRenderer(Object.class))); //Appliquer le rendu
		this.tVisiteurs.getColumn("Sélectionner").setCellRenderer(new RenduBoutonVisiteur()) ;
		this.tVisiteurs.getColumn("Sélectionner").setCellEditor(new BoutonVisiteur(new JCheckBox(),this.controleur)) ;
	}
	
	/** Actualiser le modèle du tableau
	*
	*/
	public void actualiser(){
		System.out.println("VueListeVisiteurs::actualiser()") ;
		modele.getVisiteurs().clear();
		modeleTableauVisiteurs = new ModeleListeVisiteurs(modele) ;
		modeleTableauVisiteurs.setControleur(controleur);
		tVisiteurs.setModel(modeleTableauVisiteurs) ;
		this.appliquerRendu();
	}
	
}
