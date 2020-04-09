package com.esiea.tp4A.code;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.Position;

import java.util.ArrayList;
import java.util.List;

import com.esiea.tp4A.code.Obstacle;

public abstract class Laser implements MarsRover {

    private int distance;
    private Position position;
    private Obstacle map;
    private List<Position> lstPositionsObstacles = new ArrayList<Position>();
    private boolean statutTir = false;

    public Laser configureLaserRange(int range){
        this.distance = range;
        return this;
    }
    
    
    public void shoot(Position cible) {
    	for(Position p: lstPositionsObstacles) {
    		if((cible.getX() == p.getX()) && (cible.getY() == p.getY())) {
    			System.out.println("Tir accordé! Bim!");
    			statutTir = true;
    			lstPositionsObstacles.remove(p); // Trouver comment également retirer l'obstacle dans la liste des positions d'obstacles dans Api.java
    			
    		}
    		else {
    			System.out.println("Tir refusé! Pas d'obstacle détruit");
    		}
    	}
    	
    }
    
    public void setLstPositionObstacle(List<Position> lstPosObstacles) {
    	for(Position p: lstPosObstacles) {
    		lstPositionsObstacles.add(p);
    	}
    	
    }
    
    public boolean getStatutTir() {
    	return statutTir;
    }
    
    
    
//
//    public Position shootLaser() {
//        Position result = null;
//        int i = 0;
//        boolean destroyed = false;
//
//        while (i <= this.distance && !destroyed) {
//
//            if (this.map.isPositionOnMap())
//                destroyed = map.removeObstaclePosition();
//            i++;
//        }
//
//        return result;
//    }
}

