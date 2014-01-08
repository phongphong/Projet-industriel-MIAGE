package generique.gameAbstract;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class AbstractControler implements MouseListener, MouseMotionListener {
	
	public abstract Partie getPartie();

}
