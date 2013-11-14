/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler.RushHour;

import View.RushHour.ViewRushHourGraphic;
import Model.RushHour.Voiture;
import Model.RushHour.RushHour;
import Model.RushHour.CoupRushHour;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * Cette classe représente le contrôleur en mode GRAPHIQUE du jeu rushHour
 * @author Phongphet
 */
public class ControlRushHourGraphic implements MouseListener, MouseMotionListener {

    private RushHour rh;
    private ArrayList<Voiture> lVoiture;
    private int indice;
    
    public ControlRushHourGraphic(RushHour rh){
        this.rh = rh;
        lVoiture = rh.getlVoiture();
        indice = -1;
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
         if(rh.gagner()){
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
            //si le coup cree est parmi le coup possible, on deplace a voiture
            if(rh.listerTousCoupPossible().contains(c)){
                rh.jouerUnCoup(c);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
  
    }
    
    /**
     * Cette méthode lancer le Jeu RushHour, elle lie la vue au contrôleur et
     * le listener de la souris à l'interface
     */
    public void lancer(){
        ViewRushHourGraphic view = new ViewRushHourGraphic(rh);
        ControlRushHourGraphic ctr = new ControlRushHourGraphic(rh);
        
        JFrame frame = new JFrame("Rush hour");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);
        frame.pack();
        frame.setVisible(true);

        rh.addObserver(view);
        
        view.addMouseListener(ctr);
        view.addMouseMotionListener(ctr);
    }
}
