/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.RushHour;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Phongphet
 */
public class ViewRushHour implements Observer{
    
    private RushHour rh;
    
    public ViewRushHour(RushHour rh){
        this.rh = rh;
    }
            
    public void affiche(){
        char[][] t_case = rh.getT_case();
        for(int i = 0 ; i < t_case.length ; i++){
            for(int j = 0 ; j < t_case.length ; j++){
                System.out.print(t_case[i][j]+" ");
            }
            System.out.println("");
        }
    }

    @Override
    public void update(Observable o, Object o1) {
        rh = (RushHour) o;
        this.affiche();
    }
}
