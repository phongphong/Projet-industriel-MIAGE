/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractControler;

import AbstractView.ViewGame;
import Controler.RushHour.ControlRushHourGraphic;
import Model.RushHour.*;

/**
 * Cette classe représente le contrôleur du plateforme de jeu qui gère tous les jeux
 * @author Phongphet
 */
public class ControlerGame {
    
    private ViewGame viewGame;
    
    public ControlerGame(){
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
                break;
                
            case "rushhour":
                RushHour rh = new RushHour();
                ControlRushHourGraphic control = new ControlRushHourGraphic(rh);
                control.lancer();
                break;
        }
    }
    
    public static void main(String[] args){
        new ControlerGame();
    }
}
