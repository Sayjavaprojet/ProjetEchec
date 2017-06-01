package Jeux;

public class Position {
 
    private int ligne; 
    private int colonne; 

    /**Constructeur de la classe position, Initialise les deux paramètre d'une position, ligne et colonne*/
    public Position(int colonne, int ligne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public int getLigne() {return ligne;}
    public int getColonne() {return colonne;}
    public void setLigne(int ligne) {this.ligne = ligne;}
    public void setColonne(int colonne) {this.colonne = colonne;}

    public boolean equals(Position position) {
        return position.getColonne() == this.getColonne() && position.ligne == this.ligne;
    }

}
