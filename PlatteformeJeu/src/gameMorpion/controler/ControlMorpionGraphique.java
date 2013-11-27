package gameMorpion.controler;

import gameAbstract.*;

import gameMorpion.model.CoupMorpion;
import gameMorpion.model.Joueur;
import gameMorpion.model.Morpion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlMorpionGraphique implements MouseListener {

	private Morpion morpion;
	private Partie partie;

	public ControlMorpionGraphique(Morpion morpion) {
		this.morpion = morpion;
		partie = new Partie(morpion);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {		
		int x = e.getX() / 50;
		int y = e.getY() / 50;
		Joueur j = morpion.getTourJoueur();
		Coup c = new CoupMorpion(j, x, y);
		partie.jouerUnePartie(c);
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
