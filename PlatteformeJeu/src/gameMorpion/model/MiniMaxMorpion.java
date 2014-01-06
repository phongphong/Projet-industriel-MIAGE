package gameMorpion.model;

import gameAbstract.Coup;
import gameAbstract.IA;
import gameAbstract.Partie;

import java.util.ArrayList;

public class MiniMaxMorpion implements IA {
	
	private Morpion morpion;
	private Partie p;
	
	
	public MiniMaxMorpion(Morpion morpion, Partie p){
		this.morpion = morpion;
		this.p = p;
	}
	
	/**
	 * Cette fonction retourne le coup à effectuer
	 * @return
	 */
	public int[] minimax(int profondeur, Joueur j){
		ArrayList<Coup> listeCoupPossible = p.getJeu().listerTousCoupPossible();

		int meilleurScore = 0;
		int meilleurLigne = -1;
		int meilleurCol = -1;
		int scoreActuel;
		char[][] t_case = morpion.getT_case();
		
		if(listeCoupPossible.isEmpty() || profondeur == 0){
			meilleurScore = calculerScoreTotal();
		}else{
			for(Coup c : listeCoupPossible){
				CoupMorpion c1 = (CoupMorpion) c;
				//on essaie ce coup
				t_case[c1.getX()][c1.getY()] = morpion.getTourJoueur().getSigne();
				//si c'est le joueur 2 on maximise le score
				if(morpion.getTourJoueur().equals(morpion.getJ2())){
					scoreActuel = minimax(profondeur - 1, morpion.getJ1())[0];
					if(scoreActuel > meilleurScore){
						meilleurScore = scoreActuel;
						meilleurCol = c1.getY();
						meilleurLigne = c1.getX();
					}
				}else{
				//dans ce cas mon minimise le score	
					scoreActuel = minimax(profondeur - 1, morpion.getJ2())[0];
					if(scoreActuel < meilleurScore){
						meilleurScore = scoreActuel;
						meilleurCol = c1.getY();
						meilleurLigne = c1.getX();
					}
				}
				t_case[c1.getX()][c1.getY()] = '.';
			}
		}
		return new int[]{meilleurScore, meilleurLigne, meilleurCol};
	}
	
	public int calculerScoreTotal(){
		int score = 0;
		 score += calculerScore(0, 0, 0, 1, 0, 2);  // row 0
	     score += calculerScore(1, 0, 1, 1, 1, 2);  // row 1
	     score += calculerScore(2, 0, 2, 1, 2, 2);  // row 2
	     score += calculerScore(0, 0, 1, 0, 2, 0);  // col 0
	     score += calculerScore(0, 1, 1, 1, 2, 1);  // col 1
	     score += calculerScore(0, 2, 1, 2, 2, 2);  // col 2
	     score += calculerScore(0, 0, 1, 1, 2, 2);  // diagonal
	     score += calculerScore(0, 2, 1, 1, 2, 0);  // alternate diagonal
	      
	     return score;
	}
	
	
	public int calculerScore(int ligne1, int col1, int ligne2, int col2, int ligne3, int col3){
		char[][] t_case = morpion.getT_case();
		char signeJ1 = morpion.getJ1().getSigne();
		char signeJ2 = morpion.getJ2().getSigne();
		int score = 0;
		if(t_case[ligne1][col1] == signeJ1){
			score = -1;
		}else{
			if(t_case[ligne1][col1] == signeJ2){
				score = 1;
			}
		}
		
		if(t_case[ligne2][col2] == signeJ1){
			if(score == 0){
				score = -10;
			}else{
				if(score == 1){
					score = 0;
				}else{
					score = -1;
				}
			}
		}else{
			if(score == 0){
				score = -10;
			}else{
				if(score == 1){
					score = 0;
				}else{
					score = -1;
				}
			}
		}
		
		if(t_case[ligne3][col3] == signeJ1){
			if(score < 0){
				score *= -10;
			}else{
				if(score > 1){
					score = 0;
				}else{
					score = -1;
				}
			}
		}else{
			if(score > 0){
				score *= 10;
			}else{
				if(score < 0){
					score = 0;
				}else{
					score = 1;
				}
			}
		}
		
		return score;
	}
	
}
