package com.esiea.tp4A.domain;

import com.esiea.tp4A.code.RoverMove;
import org.junit.Test;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DeplacementsTest {

        private final RoverMove roverNorth = (RoverMove) new RoverMove().initialize(Position.of(0, 0, Direction.NORTH));
        private final RoverMove roverSouth = (RoverMove) new RoverMove().initialize(Position.of(0, 0, Direction.SOUTH));
        private final RoverMove roverEast = (RoverMove) new RoverMove().initialize(Position.of(0, 0, Direction.EAST));
        private final RoverMove roverWest = (RoverMove) new RoverMove().initialize(Position.of(0, 0, Direction.WEST));

    /* Utilisation d'une commande inconnue */

    @Test
    void move_unknown_command() {
        Position newPosition = roverNorth.move("a");

        assertThat(newPosition)
            .as("Position du Rover, après un commande inconnue")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.NORTH));
    }

    /* Utilisation de la commande f (forward) */

    @Test
    void move_forward_north() {
        Position newPosition = roverNorth.move("f");

        assertThat(newPosition)
            .as("Le Rover est orienté vers le Nord, après avoir utilisé la commande f")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 1, Direction.NORTH));
    }

    @Test
    void move_forward_south() {
        Position newPosition = roverSouth.move("f");

        assertThat(newPosition)
            .as("Le Rover est orienté vers le Sud, après avoir utilisé la commande f")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, -1, Direction.SOUTH));
    }

    @Test
    void move_forward_west() {
        Position newPosition = roverWest.move("f");

        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Ouest, après avoir utilisé la commande f")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(-1, 0, Direction.WEST));
    }

    @Test
    void move_forward_east() {
        Position newPosition = roverEast.move("f");

        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Est, après avoir utilisé la commande f")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(1, 0, Direction.EAST));
    }

    /* Utilisation de la commande b (backward) */

    @Test
    void move_backward_north() {
        Position newPosition = roverNorth.move("b");

        assertThat(newPosition)
            .as("Le Rover est orienté vers le Nord, après avoir utilisé la commande b")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, -1, Direction.NORTH));
    }

    @Test
    void move_backward_south() {
        Position newPosition = roverSouth.move("b");

        assertThat(newPosition)
            .as("Le Rover est orienté vers le Sud, après avoir utilisé la commande f")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 1, Direction.SOUTH));
    }

    @Test
    void move_backward_west() {
        Position newPosition = roverWest.move("b");

        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Ouest, après avoir utilisé la commande f")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(-1, 0, Direction.WEST));
    }

    @Test
    void move_backward_east() {
        Position newPosition = roverEast.move("b");

        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Est, après avoir utilisé la commande f")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(1, 0, Direction.EAST));
    }

    /* Utilisation de la commande r (right) */

    @Test
    void move_right_north() {
        Position newPosition = roverNorth.move("r");

        assertThat(newPosition)
            .as("Le Rover est orienté vers le Nord, après avoir utilisé la commande r")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.NORTH));
    }

    @Test
    void move_right_south() {
        Position newPosition = roverSouth.move("r");

        assertThat(newPosition)
            .as("Le Rover est orienté vers le Sud, après avoir utilisé la commande r")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.SOUTH));
    }

    @Test
    void move_right_west() {
        Position newPosition = roverWest.move("r");

        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Ouest, après avoir utilisé la commande r")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.WEST));
    }

    @Test
    void move_right_east() {
        Position newPosition = roverEast.move("r");

        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Est, après avoir utilisé la commande r")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.EAST));
    }

    /* Utilisation de la commande l (left) */

    @Test
    void move_left_north() {
        Position newPosition = roverNorth.move("l");

        assertThat(newPosition)
            .as("Le Rover est orienté vers le Nord, après avoir utilisé la commande l")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.NORTH));
    }

    @Test
    void move_left_south() {
        Position newPosition = roverSouth.move("l");

        assertThat(newPosition)
            .as("Le Rover est orienté vers le Sud, après avoir utilisé la commande l")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.SOUTH));
    }

    @Test
    void move_left_west() {
        Position newPosition = roverWest.move("l");

        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Ouest, après avoir utilisé la commande l")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.WEST));
    }

    @Test
    void move_left_east() {
        Position newPosition = roverEast.move("l");

        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Est, après avoir utilisé la commande l")
            .extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.EAST));
    }
}
