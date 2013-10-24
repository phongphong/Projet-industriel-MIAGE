/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import view.ViewRushHour;

/**
 *
 * @author Phongphet
 */
public class Voiture{
    
    private boolean voitureRouge;
    private char direction;
    private int x;
    private int y;
    private int taille;

    public Voiture(boolean voitureRouge, char direction, int x, int y, int taille) {
        this.voitureRouge = voitureRouge;
        this.direction = direction;
        this.x = x;
        this.y = y;
        this.taille = taille;
    }

    public boolean isVoitureRouge() {
        return voitureRouge;
    }

    public void setVoitureRouge(boolean voitureRouge) {
        this.voitureRouge = voitureRouge;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
    
    public boolean estClique(int x, int y){
        if(this.direction == 'h'){
            if(x >= this.getX() && x <= this.getX() + ViewRushHour.length_case
               && y >= this.getY() && y<= (this.getY() + ViewRushHour.length_case) * this.taille){
                return true;
            }
        }else{
            if(x >= this.getX() && x <= (this.getX() + ViewRushHour.length_case) * this.taille
               && y >= this.getY() && y<= this.getY() + ViewRushHour.length_case){
                return true;
            }
        }
        return false;
    }
}
