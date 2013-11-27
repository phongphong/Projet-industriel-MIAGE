package gameAbstract;

public class Partie {
	
	private Jeu jeu;
	private Arbre arbre;
	private Arbre arbreCourant;
	
	public Partie(Jeu jeu){
		this.jeu = jeu;
		arbre = new Arbre(jeu);
		arbreCourant = arbre;
	}
	
	public void jouerUnePartie(Coup c){
		if (jeu.listerTousCoupPossible().contains(c)) {
			Jeu jeuEnCours = jeu.jouerUnCoup(c);
			jeu = jeuEnCours;
			Arbre a = new Arbre(jeuEnCours, c);
			arbreCourant.ajouterNoeud(a);
			arbreCourant = a;
			afficheArbre();
		}
	}
	
	public void afficheArbre(){
		int indice = 0;
		while(arbre.getListeNoeud().size() > 0 && indice < arbre.getListeNoeud().size()){
			Arbre a = arbre.getListeNoeud().get(indice);
			System.out.println("Jeu : " + a.getJeu().toString() + " | " + "Coup : " + a.getCoup().toString());
			indice ++ ;
		}
	}
	
}
