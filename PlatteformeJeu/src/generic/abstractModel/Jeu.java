package generic.abstractModel;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Phongphet
 */
public abstract class Jeu extends Observable {
    
    public abstract void jouerUnCoup(Coup c);
    
    public abstract ArrayList<Coup> listerTousCoupPossible();
    
    public abstract Jeu getCopyDeJeu();
    
    public abstract Joueur getJoueurEnCours();
    
    public abstract double calculScore(Joueur joueur);
    
}
