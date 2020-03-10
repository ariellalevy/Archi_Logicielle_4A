package com.esiea.tp4A.domain;

import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;

public class RoverMove implements MarsRover {

    public RoverMove(int x, int y, Direction direction){}

    @java.lang.Override
    public Position move(String command) {
        if(command.isEmpty()){
            return Position.of(0,0,Direction.NORTH);
        }
        char[] cmd = command.toCharArray();
        int size = cmd.length;
        for (int i = 0; i < size; i ++) {
            switch(cmd[i]) {
                case 'f':
                    return Position.of(0,1, Direction.NORTH);
                    break;
                case 'b':
                    return Position.of(0,-1, Direction.NORTH);
                    break;
                case 'l':
                    return Position.of(0,0, Direction.WEST);
                    break;
                case 'r':
                    return Position.of(0,0, Direction.EAST);
                    break;
                default:	System.out.println("Error!");
                    break;
            }
        }
    }



}
