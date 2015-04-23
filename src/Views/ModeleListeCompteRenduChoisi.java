package Views;

import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import Controller.Controleur;
import Entities.CompteRendu;
import Model.ModeleAppliCR;

public class ModeleListeCompteRenduChoisi extends AbstractTableModel{
	
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private List<CompteRendu> comptesRendus ;
		//private CompteRendu selectedCompteRendu ;
		private final String[] entetes = {"Numéro","Date de rédaction","Date de visite","Nom du praticien","Ville du praticien","Bilan","Motif"} ;
		private ModeleAppliCR modele ;
		private Controleur controleur;

		
		
		/** Créer le modèle de la liste des clients
		*
		* @param modele Le modèle de l'application
		*/
		public ModeleListeCompteRenduChoisi(ModeleAppliCR modele, Controleur controleur){
			super() ;
			System.out.println("ModeleListeCompteRenduChoisi::ModeleListeCompteRenduChoisi()") ;
			this.modele = modele ;
			this.controleur = controleur ;
			comptesRendus = modele.getComptesRendus();
		
//			for(CompteRendu compteRendu : comptesRendus){
				//System.out.println(selectedCompteRendu);
//			}
		}
		
		public ModeleAppliCR getModele(){
			return modele ;
		}
		
		public Controleur getControleur(){
			return controleur;
		}
		

	    public int getColumnCount() {
	        return entetes.length;
	    }
	 
	   
	    public int getRowCount() {

	    		return 1;
	    }
	   
	    public String getColumnName(int column) {
	        return entetes[column];
	    }
	    
	   
	    
//	    public Class getColumnClass(int column){
//	        switch(column){
//		    	case 0 :
//		    		return String.class ;
//		    	case 1 :
//		    		return Date.class ;
//		    	case 2 :
//		    		return Date.class ;
//		    	case 3 :
//		    		return String.class ;
//		    	case 4 :
//		    		return String.class ;
//		    	case 5 :
//		    		return String.class ;
//		    	case 6 :
//		    		return String.class ;
//		    	default :
//		    		return Object.class ;
//	    	}
//	    }
	    
	    public Object getValueAt(int row, int column) {
	        switch (column) {
	        case 0:
	            return  comptesRendus.get(row).getNumero();
	        case 1:
	            return comptesRendus.get(row).getDateRedac();
	        case 2:
	        	return comptesRendus.get(row).getDateVisite();
	        case 3:
	             return comptesRendus.get(row).getNomPra();
	        case 4:
	           	return comptesRendus.get(row).getVillePra();
	        case 5:
	        	return comptesRendus.get(row).getBilan();
	        case 6 :
	        	return comptesRendus.get(row).getMotif();
	        default:
	            return null;
	        }
	    }
	    
	    public boolean isCellEditable(int row, int column){
	    			return false;
	    }
	    
	


}
