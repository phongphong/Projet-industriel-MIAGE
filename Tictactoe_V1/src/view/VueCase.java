/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import model.*;


/**
 *
 * @author Phongphet
 */
public class VueCase extends JButton implements Observer{
    
    private Case c;

    public VueCase(Case c) {
        super();
        this.c = c;
    }

    @Override
    public void update(Observable o, Object o1) {
        c = (Case)o;
        this.setText(c.getSigne());
    }
    
    public Case getCase(){
        return c;
    }
}
