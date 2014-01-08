/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generique.moteurJeu;

import gameMorpion.model.Morpion;
import gameRushHour.model.RushHour;
import generique.gameAbstract.Jeu;

import java.util.ArrayList;

/**
 * Cette classe représente le contrôleur du plateforme de jeu qui gère tous les jeux
 * @author Phongphet
 */
public class GameFactory {
	
	private ArrayList<String> listeJeu;
    
    public GameFactory(){
    	listeJeu = new ArrayList<>();
    	listeJeu.add("morpion");
    	listeJeu.add("rushhour");
    }
    
    /**
     * Cette méthode lancer le jeu choisi par l'utilisateur
     * @param jeu jeu choisi par l'utilisateur
     */
    public Jeu creerJeu(String nomJeu){
    	Jeu jeu = null;
        switch(nomJeu){
            case "morpion":
            	jeu = new Morpion();
                break;
                
            case "rushhour":
                jeu = new RushHour();
                break;
        }
        return jeu;
    }
    
    public ArrayList<String> getListeJeu(){
    	return listeJeu;
    }
}