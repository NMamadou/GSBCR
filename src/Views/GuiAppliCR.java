package Views;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Controller.Controleur;
import Model.ModeleAppliCR;
import Utils.Authentification;


/** La vue principale de l'application GSB
*
* @author ndiaye
*
*/
public class GuiAppliCR  extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private ModeleAppliCR modele ;
	private Controleur controleur ;
		
	private JMenuItem itemSeConnecter ;
	private JMenuItem itemSeDeconnecter ;
	private JMenuItem itemQuitter ;
	private JMenuItem itemVisualiserVisiteurs ;
	private JMenuItem itemVisualiserPraticiensHesitants ;
	private JMenuItem itemApropos ;
	
	
	private JMenu menuComptesRendus ;
	
	
	private static JTextField nomField;
	private JPasswordField mdpField;
	private JLabel nomLabel;
	private JLabel mdpLabel;
	private JLabel infoLabel;
	
	
	private VueAccueil vueAccueil ;
	private VueListeVisiteurs vueListeVisiteurs ;
	private VueListeComptesRendus vueListeComptesRendus ;
	private VueListeCompteRenduChoisi vueListeCompteRenduChoisi ;
	private VueListePraticiensHesitants vueListePraticiensHesitants ;
	private Apropos vueApropos ;
	
	private CardLayout vues ;
	private Container conteneur ;
	
	
	/** Constructeur de la vue principale de l'application
	*
	* @param modele
	* @param controleur
	*/
	public GuiAppliCR(ModeleAppliCR modele, Controleur controleur) {
		super();
		
		this.modele = modele;
		this.controleur = controleur ;
		
		this.controleur.setVuePrincipale(this);
		
		this.setTitle("GSB / Appli-CR") ;
		
		
		this.setSize(1120,520) ;
		this.setLocationRelativeTo(null) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		
	
		this.vues = new CardLayout(2,2) ;
		this.conteneur = this.getContentPane() ;
		this.conteneur.setLayout(this.vues) ;
		
		
		vueAccueil = new VueAccueil() ;
		vueListeVisiteurs = new VueListeVisiteurs(modele,controleur) ;
		vueListeComptesRendus = new VueListeComptesRendus(modele,controleur) ;
		vueListeCompteRenduChoisi = new VueListeCompteRenduChoisi(modele,controleur) ;
		vueListePraticiensHesitants = new VueListePraticiensHesitants(modele,controleur) ;
		vueApropos = new Apropos();
		
		this.conteneur.add(vueAccueil,"Accueil") ;
		this.conteneur.add(vueListeVisiteurs,"Liste visiteurs") ;
		this.conteneur.add(vueListeComptesRendus,"Liste comptes-rendus") ;
		this.conteneur.add(vueListeCompteRenduChoisi,"Le compte-rendu") ;
		this.conteneur.add(vueListePraticiensHesitants,"Liste praticiens hésitants") ;
		this.conteneur.add(vueApropos,"A propos");
		
		this.vues.show(this.conteneur, "Accueil");
		
		
		
		this.creerBarreMenus() ;
		this.setVisible(true) ;
		
		this.itemSeDeconnecter.setEnabled(false) ;
		this.menuComptesRendus.setEnabled(false) ;
		
	}

	/** Obtenir le modèle
	*
	* @return Le modèle
	*/
	public ModeleAppliCR getModele() {
		return modele;
	}

	/** Modifier le modèle
	*
	* @param modele Le modèle
	*/
	public void setModele(ModeleAppliCR modele) {
		this.modele = modele;
	}

	/** Obtenir le contrôleur
	*
	* @return Le contrôleur
	*/
	public Controleur getControleur() {
		return controleur;
	}

	/** Modifier le contrôleur
	*
	* @param controleur Le contrôleur
	*/
	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}
	
	/** Création du menu de l'application
	*
	*/
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
		
		JMenu menuAide = new JMenu("Aide") ;
		
		this.itemApropos = new JMenuItem("A propos") ;
		this.itemApropos.addActionListener(this);
		menuAide.add(this.itemApropos);
		
		barreMenus.add(menuFichier) ;
		barreMenus.add(this.menuComptesRendus) ;
		barreMenus.add(menuAide);
		
		this.setJMenuBar(barreMenus) ;
	}
	
	/** Méthode permettant de changer de vue
	*
	* @param nomVue La vue à afficher
	*/
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
				if(nomField.getText().isEmpty() || mdpField.getText().isEmpty()){

					JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs svp.", "Saisir votre login et mot de passe ", JOptionPane.ERROR_MESSAGE);
				}
				boolean connexionOk = this.controleur.tenterConnexion(nomField.getText(),new String(mdpField.getPassword())) ;
				if(connexionOk){
					Authentification.seConnecter(nomField.getText(), mdpField.getText());
					this.itemSeDeconnecter.setEnabled(true) ;
					this.itemSeConnecter.setEnabled(false) ;
					this.menuComptesRendus.setEnabled(true) ;
					JOptionPane.showMessageDialog(this, "Bienvenue délégué régional " +nomField.getText()+".");
				}
				else {
					JOptionPane.showMessageDialog(this, "Connexion refusée");
				}
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
			
					
			this.vueListePraticiensHesitants.actualiser();
			this.vues.show(this.conteneur,"Liste praticiens hésitants") ;
			
		}
		else if(nomVue.equals("Le compte-rendu")){
			this.vueListeCompteRenduChoisi.actualiser();
			this.vues.show(this.conteneur,"Le compte-rendu") ;
			
		}
		else if(nomVue.equals("A propos")){
			this.vues.show(this.conteneur,"A propos") ;
			
		}
	}
	
	/** Gérer les actions de l'utilisateur
	*
	* @param e La source de l'événement 
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object sourceEvt = e.getSource() ;
		
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
		else if(sourceEvt == this.itemApropos){
			this.controleur.visualiserApropos();
		}
		
	}
	
	
	
}
