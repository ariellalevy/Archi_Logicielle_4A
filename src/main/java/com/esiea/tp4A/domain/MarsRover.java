package com.esiea.tp4A.domain;

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
        String N = "North";
        return Position.of(0, 0, N);
    }
}
