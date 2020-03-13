package com.esiea.tp4A.domain;

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
