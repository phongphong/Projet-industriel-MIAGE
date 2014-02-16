package generic.hypertree;

import generic.abstractModel.GamePart;
import hypertree.SwingHTView;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class represents the controller of hypertree
 * @author Phongphet
 *
 */
public class HypertreeNodeController implements MouseListener {

	private SwingHTView view;
	private GamePart gamePart;

	/**
	 * Constructor that create HypetreeController
	 * @param view current view of the tree
	 * @param gamePart part of the game
	 */
	public HypertreeNodeController(SwingHTView view, GamePart gamePart) {
		this.view = view;
		this.gamePart = gamePart;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		HypertreeNode node = (HypertreeNode) view.getNodeUnderTheMouse(e);
		if (node != null) {
			gamePart.getCurrentNode().setColor(Color.white);
			node.setColor(Color.green);
			gamePart.returnToPreviousStateOfGame(node);	
			gamePart.setNodeToCenter(node);
			view.translateToOrigin(node);
			view.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
