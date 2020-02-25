package com.esiea.tp4A.code;

public class Laser {

    private int distance ; // distance maximale du laser en cm

    public Laser(int distance){
            this.distance = distance;
    }

    public boolean TouchTarget(int distance, int TargetPosX, int TargetPosY, int RoverPosX, int RoverPosY, string Direction){

        if(RoverPosX - TargetPosX < distance) {
            return true;
        }
        else {
            return false;
        }
    }
}
