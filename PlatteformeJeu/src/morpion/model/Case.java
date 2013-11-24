/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion.model;

import java.util.*;

/**
 *
 * @author Phongphet
 */
public class Case extends Observable{
    
    private int x;
    private int y;
    private String signe;
    
	public Case(int x, int y, String signe) {
		super();
		this.x = x;
		this.y = y;
		this.signe = signe;
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

	public String getSigne() {
		return signe;
	}

	public void setSigne(String signe) {
		this.signe = signe;
	}
}
