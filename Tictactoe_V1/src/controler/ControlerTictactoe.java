/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

import model.*;
import view.*;

/**
 *
 * @author Phongphet
 */
public class ControlerTictactoe implements MouseListener {

    private Joueur j1;
    private Joueur j2;
    private Case c;
    private Jeu j;
    
    public ControlerTictactoe(Joueur j1, Joueur j2, Case c, Jeu j){
        this.j1 = j1;
        this.j2 = j2;
        this.c = c;
        this.j = j;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if("".equals(c.getSigne())){
            if(j1.isJoue()){
                c.setSigne(j1.getSigne());
                if(j.verifier(j1, c.getAbs(), c.getOrd())){
                    JOptionPane.showMessageDialog(null, "J1 Gagne");
                }
                j1.setJoue(false);
                j2.setJoue(true);
            }else{
                c.setSigne(j2.getSigne());
                if(j.verifier(j2, c.getAbs(), c.getOrd())){
                    JOptionPane.showMessageDialog(null, "J2 Gagne");
                }
                j2.setJoue(false);
                j1.setJoue(true);
            }
        }
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
}
