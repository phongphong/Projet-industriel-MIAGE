package test;

import static org.junit.Assert.*;
import gameRushHour.model.Car;
import gameRushHour.model.RushHour;
import gameRushHour.model.RushHourAction;
import generic.AI.LargeurDAbord;
import generic.abstractModel.GameAction;
import generic.abstractModel.GameSession;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestLargeurRushhour {

	private static RushHour rushhour;
	private static GameSession gamePart;
	
	@BeforeClass
	public static void setUp(){
		rushhour = new RushHour();
		gamePart = new GameSession(rushhour);
	}
	
	@Test
	public void TestAlgo(){
		Car redCar = new Car('R', 3, 0, 2, 'h', true);
		RushHourAction actionExepcted = new RushHourAction(redCar.getNumber(), 1);
		LargeurDAbord largeurDAbord = new LargeurDAbord(rushhour);
		GameAction action = largeurDAbord.calculLargeurDAbord();
		assertEquals(actionExepcted, action);
	}

}
