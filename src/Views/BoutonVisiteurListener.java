package Views;


import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controller.Controleur;
import Model.ModeleAppliCR;



public class BoutonVisiteurListener extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private int row ;
	private int column ;
	private JTable table ;
	private Controleur controleur;

	

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	/** Méthode permettant d'afficher un compte-rendu selon le mois et l'année 
	* 
	* @param e La source de l'évènement
	*/
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("BoutonVisiteurListener::actionPerformed()") ;
		Controleur controleur = ((ModeleListeVisiteurs)this.table.getModel()).getControleur() ;
		ModeleAppliCR modele = ((ModeleListeVisiteurs) this.table.getModel()).getModele() ;
			
		String matricule = ((ModeleListeVisiteurs)this.table.getModel()).getMatricule(this.row);
		String nom = ((ModeleListeVisiteurs)this.table.getModel()).getNom(this.row) ;
		String prenom = ((ModeleListeVisiteurs)this.table.getModel()).getPrenom(this.row) ;
			
			switch(this.column){
				case 7 :
					System.out.println("----------------------------------------") ;
					JLabel moisLabel = new JLabel("Mois (Format MM) : ");
					JTextField moisField = new JTextField();
					JLabel anneeLabel = new JLabel("Année (Format AAAA) : ");
					JTextField anneeField = new JTextField();
					Object affichageBoxChoixMoisAnnee [] = {"Sélectionnez le mois et l'année des comptes-rendus à visualiser pour " + prenom + " " + nom , moisLabel, moisField, anneeLabel, anneeField};
					Object options [] = {"Valider", "Annuler"};
					int boxChoixMoisAnnee = JOptionPane.showOptionDialog(null,affichageBoxChoixMoisAnnee, "Période", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,null);
				    
					if(JOptionPane.OK_OPTION==boxChoixMoisAnnee){
						System.out.println(moisField.getText()+ " " +anneeField.getText()+ " " + matricule.toString() );
						modele.getComptesRendus(moisField.getText(),anneeField.getText(),matricule);
						controleur.visualiserComptesRendus();
					}
					else {
						JOptionPane.showMessageDialog(null, "Au Revoir");
					}
				
			    break ;
			
			}
		
		
	}
	
	
}