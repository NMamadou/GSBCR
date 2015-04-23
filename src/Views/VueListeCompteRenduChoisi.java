package Views;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Controleur;
import Model.ModeleAppliCR;

public class VueListeCompteRenduChoisi extends JPanel{
	

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Controleur controleur ;
		private ModeleAppliCR modele ;
		private ModeleListeCompteRenduChoisi modeleTableauCompteRendusChoisi ;
		private JTable tCompteRendus ;
		
		

		
		public VueListeCompteRenduChoisi(ModeleAppliCR modele, Controleur controleur) {
			super();
			this.controleur = controleur;
			this.modele = modele;
			
			Box boxPrincipal = Box.createVerticalBox() ;
			Box boxEtiquette = Box.createHorizontalBox() ;
			Box boxEtiquette1 = Box.createHorizontalBox() ;
			Box boxEtiquette2 = Box.createHorizontalBox() ;
			Box boxTableau = Box.createHorizontalBox() ;
			
			
			boxEtiquette.add(new JLabel("Rapport de visite")) ;
			
			
			boxEtiquette.add(Box.createHorizontalGlue()) ;
			boxEtiquette1.add(Box.createHorizontalGlue()) ;
			boxEtiquette2.add(Box.createHorizontalGlue()) ;

			
			modeleTableauCompteRendusChoisi = new ModeleListeCompteRenduChoisi(modele,controleur) ;
			tCompteRendus = new JTable(modeleTableauCompteRendusChoisi) ;
			tCompteRendus.setRowHeight(30) ;
			
		
			
			JScrollPane spCompteRendus = new JScrollPane(tCompteRendus) ;
			spCompteRendus.setPreferredSize(new Dimension(1090,420)) ;
			
			boxTableau.add(spCompteRendus) ;
			
			boxPrincipal.add(boxEtiquette) ;
			boxPrincipal.add(boxEtiquette1) ;
			boxPrincipal.add(boxEtiquette2) ;
			boxPrincipal.add(boxTableau) ;
			
			this.add(boxPrincipal) ;
		}

		public Controleur getControleur() {
			return controleur;
		}

		public void setControleur(Controleur controleur) {
			this.controleur = controleur;
		}

		public ModeleAppliCR getModele() {
			return modele;
		}

		public void setModele(ModeleAppliCR modele) {
			this.modele = modele;
		}
		
		
		
		public void actualiser(){
			System.out.println("VueListeCompteRenduChoisi::actualiser()") ;
			modeleTableauCompteRendusChoisi = new ModeleListeCompteRenduChoisi(modele,controleur) ;
			tCompteRendus.setModel(modeleTableauCompteRendusChoisi) ;

		}
		
	

}
