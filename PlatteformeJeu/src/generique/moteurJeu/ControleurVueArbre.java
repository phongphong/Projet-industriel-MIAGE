package generique.moteurJeu;

import generique.gameAbstract.Arbre;
import generique.gameAbstract.Coup;
import generique.gameAbstract.Jeu;
import generique.gameAbstract.NodeHypertree;
import generique.gameAbstract.Partie;
import hypertree.SwingHTView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
			Arbre noeudChoisi = node.getArbre();
			this.enleverCoup(noeudChoisi);
			p.setNoeudCourant(noeudChoisi);
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

	public void enleverCoup(Arbre a) {
		ArrayList<Arbre> listeNoeud = a.getListeNoeud();
		if (!listeNoeud.isEmpty()) {
			for (int i = 0; i < listeNoeud.size(); i++) {
				ArrayList<Coup> listeCoupJoues = listeNoeud.get(i).getListeCoup(); 
				if(!listeCoupJoues.isEmpty()){
					Coup c = listeNoeud.get(i).getListeCoup().get(0);
					p.getJeu().effacerCoup(c);
					enleverCoup(listeNoeud.get(i));
				}
			}
		}
	}

}
