package gameAbstract;

import java.util.ArrayList;
import java.util.Observable;

public class Arbre extends Observable {
	
	private Jeu jeu;
	private ArrayList<Arbre> listeNoeud;
	private ArrayList<Coup> listeCoup;
	
	public Arbre(Jeu jeu){
		this.jeu = jeu;
		listeNoeud = new ArrayList<>();
		listeCoup = new ArrayList<>();
	}
	
	public void afficheArbre(Arbre a){
		if(a != null){
			System.out.println(a.getJeu().toString());
			for(int i = 0 ; i < listeCoup.size() ; i++){
				System.out.println(a.getListeCoup().get(i).toString());
			}
			for(int i=0 ; i< listeNoeud.size() ; i++){
				afficheArbre(a.getListeNoeud().get(i));
			}
		}
	}
	
	public void ajouterNoeud(Arbre a){
		this.listeNoeud.add(a);
		setChanged();
		notifyObservers();
	}
	
	public void ajouterListeNoeud(ArrayList<Arbre> listeNoeud){
		this.listeNoeud.addAll(listeNoeud);
		setChanged();
		notifyObservers();
	}
	
	public void ajouterListeCoup(ArrayList<Coup> listeCoup){
		this.listeCoup.addAll(listeCoup);
		setChanged();
		notifyObservers();
	}
	
	public void ajouterCoup(Coup c){
		this.listeCoup.add(c);
		setChanged();
		notifyObservers();
	}

	public Jeu getJeu(){
		return jeu;
	}

	
	public ArrayList<Arbre> getListeNoeud() {
		return listeNoeud;
	} 
	
	public ArrayList<Coup> getListeCoup() {
		return listeCoup;
	}

	@Override
	public String toString() {
		return jeu.toString();
	} 
}
