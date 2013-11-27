/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameRushHour.model;

/**
 *
 * @author Phongphet
 */
public class Voiture {
    
    private char num;
    private int ligne;
    private int col;
    private int longeur;
    private char direction;
    private boolean voitureR;

    public Voiture(char num, int ligne, int col, int longeur, char direction, boolean voitureR) {
        this.num = num;
        this.ligne = ligne;
        this.col = col;
        this.longeur = longeur;
        this.direction = direction;
        this.voitureR = voitureR;
    }
    
    public Voiture(char num){
        this.num = num;
    }

    public char getNum() {
        return num;
    }

    public void setNum(char num) {
        this.num = num;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getLongeur() {
        return longeur;
    }

    public char getDirection() {
        return direction;
    }

    public boolean isVoitureR() {
        return voitureR;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Voiture other = (Voiture) obj;
        if (this.num != other.num) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Voiture{" + "num=" + num + ", ligne=" + ligne + ", col=" + col + ", longeur=" + longeur + ", direction=" + direction + ", voitureR=" + voitureR + '}';
    }
}
