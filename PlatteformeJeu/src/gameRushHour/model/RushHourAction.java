package gameRushHour.model;

import generic.abstractModel.*;
import java.util.Objects;

/**
 * This car represents the action that a player can make in Rushhour game
 * 
 * @author Phongphet
 */
public class RushHourAction implements GameAction {

	private char carNumber;
	private int move;

	/**
	 * Constructor of RushHourAction class
	 * 
	 * @param car
	 * @param moves
	 */
	public RushHourAction(char carNumber, int moves) {
		super();
		this.carNumber = carNumber;
		this.move = moves;
	}

	/**
	 * getter of car
	 * 
	 * @return car
	 */
	public char getCarNumber() {
		return carNumber;
	}

	/**
	 * setter of car
	 * 
	 * @param car
	 */
	public void setCar(char carNumber) {
		this.carNumber = carNumber;
	}

	/**
	 * getter of move
	 * 
	 * @return
	 */
	public int getMove() {
		return move;
	}

	/**
	 * setter of move
	 * 
	 * @param move
	 */
	public void setMove(int move) {
		this.move = move;
	}

	@Override
	public String toString() {
		return "[" + carNumber + ", " + move + ']';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carNumber;
		result = prime * result + move;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RushHourAction other = (RushHourAction) obj;
		if (carNumber != other.carNumber)
			return false;
		if (move != other.move)
			return false;
		return true;
	}
}
