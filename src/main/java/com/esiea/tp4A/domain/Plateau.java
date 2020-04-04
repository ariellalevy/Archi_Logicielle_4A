package com.esiea.tp4A.domain;
public class Plateau {
    private int taille = 0;
    // constructeur //
    public Plateau (){
    }
    public int getTaille(){
        int tab_taille [] = {50, 150, 300};
        int rand = (int) (Math.random() * tab_taille.length);
        this.taille = tab_taille[rand];
        return taille;
    }
    public int sphere(int position){
        if(position > taille){
            position = - ((50 + taille) - position);
        }
        return position;
    }
}
