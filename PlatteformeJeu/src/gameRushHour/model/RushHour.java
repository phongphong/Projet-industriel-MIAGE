/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameRushHour.model;

import generic.abstractModel.*;
import java.util.*;

import org.apache.commons.lang.SerializationUtils;

/**
 * This class represent the Rushhour game model
 * 
 * @author Phongphet
 */
public class RushHour extends Game {

	private static final int dimension = 6;
	char[][] grid;
	private ArrayList<Car> listCar;

	/**
	 * Constructor of Rushhour model
	 */
	public RushHour() {
		// initialisation du tableau de boolean
		grid = new char[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				grid[i][j] = '.';
			}
		}

		// creation des voiture
		Car v1 = new Car('0', 0, 0, 3, 'v', false);
		Car v2 = new Car('R', 3, 0, 2, 'h', true);
		Car v3 = new Car('1', 1, 5, 3, 'v', false);

		Car v4 = new Car('2', 5, 0, 2, 'h', false);
		Car v5 = new Car('3', 5, 4, 2, 'h', false);

		// ajout de la voiture dans la liste des voitures
		listCar = new ArrayList<>();
		listCar.add(v1);
		listCar.add(v2);
		listCar.add(v3);
		listCar.add(v4);
		listCar.add(v5);

		// les cases qui sont occupes sont devenus occupe et contient le numero
		// du voiture
		this.putCarSignInGrid(v1, v1.getNumber());
		this.putCarSignInGrid(v2, v2.getNumber());
		this.putCarSignInGrid(v3, v3.getNumber());
		this.putCarSignInGrid(v4, v4.getNumber());
		this.putCarSignInGrid(v5, v5.getNumber());
	}
	
	public RushHour(ArrayList<Car> listCar){
		for(Car car : listCar){
			listCar.add(car);
			this.putCarSignInGrid(car, car.getNumber());
		}
	}

	@Override
	public String toString() {
		String viewOfGame = "";
		char[][] t_case = getGrid();
		for (int i = 0; i < t_case.length; i++) {
			for (int j = 0; j < t_case.length; j++) {
				viewOfGame += t_case[i][j] + " ";
			}
			viewOfGame += "\n";
		}

		return viewOfGame;
	}

	/**
	 * This methode applies an given action to the current state of game
	 * 
	 * @param action
	 *            new action
	 */
	@Override
	public void doAction(GameAction action) {
		// on recupere la voiture en fonction du coup
		char carNumber = ((RushHourAction) action).getCarNumber();
		int indexCar = listCar.indexOf(new Car(carNumber));
		// les anciens cases qui ont ete occupes par cette voitures sont devenus
		// disponibles
		// on recupere la direction de la voiture et mettre a jour les cases de
		// la voiture
		if(indexCar != -1){
			Car car = listCar.get(indexCar);
			this.putCarSignInGrid(car, '.');
			if (car.getDirection() == 'h') {
				car.setColumn(car.getColumn() + ((RushHourAction) action).getMove());
			} else {
				car.setRow(car.getRow() + ((RushHourAction) action).getMove());
			}
			this.putCarSignInGrid(car, (char) car.getNumber());
		}
	}

	/**
	 * This method list all actions that a player can make from the current
	 * state of game
	 * 
	 * @return list of possible actions
	 */
	@Override
	public ArrayList<GameAction> listAllPossibleAction() {
		ArrayList<GameAction> listAction = new ArrayList<>();
		// pour chaque voiture, on recupere les cases qu'elle peut deplacer en
		// fonction de sa direction
		for (int i = 0; i < listCar.size(); i++) {
			Car car = listCar.get(i);
			if (car.getDirection() == 'h') {
				// on recupere les cases qui sont devant la voiture (les cases
				// qu'elle peut y aller)
				for (int j = 0; j < car.getColumn(); j++) {
					if (grid[car.getRow()][j] == '.') {
						listAction.add(new RushHourAction(car.getNumber(), j
								- car.getColumn()));
					}
				}
				// on recupere les cases qui sont derrieres la voiture (les
				// cases qu'elle peut y aller)
				for (int k = car.getColumn() + car.getLength(); k < dimension; k++) {
					if (grid[car.getRow()][k] == '.' || grid[car.getRow()][k] == car.getNumber())
						listAction.add(new RushHourAction(car.getNumber(), k
								- car.getColumn() - car.getLength() + 1));
					else
						break;
				}
			} else {
				for (int l = 0; l < car.getRow(); l++) {
					if (grid[l][car.getColumn()] == '.')
						listAction
								.add(new RushHourAction(car.getNumber(), l - car.getRow()));
					else
						break;
				}
				for (int m = car.getRow() + car.getLength(); m < dimension; m++) {
					if (grid[m][car.getColumn()] == '.'
							|| grid[m][car.getColumn()] == car.getNumber())
						listAction.add(new RushHourAction(car.getNumber(), m - car.getRow()
								- car.getLength() + 1));
					else
						break;
				}
			}
		}
		return listAction;
	}

	/**
	 * This car update the grid, it puts the car sign in the cell
	 * 
	 * @param car
	 * @param carSign
	 *            sign of car
	 */
	private void putCarSignInGrid(Car car, char carSign) {
		if (car.getDirection() == 'v') {
			for (int i = car.getRow(); i < car.getRow() + car.getLength(); i++) {
				grid[i][car.getColumn()] = carSign;
			}
		} else {
			for (int i = car.getColumn(); i < car.getColumn() + car.getLength(); i++) {
				grid[car.getRow()][i] = carSign;
			}
		}
	}

	/**
	 * Getter of grid
	 * 
	 * @return grid
	 */
	public char[][] getGrid() {
		return grid;
	}

	/**
	 * Getter of
	 * 
	 * @return
	 */
	public static int getDimension() {
		return dimension;
	}

	/**
	 * Getter of list of car
	 * 
	 * @return list of car
	 */
	public ArrayList<Car> getlistCar() {
		return listCar;
	}

	/**
	 * Setter of grid
	 * 
	 * @param grid
	 */
	public void setGrid(char[][] grid) {
		this.grid = grid;
		setChanged();
		notifyObservers();
	}

	/**
	 * Setter of car list
	 * 
	 * @param listCar
	 */
	public void setListCar(ArrayList<Car> listCar) {
		this.listCar = listCar;
		setChanged();
		notifyObservers();
	}

	@Override
	public Game getCopyOfGame() {
		RushHour rh = new RushHour();
		for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid.length ; j++){
            	rh.getGrid()[i][j] = '.';
            }
        }
		
		rh.getlistCar().clear();
		for(Car car : listCar){
			Car car_copied = new Car(car.getNumber(), car.getRow(), car.getColumn(), car.getLength(), car.getDirection(), car.isRedcar());
			rh.getlistCar().add(car_copied);
			//rh.putCarSignInGrid(car_copied, car_copied.getNumber());
			if (car.getDirection() == 'v') {
				for (int i = car.getRow(); i < car.getRow() + car.getLength(); i++) {
					rh.getGrid()[i][car.getColumn()] = car.getNumber();
				}
			} else {
				for (int i = car.getColumn(); i < car.getColumn() + car.getLength(); i++) {
					rh.getGrid()[car.getRow()][i] = car.getNumber();
				}
			}
		}
		return rh;
	}

	/* Il y a qu'un seul joueur dans ce jeu */
	@Override
	public Player getCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double caculateScore(Player joueur) {
		// TODO Auto-generated method stub
		if (grid[3][dimension - 1] == 'R') {
			return 1;
		}
		return -1;
	}
}
