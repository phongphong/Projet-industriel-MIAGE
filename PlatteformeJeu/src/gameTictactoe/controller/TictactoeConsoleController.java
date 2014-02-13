package gameTictactoe.controller;

import gameTictactoe.model.Tictactoe;
import gameTictactoe.model.TictactoeAction;
import gameTictactoe.view.ViewMorpionConsole;
import generic.abstractModel.Coup;

import java.util.*;



public class TictactoeConsoleController {
	
	public static void main(String[] args){
		Tictactoe morpion = new Tictactoe();
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
			if(morpion.calculScore(morpion.getJoueurEnCours()) == 1){
				System.out.println(((TictactoeAction) c).getJoueur().getNom() + " gagne !!!");
				fini = true;
			}
		}
	}
}
