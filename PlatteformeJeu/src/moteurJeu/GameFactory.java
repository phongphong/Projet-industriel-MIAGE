/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moteurJeu;

import gameMorpion.controler.ControlMorpionGraphique;
import gameMorpion.model.Morpion;
import gameRushHour.controler.ControlRushHourGraphic;
import gameRushHour.model.*;

/**
 * Cette classe représente le contrôleur du plateforme de jeu qui gère tous les jeux
 * @author Phongphet
 */
public class GameFactory {
    
    private ViewGame viewGame;
    
    public GameFactory(){
        viewGame = new ViewGame(this);
        viewGame.affiche();
    }
    
    /**
     * Cette méthode lancer le jeu choisi par l'utilisateur
     * @param jeu jeu choisi par l'utilisateur
     */
    public void lancerJeu(String jeu){
        switch(jeu){
            case "morpion":
            	Morpion mp = new Morpion();
            	ControlMorpionGraphique controlMP = new ControlMorpionGraphique(mp);
            	controlMP.lancer();
                break;
                
            case "rushhour":
                RushHour rh = new RushHour();
                ControlRushHourGraphic controlRH = new ControlRushHourGraphic(rh);
                controlRH.lancer();
                break;
        }
    }
    
    public static void main(String[] args){
        new GameFactory();
    }
}