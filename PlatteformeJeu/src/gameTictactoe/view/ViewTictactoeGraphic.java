package gameTictactoe.view;

import gameTictactoe.model.Tictactoe;
import generic.abstractModel.*;
import generic.abstractView.AbstractView;

import java.awt.Graphics;
import java.util.Observable;


@SuppressWarnings("serial")
public class ViewTictactoeGraphic extends AbstractView {

	private static final int GAME_HEIGHT = 200;
	private static final int GAME_WIDTH = 200;
	private static final int CELL_SIZE = 50;
	private GamePart part;

	/**
	 * Constructor of ViewTictactoeGraphic class
	 * @param part part of tic tac toe game
	 */
	public ViewTictactoeGraphic(GamePart part) {
		super();
		this.part = part;
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Tictactoe currentGame = (Tictactoe) part.getGame();
		
		Player[][] grid = currentGame.getGrid();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
				String playerSign = "";
				if (grid[i][j] != null) {
					if (grid[i][j].equals(currentGame.getFirstPlayer())) {
						playerSign = "O";
					} else if (grid[i][j].equals(currentGame.getSecondPlayer())) {
						playerSign = "X";
					}
					g.drawString(playerSign , i * CELL_SIZE + (CELL_SIZE / 2), j * CELL_SIZE + (CELL_SIZE / 2));					
				}
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.part = ((GamePart) arg0);
		repaint();
	}
}
