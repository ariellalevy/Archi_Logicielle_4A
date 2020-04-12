package com.esiea.tp4A.code;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;

public class Aleatoire {
	
	private Plateau plateau;
	private int taille;
	
	public Aleatoire(Plateau plateau) {
		this.plateau = plateau;
		taille = plateau.getTaille();
	}	
	
	/* Fonction qui génère aléatoirement un nombre */
    public int randomNumber(int min, int max){
        int range = max - min + 1;
        int res = 0;
        for(int i = min-1; i<max; i++){
            res = (int) (Math.random() * range ) +min;
        }
        return res;
    }
    
    /*Fonction qui génère une position aléatoire */
    public Position aleaPosition(){
        int xMax = taille; //abscise maximale
        int yMax = taille; //ordonée maximale
        //x aléatoire
        int x = randomNumber(-xMax,xMax);
        //y aléatoire
        int y = randomNumber(-yMax, yMax);
        //direction aléatoire
        Direction direction = aleaDirection();
        Position p = Position.of(x,y, direction);
        return p;
    }

    /*Fonction qui génère une direction aléatoire*/
    public Direction aleaDirection(){
        Direction tabDirection[] = {Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH};
        int rand = (int) (Math.random() * tabDirection.length);
        Direction direction = tabDirection[rand];
        return direction;
    }
    
    /*Fonction qui génère aléatoirement la portée du laser*/
    public int aleaPorteeLaser() {
    	int tabPortee[] = {5, 30, 2000}; //2000 équivaut à la valeur infinie de la portée du laser
    	int rand = (int) (Math.random() * tabPortee.length);
    	int portee = tabPortee[rand];
    	return portee;
    }
}
