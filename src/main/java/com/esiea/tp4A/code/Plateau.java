package com.esiea.tp4A.code;


public class Plateau {

    private int taille = 0;

    // constructeur //
    public Plateau (){
    }

    public int getTaille(){

        int tab_taille [] = {100, 300, 600};

        int rand = (int) (Math.random() * tab_taille.length);

        this.taille = tab_taille[rand];

        return taille;
    }

    public int sphere(int position){

        if(position > taille){
            position = - ((100 + taille) - position);
        }
        return position;
    }

}
