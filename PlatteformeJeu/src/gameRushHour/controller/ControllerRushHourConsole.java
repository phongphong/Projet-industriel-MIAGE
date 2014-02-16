package gameRushHour.controller;

import gameRushHour.model.RushHour;
import gameRushHour.view.ViewRushHourConsole;
import generic.abstractModel.GameAction;

import java.util.*;

/**
 * This class repersents the controller of rushhour game in console mode
 * @author Phongphet
 */
public class ControllerRushHourConsole {

	/**
	 * This is a main method that launch the rushhour game in console mode
	 * @param args
	 */
	public static void main(String[] args) {
		
		RushHour rushhour = new RushHour();
		ViewRushHourConsole view = new ViewRushHourConsole(rushhour);
		rushhour.addObserver(view);
		view.display();
		ArrayList<GameAction> listAction;
		Scanner sc = new Scanner(System.in);
		int choice;
		boolean finishGame = false;
		while (!finishGame) {
			System.out.println("Which action do you want to do?");
			listAction = rushhour.listAllPossibleAction();
			for (int j = 0; j < listAction.size(); j++) {
				System.out.println(j + ". " + listAction.get(j).toString());
			}
			choice = sc.nextInt();
			rushhour.doAction(listAction.get(choice));
		}
	}
}
