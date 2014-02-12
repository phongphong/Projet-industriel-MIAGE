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
    
    public abstract AbstractView getView(Partie partie);
    
    public abstract AbstractControler getControler(Partie partie);
    
    public abstract Jeu getCopyDeJeu();
    
    public abstract Joueur getJoueurEnCours();
    
    public abstract Joueur getJoueurQuiDoitGagnerMinMax();
    
    public abstract void changerJoueur();
    
    public abstract double calculScore(Joueur joueur);
    
}
