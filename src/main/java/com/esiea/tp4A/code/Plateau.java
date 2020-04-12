package com.esiea.tp4A.code;


import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;

import java.util.Set;

public class Plateau implements PlanetMap {

    private int taille = 0;

    @Override
    public Set<Position> obstaclePositions() {
        return null;
    }

    // constructeur //
    public Plateau (){
    }

    //Genere la taille aleatoire
    public void geneTaille(){

        int tab_taille [] = {50, 150, 300};

        int rand = (int) (Math.random() * tab_taille.length);

        this.taille = tab_taille[rand];

    }

    public int getTaille() {
    	return taille;
    }

    public void setTaille(int taille) {
    	this.taille = taille;
    }

    public int sphere(int position){

        if((taille == 100) && (position > taille)){
            position = - ((100 + taille) - position);
        }
        if((taille == 300) && (position > taille)){
            position = - ((300 + taille) - position);
        }
        if((taille == 600) && (position > taille)){
            position = - ((600 + taille) - position);
        }
        return position;
    }

}
