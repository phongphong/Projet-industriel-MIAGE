package gameTictactoe.model;

import generic.abstractModel.*;

import java.util.ArrayList;

/**
 * This class represents the Tic tac toe game model
 * @author Phongphet
 *
 */
public class Tictactoe extends Game {

	private Player grid[][];
	private Player currentPlayer;
	private Player firstPlayer;
	private Player secondPlayer;

	/**
	 * Constructor of tic tac toe game
	 */
	public Tictactoe() {

		grid = new Player[3][3];

		// creation des joueurs
		firstPlayer = new Player("J1");
		secondPlayer = new Player("J2");

		currentPlayer = firstPlayer;
	}

	/**
	 * This method applies the action given in the method parameter to the current state of the game
	 */
	@Override
	public void doAction(GameAction action) {
		Player currentPlayer = ((TictactoeAction) action).getPlayer();
		int column = ((TictactoeAction) action).getColumn();
		int row = ((TictactoeAction) action).getRow();
		grid[column][row] = currentPlayer;
		
		if (this.caculateScore(currentPlayer) != 1) {
			this.switchPlayer();
		}
	}

	/**
	 * This method list all possible action that a player can do
	 */
	@Override
	public ArrayList<GameAction> listAllPossibleAction() {
		ArrayList<GameAction> listAllPossibleAction = new ArrayList<GameAction>();
		if (this.caculateScore(currentPlayer) != 1) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (grid[j][i] == null) {
						listAllPossibleAction.add(new TictactoeAction(currentPlayer, j, i));
					}
				}
			}
		}
		return listAllPossibleAction;
	}
	
	/**
	 * Getter of current player
	 */
	@Override
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * This method make a copy of the game
	 */
	@Override
	public Game getCopyOfGame() {
		// TODO Auto-generated method stub
		Tictactoe copyOfTictactoe = new Tictactoe();
		copyOfTictactoe.setFirstPlayer(firstPlayer);
		copyOfTictactoe.setSecondPlayer(secondPlayer);
		copyOfTictactoe.setTurnPlayer(currentPlayer);

		Player[][] copyOfGrid = new Player[3][3];
		for (int i = 0; i < copyOfGrid.length; i++) {
			for (int j = 0; j < copyOfGrid.length; j++) {
				copyOfGrid[i][j] = grid[i][j];
			}
		}
		copyOfTictactoe.setGrid(copyOfGrid);
		return copyOfTictactoe;
	}

	/**
	 * This method tells if the player given in the parameter wins the game or not
	 * it returns 1 if he wins, -1 if others win and 0 if no one wins
	 */
	@Override
	public double caculateScore(Player player) {
		// TODO Auto-generated method stub
		int win = 0;
		Player winner = null;

		if (grid[0][0] != null  && grid[0][0].equals(grid[0][1]) && grid[0][1].equals(grid[0][2])) {
			winner = grid[0][0];
		}

		if (grid[0][0] != null && grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2])) {
			winner = grid[0][0];
		}

		if (grid[0][0] != null  && grid[0][0].equals(grid[1][0]) && grid[1][0].equals(grid[2][0])) {
			winner = grid[0][0];
		}

		if (grid[1][0] != null && grid[1][0].equals(grid[1][1]) && grid[1][1].equals(grid[1][2])) {
			winner = grid[1][0];
		}
		
		if (grid[2][0] != null  && grid[2][0].equals(grid[2][1]) && grid[2][1].equals(grid[2][2])) {
			winner = grid[2][0];
		}

		if (grid[0][1] != null && grid[0][1].equals(grid[1][1]) && grid[1][1].equals(grid[2][1])) {
			winner = grid[0][1];
		}
		
		if (grid[0][2] != null  && grid[0][2].equals(grid[1][2]) && grid[1][2].equals(grid[2][2])) {
			winner = grid[0][2];
		}

		if (grid[2][0] != null && grid[2][0].equals(grid[1][1]) && grid[1][1].equals(grid[0][2])) {
			winner = grid[2][0];
		}
		
		if(winner != null){
			if(winner.equals(player)){
				win = 1;
			}else{
				win = -1;
			}
		}
		
		return win;

	}

	/**
	 * Getter of grid
	 * @return grid of tictactoe game
	 */
	public Player[][] getGrid() {
		return grid;
	}

	/**
	 * This method switches player
	 */
	public void switchPlayer() {
		if (currentPlayer.equals(firstPlayer)) {
			currentPlayer = secondPlayer;
		} else {
			currentPlayer = firstPlayer;
		}
	}

	/**
	 * Getter of first player
	 * @return first player of the game
	 */
	public Player getFirstPlayer() {
		return firstPlayer;
	}
	
	/**
	 * Setter of grid
	 * @param grid
	 */
	public void setGrid(Player[][] grid) {
		this.grid = grid;
		setChanged();
		notifyObservers();
	}

	/**
	 * Getter of second player
	 * @return second player
 	 */
	public Player getSecondPlayer() {
		return secondPlayer;
	}

	/**
	 * Setter of first player
	 * @param firstPlayer first player
	 */
	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	/**
	 * Setter of second player
	 * @param secondPlayer second player
	 */
	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
	
	/**
	 * This methode set the turn of the player
	 * @param player
	 */
	public void setTurnPlayer(Player player) {
		this.currentPlayer = player;
	}

	@Override
	public String toString() {
		String display = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				display += grid[j][i] + "	";
			}
			display += "\n";
		}
		return display;
	}
}
