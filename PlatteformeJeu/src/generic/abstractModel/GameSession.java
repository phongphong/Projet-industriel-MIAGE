package generic.abstractModel;

import generic.hypertree.HypertreeNode;
import java.awt.Color;
import java.util.Observable;

/**
 * This class represent a part of the game, this class interact with the view of the game and the view of hypertree
 * @author Phongphet
 *
 */
public class GameSession extends Observable {

	private Game game;
	private HypertreeNode rootHypertree;
	private HypertreeNode currentNode;
	private HypertreeNode nodeToCenter;

	/**
	 * Constructor
	 * @param game selected game
	 */
	public GameSession(Game game) {
		this.game = game;
		rootHypertree = new HypertreeNode(game.getCopyOfGame());
		currentNode = rootHypertree;
		nodeToCenter = rootHypertree;
	}

	/**
	 * When a player click on the node the hypertree, this method helps to return to the state of the game that
	 * was saved in the hypertree node clicked
	 * @param node
	 */
	public void returnToPreviousStateOfGame(HypertreeNode node) {
		game = node.getGame().getCopyOfGame();
		this.currentNode = node;
		setChanged();
		notifyObservers();
	}

	/**
	 * This method applies the giving action to the current state of game, it generates also the new child of hypertree
	 * @param action player's action
	 */
	public void doAction(GameAction action) {
		if(game.listAllPossibleAction().contains(action)){
			currentNode.setColor(Color.white);
			game.doAction(action);
			boolean actionExistedAlready = false;
			for(HypertreeNode child : currentNode.getChildren()){
				if(child.getListeAction().contains(action)){
					actionExistedAlready = true;
					currentNode = child;
					break;
				}
			}
			if(!actionExistedAlready){
				HypertreeNode newChildNode = new HypertreeNode(game.getCopyOfGame());
				newChildNode.getListeAction().add(action);
				currentNode.addChild(newChildNode);
				
				//on passe au coup suivant
				this.currentNode = newChildNode;
			}
			currentNode.setColor(Color.green);
			//on demande la mise a jour de dessin de jeu
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Getter of game
	 * @return game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Getter of hypertree root
	 * @return root
	 */
	public HypertreeNode getRootHypertree() {
		return rootHypertree;
	}

	/**
	 * Getter of current node
	 * @return current node
	 */
	public HypertreeNode getCurrentNode() {
		return currentNode;
	}

	/**
	 * Getter of node that we want to center (put it in the center of the screen)
	 * @return node to center
	 */
	public HypertreeNode getNodeToCenter() {
		return nodeToCenter;
	}

	/**
	 * Setter of node that we want to center (put it in the center of the screen)
	 * @return node to center
	 */
	public void setNodeToCenter(HypertreeNode nodeToCenter) {
		this.nodeToCenter = nodeToCenter;
	}
}
