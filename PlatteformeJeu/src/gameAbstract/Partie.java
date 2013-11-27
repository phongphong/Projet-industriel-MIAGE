package gameAbstract;

public class Partie {
	
	private Jeu jeu;
	private Arbre racine;
	private Arbre noeudCourant;
	
	public Partie(Jeu jeu){
		this.jeu = jeu;
		racine = new Arbre(jeu);
		noeudCourant = racine;
	}
	
	public void jouerUnCoup(Coup c){
		/*A verifier si le coup n'existe pas deja, dans le cas qu'il existe deja on a juste a pointer
		 * dessus sans ajouter une nouvelle branche dans l'arbre*/
		if (jeu.listerTousCoupPossible().contains(c)) {
			Jeu jeuEnCours = jeu.jouerUnCoup(c);
			Arbre a = new Arbre(jeuEnCours);
			noeudCourant.ajouterNoeud(a);
			noeudCourant.ajouterCoup(c);
			jeu = jeuEnCours;
			noeudCourant = a;
		}
	}	
}
