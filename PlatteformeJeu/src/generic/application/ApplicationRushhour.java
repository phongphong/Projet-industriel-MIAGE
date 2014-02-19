package generic.application;

import gameRushHour.controller.ControllerRushHourGraphic;
import gameRushHour.model.RushHour;
import gameRushHour.view.ViewRushHourGraphic;
import generic.abstractController.AbstractControler;
import generic.abstractModel.*;
import generic.abstractView.AbstractView;
import generic.hypertree.*;
import hypertree.HTModel;

public class ApplicationRushhour extends Application {
	
	private AbstractView viewGame;
	private HypertreeView viewTree;
	
	public ApplicationRushhour(){
		Game game = new RushHour();
    	GameSession gameSession = new GameSession(game);
    	viewGame = new ViewRushHourGraphic(gameSession);
    	AbstractControler control = new ControllerRushHourGraphic(gameSession);
    	
    	gameSession.addObserver(viewGame);
		viewGame.addMouseListener(control);
		
		HypertreeNode root = gameSession.getRootHypertree();
		HTModel model = new HTModel(root);
		viewTree = new HypertreeView(model);
		HypertreeNodeController HypertreeControl = new HypertreeNodeController(viewTree, gameSession);
		viewTree.addMouseListener(HypertreeControl);
		gameSession.addObserver(viewTree);
	}

	@Override
	public AbstractView getViewGame() {
		return viewGame;
	}

	@Override
	public HypertreeView getViewHypertree() {
		return viewTree;
	}

}
