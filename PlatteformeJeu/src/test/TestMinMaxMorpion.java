package test;

import static org.junit.Assert.assertEquals;
import gameMorpion.model.CoupMorpion;
import gameMorpion.model.Morpion;
import generique.gameAbstract.Coup;
import generique.gameAbstract.Jeu;
import generique.gameAbstract.Joueur;
import generique.gameAbstract.Partie;

import org.junit.BeforeClass;
import org.junit.Test;

import IA.MinMax;
import IA.NoeudMinMax;

public class TestMinMaxMorpion {
	

	private static Partie partie;
	private static Jeu jeu;
	private static MinMax minimax;
	private static Joueur j1;
	private static Joueur j2;
	
	@BeforeClass
	public static void setUp(){
		jeu = new Morpion();
		partie = new Partie(jeu);
		minimax = new MinMax();
		j1 = ((Morpion) jeu).getJ1();
		j2 = ((Morpion) jeu).getJ2();
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
		
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 1, 0);
		Coup c3 = new CoupMorpion(j1, 0, 1);
		Coup c4 = new CoupMorpion(j2, 1, 1);
		Coup c5 = new CoupMorpion(j1, 0, 2);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c4);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c5);
		int gagne = (int) jeu.calculScore(((Morpion) jeu).getJ2());
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
		
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 1, 0);
		Coup c3 = new CoupMorpion(j1, 2, 0);
		Coup c4 = new CoupMorpion(j2, 1, 1);
		Coup c5 = new CoupMorpion(j1, 0, 2);
		Coup c6 = new CoupMorpion(j2, 1, 2);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c4);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c5);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c6);
		int gagne = (int) jeu.calculScore(((Morpion) jeu).getJ2());
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
		
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 1, 0);
		Coup c3 = new CoupMorpion(j1, 2, 0);
		Coup c4 = new CoupMorpion(j2, 1, 1);
		Coup c5 = new CoupMorpion(j1, 2, 2);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c4);
		((Morpion) jeu).setTourJoueur(j1);
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
		
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 1, 0);
		Coup c3 = new CoupMorpion(j1, 0, 1);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
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
		
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 0, 1);
		Coup c3 = new CoupMorpion(j1, 1, 0);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
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
		
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 1, 1);
		Coup c3 = new CoupMorpion(j1, 2, 2);
		Coup c4 = new CoupMorpion(j2, 2, 1);
		Coup c5 = new CoupMorpion(j1, 2, 0);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c4);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c5);

		
		NoeudMinMax noeud = minimax.lancerMinMax(jeu);

		Coup coupEspere = new CoupMorpion(((Morpion) jeu).getJ2(), 1, 0);
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
		
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 1, 1);
		Coup c3 = new CoupMorpion(j1, 2, 2);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);

		NoeudMinMax noeud = minimax.lancerMinMax(jeu);

		Coup coupEspere = new CoupMorpion(((Morpion) jeu).getJ2(), 1, 0);
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
		
		Coup c1 = new CoupMorpion(j1, 0, 0);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);

		NoeudMinMax noeud = minimax.lancerMinMax(jeu);

		Coup coupEspere = new CoupMorpion(((Morpion) jeu).getJ2(), 1, 1);
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
		
		Coup c1 = new CoupMorpion(j1, 0, 0);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);

		NoeudMinMax noeud = minimax.lancerMinMax(jeu);

		Coup coupEspere = new CoupMorpion(((Morpion) jeu).getJ2(), 1, 1);
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
		
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 1, 0);
		Coup c3 = new CoupMorpion(j1, 2, 0);
		Coup c4 = new CoupMorpion(j2, 0, 1);
		Coup c5 = new CoupMorpion(j1, 1, 1);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c4);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c5);

		NoeudMinMax noeud = minimax.lancerMinMax(jeu);

		assertEquals(-1, (int)noeud.getGagner());
	}
}
