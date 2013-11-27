/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moteurJeu;

import gameAbstract.Jeu;
import gameMorpion.model.*;
import gameRushHour.model.*;

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
        }
        return jeu;
    }
}