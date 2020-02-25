package com.esiea.tp4A.code;

import java.util.Scanner;

public class Plateau {

    private int taille = 0;

    // constructeur //
    public Plateau (){
    }

    public int getTaille(int choix){
        Scanner scan = new Scanner(System.in);

        while(choix > 3 || choix < 1) {
            System.out.println("Veuillez saisir la taille du plateau :" + "\n" + "1 = Petit,\n" + "2 = Moyen,\n" + "3 = Grand\n");
            choix = scan.nextInt();
        }
        // Petit //
        if(choix == 1){
            this.taille = 100;
        }
        // Moyen //
        else if(choix == 2){
            this.taille = 300;
        }
        // Grand //
        else if (choix == 3){
            this.taille = 600;
        }
        return taille;
    }

    public int sphere(int position){

        if(position > taille){
            position = - ((100 + taille) - position);
        }
        return position;
    }

}
