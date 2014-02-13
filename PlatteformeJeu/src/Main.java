import generic.gameMotor.*;

public class Main {
	public static void main(String[] args){
		GameFactory factory = new GameFactory();
        GameView viewGame = new GameView(factory);
        viewGame.affiche();
	}
}