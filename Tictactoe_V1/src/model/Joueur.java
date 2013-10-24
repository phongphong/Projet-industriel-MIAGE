/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Phongphet
 */
public class Joueur {
    
    private String signe;
    private boolean joue;

    public Joueur(String signe, boolean joue) {
        this.signe = signe;
        this.joue = joue;
    }

    public String getSigne() {
        return signe;
    }

    public void setSigne(String signe) {
        this.signe = signe;
    }

    public boolean isJoue() {
        return joue;
    }

    public void setJoue(boolean joue) {
        this.joue = joue;
    }
}
