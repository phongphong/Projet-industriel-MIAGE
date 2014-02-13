package generic.abstractModel;

import generic.hypertree.HypertreeNode;

import java.awt.Color;
import java.util.Observable;
public class GamePart extends Observable {

	private Game jeu;
	private HypertreeNode racineHypertree;
	private HypertreeNode noeudCourant;
	private HypertreeNode noeudACentrer;

	public GamePart(Game jeu) {
		this.jeu = jeu;
		racineHypertree = new HypertreeNode(jeu.getCopyDeJeu());
		noeudCourant = racineHypertree;
		noeudACentrer = racineHypertree;
	}

	public void revenirAncienJeu(HypertreeNode node) {
		
		jeu = node.getJeu().getCopyDeJeu();
		this.noeudCourant = node;
		setChanged();
		notifyObservers();
	}

	public void jouerUnCoup(GameAction c) {
		if(jeu.listerTousCoupPossible().contains(c)){
			noeudCourant.setColor(Color.white);
			// je fais evoluer le jeu
			jeu.jouerUnCoup(c);
			//jeu.changerJoueur();
			// je mets a jour l'arbre
			
			//TODO attention si le coup existe deja
			boolean existeDeja = false;
			for(HypertreeNode fils : noeudCourant.getChildren()){
				if(fils.getListeCoup().contains(c)){
					existeDeja = true;
					noeudCourant = fils;
					break;
				}
			}
			if(!existeDeja){
				HypertreeNode n_fils = new HypertreeNode(jeu.getCopyDeJeu());
				n_fils.getListeCoup().add(c);
				noeudCourant.addChild(n_fils);
				
				//on passe au coup suivant
				this.noeudCourant = n_fils;
			}
			noeudCourant.setColor(Color.green);
			//on demande la mise a jour de dessin de jeu
			setChanged();
			notifyObservers();
		}
	}

	public Game getJeu() {
		return jeu;
	}

	public HypertreeNode getRacineHypertree() {
		return racineHypertree;
	}

	public HypertreeNode getNoeudCourant() {
		return noeudCourant;
	}

	public HypertreeNode getNoeudACentrer() {
		return noeudACentrer;
	}

	public void setNoeudACentrer(HypertreeNode noeudACentrer) {
		this.noeudACentrer = noeudACentrer;
	}
}
