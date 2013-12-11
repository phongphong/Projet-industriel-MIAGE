package gameAbstract;

import hypertree.AbstractHTNode;

import java.util.HashMap;
import java.util.Iterator;

public class NodeHypertree extends AbstractHTNode {
	
	private Arbre a;
	private HashMap<Arbre, NodeHypertree> children = null;

	public NodeHypertree(Arbre a) {
		super();
		this.a = a;
		children = new HashMap<>();
		NodeHypertree fils;
		for (int i = 0; i < a.getListeNoeud().size(); i++) {
			fils = new NodeHypertree(a.getListeNoeud().get(i));
			addChild(fils);
		}
	}

	protected void addChild(NodeHypertree child) {
		children.put(child.a, child);
	}

	public Iterator<?> children() {
		return this.children.values().iterator();
	}

	/**
	 * Returns true if this node is not a directory.
	 * 
	 * @return <CODE>false</CODE> if this node is a directory; <CODE>true</CODE>
	 *         otherwise
	 */
	public boolean isLeaf() {
		return (a.getListeNoeud().isEmpty());
	}

	/**
	 * Returns the name of the file.
	 * 
	 * @return the name of the file
	 */
	public String getName() {
		return a.toString();
	}
}
