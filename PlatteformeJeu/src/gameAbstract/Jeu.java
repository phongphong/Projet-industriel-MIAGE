/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameAbstract;

import java.util.ArrayList;

/**
 *
 * @author Phongphet
 */
public interface Jeu {
    
    public Jeu jouerUnCoup(Coup c);
    
    public ArrayList<Coup> listerTousCoupPossible();
    
    public boolean gagner(Coup c);
    
    public void effacerCoup(Coup c);
}
