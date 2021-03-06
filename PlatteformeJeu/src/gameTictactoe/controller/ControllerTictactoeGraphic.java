package gameTictactoe.controller;


import gameTictactoe.model.*;
import gameTictactoe.view.ViewTictactoeGraphic;
import generic.AI.*;
import generic.abstractController.AbstractControler;
import generic.abstractModel.*;

import java.awt.event.MouseEvent;

/**
 * This class represents the controller of tictactoe game in graphical mode
 * @author Phongphet
 *
 */
public class ControllerTictactoeGraphic extends AbstractControler {

	private GameSession gameSession;
	private MinMax minimax;
	
	/**
	 * Constructor of the controller of tic tac toe game
	 * @param gameSession part of a tic tac toe game
	 */
	public ControllerTictactoeGraphic(GameSession gameSession) {
		this.gameSession = gameSession;
		minimax = new MinMax();
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

	public void mousePressed(MouseEvent e) {
		int x = e.getX() / 50;
		int y = e.getY() / 50;
		
		Tictactoe tictactoe = (Tictactoe) gameSession.getGame(); 
		Player currentPlayer = tictactoe.getCurrentPlayer();
		GameAction action = new TictactoeAction(currentPlayer, x, y);
		gameSession.doAction(action);
		if(tictactoe.getCurrentPlayer().equals(tictactoe.getSecondPlayer())){
			MinMaxNode minmaxNode = minimax.launchMinMax(gameSession.getGame().getCopyOfGame());
			GameAction bestMove = minmaxNode.getMove();
			System.out.println("Best move : "+bestMove);
			gameSession.doAction(bestMove);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
