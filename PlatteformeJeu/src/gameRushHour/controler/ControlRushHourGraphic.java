/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameRushHour.controler;

import gameRushHour.model.CoupRushHour;
import gameRushHour.model.RushHour;
import gameRushHour.model.Voiture;
import gameRushHour.view.ViewRushHourGraphic;
import generique.gameAbstract.AbstractControler;
import generique.gameAbstract.Partie;

import java.awt.event.*;
import java.awt.*;
import java.util.*;

import javax.swing.*;


/**
 * Cette classe représente le contrôleur en mode GRAPHIQUE du jeu rushHour
 * @author Phongphet
 */
public class ControlRushHourGraphic extends AbstractControler {

    private RushHour rh;
    private ArrayList<Voiture> lVoiture;
    private int indice;
    private Partie partie;
    
    public ControlRushHourGraphic(Partie partie) {
    	this.partie = partie;
        this.rh = (RushHour) partie.getJeu();
        lVoiture = rh.getlVoiture();
        indice = -1;
        partie = new Partie(rh);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
    
    }

    @Override
    public void mousePressed(MouseEvent me) {
        int colonne = me.getX() / 50;
        int ligne = me.getY() / 50;
        char c = rh.getT_case()[ligne][colonne];
        //on récupère la voiture choisie
        indice = lVoiture.indexOf(new Voiture(c));
    }

    @Override
    public void mouseReleased(MouseEvent me) {
         if(rh.gagner(null)){
            JOptionPane.showMessageDialog(null, "Gagner");
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    
    }

    @Override
    public void mouseExited(MouseEvent me) {
    
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        //si la voiture choisi n'est pas nulle
        if(indice != -1){
            //on regenere le nouveau coup(voiture, deplacement) en fonction du deplacement de la souris et la direction 
            int colonne = me.getX() / 50;
            int ligne = me.getY() / 50;
            Voiture v = lVoiture.get(indice);
            int deplacement;
            if(v.getDirection() == 'h'){
                deplacement = colonne - v.getCol();
            }else{
                deplacement = ligne - v.getLigne();
            }
            //On cree ce coup
            CoupRushHour c = new CoupRushHour(v, deplacement);
            try {
				partie.jouerUnCoup(c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
  
    }
}
