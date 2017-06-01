package Jeux;

public class Pion extends Piece {
	
	 public Pion(String Couleur) {  // prend en parametre couleur du pion 
	        super("Pion", Couleur);
	    }

	/* Methode estValide, verifie la validite du deplacement d'un pion
      retourne true ou false si le deplacement du pion est valide*/
	   public boolean estValide(Deplacement deplacement) {
		   /*Verifie premierement que le deplacementX est bien nul, ensuite selon la couleur du pion, vérifie que son deplacementY
	          est egal à un ou deux en fonction de la position du pion. (les operateurs <= et >= servent a valider le cas que le pion
	          avancent d'une seule case et ce même si il est sur la ligne de depart.
	         */
	        if (deplacement.getDeplacementX() == 0)
	            if (this.getCouleur().equals("noir")){

	                return deplacement.getDeplacementY() <= (deplacement.getDepart().getLigne() == 1 ? 2 : 1) && deplacement.getDeplacementY() > 0;
	            }
	            else 
	                return deplacement.getDeplacementY() >= (deplacement.getDepart().getLigne() == 6 ? -2 : -1) && deplacement.getDeplacementY() < 0;
	        return false;                
	    }
	}




