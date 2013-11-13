/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author Phongphet
 */
public class RushHour extends Observable {

    private static final int dimension = 6;
    char[][] t_case;
    ArrayList<Voiture> lVoiture;

    public RushHour() {
        t_case = new char[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                t_case[i][j] = '.';
            }
        }
        
        Voiture v1 = new Voiture('0', 0, 0, 3, 'v', false);
        Voiture v2 = new Voiture('R', 3, 0, 2, 'h', true);
        Voiture v3 = new Voiture('1', 1, 5, 3, 'v', false);
        
        lVoiture = new ArrayList<>();
        lVoiture.add(v1);
        lVoiture.add(v2);
        lVoiture.add(v3);
        
        this.setCaseOccupe(v1, v1.getNum());
        this.setCaseOccupe(v2, v2.getNum());
        this.setCaseOccupe(v3, v3.getNum());
    }

    public void jouerUnCoup(Coup c) {
        Voiture v = c.getV();
        this.setCaseOccupe(v, '.');
        if(v.getDirection() == 'h'){
            v.setCol(v.getCol() + c.getDeplacement());
        }else{
            v.setLigne(v.getLigne() + c.getDeplacement());
        }
        this.setCaseOccupe(v, (char)v.getNum());
        setChanged();
        notifyObservers();
    }

    public ArrayList<Coup> listerTousCoupPossible() {
        ArrayList<Coup> listeCoup = new ArrayList<>();
        for(int i=0 ; i<lVoiture.size() ; i++){
            Voiture v = lVoiture.get(i);
            if(v.getDirection() == 'h'){
                for(int j = 0 ; j < v.getCol() ; j++){
                    if(t_case[v.getLigne()][j] == '.')
                        listeCoup.add(new Coup(v, j - v.getCol()));
                    else
                        break;
                }
                for(int k = v.getCol() + v.getLongeur() ; k < dimension ; k++){
                    if(t_case[v.getLigne()][k] == '.' || t_case[v.getLigne()][k] == v.getNum())
                        listeCoup.add(new Coup(v, k - v.getCol() - v.getLongeur() + 1));
                    else
                        break;
                }
            }else{
                for(int l = 0 ; l < v.getLigne() ; l++){
                    if(t_case[l][v.getCol()] == '.')
                        listeCoup.add(new Coup(v, l - v.getLigne()));
                    else
                        break;
                }
                for(int m = v.getLigne() + v.getLongeur() ; m < dimension ; m++){
                    if(t_case[m][v.getCol()] == '.' || t_case[m][v.getCol()] == v.getNum())
                        listeCoup.add(new Coup(v, m - v.getLigne() - v.getLongeur() + 1));
                    else
                        break;
                }
            } 
        }
        return listeCoup;
    }

    public boolean gagner() {
        return false;
    }
    
    private void setCaseOccupe(Voiture v, char c) {
        if (v.getDirection() == 'v') {
            for (int i = v.getLigne(); i < v.getLigne() + v.getLongeur(); i++) {
                t_case[i][v.getCol()] = c;
            }
        } else {
            for (int i = v.getCol(); i < v.getCol() + v.getLongeur(); i++) {
                t_case[v.getLigne()][i] = c;
            }
        }
    }

    public char[][] getT_case() {
        return t_case;
    }

    public static int getDimension() {
        return dimension;
    }

    public ArrayList<Voiture> getlVoiture() {
        return lVoiture;
    }
}
