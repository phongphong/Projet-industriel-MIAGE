package generic.hypertree;

import generic.abstractModel.GamePart;
import hypertree.HTModel;
import hypertree.SwingHTView;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

public class HypertreeView extends SwingHTView implements Observer {
	
	public HypertreeView(HTModel model){
		super(model);
		this.setSize(new Dimension(600, 600));
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		GamePart p = (GamePart) o;
		HypertreeNode root = p.getRacineHypertree();
		HTModel model = new HTModel(root);	
		this.refesh(model);
		this.translateToOrigin(p.getNoeudACentrer());
		this.repaint();
	}
}
