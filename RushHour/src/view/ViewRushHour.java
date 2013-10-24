/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import model.*;

/**
 *
 * @author Phongphet
 */
public class ViewRushHour extends JPanel implements Observer, MouseListener, MouseMotionListener {

    public static final int length_case = 50;
    public static final int dimension = 5;
    private ArrayList<Voiture> listeVoiture;
    private int select;

    public ViewRushHour() {

        Voiture v1 = new Voiture(true, 'h', 0, 0, 2);
        Voiture v2 = new Voiture(false, 'v', 150, 100, 2);
        Voiture v3 = new Voiture(false, 'h', 0, 200, 2);

        listeVoiture = new ArrayList<>();
        listeVoiture.add(v1);
        listeVoiture.add(v2);
        listeVoiture.add(v3);

        this.setSize(250, 250);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        //voiture selectionne (-1 par defaut)
        select = -1;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        //dessiner les case
        for (int i = 0; i < length_case * dimension; i += 50) {
            for (int j = 0; j < length_case * dimension; j += 50) {
                g.drawRect(i, j, length_case, length_case);
            }
        }
        //dessiner les voitures
        for (int k = 0; k < listeVoiture.size(); k++) {
            if (listeVoiture.get(k).isVoitureRouge()) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.yellow);
            }
            Voiture v = listeVoiture.get(k);
            if (v.getDirection() == 'h') {
                g.fillRect(v.getX(), v.getY(), v.getTaille() * length_case, length_case);
            } else {
                g.fillRect(v.getX(), v.getY(), length_case, v.getTaille() * length_case);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        for (int i = 0; i < listeVoiture.size(); i++) {
            if (listeVoiture.get(i).estClique(me.getX(), me.getY())) {
                select = i;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //Pour ajuster la voiture a la case
        if (select != -1) {
            int x_fixe = me.getX() / 50 * length_case;
            int y_fixe = me.getY() / 50 * length_case;

            Voiture v = listeVoiture.get(select);
            /*On test lors qu'on relache la souris et que le pointeur est dehors la grile
             la voiture sera ajuste a la derniere case*/

            if (x_fixe + (v.getTaille() * length_case) >= dimension * length_case) {
                x_fixe = (dimension * length_case) - (v.getTaille() * length_case);
            }

            if (y_fixe + (v.getTaille() * length_case) >= dimension * length_case) {
                y_fixe = (dimension * length_case) - (v.getTaille() * length_case);
            }

            if (v.getDirection() == 'h') {
                for (int i = 0; i < listeVoiture.size(); i++) {
                    if (i != select) {
                    }
                }
                listeVoiture.get(select).setX(x_fixe);
            } else {
                listeVoiture.get(select).setY(y_fixe);
            }
            repaint();
            select = -1;
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
        int x_fixe;
        int y_fixe;
        if (select != -1) {
            Voiture v = listeVoiture.get(select);
            if (v.getDirection() == 'h') {
                //On test si cela ne depasse pas la grille
                x_fixe = (me.getX() / 50 * length_case) + (v.getTaille() * length_case);
                y_fixe = me.getY() / 50 * length_case;
                boolean avance = true;
                int i = 0;
                if (me.getX() + (v.getTaille() * length_case) <= dimension * length_case) {
                    //On test s'il y a pas de la voiture devant
                    while(avance && i < listeVoiture.size()) {
                        if (i != select) {
                            if (listeVoiture.get(i).getDirection() == 'h') {
                                if (x_fixe != listeVoiture.get(i).getX() && y_fixe != listeVoiture.get(i).getY()) {
                                    v.setX(me.getX());
                                }else{
                                    avance = false;
                                }
                            } else {
                                if ((x_fixe != listeVoiture.get(i).getX() && y_fixe != listeVoiture.get(i).getY())
                                    || (x_fixe != listeVoiture.get(i).getX() && y_fixe + length_case != listeVoiture.get(i).getY() + (listeVoiture.get(i).getTaille() * length_case))) {
                                        v.setX(me.getX());
                                }else{
                                    avance = false;
                                }
                            }
                        }
                        i++;
                    }

                }
            }else{
                v.setY(me.getY());
            }

           
            repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    public static void main(String[] args) {
        ViewRushHour view = new ViewRushHour();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);
        frame.setPreferredSize(new Dimension(300, 400));
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object o1) {
        // v1 = (Voiture)o;
        repaint();
    }
}
