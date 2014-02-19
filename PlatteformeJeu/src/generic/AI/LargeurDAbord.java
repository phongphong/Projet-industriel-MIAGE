package generic.AI;

import generic.abstractModel.Game;
import generic.abstractModel.GameAction;

import java.util.ArrayList;
import java.util.LinkedList;

public class LargeurDAbord implements AI {

	private static LinkedList<Game> listNode;
	private static GameAction finalAction;

	public LargeurDAbord(Game game) {
		listNode = new LinkedList<>();
		listNode.add(game);
	}

	public GameAction calculLargeurDAbord() {
		for (Game game : listNode) {
			if (game.caculateScore(null) == 1) {
				System.out.println("fini");
				return finalAction;
			} else {
				ArrayList<GameAction> listeAllActionPossible = game.listAllPossibleAction();
				if (listeAllActionPossible.isEmpty()) {
					return null;
				} else {
					for (GameAction action : listeAllActionPossible) {
						Game copyOfGame = game.getCopyOfGame();
						copyOfGame.doAction(action);
						listNode.addLast(copyOfGame);
						finalAction = action;
					}
				}
			}
		}
		return finalAction;
	}

	class NoeudLargeurDAbord {

	}
}
