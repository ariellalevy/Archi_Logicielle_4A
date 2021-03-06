package com.esiea.tp4A.domain;
import java.lang.String;

public interface MarsRover {

    default MarsRover initialize(Position position) {
        return this;
    }

    default MarsRover updateMap(PlanetMap map) {
        return this;
    }

    default MarsRover configureLaserRange(int range) {
        return this;
    }

    default Position move(String command) {
        Direction n= Direction.NORTH;
        return Position.of(0, 0, n);
    }
}
