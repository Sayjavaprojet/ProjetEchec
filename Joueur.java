import java.util.Scanner;


// Classe Joueur

public class Joueur {
	
    private String nom;						// Nom du Joueur
    private Piece piece[]= new Piece[16];	// Création d'un tableau comportant 16 Pièces
    
    
    // Constructeur du Joueur
    public Joueur(String couleur) {
    	if(couleur=="noir"){
		this.piece[0]=new Tour("Noir");
		this.piece[1]=new Cavalier("Noir");
		this.piece[2]=new Fou("Noir");
		this.piece[4]=new Reine("Noir");
		this.piece[3]=new Roi("Noir");
		this.piece[5]=new Fou("Noir");
		this.piece[6]=new Cavalier("Noir");
		this.piece[7]=new Tour("Noir");
		for (int i=8;i<16;i++)
			this.piece[i]=new Pion("Noir");
    }
    	if(couleur=="blanc"){
    		this.piece[0]=new Tour("blanc");
    		this.piece[1]=new Cavalier("blanc");
    		this.piece[2]=new Fou("blanc");
    		this.piece[4]=new Reine("blanc");
    		this.piece[3]=new Roi("blanc");
    		this.piece[5]=new Fou("blanc");
    		this.piece[6]=new Cavalier("blanc");
    		this.piece[7]=new Tour("blanc");
    		for (int i=8;i<16;i++)
    			this.piece[i]=new Pion("blanc");
        }
    	}
    
    // Getter du nom du Joueur
    public String getNom() {
        return this.nom;
    }
    
    // Setter du nom du Joueur
    public void setNom(String nom) {
        this.nom = nom;
    }
    

    
    // Getter de la Pièce associée au Joueur
    public Piece[] getPiece() {
        return this.piece;
    }
    
    // Setter de la Pièce associée au Joueur
    public void setPiece(Piece[] piece) {
        this.piece = piece;
    }
    
    // Choix du nom du Joueur
    public void choixNom() {
    	System.out.println("Nom du Joueur");
		Scanner sc = new Scanner(System.in);
		String n=sc.nextLine();
		this.nom=n;
    }
    


    public int choixPieceADeplacer(){
    	System.out.println("tour de "+this.nom);
    	System.out.println("piece a deplacer? selectionner un nombre");
    	int pos;
		do{
    	for (pos=0;pos<16;pos++)
    		if(piece[pos].isEtat()==true){System.out.println(pos+"."+piece[pos]);}
    	Scanner sc=new Scanner(System.in);
    	pos=sc.nextInt();}
    	while(piece[pos].isEtat()!=true);
    	return pos;
    	
    }

}