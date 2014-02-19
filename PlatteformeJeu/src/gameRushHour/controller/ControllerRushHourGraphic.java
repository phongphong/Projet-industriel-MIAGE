package gameRushHour.controller;

import gameRushHour.model.*;
import generic.abstractController.AbstractControler;
import generic.abstractModel.GameSession;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

/**
 * This class represents the controller of Rushhour game in graphical mode
 * @author Phongphet
 */
public class ControllerRushHourGraphic extends AbstractControler {

	private ArrayList<Car> listeOfCars;
	private int indexSelected;
	private GameSession gameSession;

	/**
	 * Controller constructor
	 * @param gameSession part of a game
	 */
	public ControllerRushHourGraphic(GameSession gameSession) {
		this.gameSession = gameSession;
		indexSelected = -1;
	}

	@Override
	public void mouseClicked(MouseEvent me) {

	}

	@Override
	public void mousePressed(MouseEvent me) {
		int column = me.getX() / 50;
		int row = me.getY() / 50;
		if (row < RushHour.getDimension() && column < RushHour.getDimension()) {
			char carNumber = ((RushHour) gameSession.getGame()).getGrid()[row][column];
			// on récupère la voiture choisie
			listeOfCars = ((RushHour) gameSession.getGame()).getlistCar();
			indexSelected = listeOfCars.indexOf(new Car(carNumber));
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		if (gameSession.getGame().caculateScore(null) == 1) {
			JOptionPane.showMessageDialog(null, "You win !");
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
		if (indexSelected != -1) {
			
			int column = me.getX() / 50;
			int row = me.getY() / 50;
			if (row < RushHour.getDimension() && column < RushHour.getDimension()) {
				listeOfCars = ((RushHour) gameSession.getGame()).getlistCar();
				Car selectedCar = listeOfCars.get(indexSelected);
				int moves;
				if (selectedCar.getDirection() == 'h') {
					moves = column - selectedCar.getColumn();
				} else {
					moves = row - selectedCar.getRow();
				}
				// On cree ce coup
				RushHourAction c = new RushHourAction(selectedCar.getNumber(), moves);
				gameSession.doAction(c);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent me) {

	}
}
