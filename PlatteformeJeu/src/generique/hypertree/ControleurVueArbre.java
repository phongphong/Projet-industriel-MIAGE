package generique.hypertree;

import generique.abstractModel.Partie;
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
		NodeHypertree node = (NodeHypertree) view.getNodeUnderTheMouse(e);
		if (node != null) {
			p.getNoeudCourant().setColor(Color.white);
			node.setColor(Color.green);
			p.revenirAncienJeu(node);	
			p.setNoeudACentrer(node);
			view.translateToOrigin(node);
			view.repaint();
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
