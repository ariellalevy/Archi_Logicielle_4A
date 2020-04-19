package com.esiea.tp4A.code;
import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.Position;
import com.esiea.tp4A.code.Obstacle;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Set;

public final class Laser {

    private int distance;

    public Laser (int Range){
        configureLaserRange(Range);
    }

    public boolean LaserShoot(List<Position> map, Position position){
        boolean firstIsTouched = false;
        var tmpObj = obsInRange(position);
        tmpObj = orderSet(tmpObj,position.getDirection());
        map = orderSet(map,position.getDirection());
        final List<Position> tmpList = new ArrayList<>();
        for (Iterator<Position> it = map.iterator(); it.hasNext(); ) {
            Position f = it.next();
            for (Position pos: tmpObj) {
                if (firstIsTouched){
                    break;
                }
                if (f.getY() == pos.getY() && f.getX() == pos.getX() && !firstIsTouched){
                    tmpList.add(f);
                    System.out.println("Objet :" + f.getX() + " " + f.getY() + "  a été detruit" );
                    firstIsTouched = true;
                }
            }
        }
        return firstIsTouched;
    }

    private List<Position> orderSet(List<Position> set,Direction dir){
        switch (dir){
            case NORTH:
            case SOUTH:
                List<Position> numbersList = new ArrayList<Position>(set) ;        //set -> list
                numbersList.sort(new Comparator<Position>() {
                    @Override
                    public int compare(Position o1, Position o2) {
                        return o1.getY() - o2.getY() ;
                    }
                });
                return numbersList;
            case EAST:
            case WEST:
                List<Position> numbersList1 = new ArrayList<Position>(set) ;        //set -> list
                numbersList1.sort(new Comparator<Position>() {
                    @Override
                    public int compare(Position o1, Position o2) {
                        return o1.getX() - o2.getX() ;
                    }
                });
                return numbersList1 ;
            default:
                return set;
        }
    }

    private List<Position> obsInRange(Position position){
        final List<Position> tmpList = new ArrayList<>();
        switch (position.getDirection()){
            case EAST:
                for(int i = position.getX() + 1; i<= this.distance + position.getX(); i++ ){
                    tmpList.add(Position.of(i,position.getY(),position.getDirection()));
                }
                return tmpList;
            case WEST:
                for(int i = position.getX() - 1; i >= position.getX() - this.distance ; i-- ){
                    tmpList.add(Position.of(i,position.getY(),position.getDirection()));
                }
                return tmpList;
            case NORTH:
                for(int i = position.getY() + 1; i<= this.distance + position.getY(); i++ ){
                    tmpList.add(Position.of(position.getX(),i,position.getDirection()));
                }
                return tmpList;
            case SOUTH:
                for(int i = position.getY() - 1; i >= position.getY() - this.distance ; i-- ){
                    tmpList.add(Position.of(position.getX(),i,position.getDirection()));
                }
                return tmpList;
            default: return tmpList;
        }
    }

    private Laser configureLaserRange(int range){
        this.distance = range;
        return this;
    }
}
