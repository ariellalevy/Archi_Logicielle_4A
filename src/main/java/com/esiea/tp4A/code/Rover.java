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
    private List<Position> lstObstaclesPositions;
    
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
    
    
    public Position spheriqueOrdonnees(int taille, int y) {
    	Position newPosition=null;
    	if((map.getTaille() == taille) && (this.position.getY()==y)) {
    		if(y >=0) {
    			newPosition = Position.of(this.position.getX(), (this.position.getY() +(-2*taille)+1), this.position.getDirection());
    		}
    		else {
    			newPosition = Position.of(this.position.getX(), (this.position.getY() +(-2*taille)-1), this.position.getDirection());
    		}
		}
    	return newPosition;
    }
    
    
    public Position spheriqueAbscises(int taille, int x) {
    	Position newPosition=null;
    	if((map.getTaille() == taille) && (this.position.getX()==x)) {
    		if(x >=0) {
    			newPosition = Position.of((this.position.getX() +(-2*taille)+1),this.position.getY(), this.position.getDirection());
    		}
    		else {
    			newPosition = Position.of((this.position.getY() +(-2*taille)-1), this.position.getY(), this.position.getDirection());
    		}
		}
    	return newPosition;
      }
    
    public Position detectObstacles(Position anciennePosition) {
    	 
    	 //Position newPosition = null;
    	 for(Position p : lstObstaclesPositions) {
         	if((p.getX() == position.getX()) && (p.getY() == position.getY())){
         		System.out.println("Malheur! Un obstacle (le numéro " +(lstObstaclesPositions.indexOf(p) +1) +", de coordonnées (" +p.getX() +", " + p.getY() + ")) nous barre la route! Revenons à notre ancienne position... ");
             	position = anciennePosition;
         	}
    	 }
    	 return position;
    }
    

    @Override
    public Position move(String command) {
        if(command.isEmpty()){
            return Position.of(0,0,Direction.NORTH);
        }       
        Position anciennePosition = position;
        switch(command.charAt(0)) {
            case 'f':
                switch (this.position.getDirection()){
                    case NORTH:
                    	//System.out.println("TEST 1");
                        //grille sphérique
                    	if(spheriqueAbscises(100, 50) !=null) { this.position =spheriqueAbscises(100, 50);}
                    	if(spheriqueAbscises(300, 150) !=null) { this.position =spheriqueAbscises(300, 150);}
                    	if(spheriqueAbscises(600, 300) !=null) { this.position =spheriqueAbscises(600, 300);}
                        //System.out.println("HELLO 1")  
                    	this.position = Position.of(this.position.getX(), this.position.getY()+1,this.position.getDirection());
                        //Detection d'obstacles
                    	if(detectObstacles(anciennePosition)!=null) {
                    		System.out.println("ICI");
                    		this.position = detectObstacles(anciennePosition);}     
                        return this.position;
                    case SOUTH:
                    	//System.out.println("TEST 2");
                        //grille sphérique
                    	if(spheriqueAbscises(100, -50) !=null) { this.position =spheriqueAbscises(100, -50);}
                    	if(spheriqueAbscises(300, -150) !=null) { this.position =spheriqueAbscises(300, -150);}
                    	if(spheriqueAbscises(600, -300) !=null) { this.position =spheriqueAbscises(600, -300);}
                        //System.out.println("HELLO 2");   
                    	this.position = Position.of(this.position.getX(), this.position.getY()-1,this.position.getDirection());
                        //Detection d'obstacles
                    	if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}
                        return this.position;
                    case EAST:
                    	//System.out.println("TEST 3");
                    	if(spheriqueOrdonnees(100, -50) !=null) { this.position =spheriqueOrdonnees(100, -50);}
                    	if(spheriqueOrdonnees(300, -150) !=null) { this.position =spheriqueOrdonnees(300, -150);}
                    	if(spheriqueOrdonnees(600, -300) !=null) { this.position =spheriqueOrdonnees(600, -300);}
                        this.position = Position.of(this.position.getX()+1, this.position.getY(),this.position.getDirection());
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}
                        //System.out.println("TOTO 3");
                        return this.position;
                    case WEST:
                    	//System.out.println("TEST 4");
                    	if(spheriqueOrdonnees(100, 50) !=null) { this.position =spheriqueOrdonnees(100, 50);}
                    	if(spheriqueOrdonnees(300, 150) !=null) { this.position =spheriqueOrdonnees(300, 150);}
                    	if(spheriqueOrdonnees(600, 300) !=null) { this.position =spheriqueOrdonnees(600, 300);}
                        this.position = Position.of(this.position.getX()-1, this.position.getY(),this.position.getDirection());                       
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}
                       // System.out.println("TOTO 4");
                        return this.position;
                    default: System.out.println("Erreur commande 'f'");
                        break;
                }
            case 'b':
                switch (this.position.getDirection()){
                    case NORTH:
                        //grille sphérique
                    	if(spheriqueAbscises(100, -50) !=null) { this.position =spheriqueAbscises(100, -50);}
                    	if(spheriqueAbscises(300, -150) !=null) { this.position =spheriqueAbscises(300, -150);}
                    	if(spheriqueAbscises(600, -300) !=null) { this.position =spheriqueAbscises(600, -300);}
                        this.position = Position.of(this.position.getX(), this.position.getY()-1,this.position.getDirection());                        
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}
                        return this.position;
                    case SOUTH:

                        //grille sphérique
                    	if(spheriqueAbscises(100, 50) !=null) { this.position =spheriqueAbscises(100, 50);}
                    	if(spheriqueAbscises(300, 150) !=null) { this.position =spheriqueAbscises(300, 150);}
                    	if(spheriqueAbscises(600, 300) !=null) { this.position =spheriqueAbscises(600, 300);}
                        //System.out.println("Houston nous avons un pbm50");
                        this.position = Position.of(this.position.getX(), this.position.getY()+1,this.position.getDirection());                      
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}
                        return this.position;
                    case EAST:
                    	if(spheriqueOrdonnees(100, 50) !=null) { this.position =spheriqueOrdonnees(100, 50);}
                    	if(spheriqueOrdonnees(300, 150) !=null) { this.position =spheriqueOrdonnees(300, 150);}
                    	if(spheriqueOrdonnees(600, 300) !=null) { this.position =spheriqueOrdonnees(600, 300);}
                        this.position = Position.of(this.position.getX()-1, this.position.getY(),this.position.getDirection());                       
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}
                        return this.position;
                    case WEST:
                    	if(spheriqueOrdonnees(100, -50) !=null) { this.position =spheriqueOrdonnees(100, -50);}
                    	if(spheriqueOrdonnees(300, -150) !=null) { this.position =spheriqueOrdonnees(300, -150);}
                    	if(spheriqueOrdonnees(600, -300) !=null) { this.position =spheriqueOrdonnees(600, -300);}
                        this.position = Position.of(this.position.getX()+1, this.position.getY(),this.position.getDirection()); 
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}                        
                        return this.position;
                    default: System.out.println("Erreur commande 'b'");
                        break;
                }
            case 'l':
                switch (this.position.getDirection()) {
                    case NORTH:
                        this.position = Position.of(this.position.getX(), this.position.getY(), Direction.WEST);                       
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}                         
                        return this.position;
                    case SOUTH:
                        this.position = Position.of(this.position.getX(), this.position.getY(), Direction.EAST);
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}                        
                        return this.position;
                    case EAST:
                        this.position = Position.of(this.position.getX(), this.position.getY(), Direction.NORTH); 
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}                        
                        return this.position;
                    case WEST:
                        this.position = Position.of(this.position.getX(), this.position.getY(), Direction.SOUTH);                       
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}
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

                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}                        
                        return this.position;
                    case SOUTH:
                    	//System.out.println("BONJOUR");
                        this.position = Position.of(this.position.getX(), this.position.getY(), Direction.WEST);  
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}                        
                        return this.position;
                    case EAST:
                    	//System.out.println("Dzien dobre");
                        this.position = Position.of(this.position.getX(), this.position.getY(), Direction.SOUTH);   
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}  
                        return this.position;
                    case WEST:
                    	//System.out.println("Guten tag");
                        this.position = Position.of(this.position.getX(), this.position.getY(), Direction.NORTH);                       
                      //Detection d'obstacles
                        if(detectObstacles(anciennePosition)!=null) {this.position = detectObstacles(anciennePosition);}                       
                        return this.position;
                    default:
                        System.out.println("Erreur commande 'r'");
                        break;
                }
            default:	System.out.println("Error!");
                return Position.of(0,0,Direction.NORTH);
        }
    }
    
    public  Position give_order(char[] command){
        for(int  i =0; i< command.length; i++){
            String cmd ="";
            cmd +=command[i];
            move(cmd);
        }
        return this.getPosition();
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
    
    public void setObstaclesMap(List<Position> setObstaPositions) {lstObstaclesPositions = setObstaPositions;}
}
