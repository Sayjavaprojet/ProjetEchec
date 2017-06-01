package Jeux;

public class Reine extends Piece{
    
    public Reine(String Couleur) { // Prend en parametre la couleur de la reine
        super("Reine", Couleur);
    }
    /*Methode estValide, sert a verifier la validite du deplacement de la reine
    retourne true ou false si le deplacement du fou est valide*/
    public boolean estValide(Deplacement deplacement) {
    	
    	/*Le déplacement d'une reine est un mouvement qui peut être diagonale ou rectiligne.
         Je j'utilise donc les méthodes du fou et de la tour pour vérifier celle de la reine.
         */
    	
        return (Math.abs(deplacement.getDeplacementX()) - Math.abs(deplacement.getDeplacementY()) == 0 
                | deplacement.getDeplacementX() * deplacement.getDeplacementY() == 0) && !deplacement.isNul();
    }
}