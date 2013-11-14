/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.awt.event.*;
import View.*;
import Model.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author Phongphet
 */
public class ControlRushHourGraphic implements MouseListener, MouseMotionListener{

    @Override
    public void mouseClicked(MouseEvent me) {
    
    }

    @Override
    public void mousePressed(MouseEvent me) {
    
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    
    }

    @Override
    public void mouseExited(MouseEvent me) {
    
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    
    }
    
    public static void main(String[] args){
        RushHour rh = new RushHour();
        ViewRushHourGraphic view = new ViewRushHourGraphic(rh);
        JFrame frame = new JFrame("Rush hour");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);
        frame.pack();
        frame.setVisible(true);
        
        ArrayList<Coup> listeCoup;
        Scanner sc = new Scanner(System.in);
        int choixCoup;
        boolean fini = false;
        rh.addObserver(view);
        
        while (!fini) {
            System.out.println("Qu'est ce que vous voulez faire");
            listeCoup = rh.listerTousCoupPossible();
            for(int j = 0 ; j < listeCoup.size() ; j++){
                System.out.println(j + ". " + listeCoup.get(j).toString());
            }
            choixCoup = sc.nextInt();
            rh.jouerUnCoup(listeCoup.get(choixCoup));
        }
        
    }
}
