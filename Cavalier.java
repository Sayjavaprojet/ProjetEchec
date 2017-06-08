



// Classe Cavalier

public class Cavalier extends Piece {
	
	// Constructeur du Cavalier
	public Cavalier( String couleur) {	
		super();
		this.setCouleur(couleur);// Permet de manipuler les donnÃ©es de la "superclasse"
    }
    
	// MÃ©thode pour l'affichage du Cavalier sur la case
    public String toString() {
    	if(getCouleur()=="Noir")
 			return "c";
    	
    	return "C";
   	}
    @Override
    public void deplacer(Partie pa,Joueur blanc){
    	this.deplacement.clear();
		this.nbsoldir.clear();
    	this.deplacement.add(17);
		this.deplacement.add(15);
		this.deplacement.add(-17);
		this.deplacement.add(-15);
		this.deplacement.add(10);
		this.deplacement.add(6);
		this.deplacement.add(-10);
		this.deplacement.add(-6);
		for (int i=0; i<deplacement.size();i++) {
			this.nbsoldir.add(1);
		}  
    }
}