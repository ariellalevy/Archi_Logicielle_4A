package com.esiea.tp4A.code;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.Position;

public class Rover implements MarsRover{
    private Position position;
    private Plateau map;
    private boolean alive;
    private int numeroRover;
    private List<Position> setObstaclesPositions;
    
    public Rover(Position position){
        this.position = position;
        this.initialize(position);
        this.alive = true;
        numeroRover = 0;
    }
    
    @Override
    public  MarsRover initialize(Position position) {
        position = new Position.FixedPosition(0,0, Direction.NORTH);
        return  this;
    }

    @Override
    public Position move(String command) {
    	return MoveRover.move(command, this.position, this.setObstaclesPositions, this.map);
    }
    
    public  Position give_order(char[] command){ 
    	return MoveRover.give_order(command, this.position, this.setObstaclesPositions, this.map);
    }

    public boolean setAlive(boolean value){
        this.alive = value;
        return alive;
    }

    public boolean isAlive(){return alive;}

    public void setPosition(Position position) {this.position = position;}
    
    public Position getPosition() {return position;}
    
    public int getNumeroRover() {return numeroRover;}
    
    public void setNumeroRover(int numero) {numeroRover = numero;}
    
    public void setPlateau(Plateau plateau) {this.map = plateau;}
    
    public void setObstaclesMap(List<Position> setObstaPositions) {setObstaclesPositions = setObstaPositions;}
}