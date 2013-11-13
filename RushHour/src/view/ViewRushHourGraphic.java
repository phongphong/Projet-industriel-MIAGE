/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.RushHour;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Phongphet
 */
public class ViewRushHourGraphic extends JPanel implements Observer {

    private RushHour rh;
    
    public ViewRushHourGraphic(RushHour rh){
        super();
        this.rh = rh;
        this.setSize(600, 600);
    }
    
    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        char[][] t_case = rh.getT_case();
        for(int i = 0 ; i < t_case.length ; i++){
            for(int j = 0 ; j < t_case.length ; j++){
                if(t_case[j][i] == '.'){
                    g.setColor(Color.black);
                    g.drawRect(i * 50, j * 50, 50, 50);
                }else{
                    if(t_case[j][i] == 'R'){
                        g.setColor(Color.red);
                    }else{
                        g.setColor(Color.yellow);
                    }
                    g.fillRect(i * 50, j * 50, 50, 50);
                    g.setColor(Color.black);
                    g.drawString(String.valueOf(t_case[j][i]), i * 50 + 25, j * 50 + 25);
                    
                }
            }
        }
    }
    
    @Override
    public void update(Observable o, Object o1) {
        rh = (RushHour) o;
        repaint();
    }
}