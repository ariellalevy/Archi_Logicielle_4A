package com.esiea.tp4A.code;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;

public class PositionRover implements Position {

    private int x;
    private int y;
    private Direction direction;

    public PositionRover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }
}