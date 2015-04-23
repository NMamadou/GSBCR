package Utils;

import java.sql.* ;

import javax.swing.JOptionPane;

/** Connexion à la base de données
 * 
 */
public class ConnexionBD {
	
	private static final String dbURL = "jdbc:mysql://localhost/GsbCRSlam?useUnicode=yes&characterEncoding=UTF-8" ;
	private static final String user = "root" ;
	private static final String password = "ndiaye" ;
	private static Connection connexion = null ;
	
	/** Chargement du driver mysql
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ConnexionBD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver") ;
		connexion = DriverManager.getConnection(dbURL,user,password) ;
	}
	
	/** Instanciation de la connexion
	 * 
	 * @return connexion
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnexion() throws ClassNotFoundException, SQLException{
		if(connexion == null){
			new ConnexionBD() ;
		}
		return connexion ;
	}
	
	
	
	

}

