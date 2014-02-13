package gameMorpion.view;

import gameMorpion.model.Morpion;
import generique.gameAbstract.AbstractView;
import generique.jeu.Joueur;
import generique.jeu.Partie;

import java.awt.Graphics;
import java.util.Observable;

@SuppressWarnings("serial")
public class ViewMorpionGraphique extends AbstractView {

	private static final int TAILLE_CASE = 50;
	private Partie partie;

	public ViewMorpionGraphique(Partie partie) {
		super();
		this.partie = partie;
		this.setSize(200, 200);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Morpion jeuEnCours = (Morpion) partie.getJeu();
		
		Joueur[][] t_case = jeuEnCours.getT_case();
		for (int i = 0; i < t_case.length; i++) {
			for (int j = 0; j < t_case.length; j++) {
				g.drawRect(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
				String caractere = "";
				if (t_case[i][j] != null) {
					if (t_case[i][j].equals(jeuEnCours.getJ1())) {
						caractere = "O";
					} else if (t_case[i][j].equals(jeuEnCours.getJ2())) {
						caractere = "X";
					}
					g.drawString(caractere , i * 50 + 25, j * 50 + 25);					
				}
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.partie = ((Partie) arg0);
		repaint();
	}
}
