package Utils;

import java.sql.* ;

import javax.swing.JOptionPane;



public class Authentification {
	
	private static String requete ="SELECT VISITEUR.VIS_MATRICULE, VISITEUR.VIS_NOM, VISITEUR.VIS_PRENOM FROM VISITEUR, TRAVAILLER WHERE VISITEUR.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE AND TRA_ROLE='D�l�gu�' AND VIS_NOM=? AND VIS_PRENOM=?;";
	private static boolean connexionOk = false ;
	private static String matric;
		
			
	/** M�thode permettant de se connecter � l'application
	*
	* @param login = login du d�l�gu�
	* @param mdp = mot de passe du d�l�gu�
	* @return true si l'authentifiaction est r�ussie , false dans le cas contraire
	*/
	public static boolean seConnecter(String login, String mdp){
		try {
			Connection connexion = ConnexionBD.getConnexion() ;
			PreparedStatement pstmt = connexion.prepareStatement(requete);
			pstmt.setString(1, login);
			pstmt.setString(2, mdp);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()){
				if(login.equalsIgnoreCase(result.getString("VIS_NOM")) && mdp.equalsIgnoreCase(result.getString("VIS_PRENOM"))){
					connexionOk = true;
					System.out.println("Authentification r�ussie.");
					matric = result.getString("VIS_MATRICULE");
				}
			}
		}
		catch(Exception e){
			System.out.println("Erreur traitement !");
			e.printStackTrace();
		}
		return connexionOk ;
	}
	
	/** Obtenir le matricule du d�l�gu�
	*
	* @return matric Le matricule 
	*/
	public static String getMatric(){
		return matric;
	}
	
	
			
}