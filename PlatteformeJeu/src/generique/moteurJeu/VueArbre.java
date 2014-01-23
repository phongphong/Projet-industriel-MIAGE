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
	
	public VueArbre(Partie p){
		creerArbre(p);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Partie p = ((Partie) o);
		this.removeAll();
		creerArbre(p);
        this.repaint();
	}
	
	public void creerArbre(Partie p){
		NodeHypertree root = p.getRacineHypertree();
        HyperTree tree = new HyperTree(root);
        
        JPanel viewTree = tree.getView();
        viewTree.setSize(600, 600);
        this.setSize(600, 600);
        ControleurVueArbre control = new ControleurVueArbre((SwingHTView)viewTree, p);
        viewTree.addMouseListener(control);
        this.add(viewTree);
	}
}
