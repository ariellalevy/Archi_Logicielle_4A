package com.esiea.tp4A;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeplacementsTest {
    private final MarsRover rover = new MarsRover().initialize(Position.of(0,0,Direction.NORTH));

    @Test
    void move(){
        Position newPosition = rover.move("f");
        assertThat(newPosition)
            .as("test move command f (0,0,NORTH) -> (0,1,NORTH)")
            .isEqualTo(Position.of(0,1, Direction.NORTH));
        newPosition = rover.move("b");
        assertThat(newPosition)
            .as("test move command b (0,0,NORTH) -> (0,-1,NORTH)")
            .isEqualTo(Position.of(0,-1, Direction.NORTH));
        newPosition = rover.move("l");
        assertThat(newPosition)
            .as("test move command l (0,0,NORTH) -> (0,0,NORTH)")
            .isEqualTo(Position.of(0,0, Direction.NORTH));
        newPosition = rover.move("r");
        assertThat(newPosition)
            .as("test move command r (0,0,NORTH) -> (0,0,NORTH)")
            .isEqualTo(Position.of(0,0, Direction.NORTH));
    }
}
