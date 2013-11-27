import moteurJeu.*;


public class Main {
	
	public static void main(String[] args){
		GameFactory factory = new GameFactory();
        ViewGame viewGame = new ViewGame(factory);
        viewGame.affiche();
	}
}
