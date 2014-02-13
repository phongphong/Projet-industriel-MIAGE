package generique.hypertree;

import generique.abstractModel.Partie;
import hypertree.HTModel;
import hypertree.SwingHTView;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

public class VueArbre extends SwingHTView implements Observer {
	
	public VueArbre(HTModel model){
		super(model);
		this.setSize(new Dimension(600, 600));
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Partie p = (Partie) o;
		NodeHypertree root = p.getRacineHypertree();
		HTModel model = new HTModel(root);	
		this.refesh(model);
		this.translateToOrigin(p.getNoeudACentrer());
		this.repaint();
	}
}
