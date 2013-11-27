package gameMorpion.model;

import gameAbstract.Coup;
import gameAbstract.Jeu;

import java.util.ArrayList;
import java.util.Observable;


public class Morpion extends Observable implements Jeu{
	
	private char t_case[][];
	private Joueur tourJoueur;
	private Joueur j1;
	private Joueur j2;
	
	public Morpion(){
		t_case = new char[3][3];
		
		//creation des joueurs
		j1 = new Joueur("J1", 'O');
		j2 = new Joueur("J2", 'X');
		
		tourJoueur = j1;
		
		for(int i=0 ; i<t_case.length ; i++){
			for(int j=0 ; j<t_case.length ; j++){
				t_case[j][i] = '.';
			}
		}
	}

	@Override
	public void jouerUnCoup(Coup c) {
		char signe = ((CoupMorpion) c).getJ().getSigne();
		t_case[((CoupMorpion) c).getX()][((CoupMorpion) c).getY()] = signe;
		setChanged();
		notifyObservers();		
	}

	@Override
	public ArrayList<Coup> listerTousCoupPossible() {
		ArrayList<Coup> listeCoupPossible = new ArrayList<Coup>();
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				if(t_case[j][i] == '.'){
					listeCoupPossible.add(new CoupMorpion(tourJoueur, j, i));
				}
			}
		}
		return listeCoupPossible;
	}

	@Override
	public boolean gagner(Coup c) {
		int x = ((CoupMorpion) c).getX();
    	int y = ((CoupMorpion) c).getY();
    	Joueur j = ((CoupMorpion) c).getJ();
        int colonne = 0;
        int ligne = 0;
        int diagonal = 0;
        int rdiagonal = 0;
        boolean gagne = false;
 
        for (int i = 0; i < t_case.length; i++) {
            if (t_case[x][i] == j.getSigne()) {
                colonne++;
            }
            if (t_case[i][y] == j.getSigne()){
                ligne++;
            }
            if (t_case[i][i] == j.getSigne()) {
                diagonal++;
            }
            if (t_case[i][2 - i] == j.getSigne()) {
                rdiagonal++;
            }
            
        }
        if (colonne == t_case.length || ligne == t_case.length || diagonal == t_case.length || rdiagonal == t_case.length) {
            gagne = true;
        }

        return gagne;
	}

	public char[][] getT_case() {
		return t_case;
	}
	
	public void changerJoueur(){
		if(tourJoueur.equals(j1)){
			tourJoueur = j2;
		}else{
			tourJoueur = j1;
		}
	}
	
	public Joueur getTourJoueur(){
		return tourJoueur;
	}
}
