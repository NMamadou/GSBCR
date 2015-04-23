package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;










import Entities.CompteRendu;
import Entities.Praticien;
import Entities.Visiteur;
import Utils.Authentification;
import Utils.ConnexionBD;

import com.mysql.jdbc.PreparedStatement;


/** Modèle de l'application
*
* @author ndiaye
*
*/
public class ModeleAppliCR {
	
	private List<Visiteur> visiteurs = new ArrayList<Visiteur>() ;
	private List<CompteRendu> comptesRendus = new ArrayList<CompteRendu>() ;
	private CompteRendu selectedCompteRendu ;
	private List<Praticien> praticiensHesitants = new ArrayList<Praticien>() ;
	private ResultSet resultat = null;
	private Connection connexion = null;
	private Statement stat = null ;
	private PreparedStatement pstmt = null ;
	private List<CompteRendu> compteRendus;
	private String mois ;
	private String annee ;
	private String matricule ;
	
	
	public ModeleAppliCR(){
		super() ;
	}
	
	
	/** Récupération de la liste des visiteurs de la region du délégué régional qui s'en occupe
	*
	* @return la liste des visiteurs
	*/
	public List<Visiteur> getVisiteurs(){
		String requete = "SELECT VISITEUR.VIS_MATRICULE, VISITEUR.VIS_NOM, VISITEUR.VIS_PRENOM, VISITEUR.VIS_ADRESSE, VISITEUR.VIS_CP, VISITEUR.VIS_VILLE, VISITEUR.VIS_DATEEMBAUCHE FROM VISITEUR,TRAVAILLER WHERE TRAVAILLER.VIS_MATRICULE = VISITEUR.VIS_MATRICULE AND TRA_ROLE='Visiteur' AND TRAVAILLER.REG_CODE = (SELECT REGION.REG_CODE FROM REGION, TRAVAILLER WHERE REGION.REG_CODE = TRAVAILLER.REG_CODE AND TRAVAILLER.VIS_MATRICULE = ? AND TRAVAILLER.TRA_ROLE='Délégué') "; 
		
		try{
			connexion = ConnexionBD.getConnexion();
			String visMat = Authentification.getMatric();
			 pstmt = (PreparedStatement) connexion.prepareStatement(requete);
			pstmt.setString(1,visMat);
			resultat = pstmt.executeQuery();
			System.out.println("ModeleAppliCR::getVisiteurs()") ;
			
				while(resultat.next()){
					
					String matricule = resultat.getString("VIS_MATRICULE");
					String nom = resultat.getString("VIS_NOM") ;
					String prenom = resultat.getString("VIS_PRENOM") ;
					String adresse = resultat.getString("VIS_ADRESSE");
					String cp = resultat.getString("VIS_CP");
					String ville = resultat.getString("VIS_VILLE");
					Date dateEmbauche = resultat.getDate("VIS_DATEEMBAUCHE");
					this.visiteurs.add(new Visiteur(matricule,nom,prenom,adresse,cp,ville,dateEmbauche));
				}
			
		}
		catch(Exception e){
			System.out.println("Erreur requête getVisiteurs()") ;
			e.printStackTrace();
			
		}
		return visiteurs;
	
	}
	
	/** Rechercher un visiteur
	*
	* @param matricule Matricule du visiteur 
	* @return Le visiteur recherché
	*/
	public Visiteur rechercherVisiteur(String matricule){
		Visiteur visiteur = null;
		for(Visiteur unVisiteur : visiteurs){
			if(matricule == unVisiteur.getMatricule()){
				visiteur = unVisiteur;
			}
		}
		return visiteur;
	}
	
	/** Rechercher un praticien
	*
	* @param praNum Le numéro du praticien
	* @return Le praticien recherché
	*/
	public Praticien rechercherPraticien(int praNum){
		Praticien praticien = null;
		for(Praticien unPraticien : praticiensHesitants){
			if(praNum == unPraticien.getNumero()){
				praticien = unPraticien;
			}
		}
		return praticien;
	}
	
