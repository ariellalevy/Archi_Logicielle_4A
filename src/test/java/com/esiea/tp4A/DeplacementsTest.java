package com.esiea.tp4A;

import com.esiea.tp4A.code.RoverMove;
import com.esiea.tp4A.domain.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeplacementsTest {
    private final RoverMove rover = new RoverMove(0,0,Direction.NORTH);

    @Test
    void move(){
        char[] commande = {'f', 'f', 'l', 'b'};
        Position newPosition = rover.give_order(commande);
        String str = "x: " + newPosition.getX() + " y: " + newPosition.getY() + " direction: " + newPosition.getDirection();
        assertThat(str)
            .as("test move command fflb (0,0,NORTH) -> (1,2,WEST)")
            .isEqualTo("x: 1 y: 2 direction: WEST");
    }
}
