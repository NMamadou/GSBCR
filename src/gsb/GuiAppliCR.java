package gsb;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class GuiAppliCR  extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private ModeleAppliCR modele ;
	private Controleur controleur ;
		
	private JMenuItem itemSeConnecter ;
	private JMenuItem itemSeDeconnecter ;
	private JMenuItem itemQuitter ;
	private JMenuItem itemVisualiserVisiteurs ;
	private JMenuItem itemVisualiserPraticiensHesitants ;
	private JMenuItem itemVisualiserCompteRendus ;
	
	private JMenu menuComptesRendus ;
	
	//private JLabel pin = new JLabel(new ImageIcon("/Users/jam/PPE3/workspace/logo.jpg"));
	
	private static JTextField nomField;
	private JPasswordField mdpField;
	private JLabel nomLabel;
	private JLabel mdpLabel;
	private JLabel infoLabel;
	
	private String[] criteres = { "Coefficient de confiance", "Coefficient de notoriété", "Temps écoulé" };
	
	private VueAccueil vueAccueil ;
	private VueListeVisiteurs vueListeVisiteurs ;
	private VueListeComptesRendus vueListeComptesRendus ;
	private VueListePraticiensHesitants vueListePraticiensHesitants ;
	
	private CardLayout vues ;
	private Container conteneur ;
	
	
	public GuiAppliCR(ModeleAppliCR modele, Controleur controleur) {
		super();
		
		this.modele = modele;
		this.controleur = controleur ;
		
		this.controleur.setVuePrincipale(this);
		
		this.setTitle("GSB / Appli-CR") ;
		
		//this.add(pin);
		
		this.setSize(1120,520) ;
		this.setLocationRelativeTo(null) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		
		
		this.vues = new CardLayout(2,2) ;
		this.conteneur = this.getContentPane() ;
		this.conteneur.setLayout(this.vues) ;
		
		
		vueAccueil = new VueAccueil() ;
		vueListeVisiteurs = new VueListeVisiteurs(modele,controleur) ;
		vueListeComptesRendus = new VueListeComptesRendus(modele,controleur) ;
		vueListePraticiensHesitants = new VueListePraticiensHesitants(modele,controleur) ;
		
		this.conteneur.add(vueAccueil,"Accueil") ;
		this.conteneur.add(vueListeVisiteurs,"Liste visiteurs") ;
		this.conteneur.add(vueListeComptesRendus,"Liste comptes-rendus") ;
		this.conteneur.add(vueListePraticiensHesitants,"Liste praticiens hésitants") ;
		
		this.vues.show(this.conteneur, "Accueil");
		
		
		
		this.creerBarreMenus() ;
		this.setVisible(true) ;
		
		this.itemSeDeconnecter.setEnabled(false) ;
		this.menuComptesRendus.setEnabled(false) ;
		
	}

	public ModeleAppliCR getModele() {
		return modele;
	}

	public void setModele(ModeleAppliCR modele) {
		this.modele = modele;
	}

	public Controleur getControleur() {
		return controleur;
	}

	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}
	
	private void creerBarreMenus(){
		JMenuBar barreMenus = new JMenuBar() ;
		
		JMenu menuFichier = new JMenu("Fichier") ;
		
		this.itemSeConnecter = new JMenuItem("Se connecter") ;
		this.itemSeConnecter.addActionListener(this) ;
		menuFichier.add(this.itemSeConnecter) ;
		
		this.itemSeDeconnecter = new JMenuItem("Se déconnecter") ;
		this.itemSeDeconnecter.addActionListener(this) ;
		menuFichier.add(this.itemSeDeconnecter) ;
		
		this.itemQuitter = new JMenuItem("Quitter") ;
		this.itemQuitter.addActionListener(this) ;
		menuFichier.add(this.itemQuitter) ;
		
		this.menuComptesRendus = new JMenu("Comptes-Rendus") ;
		
		this.itemVisualiserVisiteurs = new JMenuItem("Liste des visiteurs") ;
		this.itemVisualiserVisiteurs.addActionListener(this) ;
		this.menuComptesRendus.add(this.itemVisualiserVisiteurs) ;
		
		this.itemVisualiserPraticiensHesitants = new JMenuItem("Liste des praticiens hésitants") ;
		this.itemVisualiserPraticiensHesitants.addActionListener(this) ;
		this.menuComptesRendus.add(this.itemVisualiserPraticiensHesitants) ;
		
		this.itemVisualiserCompteRendus = new JMenuItem("Liste comptes-rendus") ;
		this.itemVisualiserCompteRendus.addActionListener(this) ;
		this.menuComptesRendus.add(this.itemVisualiserCompteRendus) ;
		
		
		barreMenus.add(menuFichier) ;
		barreMenus.add(this.menuComptesRendus) ;
		
		this.setJMenuBar(barreMenus) ;
	}
	
	public void changerDeVue(String nomVue){
		
		if(nomVue.equals("Accueil")){
			this.vues.show(this.conteneur,"Accueil") ;
		}
		else if(nomVue.equals("Se connecter")){
			
			nomLabel = new JLabel("Nom : ");
			nomField= new JTextField();
			mdpLabel= new JLabel("Mot de passe : ");
			mdpField = new JPasswordField();
			mdpField.setEchoChar('*');
			infoLabel = new JLabel("Saisir votre nom et prénom :");
			
			Object[] infos = new Object[]{infoLabel, nomLabel, nomField, mdpLabel, mdpField};
			
			int reponse = JOptionPane.showOptionDialog(this,infos,"Identification", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			
			if(reponse == JOptionPane.OK_OPTION){
				Authentification.seConnecter(nomField.getText(), mdpField.getText());
					JOptionPane.showMessageDialog(this, "Bienvenue "+nomField.getText());
					this.itemSeDeconnecter.setEnabled(true) ;
					this.itemSeConnecter.setEnabled(false) ;
					this.menuComptesRendus.setEnabled(true) ;
				}
				else {
					JOptionPane.showMessageDialog(this, "Connexion refusée");
				}
				
			
			if(reponse == JOptionPane.CANCEL_OPTION){	
				System.exit(0);
			}
			
			this.vues.show(this.conteneur,"Accueil") ;
			
		}
		else if(nomVue.equals("Se déconnecter")){
			int reponse = JOptionPane.showConfirmDialog(null,"Voulez-vous mettre fin à la session ?","Fin de session",JOptionPane.YES_NO_OPTION) ;
			if(reponse == JOptionPane.YES_OPTION){
				this.itemSeDeconnecter.setEnabled(false) ;
				this.itemSeConnecter.setEnabled(true) ;
				this.menuComptesRendus.setEnabled(false) ;
				this.vues.show(this.conteneur,"Accueil") ;
			}
		}
		else if(nomVue.equals("Quitter")){
			int reponse = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment quitter l'application ?","Quitter l'application",JOptionPane.YES_NO_OPTION) ;
			if(reponse == JOptionPane.YES_OPTION){
				this.controleur.quitter() ;
			}
		}	
		else if(nomVue.equals("Liste visiteurs")){

			this.vueListeVisiteurs.actualiser();
			this.vues.show(this.conteneur,"Liste visiteurs") ;
		
		}
		else if(nomVue.equals("Liste comptes-rendus")){
			this.vueListeComptesRendus.actualiser();
			this.vues.show(this.conteneur,"Liste comptes-rendus") ;
			
		}
		else if(nomVue.equals("Liste praticiens hésitants")){
			
			String unCritere = (String)JOptionPane.showInputDialog(null,"Choississez un critère",
					"Choisissez un critère",JOptionPane.QUESTION_MESSAGE, null, criteres, criteres[0]);
	
			this.vueListePraticiensHesitants.actualier();
			this.vues.show(this.conteneur,"Liste praticiens hésitants") ;
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evenement) {
		
		Object sourceEvt = evenement.getSource() ;
		
		if(sourceEvt == this.itemSeConnecter){
			this.controleur.seConnecter() ;
		}
		if(sourceEvt == this.itemSeDeconnecter){
			this.controleur.seDeconnecter() ;
		}
		if(sourceEvt == this.itemQuitter){
			this.controleur.quitterApplication() ;
		}
		else if(sourceEvt == this.itemVisualiserVisiteurs){
			this.controleur.visualiserVisiteurs() ;
		}
		else if(sourceEvt == this.itemVisualiserPraticiensHesitants){
			this.controleur.visualiserPraticiensHesitants() ;
		}
		else if(sourceEvt == this.itemVisualiserCompteRendus){
			this.controleur.visualiserComptesRendus(); 
		}
	}
}
