package generique.IA;

import java.util.ArrayList;

import gameMorpion.model.Morpion;
import generique.abstractModel.*;

public class MinMax implements IA {

	private static final int MIN_VAL = 1000;
	private static final int MAX_VAL = -1000;

	public MinMax() {

	}
	
	
	public NoeudMinMax lancerMinMax(Jeu jeu){
		return minmax(jeu, jeu.getJoueurEnCours());
	}
 
	/**
	 * Cette fonction permet de renvoyer le resultat optimal d'application de
	 * l'algorithme MINMAX à un jeu morpion
	 * 
	 * @param jeu jeu en cours
	 * @return résultat optimal
	 */
	private NoeudMinMax minmax(Jeu jeu, Joueur joueurEnCours) {

		int valeur_max = MAX_VAL;
		int valeur_min = MIN_VAL;
		NoeudMinMax meilleurNoeud = null;

		double gagne = jeu.calculScore(((Morpion) jeu).getJ2());
		if(gagne != 0){
			return new NoeudMinMax(null, gagne);
		}
		
		ArrayList<Coup> listeCoupPossible = jeu.listerTousCoupPossible();
		if (listeCoupPossible.isEmpty()) {
			return new NoeudMinMax(null, 0);
		}

		for (Coup coupEnCours : listeCoupPossible) {
			
			Jeu jeuFils = jeu.getCopyDeJeu();
			jeuFils.jouerUnCoup(coupEnCours);
			NoeudMinMax resultatDeNoeudFils;
			
			if (jeu.getJoueurEnCours().equals(joueurEnCours)) {
				resultatDeNoeudFils = minmax(jeuFils, joueurEnCours);
				if (resultatDeNoeudFils.getGagner() > valeur_max) {
					valeur_max = (int) resultatDeNoeudFils.getGagner();
					meilleurNoeud = new NoeudMinMax(coupEnCours, valeur_max);
				}
			} else {
				// maximiser le score quand c'est le tour O
				resultatDeNoeudFils = minmax(jeuFils, joueurEnCours);
				if (resultatDeNoeudFils.getGagner() < valeur_min) {
					valeur_min = (int) resultatDeNoeudFils.getGagner();
					meilleurNoeud = new NoeudMinMax(coupEnCours, valeur_min);
				}
			}
		}

		return meilleurNoeud;
	}
}
