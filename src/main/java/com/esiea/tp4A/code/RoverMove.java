package com.esiea.tp4A.code;

import com.esiea.tp4A.domain.*;

import static com.esiea.tp4A.domain.Direction.*;

public class RoverMove implements MarsRover {

    public RoverMove(int x, int y, Direction direction){}
    Position position = new PositionRover(0,0, NORTH);

    @java.lang.Override
    public Position move(String command) {
        if(command.isEmpty()){
            return this.position;
        }else{
            switch(command.charAt(0)) {
                case 'f':
                    switch (this.position.getDirection()){
                        case NORTH:
                            this.position = Position.of(this.position.getX(), this.position.getY()+1,this.position.getDirection());
                            return this.position;
                        case SOUTH:
                            this.position = Position.of(this.position.getX(), this.position.getY()-1,this.position.getDirection());
                            return this.position;
                        case EAST:
                            this.position = Position.of(this.position.getX()+1, this.position.getY(),this.position.getDirection());
                            return this.position;
                        case WEST:
                            this.position = Position.of(this.position.getX()-1, this.position.getY(),this.position.getDirection());
                            return this.position;
                    }
                case 'b':
                    switch (this.position.getDirection()){
                        case NORTH:
                            this.position = Position.of(this.position.getX(), this.position.getY()-1,this.position.getDirection());
                            return this.position;
                        case SOUTH:
                            this.position = Position.of(this.position.getX(), this.position.getY()+1,this.position.getDirection());
                            return this.position;
                        case EAST:
                            this.position = Position.of(this.position.getX()-1, this.position.getY(),this.position.getDirection());
                            return this.position;
                        case WEST:
                            this.position = Position.of(this.position.getX()+1, this.position.getY(),this.position.getDirection());
                            return this.position;
                    }
                case 'l':
                    this.position = Position.of(this.position.getX(), this.position.getY(), WEST);
                    return this.position;
                case 'r':
                    this.position = Position.of(this.position.getX(), this.position.getY(), EAST);
                    return this.position;
                default:	System.out.println("Error!");
                    return this.position;
            }
        }
    }


    public  Position give_order(char[] command){
        int i = 0;
        for( i =0; i< command.length; i++){
            String cmd ="";
            cmd +=command[i];
            this.position = move(cmd);
        }
        return this.position;
    }
}
