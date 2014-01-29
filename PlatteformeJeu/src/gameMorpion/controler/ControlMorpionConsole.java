package gameMorpion.controler;

import gameMorpion.model.CoupMorpion;
import gameMorpion.model.Morpion;
import gameMorpion.view.ViewMorpionConsole;
import generique.gameAbstract.Coup;

import java.util.*;



public class ControlMorpionConsole {
	
	
	public static void main(String[] args){
		Morpion morpion = new Morpion();
		ViewMorpionConsole view = new ViewMorpionConsole(morpion);
		morpion.addObserver(view);
		boolean fini = false;
		Scanner sc = new Scanner(System.in);
		int choix;
		while(!fini){
			System.out.println("Ce tour est � " + morpion.getJoueurEnCours().getNom());
			ArrayList<Coup> listeCoup = morpion.listerTousCoupPossible();
			System.out.println("Veuillez choisir le coup : ");
			for(int i=0 ; i<listeCoup.size() ; i++){
				System.out.println(i+". " + listeCoup.get(i));
			}
			choix = sc.nextInt();
			Coup c = listeCoup.get(choix);
			morpion.jouerUnCoup(c);
			morpion.changerJoueur();
			if(morpion.gagner(c)){
				System.out.println(((CoupMorpion) c).getJ().getNom() + " gagne !!!");
				fini = true;
			}
		}
	}
}
