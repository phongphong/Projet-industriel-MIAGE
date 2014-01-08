package gameMorpion.controler;


import gameMorpion.model.CoupMorpion;
import gameMorpion.model.Joueur;
import gameMorpion.model.MiniMaxMorpion;
import gameMorpion.model.Morpion;
import generique.gameAbstract.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlMorpionGraphique extends AbstractControler {

	private Morpion morpion;
	private Partie partie;
	private MiniMaxMorpion minimax;
	
	public ControlMorpionGraphique(Morpion morpion) {
		this.morpion = morpion;
		partie = new Partie(morpion);
		this.minimax = new MiniMaxMorpion(morpion, partie);
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
		partie.jouerUnCoup(c);
		if(j.equals(morpion.getJ1())){
			int[] t_score = minimax.minimax(2, j);
			System.out.println("score : " + t_score[0] + " ligne : " + t_score[1] + " col : " + t_score[2]);
		}
		
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
	
	public Partie getPartie(){
		return this.partie;
	}

	
}
