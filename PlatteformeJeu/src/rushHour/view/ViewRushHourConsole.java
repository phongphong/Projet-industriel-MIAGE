/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rushHour.view;

import java.util.Observable;
import java.util.Observer;

import rushHour.model.RushHour;

/**
 *
 * @author Phongphet
 */
public class ViewRushHourConsole implements Observer{
    
    private RushHour rh;
    
    public ViewRushHourConsole(RushHour rh){
        this.rh = rh;
    }
            
    public void affiche(){
    	System.out.println("_ _ _");
        char[][] t_case = rh.getT_case();
        for(int i = 0 ; i < t_case.length ; i++){
            for(int j = 0 ; j < t_case.length ; j++){
                System.out.print(t_case[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("_ _ _");
    }

    @Override
    public void update(Observable o, Object o1) {
        rh = (RushHour) o;
        this.affiche();
    }
}
