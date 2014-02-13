package generic.AI;

import generic.abstractModel.Coup;

public class NoeudMinMax {
	private Coup coup;
	private double gagner;
	
	public NoeudMinMax(Coup coup, double gagner) {
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

	public double getGagner() {
		return gagner;
	}

	public void setGagner(double gagner) {
		this.gagner = gagner;
	}
}
