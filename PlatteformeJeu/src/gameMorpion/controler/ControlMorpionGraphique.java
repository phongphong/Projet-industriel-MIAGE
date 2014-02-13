package gameMorpion.controler;


import gameMorpion.model.CoupMorpion;
import gameMorpion.model.Morpion;
import generique.IA.MinMax;
import generique.IA.NoeudMinMax;
import generique.gameAbstract.AbstractControler;
import generique.jeu.Coup;
import generique.jeu.Joueur;
import generique.jeu.Partie;

import java.awt.event.MouseEvent;


public class ControlMorpionGraphique extends AbstractControler {

	private Partie partie;
	private MinMax minimax;
	
	public ControlMorpionGraphique(Partie partie) {
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
		
		Morpion morpion = (Morpion) partie.getJeu(); 
		Joueur joueurEnCours = morpion.getJoueurEnCours();
		Coup coupJoueur = new CoupMorpion(joueurEnCours, x, y);
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
