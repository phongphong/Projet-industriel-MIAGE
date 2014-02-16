package generic.abstractModel;

import java.util.ArrayList;
import java.util.Observable;

/**
 * This interface contains every methods that should be rewrite in each game class
 * @author Phongphet
 */
public abstract class Game extends Observable {
    
	/**
	 * This method applies an action to the current state of game
	 * @param action action of the game
	 */
    public abstract void doAction(GameAction action);
    
    /**
     * This method lists possible actions that a player can do
     * @return list of possible actions
     */
    public abstract ArrayList<GameAction> listAllPossibleAction();
    
    /**
     * This method makes a copy of elemens of a game
     * @return a copy of game
     */
    public abstract Game getCopyOfGame();
    
    /**
     * This method returns the current player of the game
     * @return a current player
     */
    public abstract Player getCurrentPlayer();
    
    /**
     * This method tells if the player wins the game or not 
     * @param player a player of the game
     * @return 1 if the player wins, -1 if the player loose or 0 if nobody wins
     */
    public abstract double caculateScore(Player player);
    
}
