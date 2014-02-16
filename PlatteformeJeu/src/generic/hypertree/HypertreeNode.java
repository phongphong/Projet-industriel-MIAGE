package generic.hypertree;

import generic.abstractModel.*;
import hypertree.AbstractHTNode;

import java.awt.Color;
import java.util.*;

/**
 * This class represents the hypertree node that save each state of game
 * @author Phongphet
 *
 */
public class HypertreeNode extends AbstractHTNode {

	private Game game;
	private ArrayList<GameAction> listAction;
	private ArrayList<HypertreeNode> children;
	private Color color;

	/**
	 * Constructor of HypertreeNode
	 * @param game current game
	 */
	public HypertreeNode(Game game) {
		super();
		this.game = game;
		color = new Color(255,255,255);
		listAction = new ArrayList<>();
		children = new ArrayList<>();
	}

	/**
	 * this method put child node into the current tree
	 * @param child 
	 */
	public void addChild(HypertreeNode child) {
		children.add(child);
	}

	/**
	 * this method return an iterator object of the hashmup
	 */
	public Iterator<?> children() {
		return this.children.iterator();
	}

	/**
	 * Returns true if this node is not a directory.
	 * 
	 * @return <CODE>false</CODE> if this node is a directory; <CODE>true</CODE>
	 *         otherwise
	 */
	public boolean isLeaf() {
		return (children.isEmpty());
	}

	/**
	 * Returns the name of the file.
	 * 
	 * @return the name of the file
	 */
	public String getName() {
		String nameAction = "";
		for(GameAction action : listAction){
			nameAction += action.toString();
		}
		return nameAction;
	}

	/**
	 * Getter of color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Setter of color 
	 * @param newColor new color
	 */
	public void setColor(Color newColor) {
		color=newColor;
	}

	/**
	 * Getter of game
	 * @return current game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Setter of game
	 * @param game
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Getter of action list of action 
	 * @return
	 */
	public ArrayList<GameAction> getListeAction() {
		return listAction;
	}

	/**
	 * Getter of child node
	 * @return list of child node
	 */
	public ArrayList<HypertreeNode> getChildren() {
		return children;
	}
}
