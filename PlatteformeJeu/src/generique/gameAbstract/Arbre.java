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
			if(!a.getListeCoup().isEmpty()){
				for(int i = 0 ; i < a.getListeCoup().size() ; i++){
					System.out.println(a.getListeCoup().get(i).toString());
					System.out.println("------------------------");
					afficheArbre(a.getListeNoeud().get(i));
				}
			}
		}
	}
	
	public void ajouterNoeudEtCoup(Arbre a, Coup c){
		this.listeNoeud.add(a);
		a.getListeCoup().add(c);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jeu == null) ? 0 : jeu.hashCode());
		return result;
	}	
}
