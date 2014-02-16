package gameRushHour.view;

import gameRushHour.model.RushHour;
import generic.abstractModel.GamePart;
import generic.abstractView.AbstractView;

import java.awt.*;
import java.util.*;
/**
 * This method represents the graphical view of rushhour game
 * @author Phongphet
 */
@SuppressWarnings("serial")
public class ViewRushHourGraphic extends AbstractView{

    private static final int CELL_SIZE = 50;
	private static final int GAME_HEIGHT = 600;
	private static final int GAME_WIDTH = 600;
	private GamePart part;
    
    /**
     * Constructor of ViewRushHourGraphic
     * @param part a part of game Rushhour
     */
    public ViewRushHourGraphic(GamePart part){
        super();
        this.part =  part;
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        char[][] t_case = ((RushHour) part.getGame()).getGrid();
        for(int i = 0 ; i < t_case.length ; i++){
            for(int j = 0 ; j < t_case.length ; j++){
                if(t_case[j][i] == '.'){
                    g.setColor(Color.black);
                    g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }else{
                    //dessine la voiture rouge
                    if(t_case[j][i] == 'R'){
                        g.setColor(Color.red);
                    }else{
                    //dessine les autres voitures
                        g.setColor(Color.yellow);
                    }
                    g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    g.setColor(Color.black);
                    g.drawString(String.valueOf(t_case[j][i]), i * CELL_SIZE + (CELL_SIZE / 2), j * CELL_SIZE + (CELL_SIZE / 2));
                    
                }
            }
        }
    }
    
    @Override
    public void update(Observable o, Object o1) {
        part = ((GamePart) o);
        repaint();
    }
}