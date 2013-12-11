/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moteurJeu;
import gameAbstract.Arbre;
import gameAbstract.Coup;
import gameAbstract.NodeHypertree;
import gameMorpion.controler.ControlMorpionGraphique;
import gameMorpion.model.Morpion;
import gameMorpion.view.ViewMorpionGraphique;
import gameRushHour.controler.ControlRushHourGraphic;
import gameRushHour.model.RushHour;
import gameRushHour.view.ViewRushHourGraphic;
import hypertree.HyperTree;
import hypertree.SwingHTView;

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
 * Cette classe représente la vue de la platteforme de jeu, elle liste tous les jeux
 * @author Phongphet
 */
@SuppressWarnings("serial")
public class ViewGame extends JFrame {
    
    private GameFactory factory;
    
    public ViewGame(GameFactory factory){
        this.factory = factory;
    }
    
    /**
     * Cette méthode affiche l'interface de la platteforme de jeu
     */
    public void affiche(){
        
        this.setTitle("Platteforme Jeu");
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(d);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        final JPanel panel = new JPanel();
        
        final JPanel panelJeu = new JPanel();
        panelJeu.setSize(d.width/2 , d.height);
        panelJeu.setLayout(new BorderLayout());
        
        final JPanel panelArbre = new JPanel();
        panelArbre.setSize(d.width/2 , d.height);
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menu1 = new JMenu("Jeu");
        JMenu menu2 = new JMenu("Aide");
        
        JMenuItem menuItem1 = new JMenuItem("Morpion");
        JMenuItem menuItem2 = new JMenuItem("RushHour");
        
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        
        menuBar.add(menu1);
        menuBar.add(menu2);
        

        
        menuItem1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Morpion morpion = (Morpion) factory.creerJeu("morpion");
				ArrayList<Arbre> listeNoeud = new ArrayList<>();
				Arbre a = new Arbre(morpion);
				ArrayList<Coup> listeCoup = morpion.listerTousCoupPossible();
				
				for(int i = 0 ; i< listeCoup.size() ; i++){
		        	Arbre a1 = new Arbre(morpion);
		        	a1.ajouterCoup(listeCoup.get(i));
		        	listeNoeud.add(a1);
		        }
				a.ajouterListeCoup(listeCoup);
				a.ajouterListeNoeud(listeNoeud);	
				
		        NodeHypertree root = new NodeHypertree(a);
		        HyperTree tree = new HyperTree(root);
		        SwingHTView viewTree = tree.getView();
	
				
				ViewMorpionGraphique view = new ViewMorpionGraphique(morpion);
				ControlMorpionGraphique control = new ControlMorpionGraphique( morpion);
				morpion.addObserver(view);
				view.addMouseListener(control);
				panelJeu.removeAll();
				panelJeu.add(view);
				
		        panelArbre.setLayout(new BorderLayout());
		        panelArbre.add(viewTree, BorderLayout.CENTER);
		        
				panel.repaint();
			}
		});
        
        menuItem2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RushHour rh = (RushHour) factory.creerJeu("rushhour");
				ViewRushHourGraphic view = new ViewRushHourGraphic(rh);
				ControlRushHourGraphic control = new ControlRushHourGraphic(rh);
				rh.addObserver(view);
				view.addMouseListener(control);
				view.addMouseMotionListener(control);
				panelJeu.removeAll();
				panelJeu.add(view);

				panel.repaint();
			}
		});

        panel.setLayout(new GridLayout(1,2));
        panel.add(panelJeu);
        panel.add(panelArbre);
        
        this.setJMenuBar(menuBar);
        
        this.setContentPane(panel);
        this.pack();
        this.setVisible(true);
    } 
}
