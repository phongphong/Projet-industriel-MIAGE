package generic.application;

import generic.abstractView.AbstractView;
import generic.hypertree.HypertreeView;

public abstract class Application {
	
	public abstract AbstractView getViewGame();
	
	public abstract HypertreeView getViewHypertree();

}
