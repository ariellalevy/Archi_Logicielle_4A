package com.esiea.tp4A.code;


import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Plateau {

    private int taille = 0;

    private List<Obstacle> obstacleList;

    private void setObstacleList(List<Obstacle> list){
        obstacleList = list;
    }

    public List<Obstacle> getObstacles(){
        return obstacleList;
    }

    // constructeur //
    public Plateau (List<Obstacle> list){
        setObstacleList(list);
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
