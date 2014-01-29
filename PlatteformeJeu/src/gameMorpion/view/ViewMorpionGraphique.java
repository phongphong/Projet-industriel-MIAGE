package gameMorpion.view;

import gameMorpion.model.Morpion;
import generique.gameAbstract.AbstractView;
import generique.gameAbstract.Partie;

import java.awt.Graphics;
import java.util.Observable;


@SuppressWarnings("serial")
public class ViewMorpionGraphique extends AbstractView {

	private Partie partie;

	public ViewMorpionGraphique(Partie partie) {
		super();
		this.partie =  partie;
		this.setSize(200, 200);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		char[][] t_case = ((Morpion) partie.getJeu()).getT_case();
		for (int i = 0; i < t_case.length; i++) {
			for (int j = 0; j < t_case.length; j++) {
				g.drawRect(i * 50, j * 50, 50, 50);
				if(t_case[i][j] != '.'){
					 g.drawString(String.valueOf(t_case[i][j]), i * 50 + 25, j * 50 + 25);
				}
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.partie =((Partie) arg0);
		repaint();
	}
}
