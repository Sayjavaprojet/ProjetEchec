package Jeux;

public class Roi extends Piece{
  
    public Roi(String Couleur) {
        super("Roi", Couleur);
    }
    
    public boolean estValide(Deplacement deplacement) {
        /** x+y<=2, x-y<=1 (pas en diagonale = 0,pas direct = 1). Cas ou le Roi ne bouge pas.*/
        return Math.abs(deplacement.getDeplacementX()) * Math.abs(deplacement.getDeplacementY()) <= 1
        && Math.abs(deplacement.getDeplacementX()) - Math.abs(deplacement.getDeplacementY()) <= 1
        && Math.abs(deplacement.getDeplacementX()) - Math.abs(deplacement.getDeplacementY()) >= -1
            && !deplacement.estNul();
    }
}
