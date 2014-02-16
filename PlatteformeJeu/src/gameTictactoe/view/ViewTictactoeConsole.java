package gameTictactoe.view;

import gameTictactoe.model.Tictactoe;
import generic.abstractModel.Player;

import java.util.*;

/**
 * This class represents the view of Tictactoe game in console mode
 * @author Phongphet
 *
 */
public class ViewTictactoeConsole implements Observer{

	private Tictactoe tictactoe;
	
	/**
	 * Constructor of ViewTictactoe class
	 * @param tictactoe
	 */
	public ViewTictactoeConsole(Tictactoe tictactoe){
		this.tictactoe = tictactoe;
	}
	
	/**
	 * This method display the grid of tic tac toe game in console mode
	 */
	public void display(){
		Player[][] grid = tictactoe.getGrid();
		for(int i=0 ; i<grid.length ; i++){
			for(int j=0 ; j<grid.length ; j++){
				if(grid[j][i].equals(tictactoe.getFirstPlayer())){
					System.out.print("O" + "	");
				}else if(grid[j][i].equals(tictactoe.getSecondPlayer())){
					System.out.print("X" + "	");
				}else{
					System.out.print("." + "	");
				}
			}
			System.out.println();
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.tictactoe = (Tictactoe)o;
		this.display();
	}
}
