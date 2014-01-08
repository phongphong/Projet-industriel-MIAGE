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
    
    public abstract Jeu jouerUnCoup(Coup c);
    
    public abstract ArrayList<Coup> listerTousCoupPossible();
    
    public abstract boolean gagner(Coup c);
    
    public abstract void effacerCoup(Coup c);
    
    public abstract AbstractView getView();
    
    public abstract AbstractControler getControler();
    
    public abstract Jeu copyDeJeu();
}
