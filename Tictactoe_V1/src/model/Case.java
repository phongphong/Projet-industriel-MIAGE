/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author Phongphet
 */
public class Case extends Observable{
    
    private int abs;
    private int ord;
    private String signe;

    public Case(int abs, int ord, String signe) {
        this.abs = abs;
        this.ord = ord;
        this.signe = signe;
    }

    public String getSigne() {
        return signe;
    }

    public void setSigne(String signe) {
        this.signe = signe;
        setChanged();
        notifyObservers();
    }
    
    public int getAbs(){
        return abs;
    }
    
    public int getOrd(){
        return ord;
    }
}
