package generique.gameAbstract;

import java.util.Observable;
public class Partie extends Observable {

	private Jeu jeu;
	private Arbre racine;
	private Arbre noeudCourant;
	

	public Partie(Jeu jeu) {
		this.jeu = jeu;
		racine = new Arbre(jeu.getCopyDeJeu());
		noeudCourant = racine;
		
	}

	public void revenirAncienJeu(Arbre a) {
		jeu = a.getJeu().getCopyDeJeu();
		this.noeudCourant = a;
		setChanged();
		notifyObservers();
	}

	public void jouerUnCoup(Coup c) {
		if(jeu.listerTousCoupPossible().contains(c)){
			// je fais evoluer le jeu
			jeu.jouerUnCoup(c);
			
			// je mets a jour l'arbre
			
			//TODO attention si le coup existe deja
			boolean existeDeja = false;
			for(Arbre fils : noeudCourant.getListeNoeud()){
				if(fils.getListeCoup().contains(c)){
					existeDeja = true;
					noeudCourant = fils;
					break;
				}
			}
			if(!existeDeja){
				Arbre a = new Arbre(jeu.getCopyDeJeu());
				noeudCourant.ajouterNoeudEtCoup(a, c);
				//on passe au coup suivant
				this.noeudCourant = a;
			}

			//on demande la mise a jour de dessin de jeu
			setChanged();
			notifyObservers();
		}
	}

	public Arbre getRacine() {
		return racine;
	}

	public Arbre getNoeudCourant() {
		return noeudCourant;
	}

	public void setNoeudCourant(Arbre noeudCourant) {
		this.noeudCourant = noeudCourant;

	}

	public Jeu getJeu() {
		return jeu;
	}
}
