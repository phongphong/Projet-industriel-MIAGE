package gameAbstract;

import java.util.ArrayList;

public class Arbre {
	
	private Jeu jeu;
	private Coup coup;
	private ArrayList<Arbre> listeNoeud;
	
	public Arbre(Jeu jeu){
		this.jeu = jeu;
		listeNoeud = new ArrayList<>();
	}
	
	public Arbre(Jeu jeu, Coup coup){
		this.jeu = jeu;
		this.coup = coup;
		listeNoeud = new ArrayList<>();
	}
	
	public void afficheArbre(){
		System.out.println("-----------------------");
		for(int i=0 ; i < listeNoeud.size() ; i++){
			System.out.println(listeNoeud.get(i).toString() + "   ");
		}
	}
	
	public void ajouterNoeud(Arbre a){
		this.listeNoeud.add(a);
	}

	public Jeu getJeu(){
		return jeu;
	}
	
	public Coup getCoup(){
		return coup;
	}
	
	public ArrayList<Arbre> getListeNoeud() {
		return listeNoeud;
	} 
}
