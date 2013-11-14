/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.RushHour;

import AbstractModel.*;
import java.util.Objects;

/**
 *
 * @author Phongphet
 */
public class CoupRushHour implements Coup {
    
    private Voiture v;
    private int deplacement;

    public CoupRushHour(Voiture v, int deplacement) {
        this.v = v;
        this.deplacement = deplacement;
    }

    @Override
    public Voiture getV() {
        return v;
    }

    public void setV(Voiture v) {
        this.v = v;
    }

    @Override
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
        final CoupRushHour other = (CoupRushHour) obj;
        if (!Objects.equals(this.v, other.v)) {
            return false;
        }
        if (this.deplacement != other.deplacement) {
            return false;
        }
        return true;
    }
}
