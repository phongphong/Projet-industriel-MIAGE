package test;

import static org.junit.Assert.*;
import gameMorpion.model.*;
import generique.gameAbstract.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestMinimaxMorpion {

	private static Partie partie;
	private static Jeu jeu;
	private static MiniMax minimax;
	private static Joueur j1;
	private static Joueur j2;
	
	@BeforeClass
	public static void setUp(){
		jeu = new Morpion();
		partie = new Partie(jeu);
		minimax = new MiniMax();
		j1 = ((Morpion) jeu).getJ1();
		j2 = ((Morpion) jeu).getJ2();
	}
	
	/*
	 * Test en cas (Profondeur = 1)
	 * |O|X| |
	 * |O| | |
	 * | | | |
	 */
	@Test
	public void testProfondeur1Case1(){
		setUp();
		
		Joueur j1 = ((Morpion) jeu).getJ1();
		Joueur j2 = ((Morpion) jeu).getJ2();
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 1, 0);
		Coup c3 = new CoupMorpion(j1, 0, 1);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		
		/*Avec la profondeur de 1, dans le cas normal (il n'y a pas le coup gagant,
		 *  le coup meilleur coup doit etre le premier element de la liste des coups possibles (genere par le jeu en cours)
		 */
		((Morpion) jeu).setTourJoueur(j2);
		Coup meilleurCoup = minimax.getMeilleurCoup(partie, 1);
		Coup coupEspere = new CoupMorpion(j2, 1, 1);
		assertEquals(coupEspere, meilleurCoup);
	}
	
	/*
	 * Test en cas (Profondeur = 1)
	 * |O|X|O|
	 * |O|X| |
	 * | | | |
	 */
	@Test
	public void testProfondeur1Case2(){
		setUp();

		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 1, 0);
		Coup c3 = new CoupMorpion(j1, 2, 0);
		Coup c4 = new CoupMorpion(j1, 0, 1);
		Coup c5 = new CoupMorpion(j2, 1, 1);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c4);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c5);
		
		((Morpion) jeu).setTourJoueur(j2);
		Coup meilleurCoup = minimax.getMeilleurCoup(partie, 1);
		Coup coupEspere = new CoupMorpion(j2, 1, 2);
		assertEquals(coupEspere, meilleurCoup);
	}
	
	/*
	 * Test en cas (Profondeur = 1)
	 * |X|O|O|
	 * |O|X| |
	 * | | | |
	 */
	@Test
	public void testProfondeur1Case3(){
		
		setUp();
		
		Coup c1 = new CoupMorpion(j1, 1, 0);
		Coup c2 = new CoupMorpion(j2, 0, 0);
		Coup c3 = new CoupMorpion(j1, 2, 0);
		Coup c4 = new CoupMorpion(j2, 1, 1);
		Coup c5 = new CoupMorpion(j1, 0, 1);
		
		
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
		Coup meilleurCoup = minimax.getMeilleurCoup(partie, 1);
		Coup coupEspere = new CoupMorpion(j2, 2, 2);
		assertEquals(coupEspere, meilleurCoup);
	}
	
	/*
	 * Test en cas (Profondeur = 2)
	 * |O|X| |
	 * |O| | |
	 * | | | |
	 */
	@Test
	public void testProfondeur2Case1(){
		setUp();
		
		Joueur j1 = ((Morpion) jeu).getJ1();
		Joueur j2 = ((Morpion) jeu).getJ2();
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 1, 0);
		Coup c3 = new CoupMorpion(j1, 0, 1);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		
		((Morpion) jeu).setTourJoueur(j2);
		Coup meilleurCoup = minimax.getMeilleurCoup(partie, 2);
		Coup coupEspere = new CoupMorpion(j2, 0, 2);
		assertEquals(coupEspere, meilleurCoup);
	}
	
	/*
	 * Test en cas (Profondeur = 2)
	 * |O|O| |
	 * |X| | |
	 * | | | |
	 */
	@Test
	public void testProfondeur2Case2(){
		setUp();
		
		Joueur j1 = ((Morpion) jeu).getJ1();
		Joueur j2 = ((Morpion) jeu).getJ2();
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 0, 1);
		Coup c3 = new CoupMorpion(j1, 1, 0);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		
		((Morpion) jeu).setTourJoueur(j2);
		Coup meilleurCoup = minimax.getMeilleurCoup(partie, 2);
		Coup coupEspere = new CoupMorpion(j2, 2, 0);
		assertEquals(coupEspere, meilleurCoup);
	}
	
	/*
	 * Test en cas (Profondeur = 2)
	 * | | | |
	 * | |O|X|
	 * | | |O|
	 */
	@Test
	public void testProfondeur2Case3(){
		setUp();
		
		Joueur j1 = ((Morpion) jeu).getJ1();
		Joueur j2 = ((Morpion) jeu).getJ2();
		Coup c1 = new CoupMorpion(j1, 1, 1);
		Coup c2 = new CoupMorpion(j2, 1, 2);
		Coup c3 = new CoupMorpion(j1, 2, 2);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		
		((Morpion) jeu).setTourJoueur(j2);
		Coup meilleurCoup = minimax.getMeilleurCoup(partie, 2);
		Coup coupEspere = new CoupMorpion(j2, 0, 0);
		assertEquals(coupEspere, meilleurCoup);
	}
	
	/*
	 * Test en cas (Profondeur = 3)
	 * |X|X|O|
	 * | | | |
	 * | | | |
	 */
	@Test
	public void testProfondeur3Case1(){
		setUp();
		
		Joueur j1 = ((Morpion) jeu).getJ1();
		Joueur j2 = ((Morpion) jeu).getJ2();
		Coup c1 = new CoupMorpion(j1, 0, 0);
		Coup c2 = new CoupMorpion(j2, 1, 0);
		Coup c3 = new CoupMorpion(j1, 2, 0);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		
		((Morpion) jeu).setTourJoueur(j2);
		Coup meilleurCoup = minimax.getMeilleurCoup(partie, 3);
		Coup coupEspere = new CoupMorpion(j2, 1, 1);
		assertEquals(coupEspere, meilleurCoup);
	}
	
	/*
	 * Test en cas (Profondeur = 3)
	 * | | |X|
	 * |X|O|O|
	 * |O| | |
	 */
	@Test
	public void testProfondeur3Case2(){
		setUp();
		
		Joueur j1 = ((Morpion) jeu).getJ1();
		Joueur j2 = ((Morpion) jeu).getJ2();
		Coup c1 = new CoupMorpion(j1, 0, 2);
		Coup c2 = new CoupMorpion(j2, 0, 1);
		Coup c3 = new CoupMorpion(j1, 1, 1);
		Coup c4 = new CoupMorpion(j2, 2, 0);
		Coup c5 = new CoupMorpion(j1, 2, 1);
		
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
		Coup meilleurCoup = minimax.getMeilleurCoup(partie, 3);
		Coup coupEspere = new CoupMorpion(j2, 0, 0);
		assertEquals(coupEspere, meilleurCoup);
	}

	/*
	 * Test en cas (Profondeur = infini)
	 * | | |X|
	 * |X|O|O|
	 * |O| | |
	 */
	@Test
	public void testProfondeurInfiniCase1(){
		setUp();
		
		Joueur j1 = ((Morpion) jeu).getJ1();
		Joueur j2 = ((Morpion) jeu).getJ2();
		Coup c1 = new CoupMorpion(j1, 0, 2);
		Coup c2 = new CoupMorpion(j2, 0, 1);
		Coup c3 = new CoupMorpion(j1, 1, 1);
		Coup c4 = new CoupMorpion(j2, 2, 0);
		Coup c5 = new CoupMorpion(j1, 2, 1);
		
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
		Coup meilleurCoup = minimax.getMeilleurCoup(partie, 10);
		Coup coupEspere = new CoupMorpion(j2, 0, 0);
		assertEquals(coupEspere, meilleurCoup);
	}
	
	/*
	 * Test en cas (Profondeur = infini)
	 * | | |X|
	 * | |O|O|
	 * | | | |
	 */
	@Test
	public void testProfondeurInfiniCase2(){
		setUp();
		
		Joueur j1 = ((Morpion) jeu).getJ1();
		Joueur j2 = ((Morpion) jeu).getJ2();
		Coup c1 = new CoupMorpion(j1, 1, 1);
		Coup c2 = new CoupMorpion(j2, 2, 0);
		Coup c3 = new CoupMorpion(j1, 2, 1);
		
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c1);
		((Morpion) jeu).setTourJoueur(j2);
		partie.jouerUnCoup(c2);
		((Morpion) jeu).setTourJoueur(j1);
		partie.jouerUnCoup(c3);
		((Morpion) jeu).setTourJoueur(j2);
		
		((Morpion) jeu).setTourJoueur(j2);
		Coup meilleurCoup = minimax.getMeilleurCoup(partie, 10);
		Coup coupEspere = new CoupMorpion(j2, 0, 1);
		assertEquals(coupEspere, meilleurCoup);
	}
}
