package gameMorpion.model;

public class Joueur {

	private String nom;
	char signe;
	
	public Joueur(String nom, char signe) {
		super();
		this.nom = nom;
		this.signe = signe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public char getSigne() {
		return signe;
	}

	public void setSigne(char signe) {
		this.signe = signe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + signe;
		return result;
	}

	@Override
	public String toString() {
		return "Joueur []";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (signe != other.signe)
			return false;
		return true;
	}
}
