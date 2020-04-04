package com.esiea.tp4A.domain;

import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;

public class Rover implements MarsRover{



    private Position position;
    private Plateau plateau;
    private boolean alive;



    public Rover(Position position){
        this.position = position;
        this.initialize(position);
    }


    @Override
    public  MarsRover initialize(Position position) {
        position = new Position.FixedPosition(0,0, Direction.NORTH);
        return  this;

    }



    @Override
    public Position move(String command) {
        if(command.isEmpty()){
            return Position.of(0,0,Direction.NORTH);
        }
            switch(command.charAt(0)) {
                case 'f':
                    switch (this.position.getDirection()){
                        case NORTH:


                            //grille sphérique

                            if((plateau.getTaille() == 50) && (this.position.getY() == 50)){
                                this.position = Position.of(this.position.getX(), -49,this.position.getDirection());
                            }
                            if((plateau.getTaille() == 150) && (this.position.getY() == 150)){
                                this.position = Position.of(this.position.getX(), -149,this.position.getDirection());
                            }

                            if((plateau.getTaille() == 300) && (this.position.getY() == 300)){
                                this.position = Position.of(this.position.getX(), -200,this.position.getDirection());
                            }

                            this.position = Position.of(this.position.getX(), this.position.getY()+1,this.position.getDirection());
                            return this.position;
                        case SOUTH:

                            //grille sphérique
                            if((plateau.getTaille() == 50) && (this.position.getY() == -50)){
                                this.position = Position.of(this.position.getX(), 49,this.position.getDirection());
                            }
                            if((plateau.getTaille() == 150) && (this.position.getY() == -150)){
                                this.position = Position.of(this.position.getX(), 149,this.position.getDirection());
                            }
                            if((plateau.getTaille() == 300) && (this.position.getY() == -300)){
                                this.position = Position.of(this.position.getX(), 299,this.position.getDirection());
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
                            if((plateau.getTaille() == 50) && (this.position.getY() == -50)){
                                this.position = Position.of(this.position.getX(), 49,this.position.getDirection());
                            }
                            if((plateau.getTaille() == 150) && (this.position.getY() == -150)){
                                this.position = Position.of(this.position.getX(), 149,this.position.getDirection());
                            }
                            if((plateau.getTaille() == 300) && (this.position.getY() == -300)){
                                this.position = Position.of(this.position.getX(), 299,this.position.getDirection());
                            }
                            this.position = Position.of(this.position.getX(), this.position.getY()-1,this.position.getDirection());
                            return this.position;
                        case SOUTH:

                            //grille sphérique
                            if((plateau.getTaille() == 50) && (this.position.getY() == 50)){
                                this.position = Position.of(this.position.getX(), -49,this.position.getDirection());
                            }
                            if((plateau.getTaille() == 150) && (this.position.getY() == 150)){
                                this.position = Position.of(this.position.getX(), -149,this.position.getDirection());
                            }
                            if((plateau.getTaille() == 300) && (this.position.getY() == 300)){
                                this.position = Position.of(this.position.getX(), -299,this.position.getDirection());
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

    public boolean setAlive(boolean value){
        this.alive = value;
        return alive;
    }

    public boolean isAlive(){
        return alive;
    }
}
