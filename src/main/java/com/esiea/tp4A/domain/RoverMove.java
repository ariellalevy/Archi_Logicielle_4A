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
            switch(command.charAt(0)) {
                case 'f':
                    return Position.of(0,1, Direction.NORTH);
                case 'b':
                    return Position.of(0,-1, Direction.NORTH);
                case 'l':
                    return Position.of(0,0, Direction.WEST);
                case 'r':
                    return Position.of(0,0, Direction.EAST);
                default:	System.out.println("Error!");
                    return Position.of(0,0,Direction.NORTH);
            }
        }


    public  Position give_order(char[] command){
        Position position = Position.of(0,0,Direction.NORTH);
        int i = 0;
        for( i =0; i< command.length; i++){
            String cmd ="";
            cmd +=command[i];
            position = move(cmd);
        }
        return position;
    }
}
