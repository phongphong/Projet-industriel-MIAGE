package generic.gameMotor;

import gameRushHour.controller.ControllerRushHourGraphic;
import gameRushHour.model.RushHour;
import gameRushHour.view.ViewRushHourGraphic;
import gameTictactoe.controller.ControllerTictactoeGraphic;
import gameTictactoe.model.Tictactoe;
import gameTictactoe.view.ViewTictactoeGraphic;
import generic.abstractController.*;
import generic.abstractModel.Game;
import generic.abstractModel.GamePart;
import generic.abstractView.AbstractView;
import generic.hypertree.HypertreeNodeController;
import generic.hypertree.HypertreeNode;
import generic.hypertree.HypertreeView;
import hypertree.HTModel;

import java.util.ArrayList;



/**
 * Cette classe représente le contrôleur du plateforme de jeu qui gère tous les jeux
 * @author Phongphet
 */
public class GameFactory {
	
	private ArrayList<String> listeJeu;
	private AbstractView vueJeu;
	private HypertreeView vueArbre;
    
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
    	Game jeu = null;
    	GamePart partie = null;
    	AbstractControler control = null;
    	
        switch(nomJeu){
            case "morpion":
            	jeu = new Tictactoe();
            	partie = new GamePart(jeu);
            	vueJeu = new ViewTictactoeGraphic(partie);
            	control = new ControllerTictactoeGraphic(partie);
                break;
                
            case "rushhour":
                jeu = new RushHour();
                partie = new GamePart(jeu);
                vueJeu = new ViewRushHourGraphic(partie);
                control = new ControllerRushHourGraphic(partie);
                break;
        }
		
		creerJeu(partie, control);
		creerArbre(partie);
    }

	private void creerJeu(GamePart partie, AbstractControler control) {
		partie.addObserver(vueJeu);
		vueJeu.addMouseListener(control);
		vueJeu.addMouseMotionListener(control);
	}

	private void creerArbre(GamePart partie) {
		HypertreeNode root = partie.getRacineHypertree();
		HTModel model = new HTModel(root);
		vueArbre = new HypertreeView(model);
		HypertreeNodeController controlArbre = new HypertreeNodeController(vueArbre, partie);
		vueArbre.addMouseListener(controlArbre);
		partie.addObserver(vueArbre);
	}
    
    
    
    public ArrayList<String> getListeJeu(){
    	return listeJeu;
    }

	public AbstractView getVueJeu() {
		return vueJeu;
	}

	public HypertreeView getVueArbre() {
		return vueArbre;
	}
}