
import java.util.ArrayList;
import java.util.Scanner;



public class Partie {
	
    private Joueur j1;
    private Joueur j2;
    private Echiquier echiquierPartie;

    	
    
    // Constructeur
    public Partie(Joueur j1, Joueur j2, Echiquier echiquierPartie) {
    	this.j1 = j1;
    	this.j2 = j2;
    	this.echiquierPartie = echiquierPartie;	
    }

    // Getter du Joueur 1 de la Partie
    public Joueur getJ1() {
        return this.j1;
    }

    // Setter du Joueur 1 de la Partie
    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }

    // Getter du Joueur 2 de la Partie
    public Joueur getJ2() {
        return this.j2;
    }

    // Setter du Joueur 1 de la Partie
    public void setJ2(Joueur j2) {
        this.j2 = j2;
    }

    // Getter de l'Echiquier de la Partie
    public Echiquier getEchiquierPartie() {
        return this.echiquierPartie;
    }

    // Setter de l'Echiquier de la Partie
    public void setEchequierPartie(Echiquier echiquierPartie) {
        this.echiquierPartie = echiquierPartie;
    }
    public ArrayList<Integer> deplacementPossible(Piece p,Joueur blanc){	
    	// On regarde tous les déplacements possibles (concerne toutes les pièces)
    	ArrayList<Integer> deplacementPossible = new ArrayList<Integer>();//on cree une arraylist qui va enregistrer tou les deplacement possible de la piece
    	ArrayList<Integer> nbsoldir=p.getNbsoldir();//une arrayliste du nombre de deplacment de la piece 
    	ArrayList<Integer> deplacement=p.getDeplacement();// une arrayliste des deplacment de la piece 
    	int somme=0;
    	Case c=echiquierPartie.getPlateau()[p.isCase()];// on cree case c avec le numero de la case de la piece.
    	for (int i=0;i<nbsoldir.size();i++)//boucle de tout les deplacements possible recu pour les tester chacun 
    	{
    		boolean nopresent=true;//on cree un boolean pour savoir si il ya deja une piece allie ou non sur la case, on part du principe que non
    		int pos=0;
    		if(nbsoldir.get(i)!=0){//on verifie qu il y a bien une solution pour les deplacement car 0 veut dire que y a pas de deplacement valide.
    		do{
    			    		
    			if (c.getNumCase()+deplacement.get(pos+somme)<0 || c.getNumCase()+deplacement.get(pos+somme)>=64) {// on verifie que le deplacement ne sort pas de l'echiquier
    				nopresent=false;
    			}
    			
    			else {//si le deplacement est dans l'echiquier, on regarde le cas ou le deplacement se fait sur une piece
    				if (echiquierPartie.getPlateau()[c.getNumCase()+deplacement.get(pos+somme)].isEtatCase()==true) { // si il y a une piece sur la case
    					for (int pos2=0;pos2<16;pos2++) {
    						// Si le deplacement est sur une piece qui nous appartient
    						if (echiquierPartie.getPlateau()[c.getNumCase()+deplacement.get(pos+somme)].getNumCase()==blanc.getPiece()[pos2].isCase()) {
    							//si la piece selectionne ce deplace sur une case pos2 when case == allier => impossible 
    							System.out.println(blanc.getPiece()[pos2].isCase());
    							nopresent=false;
    						}
    					}
    					
    					// Si le déplacement est sur une piece adverse, on peut la capturer mais on ne peut pas aller plus loin
    					if (nopresent==true) {
    						nopresent=false;
    						deplacementPossible.add(deplacement.get(pos+somme));    				
    					}
    				}
    			}
    			
    			// Si le deplacement n'est sur aucune piece, on peut aller plus loin
    			if(nopresent==true) {
    				deplacementPossible.add(deplacement.get(pos+somme));
    			}
    			
    			pos++;
    			
    		}
    		while(nbsoldir.get(i)>pos);}
    		somme=somme+nbsoldir.get(i);
    		
    	}
    	return deplacementPossible;
    }
    	// On affiche les différents déplacements possibles
    	//rmeplacer ca par les case en surbrillance et les listener de deplacements
    	
    public int ChoixDuDeplacement(ArrayList<Integer> deplacementPossible,Piece p){
    	
    	int pos=0;
    	int demande=0;
    	for (int pos1=0;pos1<deplacementPossible.size();pos1++){
    		System.out.println("Choix "+pos1+" : ");
    		System.out.println(p.isCase()+deplacementPossible.get(pos1));
    	}
    	if (deplacementPossible.size()==0){return 0;}
    	Scanner sc=new Scanner(System.in);//mettre un listener ici pour le deplacement
    	demande=sc.nextInt();
    do
    	{
    	for (int pos1=0;pos1<deplacementPossible.size();pos1++){
    		if (demande==(p.isCase()+deplacementPossible.get(pos1)))
    			return demande;
    	}
    	sc=new Scanner(System.in);
    	demande=sc.nextInt();
    	}while(demande!=p.isCase()+deplacementPossible.get(pos));
    
    	
    return demande;
		
    }
    
    public void deplacementChoisi(int deplacementChoisi,Piece p){	
    	Case c=echiquierPartie.getPlateau()[p.isCase()];
		
		if (echiquierPartie.getPlateau()[deplacementChoisi].isEtatCase()==false) {//si la case ou on veu aller est vide 
			echiquierPartie.getPlateau()[deplacementChoisi].setEtatCase(true);//on la met en true c a d rempli
			echiquierPartie.getPlateau()[deplacementChoisi].setP(c.getP());//on set la piece a la case choisi
		
			echiquierPartie.getPlateau()[c.getNumCase()].setP(null);// on set null a la case qui devien vide
			echiquierPartie.getPlateau()[c.getNumCase()].setEtatCase(false);// on set etatCase false a la case qui devien vide
		}
		else// si il ya une piece donc forcement un enemi
		{
			echiquierPartie.getPlateau()[deplacementChoisi].getP().setEtat(false);//on detruit la piece manger en mettan son etat a false
			echiquierPartie.getPlateau()[deplacementChoisi].getP().setCase(666);//on place donc la piece dans une case inexistante
			echiquierPartie.getPlateau()[deplacementChoisi].setEtatCase(true);//on la met en true c a d rempli
			echiquierPartie.getPlateau()[deplacementChoisi].setP(c.getP());//on set la piece a la case choisi
		
			echiquierPartie.getPlateau()[c.getNumCase()].setP(null);// on set null a la case qui devien vide
			echiquierPartie.getPlateau()[c.getNumCase()].setEtatCase(false);// on set etatCase false a la case qui devien vide
		}
		
		//p.setCase(deplacementChoisi);
    			
    }
}