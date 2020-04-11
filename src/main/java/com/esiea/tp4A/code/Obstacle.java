package com.esiea.tp4A.code;

import java.util.HashSet;
import java.util.Set;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;

public class Obstacle { //Implement Planet MAP ?
        private int positionX;//correspond à l'origine (gauche) en X
        private int positionY;//correspond à l'origine (gauche) en Y
        private Direction direction;
        private Position position;
        
        public Obstacle(int posX,int posY, Direction direction){
           positionX = posX;
           positionY = posY;
           this.direction = direction;
           position = Position.of(posX, posY, direction);
        }

        public int getPositionX(){
            return positionX;
        }

        public int getPositionY(){
            return positionY;
        }
        
        public Direction getDirection() {
        	return direction;
        }
        
        public Position getPosition() {
        	return position;
        }
}
