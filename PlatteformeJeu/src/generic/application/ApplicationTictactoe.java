package generic.application;

import gameTictactoe.controller.ControllerTictactoeGraphic;
import gameTictactoe.model.Tictactoe;
import gameTictactoe.view.ViewTictactoeGraphic;
import generic.abstractController.AbstractControler;
import generic.abstractModel.*;
import generic.abstractView.AbstractView;
import generic.hypertree.*;
import hypertree.HTModel;

public class ApplicationTictactoe extends Application{
	
	private AbstractView viewGame;
	private HypertreeView viewTree;
	
	public ApplicationTictactoe(){
		Game game = new Tictactoe();
    	GameSession gameSession = new GameSession(game);
    	viewGame = new ViewTictactoeGraphic(gameSession);
    	AbstractControler control = new ControllerTictactoeGraphic(gameSession);
    	
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
