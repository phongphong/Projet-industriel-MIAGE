package gameMorpion.model;
import gameRushHour.model.Voiture;
import generique.gameAbstract.*;

public class CoupMorpion implements Coup {

	private Joueur joueur;
	private int x;
	private int y;
	
	public CoupMorpion(Joueur j, int x, int y){
		super();
		this.joueur = j;
		this.x = x;
		this.y = y;
	}
	

	public Joueur getJoueur() {
		return joueur;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "[" + joueur + "," + x + "," + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joueur == null) ? 0 : joueur.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoupMorpion other = (CoupMorpion) obj;
		if (joueur == null) {
			if (other.joueur != null)
				return false;
		} else if (!joueur.equals(other.joueur))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}
