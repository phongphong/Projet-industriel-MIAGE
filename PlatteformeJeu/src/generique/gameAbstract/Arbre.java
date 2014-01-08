package generique.gameAbstract;

import java.util.ArrayList;

public class Arbre{
	
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

	}
	
	public void ajouterListeNoeud(ArrayList<Arbre> listeNoeud){
		this.listeNoeud.addAll(listeNoeud);

	}
	
	public void ajouterListeCoup(ArrayList<Coup> listeCoup){
		this.listeCoup.addAll(listeCoup);
	
	}
	
	public void ajouterCoup(Coup c){
		this.listeCoup.add(c);

	}
	
	public void ajouterNoeudEtCoup(Arbre a, Coup c){
		this.listeNoeud.add(a);
		this.listeCoup.add(c);
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
		String nomCoup = "";
		for(Coup c : listeCoup){
			nomCoup += c.toString();
		}
		return nomCoup;
	} 
}
