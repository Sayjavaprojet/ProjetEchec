import java.util.ArrayList;

// Classe Piece

public abstract class Piece {
	
	private String couleur;
	protected int CasePlace;				// Numéro de la case associe a� la Piece
	private boolean etat;					// Etat de la Piece : En jeu (true) ou Detruite (false)
	protected ArrayList<Integer> nbsoldir=new ArrayList<Integer>();// arraylist qui compte le nombre de solution
	protected ArrayList<Integer> deplacement=new ArrayList<Integer>();// arraylist qui ajoute les deplacements
	
	public ArrayList<Integer> getNbsoldir() {
		return nbsoldir;
	}

	public ArrayList<Integer> getDeplacement() {
		return deplacement;
	}

	// Constructeur de la Pièce sans arguments
	public Piece () {
	    this.etat=true;
	}
	
	// Constructeur de la Pièce avec arguments
	public Piece(int c) {
		this.etat=true;
		this.CasePlace=c;
		
	}
	
	// Getter de l'état de la Pièce
	public boolean isEtat() {
		return etat;
	}

	// Setter de l'état de la Pièce
	public void setEtat(boolean etat) {
		this.etat = etat;
		if (etat==false)
				this.CasePlace=65;
	}
	
	// Getter du numéro de la Case associé à la Pièce
	public int isCase() {
		return CasePlace;
	}
	
	// Setter du numéro de la Case associé à la Pièce
	public void setCase(int c) {
		this.CasePlace = c;
	}
	
	// Méthode pour l'affichage d'une Pièce sur la case
	public String toString() {
		return "X";
	}

	public void deplacer(Partie pa,Joueur blanc) {
		
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


}
