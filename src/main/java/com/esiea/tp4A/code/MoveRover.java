package com.esiea.tp4A.code;

import java.util.List;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.Position;

public class MoveRover implements MarsRover{
	
    public Position move(String command,Position position, List<Position> setObstaclesPositions, Plateau map) {
        if(command.isEmpty()){
            return Position.of(0,0,Direction.NORTH);
        }
        Position anciennePosition = position;
        switch(command.charAt(0)) {
            case 'f':
                switch (position.getDirection()){
                    case NORTH:
                    	if(map != null) {
                    		//grille sphérique
                            if((map.getTaille() == 100) && (position.getY() == 50)){
                                position = Position.of(position.getX(), -49,position.getDirection());
                            }
                            else if((map.getTaille() == 300) && (position.getY() == 150)){
                                position = Position.of(position.getX(), -149,position.getDirection());
                            }

                            else if((map.getTaille() == 600) && (position.getY() == 300)){
                                position = Position.of(position.getX(), -200,position.getDirection());
                            }
                    	}else {
                    		position = Position.of(position.getX(), position.getY()+1,position.getDirection());
                    	}
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) + 1) +", de coordonnées (" +p.getX() +", " + p.getY() +")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case SOUTH:
                        if(map != null) {
                        	//grille sphérique
                            if((map.getTaille() == 100) && (position.getY() == -50)){
                                position = Position.of(position.getX(), 49,position.getDirection());
                            }
                            if((map.getTaille() == 300) && (position.getY() == -150)){
                                position = Position.of(position.getX(), 149,position.getDirection());
                            }
                            if((map.getTaille() == 600) && (position.getY() == -300)){
                                position = Position.of(position.getX(), 299,position.getDirection());
                            }
                        }else {
                        	position = Position.of(position.getX(), position.getY()-1,position.getDirection());
                        }
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case EAST:
                        position = Position.of(position.getX()+1, position.getY(),position.getDirection());
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case WEST:
                        position = Position.of(position.getX()-1, position.getY(),position.getDirection());
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    default: System.out.println("Erreur commande 'f'");
                        break;
                }

            case 'b':
                switch (position.getDirection()){
                    case NORTH:
                    	if(map != null) {
                    		//grille sphérique
                            if((map.getTaille() == 100) && (position.getY() == -50)){
                                position = Position.of(position.getX(), 49,position.getDirection());
                            }
                            if((map.getTaille() == 300) && (position.getY() == -150)){
                                position = Position.of(position.getX(), 149,position.getDirection());
                            }
                            if((map.getTaille() == 600) && (position.getY() == -300)){
                                position = Position.of(position.getX(), 299,position.getDirection());
                            }
                    	}else {
                    		position = Position.of(position.getX(), position.getY()-1,position.getDirection());
                    	}
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case SOUTH:
                    	if(map != null) {
                    		//grille sphérique
                            if((map.getTaille() == 100) && (position.getY() == 50)){
                                position = Position.of(position.getX(), -49,position.getDirection());
                            }
                            if((map.getTaille() == 300) && (position.getY() == 150)){
                                position = Position.of(position.getX(), -149,position.getDirection());
                            }
                            if((map.getTaille() == 600) && (position.getY() == 300)){
                                position = Position.of(position.getX(), -299,position.getDirection());
                            }
                    	}else {
                    		position = Position.of(position.getX(), position.getY()+1,position.getDirection());
                    	}
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case EAST:
                        position = Position.of(position.getX()-1, position.getY(),position.getDirection());
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case WEST:
                        position = Position.of(position.getX()+1, position.getY(),position.getDirection());
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    default: System.out.println("Erreur commande 'b'");
                        break;
                }
            case 'l':
                switch (position.getDirection()) {
                    case NORTH:
                        position = Position.of(position.getX(), position.getY(), Direction.WEST);
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case SOUTH:
                        position = Position.of(position.getX(), position.getY(), Direction.EAST);
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case EAST:
                        position = Position.of(position.getX(), position.getY(), Direction.NORTH);
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case WEST:
                        position = Position.of(position.getX(), position.getY(), Direction.SOUTH);
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    default:
                        System.out.println("Erreur commande 'l'");
                        break;
                }
            case 'r':
                switch (position.getDirection()) {
                    case NORTH:
                    	//System.out.println("HOLA");
                        position = Position.of(position.getX(), position.getY(), Direction.EAST);
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case SOUTH:
                    	//System.out.println("BONJOUR");
                        position = Position.of(position.getX(), position.getY(), Direction.WEST);
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case EAST:
                    	//System.out.println("Dzien dobre");
                        position = Position.of(position.getX(), position.getY(), Direction.SOUTH);
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    case WEST:
                        position = Position.of(position.getX(), position.getY(), Direction.NORTH);
                        if(setObstaclesPositions != null) {
                        	//Detection d'obstacles
                            for(Position p : setObstaclesPositions) {
                            	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
                            		System.out.println("Malheur! Un obstacle (le numéro " +(setObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
                                	position = anciennePosition;
                            	}
                            }
                        }
                        return position;
                    default:
                        System.out.println("Erreur commande 'r'");
                        break;
                }
            default:	System.out.println("Error!");
                return Position.of(0,0,Direction.NORTH);
        }
    }
    
    public  Position give_order(char[] command, Position position, List<Position> setObstaclesPositions, Plateau map){ 
        for(int  i =0; i< command.length; i++){
            String cmd ="";
            cmd +=command[i];
            position = move(cmd, position, setObstaclesPositions, map);
        }
        return position;
    }
}
