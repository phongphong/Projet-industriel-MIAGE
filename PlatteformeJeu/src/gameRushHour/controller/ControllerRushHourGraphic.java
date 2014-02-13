/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameRushHour.controller;

import gameRushHour.model.RushHourAction;
import gameRushHour.model.RushHour;
import gameRushHour.model.Car;
import generic.abstractController.AbstractControler;
import generic.abstractModel.GamePart;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

/**
 * Cette classe représente le contrôleur en mode GRAPHIQUE du jeu rushHour
 * 
 * @author Phongphet
 */
public class ControllerRushHourGraphic extends AbstractControler {

	private ArrayList<Car> lVoiture;
	private int indice;
	private GamePart partie;

	public ControllerRushHourGraphic(GamePart partie) {
		this.partie = partie;
		indice = -1;
	}

	@Override
	public void mouseClicked(MouseEvent me) {

	}

	@Override
	public void mousePressed(MouseEvent me) {
		int colonne = me.getX() / 50;
		int ligne = me.getY() / 50;
		if (ligne < RushHour.getDimension()
				&& colonne < RushHour.getDimension()) {
			char c = ((RushHour) partie.getJeu()).getT_case()[ligne][colonne];
			// on récupère la voiture choisie
			lVoiture = ((RushHour) partie.getJeu()).getlVoiture();
			indice = lVoiture.indexOf(new Car(c));
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		if (partie.getJeu().calculScore(null) == 1) {
			JOptionPane.showMessageDialog(null, "Gagner");
		}
	}

	@Override
	public void mouseEntered(MouseEvent me) {

	}

	@Override
	public void mouseExited(MouseEvent me) {

	}

	@Override
	public void mouseDragged(MouseEvent me) {
		// si la voiture choisi n'est pas nulle
		if (indice != -1) {
			// on regenere le nouveau coup(voiture, deplacement) en fonction du
			// deplacement de la souris et la direction
			int colonne = me.getX() / 50;
			int ligne = me.getY() / 50;
			if (ligne < RushHour.getDimension()
					&& colonne < RushHour.getDimension()) {
				lVoiture = ((RushHour) partie.getJeu()).getlVoiture();
				Car v = lVoiture.get(indice);
				int deplacement;
				if (v.getDirection() == 'h') {
					deplacement = colonne - v.getCol();
				} else {
					deplacement = ligne - v.getLigne();
				}
				// On cree ce coup
				RushHourAction c = new RushHourAction(v, deplacement);
				partie.jouerUnCoup(c);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent me) {

	}
}
