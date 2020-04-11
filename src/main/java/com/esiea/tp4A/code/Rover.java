package com.esiea.tp4A.code;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.Position;

public class Rover implements MarsRover, Position {
    int positionX;
    int positionY;
    Direction direction;
    Position position;

    public Rover(int Range,int positionX,int positionY){
            configureLaserRange(Range);

    }

    @Override
    public Position move(String command) {
        for (char letter: command.toCharArray()) {
            switch (letter){
                case 'f': moveByDirection(1);
                break;
                case 'b': moveByDirection(-1);
                    break;
                case 'l': moveByDirection(1);
                    break;
                case 'r': moveByDirection(1);
                    break;

            }
        }
    }

    private void moveByDirection(int dir){
        switch (direction){
            case NORTH: positionY += dir;
            case EAST: positionX += dir;
            case WEST: positionX -= dir;
            case SOUTH: positionY -= dir;
            default:break;
        }
    }
}
