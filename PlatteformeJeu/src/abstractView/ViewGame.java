/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Factory.GameFactory;

/**
 * Cette classe représente la vue de la platteforme de jeu, elle liste tous les jeux
 * @author Phongphet
 */
@SuppressWarnings("serial")
public class ViewGame extends JFrame {
    
    private GameFactory control;
    
    public ViewGame(GameFactory control){
        this.control = control;
    }
    
    /**
     * Cette méthode affiche l'interface de la platteforme de jeu
     */
    public void affiche(){
        
        this.setTitle("Platteforme Jeu");
        this.setPreferredSize(new Dimension(300, 200));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel1.setSize(300, 100);
        
        JLabel label1 = new JLabel("Choisissez un jeu");
        
        JButton b1 = new JButton("Jeu Morpion");
        JButton b2 = new JButton("Jeu RushHour");
        
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                control.lancerJeu("morpion");
            }
        });
        
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                control.lancerJeu("rushhour");
            }
        });
        
        panel1.add(b1);
        panel1.add(b2);
        
        panel.setLayout(new BorderLayout());
        panel.add(label1, BorderLayout.NORTH);
        panel.add(panel1, BorderLayout.SOUTH);
        
        this.setContentPane(panel);
        this.pack();
        this.setVisible(true);
    }
    
}
