package gameMorpion.model;

import gameMorpion.controler.ControlMorpionGraphique;
import gameMorpion.view.ViewMorpionGraphique;
import generique.gameAbstract.AbstractControler;
import generique.gameAbstract.AbstractView;
import generique.jeu.Coup;
import generique.jeu.Jeu;
import generique.jeu.Joueur;
import generique.jeu.Partie;

import java.util.ArrayList;

public class Morpion extends Jeu {

	private Joueur t_case[][];
	private Joueur joueurEnCours;
	private Joueur j1;
	private Joueur j2;
	private char caractereJ1;
	private char caractereJ2;

	public Morpion() {

		t_case = new Joueur[3][3];

		// creation des joueurs
		j1 = new Joueur("J1");
		j2 = new Joueur("J2");
		caractereJ1 = 'O';
		caractereJ2 = 'X';

		joueurEnCours = j1;

		/*for (int i = 0; i < t_case.length; i++) {
			for (int j = 0; j < t_case.length; j++) {
				t_case[j][i] = '.';
			}
		}*/
	}

	@Override
	public void jouerUnCoup(Coup c) {
		Joueur joueurEnCours = ((CoupMorpion) c).getJoueur();
		int x = ((CoupMorpion) c).getX();
		int y = ((CoupMorpion) c).getY();
		t_case[x][y] = joueurEnCours;
		
		if (this.calculScore(joueurEnCours) != 1) {
			this.changerJoueur();
		}
	}

	@Override
	public ArrayList<Coup> listerTousCoupPossible() {
		ArrayList<Coup> listeCoupPossible = new ArrayList<Coup>();
		if (this.calculScore(joueurEnCours) != 1) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (t_case[j][i] == null) {
						listeCoupPossible.add(new CoupMorpion(joueurEnCours, j, i));
					}
				}
			}
		}
		return listeCoupPossible;
	}

	public Joueur[][] getT_case() {
		return t_case;
	}

	@Override
	public void changerJoueur() {
		if (joueurEnCours.equals(j1)) {
			joueurEnCours = j2;
		} else {
			joueurEnCours = j1;
		}
	}

	@Override
	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}

	@Override
	public Joueur getJoueurQuiDoitGagnerMinMax() {
		// TODO Auto-generated method stub
		return j2;
	}

	@Override
	public AbstractView getView(Partie partie) {
		return new ViewMorpionGraphique(partie);
	}

	@Override
	public AbstractControler getControler(Partie partie) {
		return new ControlMorpionGraphique(partie);
	}

	public Joueur getJ1() {
		return j1;
	}

	public Joueur getJ2() {
		return j2;
	}

	public void setT_case(Joueur[][] t_case) {
		this.t_case = t_case;
		setChanged();
		notifyObservers();
	}

	public void setTourJoueur(Joueur tourJoueur) {
		this.joueurEnCours = tourJoueur;
	}

	public void setJ1(Joueur j1) {
		this.j1 = j1;
	}

	public void setJ2(Joueur j2) {
		this.j2 = j2;
	}

	@Override
	public String toString() {
		String affiche = "";
		for (int i = 0; i < t_case.length; i++) {
			for (int j = 0; j < t_case.length; j++) {
				affiche += t_case[j][i] + "	";
			}
			affiche += "\n";
		}
		return affiche;
	}

	@Override
	public Jeu getCopyDeJeu() {
		// TODO Auto-generated method stub
		Morpion morpion = new Morpion();
		morpion.setJ1(j1);
		morpion.setJ2(j2);
		morpion.setTourJoueur(joueurEnCours);

		Joueur[][] t_case_bis = new Joueur[3][3];
		for (int i = 0; i < t_case_bis.length; i++) {
			for (int j = 0; j < t_case_bis.length; j++) {
				t_case_bis[i][j] = t_case[i][j];
			}
		}
		morpion.setT_case(t_case_bis);
		return morpion;
	}

	@Override
	public double calculScore(Joueur joueur) {
		// TODO Auto-generated method stub
		int gagne = 0;
		Joueur joueurGagnant = null;

		if (t_case[0][0] != null  && t_case[0][0].equals(t_case[0][1]) && t_case[0][1].equals(t_case[0][2])) {
			joueurGagnant = t_case[0][0];
		}

		if (t_case[0][0] != null && t_case[0][0].equals(t_case[1][1]) && t_case[1][1].equals(t_case[2][2])) {
			joueurGagnant = t_case[0][0];
		}

		if (t_case[0][0] != null  && t_case[0][0].equals(t_case[1][0]) && t_case[1][0].equals(t_case[2][0])) {
			joueurGagnant = t_case[0][0];
		}

		if (t_case[1][0] != null && t_case[1][0].equals(t_case[1][1]) && t_case[1][1].equals(t_case[1][2])) {
			joueurGagnant = t_case[1][0];
		}
		
		if (t_case[2][0] != null  && t_case[2][0].equals(t_case[2][1]) && t_case[2][1].equals(t_case[2][2])) {
			joueurGagnant = t_case[2][0];
		}

		if (t_case[0][1] != null && t_case[0][1].equals(t_case[1][1]) && t_case[1][1].equals(t_case[2][1])) {
			joueurGagnant = t_case[0][1];
		}
		
		if (t_case[0][2] != null  && t_case[0][2].equals(t_case[1][2]) && t_case[1][2].equals(t_case[2][2])) {
			joueurGagnant = t_case[0][2];
		}

		if (t_case[2][0] != null && t_case[2][0].equals(t_case[1][1]) && t_case[1][1].equals(t_case[0][2])) {
			joueurGagnant = t_case[2][0];
		}
		
		if(joueurGagnant != null){
			if(joueurGagnant.equals(joueur)){
				gagne = 1;
			}else{
				gagne = -1;
			}
		}
		
		return gagne;

	}
}
