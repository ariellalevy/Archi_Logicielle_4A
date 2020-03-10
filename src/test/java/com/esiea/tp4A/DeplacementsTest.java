package com.esiea.tp4A;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.Position;
import com.esiea.tp4A.domain.RoverMove;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeplacementsTest {
    private final RoverMove rover = new RoverMove(0,0,Direction.NORTH);

    @Test
    void move(){
        Position newPosition = rover.move("f");
        String str = "x: " + newPosition.getX() + " y: " + newPosition.getY() + " direction: " + newPosition.getDirection();
        assertThat(str)
            .as("test move command f (0,0,NORTH) -> (0,1,NORTH)")
            .isEqualTo("x: 0 y: 1 direction: NORTH");
        newPosition = rover.move("b");
        str = "x: " + newPosition.getX() + " y: " + newPosition.getY() + " direction: " + newPosition.getDirection();
        assertThat(str)
            .as("test move command b (0,0,NORTH) -> (0,-1,NORTH)")
            .isEqualTo("x: 0 y: -1 direction: NORTH");
        newPosition = rover.move("l");
        str = "x: " + newPosition.getX() + " y: " + newPosition.getY() + " direction: " + newPosition.getDirection();
        assertThat(str)
            .as("test move command l (0,0,NORTH) -> (0,0,WEST)")
            .isEqualTo("x: 0 y: 0 direction: WEST");
        newPosition = rover.move("r");
        str = "x: " + newPosition.getX() + " y: " + newPosition.getY() + " direction: " + newPosition.getDirection();
        assertThat(str)
            .as("test move command r (0,0,NORTH) -> (0,0,EAST)")
            .isEqualTo("x: 0 y: 0 direction: EAST");
        char[] commande = {'f', 'f', 'l', 'b'};
        newPosition = rover.give_order(commande);
        str = "x: " + newPosition.getX() + " y: " + newPosition.getY() + " direction: " + newPosition.getDirection();
        assertThat(str)
            .as("test move command fflb (0,0,NORTH) -> (1,2,WEST)")
            .isEqualTo("x: 1 y: 2 direction: WEST");
    }
}
