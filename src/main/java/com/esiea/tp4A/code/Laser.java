package com.esiea.tp4A.code;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.Position;
import com.esiea.tp4A.code.Obstacle;

public abstract class Laser implements MarsRover {

    private int distance;
    private Position position;
    private Obstacle map;

    public Laser configureLaserRange(int range){
        this.distance = range;
        return this;
    }

    public Position shootLaser() {
        Position result = null;
        int i = 0;
        boolean destroyed = false;

        while (i <= this.distance && !destroyed) {

            if (this.map.isPositionOnMap())
                destroyed = map.removeObstaclePosition();
            i++;
        }

        return result;
    }
}

