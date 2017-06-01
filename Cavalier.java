package Jeux;

public class Cavalier extends Piece {

	 public Cavalier(String Couleur) {	//en parametre: couleur du cavalier
	        super("Cavalier", Couleur);
	    }
	 
	/*verification si deplacement possible 
	return true ou false selon deplacement */
	 
	 public boolean estValide(Deplacement deplacement) {  
		 /*Verifie si le quotient des deux deplacement est egal a 2 ou .5,assure que la
         piece fait un mouvement en "L".*/
		 
	       return (Math.abs(deplacement.getDeplacementX() / deplacement.getDeplacementY())) == 2 |			
	                (Math.abs(deplacement.getDeplacementX() / deplacement.getDeplacementY())) == .5;
	    }
	}
	
	
	

