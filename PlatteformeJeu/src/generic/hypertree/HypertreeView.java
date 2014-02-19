package generic.hypertree;

import generic.abstractModel.GameSession;
import hypertree.HTModel;
import hypertree.SwingHTView;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

/**
 * This class represents the view of hypertree
 * @author Phongphet
 *
 */
@SuppressWarnings("serial")
public class HypertreeView extends SwingHTView implements Observer {
	private static int nb;
	/**
	 * Constructor that create hypertree
	 * @param model Hypertree model
	 */
	public HypertreeView(HTModel model){
		super(model);
		this.setSize(new Dimension(600, 600));
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		GameSession p = (GameSession) o;
		HypertreeNode root = p.getRootHypertree();
		HTModel model = new HTModel(root);	
		this.refesh(model);
		this.translateToOrigin(p.getNodeToCenter());
		this.repaint();
	}
}
