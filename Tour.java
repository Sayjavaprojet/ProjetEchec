


//Classe Tour

public class Tour extends Piece {
	
	// Constructeur de la Tour
	public Tour( String couleur) {	
		super();	
		this.setCouleur(couleur);
		// Permet de manipuler les données de la "superclasse"
	}

	// Méthode pour l'affichage de la Tour sur la case
	public String toString() {
		if(getCouleur()=="Noir")
			return "t";
		
		return "T";
	}
	
	public void deplacer(Partie pa,Joueur blanc){
		this.deplacement.clear();
		this.nbsoldir.clear();
    		int w=CasePlace;
    		/*
    		 * gauche = possibilité de se déplacer à gauche
    		 * droite = possibilité de se déplacer droite
    		 * 
    		 * */
    		boolean droite = true, gauche = true;
    		this.nbsoldir.add(0); this.nbsoldir.add(0); this.nbsoldir.add(0); this.nbsoldir.add(0);
    		
    		// Si la pièce est à gauche de l'échiquier
    		if (w%8==0) {
    			gauche = false;
    		}
    		
    		// Si la pièce est à droite de l'échiquier
    		if (w%8==7) {
    			droite = false;
    		}
    		
    		// Teste tous les déplacements possibles vers la droite pour ne pas sortir de l'échiquier
    		for (int pos=1;pos<=8;pos++) {
    			
    			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
    			if ((w+pos)%8==7 && droite==true) {//si la case a droite est la dernier de l'echequier
    				droite=false;
    				this.deplacement.add(pos);
    				this.nbsoldir.set(0,this.nbsoldir.get(0)+1);
    			}
    			if (droite==true) {
    				this.deplacement.add(pos);
    				this.nbsoldir.set(0,this.nbsoldir.get(0)+1);
    			}
    		}
    		
    		// Teste tous les déplacements possibles vers la gauche pour ne pas sortir de l'échiquier
    		for (int pos=1;pos<=8;pos++) {
    			// N'ajoute que les déplacements qui ne sortent pas de l'échiquier dans la liste
    			if ((w-pos)%8==0 && gauche==true) {//si la case a gauche est la dernier de l'echequier
    				gauche=false;
    				this.deplacement.add(-pos);
    				this.nbsoldir.set(1,this.nbsoldir.get(1)+1);
    			}
    			if (gauche==true) {
    				this.deplacement.add(-pos);
    				this.nbsoldir.set(1,this.nbsoldir.get(1)+1);
    			}
    		}
    		// Ajoute les déplacements vers le haut et le bas
    		//peu pas monter pck l'echequier est def entre 0 et 64 dans partie  
    		for (int pos=1; pos<=8; pos++) {
    			this.deplacement.add(-8*pos);
    			this.nbsoldir.set(2,this.nbsoldir.get(2)+1);
    		}
    		for (int pos=1; pos<=8; pos++) {
    			this.deplacement.add(8*pos);
    			this.nbsoldir.set(3,this.nbsoldir.get(3)+1);
    		}
    	}
	}