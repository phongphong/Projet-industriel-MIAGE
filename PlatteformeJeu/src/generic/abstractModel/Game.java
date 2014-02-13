package generic.abstractModel;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Phongphet
 */
public abstract class Game extends Observable {
    
    public abstract void jouerUnCoup(GameAction c);
    
    public abstract ArrayList<GameAction> listerTousCoupPossible();
    
    public abstract Game getCopyDeJeu();
    
    public abstract Player getJoueurEnCours();
    
    public abstract double calculScore(Player joueur);
    
}
