package gameMorpion.model;

import java.util.ArrayList;

import generique.gameAbstract.*;

public class MiniMax implements IA {
	
	private static final int MIN_VAL = -1000;
	
	public MiniMax(){
		
	}
	
	
	public Coup getMeilleurCoup(Partie partie, int profondeur){
		
		Jeu jeu = partie.getJeu().getCopyDeJeu();
		int max = MIN_VAL;
		Coup meilleurCoup = null;
		ArrayList<Coup> listeCoupPossible = jeu.listerTousCoupPossible();
		
		for(Coup c : listeCoupPossible){
			jeu.jouerUnCoup(c);
			
			int scoreDuFils = calculMinimax(jeu, c , profondeur - 1, false);
			 if(scoreDuFils > max){
				max = scoreDuFils;
				meilleurCoup = c;
			} 
			//effacer le coup qu'on vient de jouer
			jeu.enleverCoup(c); 
		}
		return meilleurCoup;
	}
	
	public int calculMinimax(Jeu jeu, Coup coup, int profondeur, boolean maximize){
		int score = calculScore(jeu, coup);
		if(!jeu.listerTousCoupPossible().isEmpty() && profondeur != 0){
			jeu.changerJoueur();
			ArrayList<Coup> listeCoupPossible = jeu.listerTousCoupPossible();
			for(Coup c : listeCoupPossible){
				jeu.jouerUnCoup(c);
				int scoreDuFils = calculScore(jeu, c);
				if(scoreDuFils == 0){
					scoreDuFils = ((maximize) ? calculMinimax(jeu, c, profondeur - 1, false) : calculMinimax(jeu, c, profondeur - 1, true));
				}
				score = ((maximize) ?  Math.max(scoreDuFils, score) :  Math.min(scoreDuFils, score));
				//effacer le coup qu'on vient de jouer
				jeu.enleverCoup(c);
			}
			jeu.changerJoueur();
		}
		
		return score;
	}
	
	public int calculScore(Jeu jeu, Coup coup){
		int score = 0;
		if(jeu.gagner(coup)){
			if(((CoupMorpion) coup).getJ().equals(((Morpion) jeu).getJ2())){
				score = 2;
			}else if(((CoupMorpion) coup).getJ().equals(((Morpion) jeu).getJ1())){
				score = -2;
			}
		}else{
			if(((CoupMorpion) coup).getX() == 1 && ((CoupMorpion) coup).getY() == 1){
				if(((CoupMorpion) coup).getJ().equals(((Morpion) jeu).getJ2())){
					score = 1;
				}else if(((CoupMorpion) coup).getJ().equals(((Morpion) jeu).getJ1())){
					score = -1;
				}
			}
		}
		return score;
	}
}
