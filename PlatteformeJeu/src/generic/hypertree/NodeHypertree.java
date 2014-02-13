package generic.hypertree;

import generic.abstractModel.Coup;
import generic.abstractModel.Jeu;
import hypertree.AbstractHTNode;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class NodeHypertree extends AbstractHTNode {

	private Jeu jeu;
	private ArrayList<Coup> listeCoup;
	private ArrayList<NodeHypertree> children;
	private Color c;

	public NodeHypertree(Jeu jeu) {
		super();
		this.jeu = jeu;
		c = new Color(255,255,255);
		listeCoup = new ArrayList<>();
		children = new ArrayList<>();
	}

	public void addChild(NodeHypertree child) {
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
		for(Coup c : listeCoup){
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

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public ArrayList<Coup> getListeCoup() {
		return listeCoup;
	}

	public ArrayList<NodeHypertree> getChildren() {
		return children;
	}
}
