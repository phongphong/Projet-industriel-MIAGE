package generic.AI;

import generic.abstractModel.GameAction;

/**
 * This class represents the node in min max tree implementation
 */
public class MinMaxNode {
	private GameAction move;
	private double win;
	
	/**
	 * Constructor
	 * @param move the move of the game
	 * @param win the score of the move application to the current state of game
	 */
	public MinMaxNode(GameAction move, double win) {
		super();
		this.move = move;
		this.win = win;
	}

	/**
	 * Getter of move
	 * @return move
	 */
	public GameAction getMove() {
		return move;
	}

	/**
	 * Setter of move
	 * @param move
	 */
	public void setCoup(GameAction move) {
		this.move = move;
	}

	/**
	 * Getter of win
	 * @return 1 for winning, -1 for loosing and 0 if no one win
	 */
	public double getWin() {
		return win;
	}
	
	/**
	 * Setter of win
	 * @param win
	 */
	public void setWin(double win) {
		this.win = win;
	}
}
