package gameTictactoe.model;

import gameTictactoe.controller.ControllerTictactoeGraphic;
import gameTictactoe.view.ViewTictactoeGraphic;
import generic.abstractController.AbstractControler;
import generic.abstractModel.GameAction;
import generic.abstractModel.Game;
import generic.abstractModel.Player;
import generic.abstractModel.GamePart;
import generic.abstractView.AbstractView;

import java.util.ArrayList;


public class Tictactoe extends Game {

	private Player t_case[][];
	private Player joueurEnCours;
	private Player j1;
	private Player j2;

	public Tictactoe() {

		t_case = new Player[3][3];

		// creation des joueurs
		j1 = new Player("J1");
		j2 = new Player("J2");

		joueurEnCours = j1;
	}

	@Override
	public void jouerUnCoup(GameAction c) {
		Player joueurEnCours = ((TictactoeAction) c).getJoueur();
		int x = ((TictactoeAction) c).getX();
		int y = ((TictactoeAction) c).getY();
		t_case[x][y] = joueurEnCours;
		
		if (this.calculScore(joueurEnCours) != 1) {
			this.changerJoueur();
		}
	}

	@Override
	public ArrayList<GameAction> listerTousCoupPossible() {
		ArrayList<GameAction> listeCoupPossible = new ArrayList<GameAction>();
		if (this.calculScore(joueurEnCours) != 1) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (t_case[j][i] == null) {
						listeCoupPossible.add(new TictactoeAction(joueurEnCours, j, i));
					}
				}
			}
		}
		return listeCoupPossible;
	}

	public Player[][] getT_case() {
		return t_case;
	}

	public void changerJoueur() {
		if (joueurEnCours.equals(j1)) {
			joueurEnCours = j2;
		} else {
			joueurEnCours = j1;
		}
	}

	@Override
	public Player getJoueurEnCours() {
		return joueurEnCours;
	}

	public Player getJ1() {
		return j1;
	}

	public Player getJ2() {
		return j2;
	}

	public void setT_case(Player[][] t_case) {
		this.t_case = t_case;
		setChanged();
		notifyObservers();
	}

	public void setTourJoueur(Player tourJoueur) {
		this.joueurEnCours = tourJoueur;
	}

	public void setJ1(Player j1) {
		this.j1 = j1;
	}

	public void setJ2(Player j2) {
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
	public Game getCopyDeJeu() {
		// TODO Auto-generated method stub
		Tictactoe morpion = new Tictactoe();
		morpion.setJ1(j1);
		morpion.setJ2(j2);
		morpion.setTourJoueur(joueurEnCours);

		Player[][] t_case_bis = new Player[3][3];
		for (int i = 0; i < t_case_bis.length; i++) {
			for (int j = 0; j < t_case_bis.length; j++) {
				t_case_bis[i][j] = t_case[i][j];
			}
		}
		morpion.setT_case(t_case_bis);
		return morpion;
	}

	@Override
	public double calculScore(Player joueur) {
		// TODO Auto-generated method stub
		int gagne = 0;
		Player joueurGagnant = null;

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
