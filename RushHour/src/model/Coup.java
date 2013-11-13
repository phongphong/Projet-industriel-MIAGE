/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Phongphet
 */
public class Coup {
    
    private Voiture v;
    private int deplacement;

    public Coup(Voiture v, int deplacement) {
        this.v = v;
        this.deplacement = deplacement;
    }

    public Voiture getV() {
        return v;
    }

    public void setV(Voiture v) {
        this.v = v;
    }

    public int getDeplacement() {
        return deplacement;
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    @Override
    public String toString() {
        return "Coup{" + "v=" + v.getNum() + ", deplacement=" + deplacement + '}';
    }
}
