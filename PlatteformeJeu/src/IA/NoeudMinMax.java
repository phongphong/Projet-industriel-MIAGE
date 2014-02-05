package IA;

import generique.gameAbstract.Coup;

public class NoeudMinMax {
	private Coup coup;
	private int gagner;
	
	public NoeudMinMax(Coup coup, int gagner) {
		super();
		this.coup = coup;
		this.gagner = gagner;
	}

	public Coup getCoup() {
		return coup;
	}

	public void setCoup(Coup coup) {
		this.coup = coup;
	}

	public int getGagner() {
		return gagner;
	}

	public void setGagner(int gagner) {
		this.gagner = gagner;
	}
}
