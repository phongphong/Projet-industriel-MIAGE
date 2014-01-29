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
			CoupScore cs = calculMin(mp, c, profondeur - 1);
			if(cs.getScore() * -1 > max){
				max = -1 * cs.getScore() ;
				meilleurCoup = cs.getCoup();
			}
			mp.getT_case()[cm.getX()][cm.getY()] = '.';
		}
		System.out.println(max);
		return meilleurCoup;
	}
	
	public CoupScore calculMin(Morpion mp, Coup coup, int profondeur){
		
		int min = MAX_VAL;
		CoupScore cs = new CoupScore(coup, 0);
		mp.changerJoueur();
		if(mp.listerTousCoupPossible().isEmpty() || profondeur == 0){
			
			int score = calculScore(mp, coup);
			cs.setScore(score);
		}else{
			ArrayList<Coup> listeCoupPossible = mp.listerTousCoupPossible();
			for(Coup c : listeCoupPossible){
				CoupMorpion cm = (CoupMorpion) c; 
				mp.getT_case()[cm.getX()][cm.getY()] = cm.getJ().getSigne();
				CoupScore cs_temp = calculMax(mp, c, profondeur - 1);
				if(cs_temp.getScore() < min){
					min = cs_temp.getScore();
					cs.setCoup(c);
					cs.setScore(min);
				}
				
				mp.getT_case()[cm.getX()][cm.getY()] = '.';
				
			}
		}
		mp.changerJoueur();
		return cs;
	}
	
	public CoupScore calculMax(Morpion mp, Coup coup, int profondeur){
		
		mp.changerJoueur();
		int max = MIN_VAL;
		CoupScore cs = new CoupScore(coup, 0);
		
		if(mp.listerTousCoupPossible().isEmpty() || profondeur == 0){
			int score = calculScore(mp, coup);
			cs.setScore(score);
		}else{
			ArrayList<Coup> listeCoupPossible = mp.listerTousCoupPossible();
			for(Coup c : listeCoupPossible){
				CoupMorpion cm = (CoupMorpion) c; 
				mp.getT_case()[cm.getX()][cm.getY()] = cm.getJ().getSigne();
				CoupScore cs_temp = calculMin(mp, c, profondeur - 1);
				if(cs_temp.getScore() > max){
					max = cs.getScore();
					cs.setCoup(c);
					cs.setScore(max);
				}
				
				mp.getT_case()[cm.getX()][cm.getY()] = '.';
				
			}
		}
		mp.changerJoueur();
		return cs;
	}
	
	public int calculScore(Morpion mp, Coup coup){
		int score = 0;
		if(mp.gagner(coup)){
			if(((CoupMorpion) coup).getJ().equals(mp.getJ2())){
				score = 1;
			}else if(((CoupMorpion) coup).getJ().equals(mp.getJ1())){
				score = -1;
			}
		}
		
		return score;
	
	}
	
	class CoupScore {
		
		private Coup coup;
		private int score;
		
		public CoupScore(Coup coup, int score) {
			super();
			this.coup = coup;
			this.score = score;
		}

		public Coup getCoup() {
			return coup;
		}

		public void setCoup(Coup coup) {
			this.coup = coup;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		@Override
		public String toString() {
			return "CoupScore [coup=" + coup + ", score=" + score + "]";
		}
	}
}
