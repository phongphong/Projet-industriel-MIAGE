package gameAbstract;

import java.util.ArrayList;

public class Arbre {
	
	private Jeu jeu;
	private ArrayList<Arbre> listeNoeud;
	private ArrayList<Coup> listeCoup;
	
	public Arbre(Jeu jeu){
		this.jeu = jeu;
		listeNoeud = new ArrayList<>();
		listeCoup = new ArrayList<>();
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
	
	public void ajouterCoup(Coup c){
		this.listeCoup.add(c);
	}

	public Jeu getJeu(){
		return jeu;
	}

	
	public ArrayList<Arbre> getListeNoeud() {
		return listeNoeud;
	} 
}
