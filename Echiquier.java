package Jeux;

public class Echiquier implements MethodesEchiquier{
  
	 //Tableau d'objet Case, contient les cases qui contiennent les Piece
    private Case[][] location;

    public Echiquier() {
        location = new Case[8][8];
        for (int ctr = 0; ctr <= 7; ctr++)
            for (int ctr1 = 0; ctr1 <= 7; ctr1++)
                location[ctr][ctr1] = new Case();
        

        
        
    }
    /*capture par un pion possible, verifie si le deplacement d'un pion en diagonale est valide
    Il verifie si une piece d'une couleur contraire au pion se trouve a sa diagonale, si oui, le deplacement est accepte
    retourne vrai ou faux si pion peut le manger ou pas */
    
    public boolean captureParUnPionPossible(Deplacement deplacement) {
       // verification si piece est un pion 
        if(location[deplacement.getDepart().getColonne()][deplacement.getDepart().getLigne()].getPiece() instanceof Pion)
        {
        	//initialisation des variables dont j'aurai besoin dans mes conditions,  savoir la couleur de la pièce de départ et la case d'arrivée.
            Case Arrive = location[(int)deplacement.getArrivee().getColonne()][(int)deplacement.getArrivee().getLigne()];
            String couleurDepart = location[(int)deplacement.getDepart().getColonne()][(int)deplacement.getDepart().getLigne()].getPiece().getCouleur();
            
          //je vérifie d'abord si la pièce d'arrivée existe et si elle est de la couleur contraire de celle de départ.
            if(Arrive.estOccupe(couleurDepart.equals("blanc") ? "noir" : "blanc"))
            	/*Je vérifie si le déplacement est valide, 
                Le déplacement est valide si le produit du déplacement x et y donne 1 si la couleur de départ est noir*/
                // -1 si la pièce de départ est blanche.
                return (deplacement.getDeplacementY() * Math.abs(deplacement.getDeplacementX()) == (couleurDepart.equals("noir") ? 1 : -1));
        }
        return false;
        
    }
    /* chemin possible :  verifie si la piece peut faire le deplacement. Pour le faire, il verifie si le chemin
     est libre entre le depart et l'arrive*/
    //return vrai ou faux si la piece peut faire le deplacement ou non
    public boolean cheminPossible(Deplacement deplacement) {
        Piece pieceDepart = location[(int)deplacement.getDepart().getColonne()][(int)deplacement.getDepart().getLigne()].getPiece();
        
        /*deux condition , que la case d'arrivée sois libre ou qu'elle possède une pièce de couleur
        contraire  celle de la pièce de départ*/
        if (!location[(int)deplacement.getArrivee().getColonne()][(int)deplacement.getArrivee().getLigne()].estOccupe(pieceDepart.getCouleur().equals("blanc") ? "blanc" : "noir")
                | deplacement.isNul()){
            if (!(pieceDepart instanceof Cavalier)){
                if(!(pieceDepart instanceof Pion)){
                	//vérification  que le déplacement est supérieur à1.
                    if(!(Math.abs(deplacement.getDeplacementX()) - Math.abs(deplacement.getDeplacementY()) <= 1
                            && Math.abs(deplacement.getDeplacementX()) + Math.abs(deplacement.getDeplacementY()) <= 1)){

                    	  /*JumpX et jumpY seront sois 0,  1 ou -1, ils indiquent l'incrémentation que je devrais utiliser pour les valeurs X et Y pour 
                        vérifier toute les cases entre le départ et l'arrivé*/
                    	
                        int jumpX = deplacement.getDeplacementX() == 0 ? 0 : (int)(deplacement.getArrivee().getColonne() - deplacement.getDepart().getColonne())
                                /Math.abs((int)(deplacement.getArrivee().getColonne() - deplacement.getDepart().getColonne()));
                
                        int jumpY = deplacement.getDeplacementY() == 0 ? 0 : (int)(deplacement.getArrivee().getLigne() - deplacement.getDepart().getLigne())
                                /Math.abs((int)(deplacement.getArrivee().getLigne() - deplacement.getDepart().getLigne()));

                      //Je vérifie successivement toutes les cases entre l'arrivée et le départ
                        for (int ctrX = (int)deplacement.getDepart().getColonne() + jumpX, ctrY = (int)deplacement.getDepart().getLigne() + jumpY;
                            ctrX != (int)deplacement.getArrivee().getColonne() | ctrY != (int)deplacement.getArrivee().getLigne();
                            ctrX += jumpX, ctrY += jumpY){
                            if (location[ctrX][ctrY].estOccupe()){
                                return false;
                            }
                        }
                        return true;
                    }
                    else
                    	/*Si le déplacement est égal, il est automatiquement valide car il a passé les prècedents test. Puisque
                        le déplacement est de 1, je n'ai pas besoin de vérifier les cases entre le départ et l'arrivé*/
                        return true;
                }
                else
                    //Si c'est un pion, je vérifie si la case est libre de toute pièce.
                    return !location[(int)deplacement.getArrivee().getColonne()][(int)deplacement.getArrivee().getLigne()].estOccupe();
                    
            }
            else
                // renvoie true car un cavalier peut sauter par dessus les autres pièces.
                return true;
        }
        else
            //Le déplacement est automatiquement incorrecte si la case d'arrivée contient une pièce de même couleur que la pièce de départ.
            return false;

        
    }



    
    public Case getCase(int colonne, int ligne) {
        return location[colonne][ligne];
    }

    // Methode servant a placer toute les pieces sur l'echiquier. Met donc toute les pieces sur les objets cases du tableau location
    public void debuter() {
        int ligne = 7;
        /* instruction exécuté deux fois, premère fois , ligne est égal à 7 et la couleur est noir,
        et à la deuxième, la couleur est blanche et la ligne est égal à 0.*/
        for (String couleur = "noir" ; !couleur.equals("blanc"); couleur = "blanc", ligne = 0){
            //J'initialise tout mes pièces de la première rangée (fou, cavalier,pion,...)
            location[0][ligne].setPiece(new Tour(couleur));
            location[1][ligne].setPiece(new Cavalier(couleur));
            location[2][ligne].setPiece(new Fou(couleur));
            location[3][ligne].setPiece(new Reine(couleur));
            location[4][ligne].setPiece(new Roi(couleur));
            location[5][ligne].setPiece(new Fou(couleur));
            location[6][ligne].setPiece(new Cavalier(couleur));
            location[7][ligne].setPiece(new Tour(couleur));
            //Je change de ligne, dépendamment de la couleur que je suis en train de traiter.
          
            ligne += couleur.equals("noir") ? -1 : 1;
            //J'initialise tout mes pions.
            for (int ctr = 0; ctr <= 7; ctr++)
                location[ctr][ligne].setPiece(new Pion(couleur));
        }
    }
    
    
}
