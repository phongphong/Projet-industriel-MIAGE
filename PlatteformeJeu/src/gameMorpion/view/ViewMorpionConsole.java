package gameMorpion.view;

import gameMorpion.model.Morpion;

import java.util.Observable;
import java.util.Observer;


public class ViewMorpionConsole implements Observer{

	private Morpion morpion;
	
	public ViewMorpionConsole(Morpion morpion){
		this.morpion = morpion;
	}
	
	public void affiche(){
		char[][] t_case = morpion.getT_case();
		for(int i=0 ; i<t_case.length ; i++){
			for(int j=0 ; j<t_case.length ; j++){
				System.out.print(t_case[j][i] + "	");
			}
			System.out.println();
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.morpion = (Morpion)o;
		this.affiche();
	}
}
