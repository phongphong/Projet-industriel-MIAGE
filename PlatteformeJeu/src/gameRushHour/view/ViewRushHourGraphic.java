/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameRushHour.view;

import gameRushHour.model.RushHour;
import generique.gameAbstract.AbstractView;
import generique.gameAbstract.Partie;

import java.awt.*;
import java.util.*;
/**
 * Cette méthode représente la vue Graphique du jeu RushHour
 * @author Phongphet
 */
@SuppressWarnings("serial")
public class ViewRushHourGraphic extends AbstractView{

    private Partie partie;
    
    public ViewRushHourGraphic(Partie partie){
        super();
        this.partie =  partie;
        this.setSize(600, 600);
    }
    
    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        char[][] t_case = ((RushHour) partie.getJeu()).getT_case();
        for(int i = 0 ; i < t_case.length ; i++){
            for(int j = 0 ; j < t_case.length ; j++){
                if(t_case[j][i] == '.'){
                    g.setColor(Color.black);
                    g.drawRect(i * 50, j * 50, 50, 50);
                }else{
                    //dessine la voiture rouge
                    if(t_case[j][i] == 'R'){
                        g.setColor(Color.red);
                    }else{
                    //dessine les autres voitures
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
        partie = ((Partie) o);
        repaint();
    }
}