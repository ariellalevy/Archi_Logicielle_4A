package com.esiea.tp4A;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.esiea.tp4A.code.Plateau;
import com.esiea.tp4A.code.Rover;
import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;

public class RoverTest {
	private final Rover rover = new Rover(Position.of(0, 0, Direction.NORTH));
	private final Plateau plateau = new Plateau(100);
	
	@Test
    void move() {
        Position newPosition = rover.move("f");
        assertThat(newPosition)
            .as("Déplacement rover").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 1, Direction.NORTH));
        rover.setPosition(Position.of(1, 2, Direction.SOUTH));
        assertThat("[" + rover.getPosition().getX() + "," + rover.getPosition().getY() + "," + rover.getPosition().getDirection() + "]")
        	.isEqualTo("[1,2,SOUTH]");
    }

    @Test
    void give_order_move() {
    	char command[] = {'f','b','l','r'};
    	Position newPosition = rover.give_order(command);
        assertThat(newPosition)
            .as("commande de déplacement retour au point de départ").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.NORTH));
        }
    
    @Test
    void setAlive() {
    	assertThat(rover.setAlive(true)).isEqualTo(rover.isAlive());
    }
    
    @Test
    void set_get_joueur() {
    	rover.setNumeroRover(10);
    	assertThat(rover.getNumeroRover()).isEqualTo(10);
    }
    
    @Test
    void set_Plateau() {
    	rover.setPlateau(plateau);
    	assertThat(plateau.getTaille());
    }
}
