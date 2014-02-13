/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameRushHour.model;

import gameRushHour.controler.ControlRushHourGraphic;
import gameRushHour.view.ViewRushHourGraphic;
import generique.gameAbstract.*;
import generique.jeu.Coup;
import generique.jeu.Jeu;
import generique.jeu.Joueur;
import generique.jeu.Partie;

import java.util.*;

/**
 * Cette classe représente le modèle du Jeu RushHour
 * 
 * @author Phongphet
 */
public class RushHour extends Jeu {

	private static final int dimension = 6;
	char[][] t_case;
	ArrayList<Voiture> lVoiture;

	public RushHour() {
		// initialisation du tableau de boolean
		t_case = new char[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				t_case[i][j] = '.';
			}
		}

		// creation des voiture
		Voiture v1 = new Voiture('0', 0, 0, 3, 'v', false);
		Voiture v2 = new Voiture('R', 3, 0, 2, 'h', true);
		Voiture v3 = new Voiture('1', 1, 5, 3, 'v', false);
		
		Voiture v4 = new Voiture('2', 5, 0, 2, 'h', false);
		Voiture v5 = new Voiture('3', 5, 4, 2, 'h', false);

		// ajout de la voiture dans la liste des voitures
		lVoiture = new ArrayList<>();
		lVoiture.add(v1);
		lVoiture.add(v2);
		lVoiture.add(v3);
		lVoiture.add(v4);
		lVoiture.add(v5);

		// les cases qui sont occupes sont devenus occupe et contient le numero
		// du voiture
		this.setCaseOccupe(v1, v1.getNum());
		this.setCaseOccupe(v2, v2.getNum());
		this.setCaseOccupe(v3, v3.getNum());
		this.setCaseOccupe(v4, v4.getNum());
		this.setCaseOccupe(v5, v5.getNum());
	}

	/**
	 * Cette méthode applique un coup choisi par l'utilisateur au jeu
	 * 
	 * @param c
	 */
	@Override
	public void jouerUnCoup(Coup c) {
		// on recupere la voiture en fonction du coup
		Voiture v = ((CoupRushHour) c).getV();
		// les anciens cases qui ont ete occupes par cette voitures sont devenus
		// disponibles
		// on recupere la direction de la voiture et mettre a jour les cases de
		// la voiture
		this.setCaseOccupe(v, '.');
		if (v.getDirection() == 'h') {
			v.setCol(v.getCol() + ((CoupRushHour) c).getDeplacement());
		} else {
			v.setLigne(v.getLigne() + ((CoupRushHour) c).getDeplacement());
		}
		this.setCaseOccupe(v, (char) v.getNum());
	}
	
	

	/**
	 * Cette méthode analyse une situation actuelle du jeu et liste tous les
	 * coups possibles
	 * 
	 * @return
	 */
	@Override
	public ArrayList<Coup> listerTousCoupPossible() {
		ArrayList<Coup> listeCoup = new ArrayList<>();
		// pour chaque voiture, on recupere les cases qu'elle peut deplacer en
		// fonction de sa direction
		for (int i = 0; i < lVoiture.size(); i++) {
			Voiture v = lVoiture.get(i);
			if (v.getDirection() == 'h') {
				// on recupere les cases qui sont devant la voiture (les cases
				// qu'elle peut y aller)
				for (int j = 0; j < v.getCol(); j++) {
					if (t_case[v.getLigne()][j] == '.'){
						listeCoup.add(new CoupRushHour(v, j - v.getCol()));
					} 
				}
				// on recupere les cases qui sont derrieres la voiture (les
				// cases qu'elle peut y aller)
				for (int k = v.getCol() + v.getLongeur(); k < dimension; k++) {
					if (t_case[v.getLigne()][k] == '.'
							|| t_case[v.getLigne()][k] == v.getNum())
						listeCoup.add(new CoupRushHour(v, k - v.getCol()
								- v.getLongeur() + 1));
					else
						break;
				}
			} else {
				for (int l = 0; l < v.getLigne(); l++) {
					if (t_case[l][v.getCol()] == '.')
						listeCoup.add(new CoupRushHour(v, l - v.getLigne()));
					else
						break;
				}
				for (int m = v.getLigne() + v.getLongeur(); m < dimension; m++) {
					if (t_case[m][v.getCol()] == '.'
							|| t_case[m][v.getCol()] == v.getNum())
						listeCoup.add(new CoupRushHour(v, m - v.getLigne()
								- v.getLongeur() + 1));
					else
						break;
				}
			}
		}
		return listeCoup;
	}

	/**
	 * Cette méthode mettre à jour le tableau de caractère en fonction de la
	 * position de la voiture
	 * 
	 * @param v
	 * @param c
	 */
	private void setCaseOccupe(Voiture v, char c) {
		if (v.getDirection() == 'v') {
			for (int i = v.getLigne(); i < v.getLigne() + v.getLongeur(); i++) {
				t_case[i][v.getCol()] = c;
			}
		} else {
			for (int i = v.getCol(); i < v.getCol() + v.getLongeur(); i++) {
				t_case[v.getLigne()][i] = c;
			}
		}
	}

	public char[][] getT_case() {
		return t_case;
	}

	public static int getDimension() {
		return dimension;
	}

	public ArrayList<Voiture> getlVoiture() {
		return lVoiture;
	}

	@Override
	public AbstractView getView(Partie partie) {
		return (AbstractView) new ViewRushHourGraphic(partie);
	}

	@Override
	public AbstractControler getControler(Partie partie) {
		return new ControlRushHourGraphic(partie);
	}

	@Override
	public Jeu getCopyDeJeu() {
		RushHour rh = new RushHour();
		for(int i = 0 ; i < t_case.length ; i++){
            for(int j = 0 ; j < t_case.length ; j++){
            	rh.getT_case()[i][j] = t_case[i][j];
            }
        }
		
		rh.getlVoiture().clear();
		for(Voiture v : lVoiture){
			Voiture v_temp = new Voiture(v.getNum(), v.getLigne(), v.getCol(), v.getLongeur(), v.getDirection(), v.isVoitureR());
			rh.getlVoiture().add(v_temp);
			rh.setCaseOccupe(v_temp, v_temp.getNum());
		}
		
		
		return rh;
	}

	public void setT_case(char[][] t_case) {
		this.t_case = t_case;
		setChanged();
		notifyObservers();
	}

	public void setlVoiture(ArrayList<Voiture> lVoiture) {
		this.lVoiture = lVoiture;
		setChanged();
		notifyObservers();
	}

	/*Il y a qu'un seul joueur dans ce jeu*/
	@Override
	public Joueur getJoueurEnCours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changerJoueur() {
		// TODO Auto-generated method stub
		
	}	

	@Override
	public double calculScore(Joueur joueur) {
		// TODO Auto-generated method stub
		if (t_case[3][dimension - 1] == 'R') {
			return 1;
		}
		return -1;
	}

	@Override
	public Joueur getJoueurQuiDoitGagnerMinMax() {
		// TODO Auto-generated method stub
		return null;
	}
}
