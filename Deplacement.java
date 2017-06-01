package Jeux;

public class Deplacement {
    
    private double deplacementX;
    private double deplacementY;
    
    /** Coordonnée de la case d'arrivee*/
    private Position arrivee;
    
    /**Coordonnée de la case de depart*/
    private Position depart;

    /**Constructeur d'un objet Deplacement. Calcul des déplacements sur les axes X et Y*/
    public Deplacement(Position depart, Position arrivee)
    {
        this.arrivee = arrivee;
        this.depart = depart;
        this.deplacementX = arrivee.getColonne() - depart.getColonne();
        this.deplacementY = arrivee.getLigne() - depart.getLigne();
    }

    public double getDeplacementX() {return deplacementX;}
    public double getDeplacementY() {return deplacementY;}
    public Position getArrivee() {return arrivee;}
    public Position getDepart() {return depart;}   
    public boolean estNul(){
        return deplacementX == 0 && deplacementY == 0;
    }
    
}
