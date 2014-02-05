package IA;

import java.util.ArrayList;

import gameMorpion.model.Morpion;
import generique.gameAbstract.*;

public class MinMax implements IA {

	private static final int MIN_VAL = 1000;
	private static final int MAX_VAL = -1000;

	public MinMax() {

	}

	/**
	 * Cette fonction permet de renvoyer le resultat optimal d'application de
	 * l'algorithme MINMAX à un jeu morpion
	 * 
	 * @param jeu
	 *            jeu en cours
	 * @param coup
	 *            coup que le joueur vient de générer
	 * @param changePlayer
	 *            par défaut cette valeur est false
	 * @param max
	 *            par défaut cette valeur est true, le booléen qui détermine si
	 *            c'est le tour de min ou max
	 * @return résultat optimal
	 */
	public NoeudMinMax minmax(Jeu jeu, Coup coup) {

		int valeur_max = MAX_VAL;
		int valeur_min = MIN_VAL;

		NoeudMinMax meilleurNoeud = ((estTourJoueur2(jeu)) ? new NoeudMinMax(
				coup, valeur_max) : new NoeudMinMax(coup, valeur_min));

		if (jeu.gagner(coup) && estTourJoueur1(jeu)) {
			return new NoeudMinMax(coup, -1);
		}

		if (jeu.gagner(coup) && estTourJoueur2(jeu)) {
			return new NoeudMinMax(coup, 1);
		}

		ArrayList<Coup> listeCoupPossible = jeu.listerTousCoupPossible();

		if (listeCoupPossible.isEmpty()) {
			return new NoeudMinMax(coup, 0);

		}

		for (Coup coupEnCours : listeCoupPossible) {
			Jeu jeuFils = jeu.getCopyDeJeu();
			jeuFils.jouerUnCoup(coupEnCours);
			NoeudMinMax resultatDeNoeudFils;
			// maximiser le score quand c'est le tour de X
			if (estTourJoueur2(jeu)) {
				resultatDeNoeudFils = minmax(jeuFils, coupEnCours);
				if (resultatDeNoeudFils.getGagner() > valeur_max) {
					valeur_max = resultatDeNoeudFils.getGagner();
					meilleurNoeud = new NoeudMinMax(coupEnCours, valeur_max);
				}

			} else {
				// maximiser le score quand c'est le tour O
				resultatDeNoeudFils = minmax(jeuFils, coupEnCours);
				if (resultatDeNoeudFils.getGagner() < valeur_min) {
					valeur_min = resultatDeNoeudFils.getGagner();
					meilleurNoeud = new NoeudMinMax(coupEnCours, valeur_min);
				}

			}
		}

		return meilleurNoeud;
	}

	private boolean estTourJoueur2(Jeu jeu) {
		return jeu.getJoueurEnCours().equals(((Morpion) jeu).getJ2());
	}

	private boolean estTourJoueur1(Jeu jeu) {
		return jeu.getJoueurEnCours().equals(((Morpion) jeu).getJ1());
	}

}
