package test;

import static org.junit.Assert.assertEquals;
import gameTictactoe.model.Tictactoe;
import gameTictactoe.model.TictactoeAction;
import generic.AI.MinMax;
import generic.AI.MinMaxNode;
import generic.abstractModel.GameAction;
import generic.abstractModel.Game;
import generic.abstractModel.Player;
import generic.abstractModel.GamePart;

import org.junit.BeforeClass;
import org.junit.Test;



public class TestMinMaxMorpion {
	

	private static GamePart partie;
	private static Game jeu;
	private static MinMax minimax;
	private static Player j1;
	private static Player j2;
	
	@BeforeClass
	public static void setUp(){
		jeu = new Tictactoe();
		partie = new GamePart(jeu);
		minimax = new MinMax();
		j1 = ((Tictactoe) jeu).getJ1();
		j2 = ((Tictactoe) jeu).getJ2();
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
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c4);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c5);
		int gagne = (int) jeu.calculScore(((Tictactoe) jeu).getJ2());
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
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c4);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c5);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c6);
		int gagne = (int) jeu.calculScore(((Tictactoe) jeu).getJ2());
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
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c4);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c5);
		int gagne = (int) minimax.lancerMinMax(jeu).getGagner();
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
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);

		int gagne = (int) minimax.lancerMinMax(jeu).getGagner();
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
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);

		int gagne = (int) minimax.lancerMinMax(jeu).getGagner();
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
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c4);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c5);

		
		MinMaxNode noeud = minimax.lancerMinMax(jeu);

		GameAction coupEspere = new TictactoeAction(((Tictactoe) jeu).getJ2(), 1, 0);
		assertEquals(coupEspere, noeud.getCoup());
		assertEquals(1, (int)noeud.getGagner());
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
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);

		MinMaxNode noeud = minimax.lancerMinMax(jeu);

		GameAction coupEspere = new TictactoeAction(((Tictactoe) jeu).getJ2(), 1, 0);
		assertEquals(coupEspere, noeud.getCoup());
		assertEquals(0, (int) noeud.getGagner());
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
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);

		MinMaxNode noeud = minimax.lancerMinMax(jeu);

		GameAction coupEspere = new TictactoeAction(((Tictactoe) jeu).getJ2(), 1, 1);
		assertEquals(coupEspere, noeud.getCoup());
		assertEquals(0, (int)noeud.getGagner());
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
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);

		MinMaxNode noeud = minimax.lancerMinMax(jeu);

		GameAction coupEspere = new TictactoeAction(((Tictactoe) jeu).getJ2(), 1, 1);
		assertEquals(coupEspere, noeud.getCoup());
		assertEquals(0, (int)noeud.getGagner());
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
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c4);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c5);

		MinMaxNode noeud = minimax.lancerMinMax(jeu);

		assertEquals(-1, (int)noeud.getGagner());
	}
}
