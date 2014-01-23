package generique.moteurJeu;

import generique.gameAbstract.NodeHypertree;
import generique.gameAbstract.Partie;
import hypertree.SwingHTView;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurVueArbre implements MouseListener {

	private SwingHTView view;
	private Partie p;

	public ControleurVueArbre(SwingHTView view, Partie p) {
		this.view = view;
		this.p = p;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		NodeHypertree previousNode = p.getNoeudPrecedent();
		previousNode.setColor(Color.white);
		NodeHypertree node = (NodeHypertree) view.getNodeUnderTheMouse(e);
		if (node != null) {
			p.setNoeudPrecedent(node);
			node.setColor(Color.green);
			p.revenirAncienJeu(node);	
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
