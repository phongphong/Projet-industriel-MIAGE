package generique.gameAbstract;

import java.util.Observable;
public class Partie extends Observable {

	private Jeu jeu;
	private NodeHypertree racineHypertree;
	private NodeHypertree noeudCourant;
	private NodeHypertree noeudPrecedent;

	public Partie(Jeu jeu) {
		this.jeu = jeu;
		racineHypertree = new NodeHypertree(jeu.getCopyDeJeu());
		noeudCourant = racineHypertree;
		noeudPrecedent = racineHypertree;
	}

	public void revenirAncienJeu(NodeHypertree node) {
		jeu = node.getJeu().getCopyDeJeu();
		this.noeudCourant = node;
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
			for(NodeHypertree fils : noeudCourant.getChildren()){
				if(fils.getListeCoup().contains(c)){
					existeDeja = true;
					noeudCourant = fils;
					break;
				}
			}
			if(!existeDeja){
				NodeHypertree n_fils = new NodeHypertree(jeu.getCopyDeJeu());
				n_fils.getListeCoup().add(c);
				noeudCourant.addChild(n_fils);
				
				//on passe au coup suivant
				this.noeudCourant = n_fils;
			}

			//on demande la mise a jour de dessin de jeu
			setChanged();
			notifyObservers();
		}
	}

	public Jeu getJeu() {
		return jeu;
	}

	public NodeHypertree getRacineHypertree() {
		return racineHypertree;
	}

	public NodeHypertree getNoeudCourant() {
		return noeudCourant;
	}

	public NodeHypertree getNoeudPrecedent() {
		return noeudPrecedent;
	}

	public void setNoeudPrecedent(NodeHypertree noeudPrecedent) {
		this.noeudPrecedent = noeudPrecedent;
	}
}
