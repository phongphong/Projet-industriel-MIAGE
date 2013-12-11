package moteurJeu;

import gameAbstract.Arbre;
import gameAbstract.NodeHypertree;
import gameAbstract.Partie;
import hypertree.HyperTree;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class VueArbre extends JPanel implements Observer {

	private Arbre a;
	
	public VueArbre(Partie partie){

		this.a = partie.getRacine();
		NodeHypertree root = new NodeHypertree(a);
        HyperTree tree = new HyperTree(root);
        JPanel viewTree = tree.getView();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        viewTree.setSize(600, 600);
        this.setSize(600, 600);
        this.add(viewTree);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("je suis appele");
		Partie p = ((Partie) o);
		this.removeAll();
		this.a = p.getRacine();
		NodeHypertree root = new NodeHypertree(a);
        HyperTree tree = new HyperTree(root);
        JPanel viewTree = tree.getView();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        viewTree.setSize(600, 600);
        this.setSize(600, 600);
        this.add(viewTree);
        this.repaint();
	}
}
