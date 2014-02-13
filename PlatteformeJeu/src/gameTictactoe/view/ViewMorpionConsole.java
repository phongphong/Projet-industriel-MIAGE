package gameTictactoe.view;

import gameTictactoe.model.Tictactoe;
import generic.abstractModel.Joueur;

import java.util.Observable;
import java.util.Observer;



public class ViewMorpionConsole implements Observer{

	private Tictactoe morpion;
	
	public ViewMorpionConsole(Tictactoe morpion){
		this.morpion = morpion;
	}
	
	public void affiche(){
		Joueur[][] t_case = morpion.getT_case();
		for(int i=0 ; i<t_case.length ; i++){
			for(int j=0 ; j<t_case.length ; j++){
				if(t_case[j][i].equals(morpion.getJ1())){
					System.out.print("O" + "	");
				}else if(t_case[j][i].equals(morpion.getJ2())){
					System.out.print("X" + "	");
				}else{
					System.out.print("." + "	");
				}
			}
			System.out.println();
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.morpion = (Tictactoe)o;
		this.affiche();
	}
}
