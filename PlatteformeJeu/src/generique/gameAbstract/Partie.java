package generique.gameAbstract;

import java.util.Observable;

public class Partie extends Observable  {
	
	private Jeu jeu;
	private Arbre racine;
	private Arbre noeudCourant;
	private int i;
	
	public Partie(Jeu jeu){
		this.jeu = jeu;
		racine = new Arbre(jeu);
		noeudCourant = racine;  
		i = 0;
	}
	
	public void jouerUnCoup(Coup c){
		/*A verifier si le coup n'existe pas deja, dans le cas qu'il existe deja on a juste a pointer
		 * dessus sans ajouter une nouvelle branche dans l'arbre*/
		if (jeu.listerTousCoupPossible().contains(c)) {
			Jeu jeuEnCours = jeu.jouerUnCoup(c);
			Arbre a = new Arbre(jeuEnCours);
			noeudCourant.ajouterNoeudEtCoup(a, c);
			jeu = jeuEnCours;
			noeudCourant = a;
			setChanged();
			notifyObservers();
		}
	}	
	
	public Arbre getRacine(){
		return racine;
	}
	
	public Arbre getNoeudCourant(){
		return noeudCourant;
	}
	
	public void setNoeudCourant(Arbre noeudCourant){
		this.noeudCourant = noeudCourant;
		
	}
	
	public Jeu getJeu(){
		return jeu;
	}
}
