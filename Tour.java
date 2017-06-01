package Jeux;

public class Tour extends Piece {
 
    public Tour(String Couleur) {
        super("Tour", Couleur);
    }
    
    public boolean estValide(Deplacement deplacement) {
        /** x*y=0 car mouvement Horizontal ou Vertical, donc x=0 ou y=0. Cas ou la Tour ne bouge pas*/
        return deplacement.getDeplacementX() * deplacement.getDeplacementY() == 0 && !deplacement.estNul();
    }

}
