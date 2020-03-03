package com.esiea.tp4A.code;

public class Laser {

    private int distance ; // distance maximale du laser en cm

    public Laser(int distance){
        this.distance = distance;
    }

    public boolean TouchTarget(int distance, int TargetPosX, int TargetPosY, int RoverPosX, int RoverPosY, String Direction){

        Direction = Rover.getDirection();
        switch (Direction){
            case EAST :
                break;
            case WEST :
                break;
            case NORTH :
                break;
            case SOUTH :
                break;
        }
        if(RoverPosX - TargetPosX < distance) {
            return true;
        }
        else {
            return false;
        }
    }
}
