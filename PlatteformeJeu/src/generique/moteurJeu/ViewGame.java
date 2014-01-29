/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generique.moteurJeu;

import generique.gameAbstract.AbstractControler;
import generique.gameAbstract.AbstractView;
import generique.gameAbstract.Jeu;
import generique.gameAbstract.NodeHypertree;
import generique.gameAbstract.Partie;
import hypertree.HTModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Cette classe représente la vue de la platteforme de jeu, elle liste tous les
 * jeux
 * 
 * @author Phongphet
 */
@SuppressWarnings("serial")
public class ViewGame extends JFrame {

	private GameFactory factory;
	private Dimension d;

	public ViewGame(GameFactory factory) {
		this.factory = factory;
		d = Toolkit.getDefaultToolkit().getScreenSize();
	}

	/**
	 * Cette méthode affiche l'interface de la platteforme de jeu
	 */
	public void affiche() {

		this.setTitle("Platteforme Jeu");
		this.setPreferredSize(d);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		final JPanel panel = new JPanel();

		final JPanel panelJeu = new JPanel();
		panelJeu.setSize(d.width / 2, d.height);
		panelJeu.setLayout(new BorderLayout());

		final JPanel panelArbre = new JPanel();
		panelArbre.setSize(d.width / 2, d.height);

		JMenuBar menuBar = new JMenuBar();

		JMenu menu1 = new JMenu("Jeu");
		JMenu menu2 = new JMenu("Aide");

		/*creer des menus generiquement et ajouter ses actions correspondantes*/
		ArrayList<String> listeJeu = factory.getListeJeu();
		for(final String nomJeu : listeJeu){
			JMenuItem sousMenu = new JMenuItem(nomJeu);
			menu1.add(sousMenu);
			sousMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Jeu jeu = factory.creerJeu(nomJeu);
					//je creer la partie du jeu
					Partie partie = new Partie(jeu);
					
					//Je recupere les vues et les controleurs selon le jeu et je lie la partie aux vues et controleurs
					AbstractView view = jeu.getView(partie);
					AbstractControler control = jeu.getControler(partie);
					
					
					partie.addObserver(view);
					view.addMouseListener(control);
					view.addMouseMotionListener(control);
					panelJeu.removeAll();
					panelJeu.add(view);
					
					NodeHypertree root = partie.getRacineHypertree();
					HTModel model = new HTModel(root);
					VueArbre vueArbre = new VueArbre(model);
					ControleurVueArbre controlArbre = new ControleurVueArbre(vueArbre, partie);
					vueArbre.addMouseListener(controlArbre);
					partie.addObserver(vueArbre);
					
					panelArbre.removeAll();
					panelArbre.setLayout(new BorderLayout());
					panelArbre.add(vueArbre, BorderLayout.CENTER);
					
					panel.repaint();	
				}
			});
		}

		menuBar.add(menu1);
		menuBar.add(menu2);

		
		panel.setLayout(new GridLayout(1, 2));
		panel.add(panelJeu);
		panel.add(panelArbre);

		this.setJMenuBar(menuBar);

		this.setContentPane(panel);
		this.pack();
		this.setVisible(true);
	}
}
