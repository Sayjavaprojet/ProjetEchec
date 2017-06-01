package Jeux;

public class Case {
    
    private Piece piece;		//une pièce dans une case
    
 
    public Case()
    {
        
    }
    
    public Case(Piece piece)	//en parametre: la futur pièce sur la case
    {
        this.piece = piece;
    }
    
 
    public Piece getPiece() {		// retourne la pièce se trouvant sur la case et null si la case est vide 
        return piece;				 
    }
    
   
    public void setPiece(Piece piece) {  // met un objet Piece sur la case
        this.piece = piece;
    }
    

    public boolean estOccupe()			//savoir si case occupée ou pas
    {
        return (piece != null);    
    }
    

    public boolean estOccupe(String couleur)	//savoir si la case est occupée ou pas par une pièce de couleur entrée en parametre
    {
        if (piece == null)
            return false;
        else
            return (piece.getCouleur().equals(couleur));
    }
    
}
