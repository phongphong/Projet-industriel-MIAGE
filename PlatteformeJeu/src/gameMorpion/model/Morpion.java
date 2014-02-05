package gameMorpion.model;

import gameMorpion.controler.ControlMorpionGraphique;
import gameMorpion.view.ViewMorpionGraphique;
import generique.gameAbstract.AbstractControler;
import generique.gameAbstract.AbstractView;
import generique.gameAbstract.Coup;
import generique.gameAbstract.Jeu;
import generique.gameAbstract.Partie;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Morpion extends Jeu {

	private char t_case[][];
	private Joueur joueurEnCours;
	private Joueur j1;
	private Joueur j2;

	public Morpion() {

		t_case = new char[3][3];

		// creation des joueurs
		j1 = new Joueur("J1", 'O');
		j2 = new Joueur("J2", 'X');

		joueurEnCours = j1;

		for (int i = 0; i < t_case.length; i++) {
			for (int j = 0; j < t_case.length; j++) {
				t_case[j][i] = '.';
			}
		}
	}

	@Override
	public void jouerUnCoup(Coup c) {
		char signe = ((CoupMorpion) c).getJ().getSigne();
		t_case[((CoupMorpion) c).getX()][((CoupMorpion) c).getY()] = signe;
		if(!gagner(c)){
			this.changerJoueur();
		}
		/*
		 * if (gagner(c)) { JOptionPane.showMessageDialog(null,
		 * joueurEnCours.getNom() + " gagne ce tour !!"); }
		 */
	}

	@Override
	public void enleverCoup(Coup c) {
		t_case[((CoupMorpion) c).getX()][((CoupMorpion) c).getY()] = '.';
	}

	@Override
	public ArrayList<Coup> listerTousCoupPossible() {
		ArrayList<Coup> listeCoupPossible = new ArrayList<Coup>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (t_case[j][i] == '.') {
					listeCoupPossible.add(new CoupMorpion(joueurEnCours, j, i));
				}
			}
		}
		return listeCoupPossible;
	}

	@Override
	public boolean gagner(Coup c) {
		int x = ((CoupMorpion) c).getX();
		int y = ((CoupMorpion) c).getY();
		Joueur j = ((CoupMorpion) c).getJ();
		int colonne = 0;
		int ligne = 0;
		int diagonal = 0;
		int rdiagonal = 0;
		boolean gagne = false;

		for (int i = 0; i < t_case.length; i++) {
			if (t_case[x][i] == j.getSigne()) {
				colonne++;
			}
			if (t_case[i][y] == j.getSigne()) {
				ligne++;
			}
			if (t_case[i][i] == j.getSigne()) {
				diagonal++;
			}
			if (t_case[i][2 - i] == j.getSigne()) {
				rdiagonal++;
			}

		}
		if (colonne == t_case.length || ligne == t_case.length
				|| diagonal == t_case.length || rdiagonal == t_case.length) {
			gagne = true;
		}

		return gagne;
	}

	public char[][] getT_case() {
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

	public void setT_case(char[][] t_case) {
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

		char[][] t_case_bis = new char[3][3];
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
		return 0;
	}
	
	
}
