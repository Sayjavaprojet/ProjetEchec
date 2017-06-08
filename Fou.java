

//Classe Fou

public class Fou extends Piece {
 
	// Constructeur du Fou
	public Fou(String couleur) {	
		super();
		this.setCouleur(couleur);// Permet de manipuler les données de la "superclasse"
 }
 
	// Méthode pour l'affichage du Fou sur la case
	public String toString() {
 		if(getCouleur()=="Noir")
 			return "f";
		
		return "F";
	}
	
	public void deplacer(Partie pa,Joueur blanc){
		this.deplacement.clear();
		this.nbsoldir.clear();
		int w=this.CasePlace;
		/*
		 * mdroite diagonale montante droite
		 * ddroite diagonale descendante droite
		 * mgauche diagonale montante gauche
		 * gauche diagonale descendante gauche
		 * 
		 * */
		boolean mdroite = true, mgauche = true, dgauche = true, ddroite = true;
		this.nbsoldir.add(0); this.nbsoldir.add(0); this.nbsoldir.add(0); this.nbsoldir.add(0);
		
		// Si la piece est a gauche de l'echiquier
		if (w%8==0) {
			dgauche=false; mgauche=false;
		}
		
		// Si la pièce est à droite de l'échiquier
		if (w%8==7) {
			ddroite=false; mdroite=false;
		}
		
		// Teste tous les déplacements possibles dans la diagonale descendante droite pour ne pas sortir de l'echiquier
		for (int pos=1; pos<8; pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if ((w+9*pos)%8==7 && ddroite==true) {// si la case est en bas touuuut a droite est une la fin de l'echequier
				ddroite=false; this.deplacement.add(9*pos); this.nbsoldir.set(0,this.nbsoldir.get(0)+1);//on l'ajoute dans la liste des case disponible
			}
			if (ddroite==true) {
				this.deplacement.add(9*pos); this.nbsoldir.set(0,this.nbsoldir.get(0)+1);
			}
		}
				
		// Teste tous les déplacements possibles dans la diagonale descendante gauche pour ne pas sortir de l'échiquier
		for (int pos=1; pos<8; pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if ((w+7*pos)%8==0 && dgauche==true) {// si la case est en bas touuuut a gauche est une la fin de l'echequier
				dgauche=false;this.deplacement.add(7*pos);this.nbsoldir.set(1,this.nbsoldir.get(1)+1);//on l'ajoute dans la liste des case disponible
			}
			if (dgauche==true) {
				this.deplacement.add(7*pos); this.nbsoldir.set(1,this.nbsoldir.get(1)+1);
			}	
		}
				
		// Teste tous les déplacements possibles dans la diagonale montante droite pour ne pas sortir de l'échiquier
		for (int pos=1;pos<8;pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if ((w-7*pos)%8==7 && mdroite==true) {// si la case est en haut touuuut a droite est une la fin de l'echequier
				mdroite=false;this.deplacement.add(-7*pos); this.nbsoldir.set(2,this.nbsoldir.get(2)+1);//on l'ajoute dans la liste des case disponible
			}
			if (mdroite==true) {
				this.deplacement.add(-7*pos); this.nbsoldir.set(2,this.nbsoldir.get(2)+1);
			}
		}
			
		// Teste tous les déplacements possibles dans la diagonale montante gauche pour ne pas sortir de l'échiquier
		for (int pos=1;pos<8;pos++) {
			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
			if ((w-9*pos)%8==0 && mgauche==true) {// si la case est en haut touuuut a gauche est une la fin de l'echequier
				mgauche=false;this.deplacement.add(-9*pos); this.nbsoldir.set(3,this.nbsoldir.get(3)+1);//on l'ajoute dans la liste des case disponible
			}
			if (mgauche==true) {
				this.deplacement.add(-9*pos); this.nbsoldir.set(3,this.nbsoldir.get(3)+1);
			}
		}
	}
 
}
