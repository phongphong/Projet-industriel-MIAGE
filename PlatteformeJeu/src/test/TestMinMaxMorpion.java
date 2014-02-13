package test;

import static org.junit.Assert.assertEquals;
import gameTictactoe.model.Tictactoe;
import gameTictactoe.model.TictactoeAction;
import generic.AI.MinMax;
import generic.AI.NoeudMinMax;
import generic.abstractModel.Coup;
import generic.abstractModel.Jeu;
import generic.abstractModel.Joueur;
import generic.abstractModel.Partie;

import org.junit.BeforeClass;
import org.junit.Test;



public class TestMinMaxMorpion {
	

	private static Partie partie;
	private static Jeu jeu;
	private static MinMax minimax;
	private static Joueur j1;
	private static Joueur j2;
	
	@BeforeClass
	public static void setUp(){
		jeu = new Tictactoe();
		partie = new Partie(jeu);
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
		
		Coup c1 = new TictactoeAction(j1, 0, 0);
		Coup c2 = new TictactoeAction(j2, 1, 0);
		Coup c3 = new TictactoeAction(j1, 0, 1);
		Coup c4 = new TictactoeAction(j2, 1, 1);
		Coup c5 = new TictactoeAction(j1, 0, 2);
		
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
		
		Coup c1 = new TictactoeAction(j1, 0, 0);
		Coup c2 = new TictactoeAction(j2, 1, 0);
		Coup c3 = new TictactoeAction(j1, 2, 0);
		Coup c4 = new TictactoeAction(j2, 1, 1);
		Coup c5 = new TictactoeAction(j1, 0, 2);
		Coup c6 = new TictactoeAction(j2, 1, 2);
		
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
		
		Coup c1 = new TictactoeAction(j1, 0, 0);
		Coup c2 = new TictactoeAction(j2, 1, 0);
		Coup c3 = new TictactoeAction(j1, 2, 0);
		Coup c4 = new TictactoeAction(j2, 1, 1);
		Coup c5 = new TictactoeAction(j1, 2, 2);
		
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
		
		Coup c1 = new TictactoeAction(j1, 0, 0);
		Coup c2 = new TictactoeAction(j2, 1, 0);
		Coup c3 = new TictactoeAction(j1, 0, 1);
		
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
		
		Coup c1 = new TictactoeAction(j1, 0, 0);
		Coup c2 = new TictactoeAction(j2, 0, 1);
		Coup c3 = new TictactoeAction(j1, 1, 0);
		
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
		
		Coup c1 = new TictactoeAction(j1, 0, 0);
		Coup c2 = new TictactoeAction(j2, 1, 1);
		Coup c3 = new TictactoeAction(j1, 2, 2);
		Coup c4 = new TictactoeAction(j2, 2, 1);
		Coup c5 = new TictactoeAction(j1, 2, 0);
		
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

		
		NoeudMinMax noeud = minimax.lancerMinMax(jeu);

		Coup coupEspere = new TictactoeAction(((Tictactoe) jeu).getJ2(), 1, 0);
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
		
		Coup c1 = new TictactoeAction(j1, 0, 0);
		Coup c2 = new TictactoeAction(j2, 1, 1);
		Coup c3 = new TictactoeAction(j1, 2, 2);
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Tictactoe) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);

		NoeudMinMax noeud = minimax.lancerMinMax(jeu);

		Coup coupEspere = new TictactoeAction(((Tictactoe) jeu).getJ2(), 1, 0);
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
		
		Coup c1 = new TictactoeAction(j1, 0, 0);
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);

		NoeudMinMax noeud = minimax.lancerMinMax(jeu);

		Coup coupEspere = new TictactoeAction(((Tictactoe) jeu).getJ2(), 1, 1);
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
		
		Coup c1 = new TictactoeAction(j1, 0, 0);
		
		((Tictactoe) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);

		NoeudMinMax noeud = minimax.lancerMinMax(jeu);

		Coup coupEspere = new TictactoeAction(((Tictactoe) jeu).getJ2(), 1, 1);
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
		
		Coup c1 = new TictactoeAction(j1, 0, 0);
		Coup c2 = new TictactoeAction(j2, 1, 0);
		Coup c3 = new TictactoeAction(j1, 2, 0);
		Coup c4 = new TictactoeAction(j2, 0, 1);
		Coup c5 = new TictactoeAction(j1, 1, 1);
		
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

		NoeudMinMax noeud = minimax.lancerMinMax(jeu);

		assertEquals(-1, (int)noeud.getGagner());
	}
}
