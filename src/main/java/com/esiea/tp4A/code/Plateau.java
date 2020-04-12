package com.esiea.tp4A.code;


import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Plateau implements PlanetMap{
    private int taille = 0;
    private Set<Position> setPosition = new HashSet<Position>();

    @Override
    public Set<Position> obstaclePositions() {return null;}

    public Plateau (){}
    
    /* Constructeur */
    public Plateau (int tailleInput){
        initMap();
        initMapWithObstacles(tailleInput);
    }

    private void initMap(){
        int tab_taille [] = {50, 150, 300};
        int rand = (int) (Math.random() * tab_taille.length);
        this.taille = tab_taille[rand];
    }

    private void initMapWithObstacles(int taille){
        int obstacleCount = (int) (taille * 0.15);
        for (int i = 0; i< obstacleCount; i++){
            int posX = (int) (Math.random() * taille);
            int posY = (int) (Math.random() * taille);
            Obstacle tmpObstacle = new Obstacle(posX,posY,Direction.NORTH);
            setPosition.add(Position.of(tmpObstacle.getPositionX(),tmpObstacle.getPositionY(), Direction.NORTH));
        }
    }

    public Set<Position> getObstacleList(){return this.obstaclePositions();}

    /* Génère un obstacle */
    public void geneObstacle(Position position){
        int obs = (int) (0.15 * getTaille());
        for(int i = 0; i < obs; i++){
            creationObs(position);
        }
    }

    /* Création de l'obstacle */
    public boolean creationObs(Position position) {
        if (!this.present(position)) {
            this.getObstacleList().add(position);
            return true;
        }
        return false;
    }

    /* Verification si obstacle déjà présent */
    boolean present(Position position) {
        for (Position p : this.getObstacleList()) {
            if (p.getX() == position.getX() && p.getY() == position.getY()) {
                return true;
            }
        }
        return false;
    }

    public int getTaille(){return taille;}

    public void setTaille(int taille){this.taille = taille;}

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