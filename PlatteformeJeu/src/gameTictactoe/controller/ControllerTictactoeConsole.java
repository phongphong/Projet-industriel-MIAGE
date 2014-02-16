package gameTictactoe.controller;

import gameTictactoe.model.*;
import gameTictactoe.view.ViewTictactoeConsole;
import generic.abstractModel.GameAction;
import java.util.*;

/**
 * This class represents the controller of Tic Tac Toe game in console mode
 * @author Phongphet
 *
 */
public class ControllerTictactoeConsole {
	
	/**
	 * Main class that launch the game in console mode
	 * @param args
	 */
	public static void main(String[] args){
		Tictactoe tictactoe = new Tictactoe();
		ViewTictactoeConsole view = new ViewTictactoeConsole(tictactoe);
		tictactoe.addObserver(view);
		boolean finishGame = false;
		Scanner sc = new Scanner(System.in);
		int choice;
		while(!finishGame){
			System.out.println("Ce tour est de " + tictactoe.getCurrentPlayer().getName());
			ArrayList<GameAction> listAction = tictactoe.listAllPossibleAction();
			System.out.println("Veuillez choisir le coup : ");
			for(int i=0 ; i<listAction.size() ; i++){
				System.out.println(i+". " + listAction.get(i));
			}
			choice = sc.nextInt();
			GameAction action = listAction.get(choice);
			tictactoe.doAction(action);
			tictactoe.switchPlayer();
			if(tictactoe.caculateScore(tictactoe.getCurrentPlayer()) == 1){
				System.out.println(((TictactoeAction) action).getPlayer().getName() + " gagne !!!");
				finishGame = true;
			}
		}
	}
}
