package morpion.controler;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import abstractModel.Coup;

import morpion.model.CoupMorpion;
import morpion.model.Joueur;
import morpion.model.Morpion;
import morpion.view.ViewMorpionGraphique;

public class ControlMorpionGraphique implements MouseListener {

	private Morpion morpion;
	private boolean finiTour;

	public ControlMorpionGraphique(Morpion morpion) {
		this.morpion = morpion;
		finiTour = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX() / 50;
		int y = e.getY() / 50;
		Joueur j = morpion.getTourJoueur();
		Coup c = new CoupMorpion(j, x, y);
		if (morpion.listerTousCoupPossible().contains(c)) {
			morpion.jouerUnCoup(c);
			morpion.changerJoueur();
			if (morpion.gagner(c)) {
				finiTour = true;
				JOptionPane.showMessageDialog(null, j.getNom()
						+ " gagne ce tour");
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	public void lancer() {
		JFrame frame = new JFrame("Morpion");

		ViewMorpionGraphique view = new ViewMorpionGraphique(morpion);
		ControlMorpionGraphique control = new ControlMorpionGraphique(morpion);

		frame.setContentPane(view);

		view.addMouseListener(control);
		morpion.addObserver(view);

		frame.setPreferredSize(new Dimension(200, 200));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
