package Jeux;

public class Fou extends Piece{
   
    public Fou(String Couleur) {
        super("Fou", Couleur);
    }

    public boolean estValide(Deplacement deplacement) {
        /*x-y=0 tout le temps car mouvement en diagonale. Cas ou le Fou ne bouge pas*/
        return Math.abs(deplacement.getDeplacementX()) - Math.abs(deplacement.getDeplacementY()) == 0 && !deplacement.estNul();
    }
}
