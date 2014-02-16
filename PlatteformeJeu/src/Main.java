import generic.gameMotor.*;

/**
 * This is a main class of the game application
 * @author Phongphet
 *
 */
public class Main {
	
	/**
	 * This is a main method that launch the game
	 * @param args
	 */
	public static void main(String[] args){	
		
		GameFactory factory = new GameFactory();
        GameView viewGame = new GameView(factory);
        viewGame.display();
	
	}
}