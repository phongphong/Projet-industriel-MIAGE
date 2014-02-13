package generique.factory;

import gameMorpion.controler.ControlMorpionGraphique;
import gameMorpion.model.Morpion;
import gameMorpion.view.ViewMorpionGraphique;
import gameRushHour.controler.ControlRushHourGraphic;
import gameRushHour.model.RushHour;
import gameRushHour.view.ViewRushHourGraphic;
import generique.gameAbstract.*;
import generique.hypertree.ControleurVueArbre;
import generique.hypertree.NodeHypertree;
import generique.hypertree.VueArbre;
import generique.jeu.Jeu;
import generique.jeu.Partie;
import hypertree.HTModel;

import java.util.ArrayList;

/**
 * Cette classe représente le contrôleur du plateforme de jeu qui gère tous les jeux
 * @author Phongphet
 */
public class GameFactory {
	
	private ArrayList<String> listeJeu;
	private AbstractView vueJeu;
	private VueArbre vueArbre;
    
    public GameFactory(){
    	listeJeu = new ArrayList<>();
    	listeJeu.add("morpion");
    	listeJeu.add("rushhour");
    }
    
    /**
     * Cette méthode lancer le jeu choisi par l'utilisateur
     * @param jeu jeu choisi par l'utilisateur
     */
    public void creerJeu(String nomJeu){
    	Jeu jeu = null;
    	Partie partie = null;
    	AbstractControler control = null;
    	
        switch(nomJeu){
            case "morpion":
            	jeu = new Morpion();
            	partie = new Partie(jeu);
            	vueJeu = new ViewMorpionGraphique(partie);
            	control = new ControlMorpionGraphique(partie);
                break;
                
            case "rushhour":
                jeu = new RushHour();
                partie = new Partie(jeu);
                vueJeu = new ViewRushHourGraphic(partie);
                control = new ControlRushHourGraphic(partie);
                break;
        }
		
		creerJeu(partie, control);
		creerArbre(partie);
    }

	private void creerJeu(Partie partie, AbstractControler control) {
		partie.addObserver(vueJeu);
		vueJeu.addMouseListener(control);
		vueJeu.addMouseMotionListener(control);
	}

	private void creerArbre(Partie partie) {
		NodeHypertree root = partie.getRacineHypertree();
		HTModel model = new HTModel(root);
		vueArbre = new VueArbre(model);
		ControleurVueArbre controlArbre = new ControleurVueArbre(vueArbre, partie);
		vueArbre.addMouseListener(controlArbre);
		partie.addObserver(vueArbre);
	}
    
    
    
    public ArrayList<String> getListeJeu(){
    	return listeJeu;
    }

	public AbstractView getVueJeu() {
		return vueJeu;
	}

	public VueArbre getVueArbre() {
		return vueArbre;
	}
}