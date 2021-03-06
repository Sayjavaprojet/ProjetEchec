import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



// Classe Jeu permettant le lancement du jeu

public class Jeu {
	private Partie pa1;

	public Jeu(Partie p){
		this.pa1=p;
			}


public static void main(String[] args) {
		
		// Choix Lancer Nouvelle Partie ou Règles du jeu ou Quitter
		
		// Lancer Nouvelle Partie a� coupler avec l'interface
		
		Joueur j1 = new Joueur("blanc");
		Joueur j2 = new Joueur("noir");
		Echiquier e1 = new Echiquier();
		
		// Choix du nom des Joueurs
		j1.choixNom();
		j2.choixNom();
		System.out.println("Nom du Joueur 1 : "+j1.getNom());
		System.out.println("Nom du Joueur 2 : "+j2.getNom());
		
		
		
		// Création de la Partie
		
		Partie pa1 = new Partie(j1, j2, e1);
		Jeu game=new Jeu(pa1);
		// Mise en place de l'echiquier
		
			
			// Placement des pièces sur les cases
			for (int i=0;i<16;i++)
			{	
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ2().getPiece()[i]);//on met dans la case i de lechequier la piece correspondante:si i=0 alors 0=tour a la case 0
				pa1.getJ2().getPiece()[i].setCase(i);
			}
			
		
			
			for (int i=48;i<56;i++)
			{
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ1().getPiece()[i-40]);

				pa1.getJ1().getPiece()[i-40].setCase(i);
			}
			
			for (int i=56;i<64;i++)
			{
				pa1.getEchiquierPartie().getPlateau()[i].setP(pa1.getJ1().getPiece()[i-56]);

				pa1.getJ1().getPiece()[i-56].setCase(i);
			}
					
	
		Manche man=new Manche(pa1.getJ1(),pa1);// pour que le joueur 1 commence

		boolean finDePartie=false;
		boolean finDeManche = false;
		while(finDePartie==false){
			man.jouerManche(finDeManche);
			man.finDeManche();
		}
}
}
		