package gameMorpion.model;

import java.util.ArrayList;

import generique.gameAbstract.*;

public class MiniMax implements IA {
	
	private static final int MAX_VAL = 1000;
	private static final int MIN_VAL = -1000;
	private Partie partie;
	
	public MiniMax(Partie partie){
		this.partie  = partie;
	}
	
	public Coup minimax(int profondeur){
		int max = MIN_VAL;
		Coup meilleurCoup = null;
		Morpion mp = (Morpion) partie.getJeu();
		ArrayList<Coup> listeCoupPossible = mp.listerTousCoupPossible();
		
		for(Coup c : listeCoupPossible){
			CoupMorpion cm = (CoupMorpion) c; 
			mp.getT_case()[cm.getX()][cm.getY()] = cm.getJ().getSigne();
			mp.changerJoueur();
			int score = calculMin(mp, c, profondeur - 1);
			if(score > max){
				max = score ;
				meilleurCoup = c;
			}
			
			mp.getT_case()[cm.getX()][cm.getY()] = '.';
			mp.changerJoueur();
		}
		System.out.println(max);
		return meilleurCoup;
	}
	
	public int calculMin(Morpion mp, Coup coup, int profondeur){
		int min = MAX_VAL;
		if(mp.listerTousCoupPossible().isEmpty() || profondeur == 0){
			return calculScore(mp, coup);
		}else{
			ArrayList<Coup> listeCoupPossible = mp.listerTousCoupPossible();
			for(Coup c : listeCoupPossible){
				CoupMorpion cm = (CoupMorpion) c; 
				mp.getT_case()[cm.getX()][cm.getY()] = cm.getJ().getSigne();
				mp.changerJoueur();
				int score = calculMax(mp, c, profondeur - 1);
				if(score < min){
					min = score;
				}
				
				mp.getT_case()[cm.getX()][cm.getY()] = '.';
				mp.changerJoueur();
			}
		}
		return min;
	}
	
	public int calculMax(Morpion mp, Coup coup, int profondeur){
		int max = MIN_VAL;
		if(mp.listerTousCoupPossible().isEmpty() || profondeur == 0){
			return calculScore(mp, coup);
		}else{
			ArrayList<Coup> listeCoupPossible = mp.listerTousCoupPossible();
			for(Coup c : listeCoupPossible){
				CoupMorpion cm = (CoupMorpion) c; 
				mp.getT_case()[cm.getX()][cm.getY()] = cm.getJ().getSigne();
				mp.changerJoueur();
				int score = calculMax(mp, c, profondeur - 1);
				if(score > max){
					max = score;
				}
				
				mp.getT_case()[cm.getX()][cm.getY()] = '.';
				mp.changerJoueur();
			}
		}
		return max;
	}
	
	public int compteSigne(Morpion mp, Joueur joueur){
		int compteur = 0;
		char[][] t_case = mp.getT_case();
		for(int i=0 ; i < t_case.length ; i++){
			for(int j=0 ; j < t_case.length ; j++){
				if(t_case[i][j] == joueur.getSigne()){
					compteur ++;
				}
			}
		}
		return compteur;
	}
	
	public int nombreSerieDe2(Morpion mp, Joueur joueur){
		int compteur = 0;
		char[][] t_case = mp.getT_case();
		for(int i=0 ; i < t_case.length - 1 ; i++){
			for(int j=0 ; j < t_case.length - 1 ; j++){
				if(t_case[i][j] == joueur.getSigne()){
					if(t_case[i][j+1] == joueur.getSigne() || t_case[i+1][j] == joueur.getSigne()
							||t_case[i][i] == joueur.getSigne() || t_case[i][2 - i] == joueur.getSigne())
					compteur ++;
				}
			}
		}
		return compteur;
	}
	
	public int calculScore(Morpion mp, Coup coup){
		int score = 0;
		if(mp.gagner(coup)){
			if(mp.getTourJoueur().equals(mp.getJ2())){
				score = 1000 - compteSigne(mp, mp.getJ2()) ;
			}else if(mp.getTourJoueur().equals(mp.getJ1())){
				score = -1000 + compteSigne(mp, mp.getJ1());
			}else{
				return 0;
			}
		}else{
			score = nombreSerieDe2(mp, mp.getJ2()) - nombreSerieDe2(mp, mp.getJ1()); 
		}
		return score;
	}

}
