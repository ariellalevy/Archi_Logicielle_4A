package com.esiea.tp4A.domain;

import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;

public class RoverMove implements MarsRover {

    Position position = new PositionRover(0,0, NORTH); // position initiale


    public RoverMove(int x, int y, Direction direction){}

    @java.lang.Override
    public Position move(String command) {
        if(command.isEmpty()){
            return Position.of(0,0,Direction.NORTH);
        }
            switch(command.charAt(0)) {
                case 'f':
                    switch (this.position.getDirection()){
                        case NORTH:
                            //grille sphérique
                            if(this.position.getY() == 50){
                                this.position = Position.of(this.position.getX(), -49,this.position.getDirection())
                            }
                            this.position = Position.of(this.position.getX(), this.position.getY()+1,this.position.getDirection());
                            return this.position;
                        case SOUTH:
                            //grille sphérique
                            if(this.position.getY() == -50){
                                this.position = Position.of(this.position.getX(), 49,this.position.getDirection())
                            }
                            this.position = Position.of(this.position.getX(), this.position.getY()-1,this.position.getDirection());
                            return this.position;
                        case EAST:
                            this.position = Position.of(this.position.getX()+1, this.position.getY(),this.position.getDirection());
                            return this.position;
                        case WEST:
                            this.position = Position.of(this.position.getX()-1, this.position.getY(),this.position.getDirection());
                            return this.position;
                        default: System.out.println("Erreur commande 'f'");
                        break;
                    }

                case 'b':
                    switch (this.position.getDirection()){
                        case NORTH:
                            //grille sphérique
                            if(this.position.getY() == -50){
                                this.position = Position.of(this.position.getX(), 49,this.position.getDirection())
                            }
                            this.position = Position.of(this.position.getX(), this.position.getY()-1,this.position.getDirection());
                            return this.position;
                        case SOUTH:
                            //grille sphérique
                            if(this.position.getY() == 50){
                                this.position = Position.of(this.position.getX(), -49,this.position.getDirection())
                            }
                            this.position = Position.of(this.position.getX(), this.position.getY()+1,this.position.getDirection());
                            return this.position;
                        case EAST:
                            this.position = Position.of(this.position.getX()-1, this.position.getY(),this.position.getDirection());
                            return this.position;
                        case WEST:
                            this.position = Position.of(this.position.getX()+1, this.position.getY(),this.position.getDirection());
                            return this.position;
                        default: System.out.println("Erreur commande 'b'");
                            break;
                    }
                case 'l':
                    switch (this.position.getDirection()) {
                        case NORTH:
                            this.position = Position.of(this.position.getX(), this.position.getY(), Direction.WEST);
                            return this.position;
                        case SOUTH:
                            this.position = Position.of(this.position.getX(), this.position.getY(), Direction.EAST);
                            return this.position;
                        case EAST:
                            this.position = Position.of(this.position.getX(), this.position.getY(), Direction.NORTH);
                            return this.position;
                        case WEST:
                            this.position = Position.of(this.position.getX(), this.position.getY(), Direction.SOUTH);
                            return this.position;
                        default:
                            System.out.println("Erreur commande 'l'");
                            break;
                    }
                case 'r':
                    switch (this.position.getDirection()) {
                        case NORTH:
                            this.position = Position.of(this.position.getX(), this.position.getY(), Direction.EAST);
                            return this.position;
                        case SOUTH:
                            this.position = Position.of(this.position.getX(), this.position.getY(), Direction.WEST);
                            return this.position;
                        case EAST:
                            this.position = Position.of(this.position.getX(), this.position.getY(), Direction.SOUTH);
                            return this.position;
                        case WEST:
                            this.position = Position.of(this.position.getX(), this.position.getY(), Direction.NORTH);
                            return this.position;
                        default:
                            System.out.println("Erreur commande 'r'");
                            break;
                    }


                default:	System.out.println("Error!");
                    return Position.of(0,0,Direction.NORTH);
            }
        }


    public  void give_order(char[] command){
        int i = 0;
        for( i =0; i< command.length; i++){
            String cmd ="";
            cmd +=command[i];
            move(cmd);
        }
    }
}
