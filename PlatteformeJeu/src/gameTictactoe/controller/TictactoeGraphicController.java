package gameTictactoe.controller;


import gameTictactoe.model.Tictactoe;
import gameTictactoe.model.TictactoeAction;
import generic.AI.MinMax;
import generic.AI.NoeudMinMax;
import generic.abstractController.AbstractControler;
import generic.abstractModel.Coup;
import generic.abstractModel.Joueur;
import generic.abstractModel.Partie;

import java.awt.event.MouseEvent;



public class TictactoeGraphicController extends AbstractControler {

	private Partie partie;
	private MinMax minimax;
	
	public TictactoeGraphicController(Partie partie) {
		this.partie = partie;
		minimax = new MinMax();
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

	public void mousePressed(MouseEvent e) {
		int x = e.getX() / 50;
		int y = e.getY() / 50;
		
		Tictactoe morpion = (Tictactoe) partie.getJeu(); 
		Joueur joueurEnCours = morpion.getJoueurEnCours();
		Coup coupJoueur = new TictactoeAction(joueurEnCours, x, y);
		partie.jouerUnCoup(coupJoueur);
		if(morpion.getJoueurEnCours().equals(morpion.getJ2())){
			NoeudMinMax noeudMinMax = minimax.lancerMinMax(partie.getJeu().getCopyDeJeu());
			Coup meilleurCoup = noeudMinMax.getCoup();
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
