package generic.gameMotor;

import gameRushHour.controller.ControllerRushHourGraphic;
import gameRushHour.model.RushHour;
import gameRushHour.view.ViewRushHourGraphic;
import gameTictactoe.controller.ControllerTictactoeGraphic;
import gameTictactoe.model.Tictactoe;
import gameTictactoe.view.ViewTictactoeGraphic;
import generic.abstractController.AbstractControler;
import generic.abstractModel.Game;
import generic.abstractModel.GameSession;
import generic.abstractView.AbstractView;
import generic.application.Application;
import generic.application.ApplicationRushhour;
import generic.application.ApplicationTictactoe;
import generic.hypertree.HypertreeNode;
import generic.hypertree.HypertreeNodeController;
import generic.hypertree.HypertreeView;
import hypertree.HTModel;

import java.util.ArrayList;



/**
 * This class represents the factory that create every game in this application
 * @author Phongphet
 */
public class GameFactory {
	
	private ArrayList<String> listGame;
	private AbstractView viewGame;
	private HypertreeView treeView;
    
	/**
	 * Constructor of factory
	 */
    public GameFactory(){
    	listGame = new ArrayList<>();
    	listGame.add("morpion");
    	listGame.add("rushhour");
    }
    
    /**
     * This method create a game that a player select
     * @param name of the game selected by a player
     */
    public Application createGame(String gameName){
    	Application applicationGame = null;
    	
        switch(gameName){
            case "morpion":
            	applicationGame = new ApplicationTictactoe();
                break;
                
            case "rushhour":
            	applicationGame = new ApplicationRushhour();
                break;
        }
        return applicationGame;
    }

    /**
     * This methods create necessary elements for lunching the select game
     * @param part part of game
     * @param control game controller
     */
	private void createCurrentGame(GameSession part, AbstractControler control) {
		part.addObserver(viewGame);
		viewGame.addMouseListener(control);
		viewGame.addMouseMotionListener(control);
	}

	/**
	 * This method create a hypertree that relates to the game
	 * @param part part of game
	 */
	private void createTree(GameSession part) {
		HypertreeNode root = part.getRootHypertree();
		HTModel model = new HTModel(root);
		treeView = new HypertreeView(model);
		HypertreeNodeController HypertreeControl = new HypertreeNodeController(treeView, part);
		treeView.addMouseListener(HypertreeControl);
		part.addObserver(treeView);
	}
    
    /**
     * Getter of game list
     * @return game list
     */
    public ArrayList<String> getListGame(){
    	return listGame;
    }

    /**
     * Getter of game view
     * @return game view
     */
	public AbstractView getViewGame() {
		return viewGame;
	}

	/**
	 * Getter of tree view
	 * @return tree view
	 */
	public HypertreeView getViewTree() {
		return treeView;
	}
}