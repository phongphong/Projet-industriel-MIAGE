/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;
import controler.*;
import model.*;

/**
 *
 * @author Phongphet
 */
public class VueTictactoe extends JFrame {

    public VueTictactoe() {

        Joueur j1 = new Joueur("O", true);
        Joueur j2 = new Joueur("X", false);

        this.setTitle("Tictactoe");
        this.setPreferredSize(new Dimension(300, 300));

        Case c1 = new Case(0, 0, "");
        Case c2 = new Case(1, 0, "");
        Case c3 = new Case(2, 0, "");
        Case c4 = new Case(0, 1, "");
        Case c5 = new Case(1, 1, "");
        Case c6 = new Case(2, 1, "");
        Case c7 = new Case(0, 2, "");
        Case c8 = new Case(1, 2, "");
        Case c9 = new Case(2, 2, "");

        VueCase vc1 = new VueCase(c1);
        VueCase vc2 = new VueCase(c2);
        VueCase vc3 = new VueCase(c3);
        VueCase vc4 = new VueCase(c4);
        VueCase vc5 = new VueCase(c5);
        VueCase vc6 = new VueCase(c6);
        VueCase vc7 = new VueCase(c7);
        VueCase vc8 = new VueCase(c8);
        VueCase vc9 = new VueCase(c9);
        
        c1.addObserver(vc1);
        c2.addObserver(vc2);
        c3.addObserver(vc3);
        c4.addObserver(vc4);
        c5.addObserver(vc5);
        c6.addObserver(vc6);
        c7.addObserver(vc7);
        c8.addObserver(vc8);
        c9.addObserver(vc9);
        
        VueCase[][] t_case = new VueCase[3][3];
        t_case[0][0] = vc1;
        t_case[1][0] = vc2;
        t_case[2][0] = vc3;
        t_case[0][1] = vc4;
        t_case[1][1] = vc5;
        t_case[2][1] = vc6;
        t_case[0][2] = vc7;
        t_case[1][2] = vc8;
        t_case[2][2] = vc9;

        Jeu j = new Jeu(t_case);

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(3, 3);
        panel.setLayout(layout);
        panel.add(vc1);
        panel.add(vc2);
        panel.add(vc3);
        panel.add(vc4);
        panel.add(vc5);
        panel.add(vc6);
        panel.add(vc7);
        panel.add(vc8);
        panel.add(vc9);

        ControlerTictactoe ct1 = new ControlerTictactoe(j1, j2, c1, j);
        ControlerTictactoe ct2 = new ControlerTictactoe(j1, j2, c2, j);
        ControlerTictactoe ct3 = new ControlerTictactoe(j1, j2, c3, j);
        ControlerTictactoe ct4 = new ControlerTictactoe(j1, j2, c4, j);
        ControlerTictactoe ct5 = new ControlerTictactoe(j1, j2, c5, j);
        ControlerTictactoe ct6 = new ControlerTictactoe(j1, j2, c6, j);
        ControlerTictactoe ct7 = new ControlerTictactoe(j1, j2, c7, j);
        ControlerTictactoe ct8 = new ControlerTictactoe(j1, j2, c8, j);
        ControlerTictactoe ct9 = new ControlerTictactoe(j1, j2, c9, j);

        vc1.addMouseListener(ct1);
        vc2.addMouseListener(ct2);
        vc3.addMouseListener(ct3);
        vc4.addMouseListener(ct4);
        vc5.addMouseListener(ct5);
        vc6.addMouseListener(ct6);
        vc7.addMouseListener(ct7);
        vc8.addMouseListener(ct8);
        vc9.addMouseListener(ct9);

        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new VueTictactoe();
    }
}
