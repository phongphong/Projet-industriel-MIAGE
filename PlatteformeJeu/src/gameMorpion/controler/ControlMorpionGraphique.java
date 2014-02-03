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
		minimax = new MiniMax();
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
		
		Morpion morpion = (Morpion) partie.getJeu(); 
		Joueur joueurEnCours = morpion.getJoueurEnCours();
		Coup c = new CoupMorpion(joueurEnCours, x, y);
		partie.jouerUnCoup(c);
		if(morpion.getJoueurEnCours().equals(morpion.getJ2())){
			Coup meilleurCoup = minimax.getMeilleurCoup(partie, 7);
			System.out.println("Meilleur coup : "+meilleurCoup);
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
}
