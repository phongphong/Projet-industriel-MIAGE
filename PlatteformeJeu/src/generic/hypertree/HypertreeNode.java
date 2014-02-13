package generic.hypertree;

import generic.abstractModel.GameAction;
import generic.abstractModel.Game;
import hypertree.AbstractHTNode;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class HypertreeNode extends AbstractHTNode {

	private Game jeu;
	private ArrayList<GameAction> listeCoup;
	private ArrayList<HypertreeNode> children;
	private Color c;

	public HypertreeNode(Game jeu) {
		super();
		this.jeu = jeu;
		c = new Color(255,255,255);
		listeCoup = new ArrayList<>();
		children = new ArrayList<>();
	}

	public void addChild(HypertreeNode child) {
		children.add(child);
	}

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
		String nomCoup = "";
		for(GameAction c : listeCoup){
			nomCoup += c.toString();
		}
		return nomCoup;
	}

	public Color getColor() {
		return c;
	}
	
	public void setColor(Color nc) {
		c=nc;
	}

	public Game getJeu() {
		return jeu;
	}

	public void setJeu(Game jeu) {
		this.jeu = jeu;
	}

	public ArrayList<GameAction> getListeCoup() {
		return listeCoup;
	}

	public ArrayList<HypertreeNode> getChildren() {
		return children;
	}
}
