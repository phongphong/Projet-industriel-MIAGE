/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameRushHour.model;

import gameMorpion.model.Joueur;
import generique.gameAbstract.*;

import java.util.Objects;



/**
 *
 * @author Phongphet
 */
public class CoupRushHour implements Coup {
    
    private Voiture v;
    private int deplacement;

    public CoupRushHour(Voiture v, int deplacement) {
        super();
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

	public Joueur getJ() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
}
