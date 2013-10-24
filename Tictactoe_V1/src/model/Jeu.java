/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.VueCase;

/**
 *
 * @author Phongphet
 */
public class Jeu {

    private static final int DIM = 3;
    private VueCase[][] t_case;

    public Jeu(VueCase[][] t_case) {
        this.t_case = t_case;
    }

    public boolean verifier(Joueur j, int x, int y) {
        int colonne = 0;
        int ligne = 0;
        int diagonal = 0;
        int rdiagonal = 0;
        boolean gagne = false;

        for (int i = 0; i < DIM; i++) {
            if (t_case[x][i].getText().equals(j.getSigne())) {
                colonne++;
            }
            if (t_case[i][y].getText().equals(j.getSigne())) {
                ligne++;
            }
            if (t_case[i][i].getText().equals(j.getSigne())) {
                diagonal++;
            }
            if (t_case[i][2 - i].getText().equals(j.getSigne())) {
                rdiagonal++;
            }
            
        }
        if (colonne == DIM || ligne == DIM || diagonal == DIM || rdiagonal == DIM) {
            gagne = true;
        }

        return gagne;
    }
}
