package gameRushHour.controller;

import gameRushHour.model.RushHour;
import gameRushHour.view.ViewRushHourConsole;
import generic.abstractModel.GameAction;

import java.util.*;

public class ControllerRushHourConsole {
        public static void main(String[] args) {
        RushHour rh = new RushHour();
        ViewRushHourConsole vue = new ViewRushHourConsole(rh);
        rh.addObserver(vue);
        vue.affiche();
        ArrayList<GameAction> listeCoup;
        Scanner sc = new Scanner(System.in);
        int choixCoup;
        boolean fini = false;
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