	/** Rechercher un compte-rendu
	*
	* @param visMatricule Matricule du visiteur
	* @param numCR Numéro du compte-rendu
	* @return Le compte-rendu recherché
	*/
	public CompteRendu rechercherCR(String visMatricule, int numCR){
		for(CompteRendu unCompteRendu : comptesRendus){
			if(visMatricule == unCompteRendu.getNomVis() && numCR == unCompteRendu.getNumero()){
				this.selectedCompteRendu = unCompteRendu;
			}
		}
		return selectedCompteRendu;
	}

	
	/** Récupération de la liste des comptes-rendus
	*
	* @return la liste des comptes-rendus
	*/
	public List<CompteRendu> getComptesRendus(String mois, String annee, String matricule){
		 

		String requete = "SELECT RAP_NUM, PRATICIEN.PRA_NOM, RAP_DATE, RAP_DATE_REDAC, RAP_BILAN, RAP_MOTIF, RAP_LU, RAP_COEFCONFIANCE, PRATICIEN.PRA_VILLE, RAPPORT_VISITE.VIS_MATRICULE FROM (RAPPORT_VISITE INNER JOIN PRATICIEN ON RAPPORT_VISITE.PRA_NUM = PRATICIEN.PRA_NUM) INNER JOIN VISITEUR ON RAPPORT_VISITE.VIS_MATRICULE = VISITEUR.VIS_MATRICULE WHERE RAPPORT_VISITE.VIS_MATRICULE = ? AND YEAR(RAP_DATE)=? AND MONTH(RAP_DATE)=? ;";	
		int moisInt = Integer.parseInt(mois);
		int anneeInt = Integer.parseInt(annee);		
		try {
					connexion = ConnexionBD.getConnexion();
					pstmt = (PreparedStatement) connexion.prepareStatement(requete);
					pstmt.setString(1,matricule);
					pstmt.setInt(2,anneeInt);
					pstmt.setInt(3,moisInt);
					resultat = pstmt.executeQuery();
					System.out.println("ModeleAppliCR::getComptesRendus(mois,annee,matricule)") ;
				
					try{
						while (resultat.next()) {
							String nomVis = resultat.getString("RAPPORT_VISITE.VIS_MATRICULE");
							int numero = resultat.getInt("RAP_NUM");
							String nomPra = resultat.getString("PRATICIEN.PRA_NOM");
							String villePra = resultat.getString("PRATICIEN.PRA_VILLE") ;
							Date dateVisite = resultat.getDate("RAPPORT_VISITE.RAP_DATE") ;
							Date dateRedac = resultat.getDate("RAPPORT_VISITE.RAP_DATE_REDAC") ;
							String bilan = resultat.getString("RAPPORT_VISITE.RAP_BILAN");
							String motif = resultat.getString("RAPPORT_VISITE.RAP_MOTIF");
							String read = resultat.getString("RAPPORT_VISITE.RAP_LU");
							float coefConfiance = resultat.getFloat("RAP_COEFCONFIANCE");
							
							//CompteRendu compteRendu = new CompteRendu(resultat.getInt("RAP_NUM"),resultat.getDate("RAPPORT_VISITE.RAP_DATE_REDAC"),resultat.getDate("RAPPORT_VISITE.RAP_DATE"),resultat.getString("PRATICIEN.PRA_NOM"),resultat.getString("PRATICIEN.PRA_VILLE"),matricule,resultat.getString("RAPPORT_VISITE.RAP_LU"),resultat.getFloat("RAP_COEFCONFIANCE"));
							
							this.comptesRendus.add(new CompteRendu(numero,dateRedac,dateVisite,bilan,motif,nomPra,villePra,nomVis,read)) ;
							
							
							//comptesRendus.add(compteRendu);
							
						}
					}
					catch(Exception e){
						e.printStackTrace();	
					}	
				}
				catch(Exception e){
					e.printStackTrace();
				}

		return comptesRendus ;
		
		
	}
	
	
	/** Obtenir la liste des comptes-rendus
	*
	* @return la liste des comptes-rendus
	*/
	public List<CompteRendu> getComptesRendus() {
		return comptesRendus;
	}					

	
	/** Récupération de la liste des praticiens hésitants qui ont un coeficient de confiance en dessous de 5 sur 10
	*
	* @return la liste des praticiens hésitants
	*/
	public List<Praticien> getPraticiensHesitants(){
		List<Praticien> praticiensHesitants = new ArrayList<Praticien>() ;
		
		String requete = "SELECT PRATICIEN.PRA_NUM, PRATICIEN.PRA_NOM, PRATICIEN.PRA_PRENOM, PRATICIEN.PRA_ADRESSE, PRATICIEN.PRA_CP, PRATICIEN.PRA_VILLE, PRATICIEN.PRA_COEFNOTORIETE, rapport_visite.RAP_COEFCONFIANCE, rapport_visite.RAP_DATE FROM PRATICIEN, rapport_visite WHERE rapport_visite.PRA_NUM = PRATICIEN.PRA_NUM AND RAPPORT_VISITE.RAP_COEFCONFIANCE < 5 ORDER BY PRA_COEFNOTORIETE ASC";
		
		try{
			Connection connexion = ConnexionBD.getConnexion();
			Statement stat = (Statement) connexion.createStatement(); 
			ResultSet resultat = stat.executeQuery(requete);
			System.out.println("ModeleAppliCR::getPraticiensHesitants()");
			while(resultat.next()){
				
				int numero = resultat.getInt("PRATICIEN.PRA_NUM");
				String nom = resultat.getString("PRATICIEN.PRA_NOM") ;
				String prenom = resultat.getString("PRATICIEN.PRA_PRENOM") ;
				String adresse = resultat.getString("PRATICIEN.PRA_ADRESSE");
				String cp = resultat.getString("PRATICIEN.PRA_CP");
				String ville = resultat.getString("PRATICIEN.PRA_VILLE");
				float coefnotoriete = resultat.getFloat("PRATICIEN.PRA_COEFNOTORIETE");
				float coefconfiance = resultat.getFloat("RAPPORT_VISITE.RAP_COEFCONFIANCE");
				Date dateVisite = resultat.getDate("RAPPORT_VISITE.RAP_DATE");
				this.praticiensHesitants.add(new Praticien(numero,nom,prenom,adresse,cp,ville,coefnotoriete,coefconfiance,dateVisite));
			}

		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		return this.praticiensHesitants ;
	}
	
	
	
	
	/** Modifier l'état du compte-rendu 
	 * 
	 * @param numero Le numéro du compte-rendu
	 */
	public void setRead(int numero){
		String requete ="UPDATE RAPPORT_VISITE SET RAP_LU = 'Oui' WHERE RAP_NUM = ?;";
		try {
			connexion = ConnexionBD.getConnexion() ;
			PreparedStatement pstmt = (PreparedStatement) connexion.prepareStatement(requete);
			pstmt.setInt(1,numero);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

	
	/** Obtenir le compte-rendu sélectionné
	* @return Le compte-rendu sélectionné
	*/
	public CompteRendu getSelectedCompteRendu() {
		return selectedCompteRendu;
	}

	/** Modifier le compte-rendu séléctionné
	* @param selectedCompteRendu Le compte-rendu 
	*/
	public void setSelectedCompteRendu(CompteRendu selectedCompteRendu) {
		this.selectedCompteRendu = selectedCompteRendu;
	}

	
	


	
	
	
	
}
	


