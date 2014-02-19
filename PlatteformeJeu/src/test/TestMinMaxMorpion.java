package test;

import static org.junit.Assert.assertEquals;
import gameTictactoe.model.Tictactoe;
import gameTictactoe.model.TictactoeAction;
import generic.AI.MinMax;
import generic.AI.MinMaxNode;
import generic.abstractModel.GameAction;
import generic.abstractModel.Game;
import generic.abstractModel.Player;
import generic.abstractModel.GameSession;

import org.junit.BeforeClass;
import org.junit.Test;



public class TestMinMaxMorpion {
	

	private static GameSession partie;
	private static Game jeu;
	private static MinMax minimax;
	private static Player j1;
	private static Player j2;
	
	@BeforeClass
	public static void setUp(){
		jeu = new Tictactoe();
		partie = new GameSession(jeu);
		minimax = new MinMax();
		j1 = ((Tictactoe) jeu).getFirstPlayer();
		j2 = ((Tictactoe) jeu).getSecondPlayer();
	}
	
	/*
	 * Test du score en cas
	 * |O|X| |
	 * |O|X| |
	 * |O| | |
	 */
	@Test
	public void testCalculScore1(){
		setUp();
		
		GameAction c1 = new TictactoeAction(j1, 0, 0);
		GameAction c2 = new TictactoeAction(j2, 1, 0);
		GameAction c3 = new TictactoeAction(j1, 0, 1);
		GameAction c4 = new TictactoeAction(j2, 1, 1);
		GameAction c5 = new TictactoeAction(j1, 0, 2);
		
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c1);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c2);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c3);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c4);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c5);
		int gagne = (int) jeu.caculateScore(((Tictactoe) jeu).getSecondPlayer());
		assertEquals(-1, gagne);
	}
	
	/*
	 * Test du score en cas
	 * |O|X|O|
	 * | |X| |
	 * |O|X| |
	 */
	@Test
	public void testCalculScore2(){
		setUp();
		
		GameAction c1 = new TictactoeAction(j1, 0, 0);
		GameAction c2 = new TictactoeAction(j2, 1, 0);
		GameAction c3 = new TictactoeAction(j1, 2, 0);
		GameAction c4 = new TictactoeAction(j2, 1, 1);
		GameAction c5 = new TictactoeAction(j1, 0, 2);
		GameAction c6 = new TictactoeAction(j2, 1, 2);
		
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c1);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c2);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c3);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c4);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c5);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c6);
		int gagne = (int) jeu.caculateScore(((Tictactoe) jeu).getSecondPlayer());
		assertEquals(1, gagne);
	}
	
	/*
	 * Test du score en cas
	 * |O|X|O|
	 * | |X| |
	 * | | |O|
	 */
	@Test
	public void testMinmax1(){
		setUp();
		
		GameAction c1 = new TictactoeAction(j1, 0, 0);
		GameAction c2 = new TictactoeAction(j2, 1, 0);
		GameAction c3 = new TictactoeAction(j1, 2, 0);
		GameAction c4 = new TictactoeAction(j2, 1, 1);
		GameAction c5 = new TictactoeAction(j1, 2, 2);
		
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c1);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c2);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c3);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c4);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c5);
		int gagne = (int) minimax.launchMinMax(jeu).getWin();
		assertEquals(1, gagne);
	}
	
	/*
	 * Test du score en cas
	 * |O|X| |
	 * |O| | |
	 * | | | |
	 */
	@Test
	public void testMinmax2(){
		setUp();
		
		GameAction c1 = new TictactoeAction(j1, 0, 0);
		GameAction c2 = new TictactoeAction(j2, 1, 0);
		GameAction c3 = new TictactoeAction(j1, 0, 1);
		
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c1);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c2);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c3);

		int gagne = (int) minimax.launchMinMax(jeu).getWin();
		assertEquals(-1, gagne);
	}

	/*
	 * Test du score en cas
	 * |O|O| |
	 * |X| | |
	 * | | | |
	 */
	@Test
	public void testMinmax3(){
		setUp();
		
		GameAction c1 = new TictactoeAction(j1, 0, 0);
		GameAction c2 = new TictactoeAction(j2, 0, 1);
		GameAction c3 = new TictactoeAction(j1, 1, 0);
		
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c1);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c2);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c3);

		int gagne = (int) minimax.launchMinMax(jeu).getWin();
		assertEquals(-1, gagne);
	}
	
	/*
	 * Test du score en cas
	 * |O| |O|
	 * | |X|X|
	 * | | |O|
	 */
	@Test
	public void testMinmax4(){
		setUp();
		
		GameAction c1 = new TictactoeAction(j1, 0, 0);
		GameAction c2 = new TictactoeAction(j2, 1, 1);
		GameAction c3 = new TictactoeAction(j1, 2, 2);
		GameAction c4 = new TictactoeAction(j2, 2, 1);
		GameAction c5 = new TictactoeAction(j1, 2, 0);
		
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c1);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c2);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c3);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c4);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c5);

		
		MinMaxNode noeud = minimax.launchMinMax(jeu);

		GameAction coupEspere = new TictactoeAction(((Tictactoe) jeu).getSecondPlayer(), 1, 0);
		assertEquals(coupEspere, noeud.getMove());
		assertEquals(1, (int)noeud.getWin());
	}
	
	/*
	 * Test du score en cas
	 * |O| | |
	 * | |X| |
	 * | | |O|
	 */
	@Test
	public void testMinmax5(){
		setUp();
		
		GameAction c1 = new TictactoeAction(j1, 0, 0);
		GameAction c2 = new TictactoeAction(j2, 1, 1);
		GameAction c3 = new TictactoeAction(j1, 2, 2);
		
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c1);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c2);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c3);

		MinMaxNode noeud = minimax.launchMinMax(jeu);

		GameAction coupEspere = new TictactoeAction(((Tictactoe) jeu).getSecondPlayer(), 1, 0);
		assertEquals(coupEspere, noeud.getMove());
		assertEquals(0, (int) noeud.getWin());
	}
	
	/*
	 * Test du score en cas
	 * |O| | |
	 * | | | |
	 * | | | |
	 */
	@Test
	public void testMinmax6(){
		setUp();
		
		GameAction c1 = new TictactoeAction(j1, 0, 0);
		
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c1);

		MinMaxNode noeud = minimax.launchMinMax(jeu);

		GameAction coupEspere = new TictactoeAction(((Tictactoe) jeu).getSecondPlayer(), 1, 1);
		assertEquals(coupEspere, noeud.getMove());
		assertEquals(0, (int)noeud.getWin());
	}
	
	/*
	 * Test du score en cas
	 * | | | |
	 * | | | |
	 * | | | |
	 */
	@Test
	public void testMinmax7(){
		setUp();
		
		GameAction c1 = new TictactoeAction(j1, 0, 0);
		
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c1);

		MinMaxNode noeud = minimax.launchMinMax(jeu);

		GameAction coupEspere = new TictactoeAction(((Tictactoe) jeu).getSecondPlayer(), 1, 1);
		assertEquals(coupEspere, noeud.getMove());
		assertEquals(0, (int)noeud.getWin());
	}
	
	/*
	 * Test du score en cas
	 * |O|X|O|
	 * |X|O| |
	 * | | | |
	 */
	@Test
	public void testMinmax8(){
		setUp();
		
		GameAction c1 = new TictactoeAction(j1, 0, 0);
		GameAction c2 = new TictactoeAction(j2, 1, 0);
		GameAction c3 = new TictactoeAction(j1, 2, 0);
		GameAction c4 = new TictactoeAction(j2, 0, 1);
		GameAction c5 = new TictactoeAction(j1, 1, 1);
		
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c1);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c2);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c3);
		((Tictactoe) jeu).setTurnPlayer(j2);
		partie.doAction(c4);
		((Tictactoe) jeu).setTurnPlayer(j1);
		partie.doAction(c5);

		MinMaxNode noeud = minimax.launchMinMax(jeu);

		assertEquals(-1, (int)noeud.getWin());
	}
}
