package generic.AI;

import java.util.ArrayList;


import gameTictactoe.model.Tictactoe;
import generic.abstractModel.*;

public class MinMax implements AI {

	private static final int MIN_VAL = 1000;
	private static final int MAX_VAL = -1000;

	public MinMax() {

	}
	
	
	public MinMaxNode lancerMinMax(Game jeu){
		return minmax(jeu, jeu.getJoueurEnCours());
	}
 
	/**
	 * Cette fonction permet de renvoyer le resultat optimal d'application de
	 * l'algorithme MINMAX à un jeu morpion
	 * 
	 * @param jeu jeu en cours
	 * @return résultat optimal
	 */
	private MinMaxNode minmax(Game jeu, Player joueurEnCours) {

		int valeur_max = MAX_VAL;
		int valeur_min = MIN_VAL;
		MinMaxNode meilleurNoeud = null;

		double gagne = jeu.calculScore(((Tictactoe) jeu).getJ2());
		if(gagne != 0){
			return new MinMaxNode(null, gagne);
		}
		
		ArrayList<GameAction> listeCoupPossible = jeu.listerTousCoupPossible();
		if (listeCoupPossible.isEmpty()) {
			return new MinMaxNode(null, 0);
		}

		for (GameAction coupEnCours : listeCoupPossible) {
			
			Game jeuFils = jeu.getCopyDeJeu();
			jeuFils.jouerUnCoup(coupEnCours);
			MinMaxNode resultatDeNoeudFils;
			
			if (jeu.getJoueurEnCours().equals(joueurEnCours)) {
				resultatDeNoeudFils = minmax(jeuFils, joueurEnCours);
				if (resultatDeNoeudFils.getGagner() > valeur_max) {
					valeur_max = (int) resultatDeNoeudFils.getGagner();
					meilleurNoeud = new MinMaxNode(coupEnCours, valeur_max);
				}
			} else {
				// maximiser le score quand c'est le tour O
				resultatDeNoeudFils = minmax(jeuFils, joueurEnCours);
				if (resultatDeNoeudFils.getGagner() < valeur_min) {
					valeur_min = (int) resultatDeNoeudFils.getGagner();
					meilleurNoeud = new MinMaxNode(coupEnCours, valeur_min);
				}
			}
		}

		return meilleurNoeud;
	}
}
