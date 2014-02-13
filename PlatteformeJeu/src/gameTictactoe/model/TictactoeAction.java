package gameTictactoe.model;
import generic.abstractModel.*;

public class TictactoeAction implements GameAction {

	private Player joueur;
	private int x;
	private int y;
	
	public TictactoeAction(Player j, int x, int y){
		super();
		this.joueur = j;
		this.x = x;
		this.y = y;
	}
	

	public Player getJoueur() {
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
		TictactoeAction other = (TictactoeAction) obj;
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
