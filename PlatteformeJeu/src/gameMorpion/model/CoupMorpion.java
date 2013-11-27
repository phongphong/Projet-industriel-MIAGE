package gameMorpion.model;
import gameAbstract.*;
import gameRushHour.model.Voiture;

public class CoupMorpion implements Coup {

	private Joueur j;
	private int x;
	private int y;
	
	public CoupMorpion(Joueur j, int x, int y){
		super();
		this.j = j;
		this.x = x;
		this.y = y;
	}
	

	public Joueur getJ() {
		return j;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public Voiture getV() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getDeplacement() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "coupMorpion [j=" + j + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((j == null) ? 0 : j.hashCode());
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
		if (j == null) {
			if (other.j != null)
				return false;
		} else if (!j.equals(other.j))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
