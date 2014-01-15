/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generique.gameAbstract;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Phongphet
 */
public abstract class Jeu extends Observable {
    
    public abstract void jouerUnCoup(Coup c);
    
    public abstract ArrayList<Coup> listerTousCoupPossible();
    
    public abstract boolean gagner(Coup c);
    
    public abstract void effacerCoup(Coup c);
    
    public abstract AbstractView getView(Partie partie);
    
    public abstract AbstractControler getControler(Partie partie);
    
    public abstract Jeu getCopyDeJeu();
    
}
