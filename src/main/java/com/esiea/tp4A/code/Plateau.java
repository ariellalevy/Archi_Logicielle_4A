package com.esiea.tp4A.code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private int longueur;
    private int largeur;

    // constructeur //
    public Plateau (int L, int l){
        this.longueur = L;
        this.largeur = l;
    }

    // getters //
    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public ArrayList<Integer> getTaille() {
        ArrayList<Integer> taille = new ArrayList<>();

        taille.add(largeur);
        taille.add(longueur);

        return taille;
    }
}
