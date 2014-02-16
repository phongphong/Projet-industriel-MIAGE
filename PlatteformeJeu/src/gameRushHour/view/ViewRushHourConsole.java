/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameRushHour.view;

import gameRushHour.model.RushHour;

import java.util.*;


/**
 * This class represents the view of rushhour game in console mode
 * @author Phongphet
 */
public class ViewRushHourConsole implements Observer{
    
    private RushHour rushhour;
    
    /**
     * Contructor of the view
     * @param rh rushhour model
     */
    public ViewRushHourConsole(RushHour rh){
        this.rushhour = rh;
    }
            
    /**
     * This method display the game grid
     */
    public void display(){
    	System.out.println("_ _ _");
        char[][] t_case = rushhour.getGrid();
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
        rushhour = (RushHour) o;
        this.display();
    }
}
