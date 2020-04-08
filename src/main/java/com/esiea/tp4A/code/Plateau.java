package com.esiea.tp4A.code;


public class Plateau {

    private int taille = 0;

    // constructeur //
    public Plateau (){
    }

    //Genere la taille aleatoire
    public void geneTaille(){

        int tab_taille [] = {100, 300, 600};

        int rand = (int) (Math.random() * tab_taille.length);

        this.taille = tab_taille[rand];

    }
    
    public int getTaille() {
    	return taille;
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
