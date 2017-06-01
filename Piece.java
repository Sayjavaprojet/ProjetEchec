package Jeux;

public abstract class Piece {

    private String nom;
    private String couleur;

    /** constructeur qui initialise le nom et la couleur d'un objet Piece*/
    public Piece(String nom, String couleur) {
        setNom(nom);
        setCouleur(couleur);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        if ((couleur == "noir") || (couleur == "blanc"))
            this.couleur = couleur;
    }
    
    /**  méthode abstraite à implementer dans les sous-classe (sert a verifier si le deplacement est valide)*/
    public abstract boolean estValide(Deplacement deplacement);
}
