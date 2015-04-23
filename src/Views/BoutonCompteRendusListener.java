package Views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

import Controller.Controleur;
import Model.ModeleAppliCR;


	public class BoutonCompteRendusListener implements ActionListener {
		
		private int row ;
		private int column ;
		private JTable table ;
		private JButton bouton ;
		private ModeleAppliCR modele;
		private Controleur controleur ;
		
		/** Modifier l'indice de la ligne
		* @param row L'indice de la ligne
		*/
		public void setRow(int row){
			this.row = row ;
		}
		
		/** Modifier l'indice de la colonne
		*
		* @param column L'indice de la colonne
		*/
		public void setColumn(int column){
			this.column = column ;
		}
		
		/** Modifier le tableau
		* @param table Le nouveau tableau
		*/
		public void setTable(JTable table){
			this.table = table ;
		}
		
		/** Ecouteur du bouton des comptes-rendus
		* @param e La source de l'évènement
		*/
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("BoutonCompteRendusListener::actionPerformed()") ;
			Controleur controleur = ((ModeleListeCompteRendus)this.table.getModel()).getControleur() ;
			ModeleAppliCR modele = ((ModeleListeCompteRendus)this.table.getModel()).getModele();
			int numCR =((ModeleListeCompteRendus)this.table.getModel()).getNumero(row);
			String visMatricule = ((ModeleListeCompteRendus)this.table.getModel()).getNomVis(row);
			String bilan = ((ModeleListeCompteRendus)this.table.getModel()).getBilan(row);
			String motif = ((ModeleListeCompteRendus)this.table.getModel()).getMotif(row);
			String readCR = ((ModeleListeCompteRendus)this.table.getModel()).getRead(row) ;
			String nomPraticien = ((ModeleListeCompteRendus)this.table.getModel()).getNom(row);
			String villePraticien = ((ModeleListeCompteRendus)this.table.getModel()).getVille(row);
			Date dateRedac = ((ModeleListeCompteRendus)this.table.getModel()).getDateRedac(row);
			Date dateVisite = ((ModeleListeCompteRendus)this.table.getModel()).getDateVisite(this.row);
			
			
			//Création d'un JTextArea pour afficher les informations sur le compte-rendu séléctionné
			JTextArea crTextArea = new JTextArea();
			crTextArea.setText("Matricule du visiteur : " + visMatricule + "\n" + "Numéro du rapport : " + numCR + "\n" + "Nom du praticien : " + nomPraticien + "\n" + "Ville du praticien : " + villePraticien + "\n" + "Date de rédaction : " + dateRedac + "\n" + "Date de visite : " + dateVisite + "\n" + "Bilan : " + bilan + " \n" + "Motif : " + motif + "\n");
			crTextArea.setColumns(50);
			crTextArea.setRows(7);
			crTextArea.setOpaque(false);
			crTextArea.setEditable(false);
			crTextArea.setLineWrap(true);
			crTextArea.setWrapStyleWord(true);
			JScrollPane crSp = new JScrollPane(crTextArea);
			
			switch(this.column){
				case 5 :
					if(readCR == "Non"){
						try {
							modele.setRead(numCR);
						} catch (Exception e1) {
							System.err.println(e1.getMessage());
						}
						try{
							modele.rechercherCR(visMatricule, numCR);
						} catch (Exception e1) {
							System.err.println(e1.getMessage());
						}
					}
					
					modele.setRead(numCR);
					//controleur.visualiserComptesRenduChoisi();
					
					//Afficher le JTextArea 
					 JOptionPane.showMessageDialog(null,crSp,"Informations sur le compte-rendu",JOptionPane.DEFAULT_OPTION);
					 
					 //Modifier la valeur à "Oui" dans la tableau sur la 7e colonne
					((ModeleListeCompteRendus) this.table.getModel()).setValueAt(new String("Oui"), this.row, 6);
						
				break;
			}
		}
}