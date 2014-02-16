package generic.gameMotor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * This class represents the main graphical interface of the game
 * @author Phongphet
 */
@SuppressWarnings("serial")
public class GameView extends JFrame {

	private GameFactory factory;
	private Dimension screenDimension;

	public GameView(GameFactory factory) {
		this.factory = factory;
		screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	}

	/**
	 * This method displays the main UI of the game application
	 */
	public void display() {

		this.setTitle("Platteforme Jeu");
		this.setPreferredSize(screenDimension);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		final JPanel panel = new JPanel();

		final JPanel gamePanel = new JPanel();
		gamePanel.setSize(screenDimension.width / 2, screenDimension.height);
		gamePanel.setLayout(new BorderLayout());

		final JPanel treePanel = new JPanel();
		treePanel.setSize(screenDimension.width / 2, screenDimension.height);

		JMenuBar menuBar = new JMenuBar();

		JMenu menu1 = new JMenu("Jeu");
		JMenu menu2 = new JMenu("IA");
		JMenu menu3 = new JMenu("Aide");

		/*creer des menus generiquement et ajouter ses actions correspondantes*/
		ArrayList<String> listOfGame = factory.getListGame();
		for(final String gameName : listOfGame){
			JMenuItem gameSubMenu = new JMenuItem(gameName);
			menu1.add(gameSubMenu);
			gameSubMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					factory.createGame(gameName);
				
					gamePanel.removeAll();
					gamePanel.add(factory.getViewGame());
					
					treePanel.removeAll();
					treePanel.setLayout(new BorderLayout());
					treePanel.add(factory.getViewTree(), BorderLayout.CENTER);
					
					panel.repaint();	
				}
			});
		}

		menu2.add(new JCheckBox("MinMax"));
		menu2.add(new JCheckBox("Largeur d'abord"));
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		
		
		panel.setLayout(new GridLayout(1, 2));
		panel.add(gamePanel);
		panel.add(treePanel);

		this.setJMenuBar(menuBar);

		this.setContentPane(panel);
		this.pack();
		this.setVisible(true);
	}
	
	
}
