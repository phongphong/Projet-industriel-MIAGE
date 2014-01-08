/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generique.moteurJeu;

import gameMorpion.model.*;
import gameRushHour.model.*;
import generique.gameAbstract.Jeu;

/**
 * Cette classe représente le contrôleur du plateforme de jeu qui gère tous les jeux
 * @author Phongphet
 */
public class GameFactory {
    
    public GameFactory(){
    	
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
            case "sa;ega;e":
                jeu = new samegame();
                break;
        }
        return jeu;
    }
}