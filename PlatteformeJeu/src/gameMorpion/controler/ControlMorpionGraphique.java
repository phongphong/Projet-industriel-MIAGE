package gameMorpion.controler;


import gameMorpion.model.CoupMorpion;
import gameMorpion.model.Joueur;
import gameMorpion.model.MiniMax;
import gameMorpion.model.Morpion;
import generique.gameAbstract.AbstractControler;
import generique.gameAbstract.Coup;
import generique.gameAbstract.Partie;

import java.awt.event.MouseEvent;

public class ControlMorpionGraphique extends AbstractControler {

	private Partie partie;
	private MiniMax minimax;
	
	public ControlMorpionGraphique(Partie partie) {
		this.partie = partie;
		minimax = new MiniMax(partie);
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
		Joueur j = ((Morpion) partie.getJeu()).getTourJoueur();
		Coup c = new CoupMorpion(j, x, y);
		partie.jouerUnCoup(c);
		Coup meilleurCoup = minimax.minimax(2);
		System.out.println(meilleurCoup);
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
