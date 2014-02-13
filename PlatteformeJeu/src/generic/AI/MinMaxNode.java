package generic.AI;

import generic.abstractModel.GameAction;

public class MinMaxNode {
	private GameAction coup;
	private double gagner;
	
	public MinMaxNode(GameAction coup, double gagner) {
		super();
		this.coup = coup;
		this.gagner = gagner;
	}

	public GameAction getCoup() {
		return coup;
	}

	public void setCoup(GameAction coup) {
		this.coup = coup;
	}

	public double getGagner() {
		return gagner;
	}

	public void setGagner(double gagner) {
		this.gagner = gagner;
	}
}
