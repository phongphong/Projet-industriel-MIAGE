package generic.AI;

import java.util.ArrayList;


import gameTictactoe.model.Tictactoe;
import generic.abstractModel.*;

/**
 * This class represents the implementation of MinMax algorithm
 * @author Phongphet
 *
 */
public class MinMax implements AI {

	private static final int MIN_VAL = 1000;
	private static final int MAX_VAL = -1000;

	public MinMax() {

	}
	
	/**
	 * This method launch the minmax algorithm to the game given in the parameter
	 * @param game game that we're launching min max algorithm on
	 * @return MinMax Node which is the best node in min max tree, it contains the best move and best score
	 */
	public MinMaxNode launchMinMax(Game game){
		return minmax(game, game.getCurrentPlayer());
	}
 
	/**
	 * This function implements minmax tree and find the best node in the tree
	 * @param game current game
	 * @return best move
	 */
	private MinMaxNode minmax(Game game, Player currentPlayer) {

		int max_value = MAX_VAL;
		int min_value = MIN_VAL;
		MinMaxNode bestMove = null;

		double win = game.caculateScore(currentPlayer);
		if(win != 0){
			return new MinMaxNode(null, win);
		}
		
		ArrayList<GameAction> listAllPossibleAction = game.listAllPossibleAction();
		if (listAllPossibleAction.isEmpty()) {
			return new MinMaxNode(null, 0);
		}

		for (GameAction currentMove : listAllPossibleAction) {
			
			Game copyOfGame = game.getCopyOfGame();
			copyOfGame.doAction(currentMove);
			MinMaxNode childNode;
			
			if (game.getCurrentPlayer().equals(currentPlayer)) {
				childNode = minmax(copyOfGame, currentPlayer);
				if (childNode.getWin() > max_value) {
					max_value = (int) childNode.getWin();
					bestMove = new MinMaxNode(currentMove, max_value);
				}
			} else {
				
				childNode = minmax(copyOfGame, currentPlayer);
				if (childNode.getWin() < min_value) {
					min_value = (int) childNode.getWin();
					bestMove = new MinMaxNode(currentMove, min_value);
				}
			}
		}

		return bestMove;
	}
}
