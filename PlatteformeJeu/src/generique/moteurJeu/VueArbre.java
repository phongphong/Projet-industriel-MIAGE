package generique.moteurJeu;

import generique.gameAbstract.Arbre;
import generique.gameAbstract.NodeHypertree;
import generique.gameAbstract.Partie;
import hypertree.HyperTree;
import hypertree.SwingHTView;

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
        viewTree.setSize(600, 600);
        this.setSize(600, 600);
        ControleurVueArbre control = new ControleurVueArbre((SwingHTView)viewTree, partie);
        viewTree.addMouseListener(control);
        this.add(viewTree);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Partie p = ((Partie) o);
		this.removeAll();
		this.a = p.getRacine();
		NodeHypertree root = new NodeHypertree(a);
        HyperTree tree = new HyperTree(root);
        JPanel viewTree = tree.getView();
        viewTree.setSize(600, 600);
        this.setSize(600, 600);
        ControleurVueArbre control = new ControleurVueArbre((SwingHTView)viewTree, p);
        viewTree.addMouseListener(control);
        this.add(viewTree);
        this.repaint();
	}
}
