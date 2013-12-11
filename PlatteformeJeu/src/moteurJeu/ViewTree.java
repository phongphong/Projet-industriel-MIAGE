package moteurJeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import hypertree.*;

public class ViewTree extends JPanel implements HTView {

    private HTModel    model  = null; // the tree model represented
    private HTDraw     draw   = null; // the drawing model
    private HTAction   action = null; // action manager
    private boolean    fastMode = false;
    private boolean    longNameMode = false;
    private boolean    circleMode = false;
    private boolean    transNotCorrected = false;
    private boolean    quadMode = true;


    private Image image = null;

  /* --- Constructor --- */

    /**
     * Constructor.
     *
     * @param model    the tree model to view
     */
    public ViewTree(HTModel model) {
        super(new BorderLayout());
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width/2 , d.height);

        this.model = model; 
        draw = new HTDraw(model, this);
        action = new HTAction(draw);
        startMouseListening();

        //ToolTipManager.sharedInstance().registerComponent(this);

        return;
    }


  /* --- Node finding --- */

    /**
     * Returns the node containing the mouse event.
     * <P>
     * This will be a HTNode.
     *
     * @param event    the mouse event on a node
     * @return         the node containing this event;
     *                 could be <CODE>null</CODE> if no node was found
     */
    public HTNode getNodeUnderTheMouse(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        
        HTDrawNode node = draw.findNode(new HTCoordS(x, y));
        if (node != null) {
            return node.getHTModelNode().getNode();
        } else {
            return null;
        }
    }
    
  /* --- Tooltip --- */

    /**
     * Returns the tooltip to be displayed.
     *
     * @param event    the event triggering the tooltip
     * @return         the String to be displayed
     */
    public String getToolTipText(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        
        HTDrawNode node = draw.findNode(new HTCoordS(x, y));
        if (node != null) {
            return node.getName();
        } else {
            return null;
        }
    }

  /* --- Paint --- */

    /**
     * Paint the component.
     *
     * @param g    the graphic context
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
	if (image != null) {
	    g.drawImage(image, 0, 0, getWidth(), this.getHeight(), this);
	}

        if (g instanceof Graphics2D) {
            ((Graphics2D) g).setRenderingHint
                (RenderingHints.KEY_ANTIALIASING,
                 RenderingHints.VALUE_ANTIALIAS_ON);
        }
        draw.refreshScreenCoordinates();
        draw.drawBranches(g);
        draw.drawNodes(g);
    }


  /* --- Thread-safe locking --- */
  
    /**
     * Stops the listening of mouse events.
     */
    public void stopMouseListening() {
        this.removeMouseListener(action);
        this.removeMouseMotionListener(action);
    }
    
    /**
     * Starts the listening of mouse events.
     */
    public void startMouseListening() {
        this.addMouseListener(action);
        this.addMouseMotionListener(action);
    }


    public void translateToOrigin(HTNode node) {
	HTDrawNode drawNode = draw.findDrawNode(node);
        draw.translateToOrigin(drawNode);
        return;
    }

    public void setImage(Image image) {
        this.image = image;
        return;
    }
}
