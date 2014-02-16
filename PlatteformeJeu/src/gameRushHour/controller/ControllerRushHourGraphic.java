package gameRushHour.controller;

import gameRushHour.model.*;
import generic.abstractController.AbstractControler;
import generic.abstractModel.GamePart;

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
	private GamePart part;

	/**
	 * Controller constructor
	 * @param part part of a game
	 */
	public ControllerRushHourGraphic(GamePart part) {
		this.part = part;
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
			char carNumber = ((RushHour) part.getGame()).getGrid()[row][column];
			// on récupère la voiture choisie
			listeOfCars = ((RushHour) part.getGame()).getlistCar();
			indexSelected = listeOfCars.indexOf(new Car(carNumber));
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		if (part.getGame().caculateScore(null) == 1) {
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
				listeOfCars = ((RushHour) part.getGame()).getlistCar();
				Car selectedCar = listeOfCars.get(indexSelected);
				int moves;
				if (selectedCar.getDirection() == 'h') {
					moves = column - selectedCar.getColumn();
				} else {
					moves = row - selectedCar.getRow();
				}
				// On cree ce coup
				RushHourAction c = new RushHourAction(selectedCar, moves);
				part.doAction(c);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent me) {

	}
}
