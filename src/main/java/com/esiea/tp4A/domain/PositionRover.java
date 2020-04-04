package com.esiea.tp4A.domain;

import com.esiea.tp4A.domain.Position;
import com.esiea.tp4A.domain.Direction;

public class PositionRover implements Position {

    private int x;
    private int y;
    private Direction direction;

    public PositionRover(int x, int y, Direction direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public Direction getDirection() {
        return null;
    }
}
