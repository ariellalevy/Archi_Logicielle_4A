package com.esiea.tp4A.code;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.Position;

public class Rover implements MarsRover{




    private Position position;
    private Plateau map;
    private boolean alive;
    private int numeroRover;




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



// ATTENTION REPETER LA MANOEUVRE POUR TOUS LES CHARACTERES DE LA STRING
    
    //PROBLEME REPETITION DE COMMANDES !!!

    @Override
    public Position move(String command) {
        if(command.isEmpty()){
            return Position.of(0,0,Direction.NORTH);
        }

        switch(command.charAt(0)) {
            case 'f':
                switch (this.position.getDirection()){
                    case NORTH:
                    	//System.out.println("TEST 1");


                        //grille sphérique

                        if((map.getTaille() == 100) && (this.position.getY() == 50)){
                            this.position = Position.of(this.position.getX(), -49,this.position.getDirection());
                            //System.out.println("TOTO 1a");
                        }
                        else if((map.getTaille() == 300) && (this.position.getY() == 150)){
                            this.position = Position.of(this.position.getX(), -149,this.position.getDirection());
                            //System.out.println("TOTO 1b");
                        }

                        else if((map.getTaille() == 600) && (this.position.getY() == 300)){
                            this.position = Position.of(this.position.getX(), -200,this.position.getDirection());
                            //System.out.println("TOTO 1c");
                        }
                        //System.out.println("HELLO 1");
                        this.position = Position.of(this.position.getX(), this.position.getY()+1,this.position.getDirection());
                        return this.position;
                    case SOUTH:
                    	//System.out.println("TEST 2");
                        //grille sphérique
                        if((map.getTaille() == 100) && (this.position.getY() == -50)){
                            this.position = Position.of(this.position.getX(), 49,this.position.getDirection());
                            //System.out.println("TOTO 2a");
                        }
                        if((map.getTaille() == 300) && (this.position.getY() == -150)){
                            this.position = Position.of(this.position.getX(), 149,this.position.getDirection());
                            //System.out.println("TOTO 2b");
                        }
                        if((map.getTaille() == 600) && (this.position.getY() == -300)){
                            this.position = Position.of(this.position.getX(), 299,this.position.getDirection());
                           // System.out.println("TOTO 2c");
                        }
                        //System.out.println("HELLO 2");
                        this.position = Position.of(this.position.getX(), this.position.getY()-1,this.position.getDirection());
                        return this.position;
                    case EAST:
                    	//System.out.println("TEST 3");
                        this.position = Position.of(this.position.getX()+1, this.position.getY(),this.position.getDirection());
                        //System.out.println("TOTO 3");
                        return this.position;
                    case WEST:
                    	//System.out.println("TEST 4");
                        this.position = Position.of(this.position.getX()-1, this.position.getY(),this.position.getDirection());
                       // System.out.println("TOTO 4");
                        return this.position;
                    default: System.out.println("Erreur commande 'f'");
                        break;
                }

            case 'b':
                switch (this.position.getDirection()){
                    case NORTH:

                        //grille sphérique
                        if((map.getTaille() == 100) && (this.position.getY() == -50)){
                            this.position = Position.of(this.position.getX(), 49,this.position.getDirection());
                        }
                        if((map.getTaille() == 300) && (this.position.getY() == -150)){
                            this.position = Position.of(this.position.getX(), 149,this.position.getDirection());
                        }
                        if((map.getTaille() == 600) && (this.position.getY() == -300)){
                            this.position = Position.of(this.position.getX(), 299,this.position.getDirection());
                        }
                        this.position = Position.of(this.position.getX(), this.position.getY()-1,this.position.getDirection());
                        return this.position;
                    case SOUTH:

                        //grille sphérique
                        if((map.getTaille() == 100) && (this.position.getY() == 50)){
                            this.position = Position.of(this.position.getX(), -49,this.position.getDirection());
                        }
                        if((map.getTaille() == 300) && (this.position.getY() == 150)){
                            this.position = Position.of(this.position.getX(), -149,this.position.getDirection());
                        }
                        if((map.getTaille() == 600) && (this.position.getY() == 300)){
                            this.position = Position.of(this.position.getX(), -299,this.position.getDirection());
                        }
                        //System.out.println("Houston nous avons un pbm50");
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
                    	//System.out.println("HOLA");
                        this.position = Position.of(this.position.getX(), this.position.getY(), Direction.EAST);
                        return this.position;
                    case SOUTH:
                    	//System.out.println("BONJOUR");
                        this.position = Position.of(this.position.getX(), this.position.getY(), Direction.WEST);
                        return this.position;
                    case EAST:
                    	//System.out.println("Dzien dobre");
                        this.position = Position.of(this.position.getX(), this.position.getY(), Direction.SOUTH);
                        return this.position;
                    case WEST:
                    	//System.out.println("Guten tag");
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
        for(int  i =0; i< command.length; i++){
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


    public void setPosition(Position position) {
        this.position = position;
    }
    
    public Position getPosition() {
    	return position;
    }

    
    public int getNumeroRover() {
    	return numeroRover;
    }
    
    public void setNumeroRover(int numero) {
    	numeroRover = numero;
    }

    
    public void setPlateau(Plateau plateau) {
    	this.map = plateau;
    	    }

}
