package com.esiea.tp4A;

import com.esiea.tp4A.code.Plateau;
import com.esiea.tp4A.code.Rover;
import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DeplacementsTest {
        private final Rover roverNorth = (Rover) new Rover(Position.of(0, 0, Direction.NORTH));
        private final Rover roverSouth = (Rover) new Rover(Position.of(0, 0, Direction.SOUTH));
        private final Rover roverEast = (Rover) new Rover(Position.of(0, 0, Direction.EAST));
        private final Rover roverWest = (Rover) new Rover(Position.of(0, 0, Direction.WEST));
        private final Rover roverSphere = (Rover) new Rover(Position.of(0, 50, Direction.NORTH));
        private final Plateau plateau = new Plateau(100);

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
    /* Orientation Nord */
    @Test
    void move_forward_north() {
        Position newPosition = roverNorth.move("f");
        assertThat(newPosition)
            .as("Le Rover est orienté vers le Nord, après avoir utilisé la commande f").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 1, Direction.NORTH));
    }

    /* Orientation Sud */
    @Test
    void move_forward_south() {
        Position newPosition = roverSouth.move("f");
        assertThat(newPosition)
            .as("Le Rover est orienté vers le Sud, après avoir utilisé la commande f").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, -1, Direction.SOUTH));
    }

    /* Orientation Ouest */
    @Test
    void move_forward_west() {
        Position newPosition = roverWest.move("f");
        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Ouest, après avoir utilisé la commande f").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(-1, 0, Direction.WEST));
    }

    /* Orientation Est */
    @Test
    void move_forward_east() {
        Position newPosition = roverEast.move("f");
        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Est, après avoir utilisé la commande f").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(1, 0, Direction.EAST));
    }

    /* Utilisation de la commande b (backward) */

    /* Orientation Nord */
    @Test
    void move_backward_north() {
        Position newPosition = roverNorth.move("b");
        assertThat(newPosition)
            .as("Le Rover est orienté vers le Nord, après avoir utilisé la commande b").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, -1, Direction.NORTH));
    }

    /* Orientation Sud */
    @Test
    void move_backward_south() {
        Position newPosition = roverSouth.move("b");
        assertThat(newPosition)
            .as("Le Rover est orienté vers le Sud, après avoir utilisé la commande f").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 1, Direction.SOUTH));
    }

    /* Orientation Oues */
    @Test
    void move_backward_west() {
        Position newPosition = roverWest.move("b");
        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Ouest, après avoir utilisé la commande f").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(1, 0, Direction.WEST));
    }

    /* Orientation Est */
    @Test
    void move_backward_east() {
        Position newPosition = roverEast.move("b");
        assertThat(newPosition)
            .as("Le Rover est orienté vers l'Est, après avoir utilisé la commande f").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(-1, 0, Direction.EAST));
    }

    /* Utilisation de la commande r (right) */

    /* Orientation Nord */
    @Test
    void move_right_north() {
        Position newPosition = roverNorth.move("r");
        assertThat(newPosition)
            .as("Le Rover est orienté vers l'est, après avoir utilisé la commande r").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.EAST));
    }

    /* Orientation Sud */
    @Test
    void move_right_south() {
        Position newPosition = roverSouth.move("r");
        assertThat(newPosition)
            .as("Le Rover est orienté vers l'ouest, après avoir utilisé la commande r").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.WEST));
    }

    /* Orientation Ouest */
    @Test
    void move_right_west() {
        Position newPosition = roverWest.move("r");
        assertThat(newPosition)
            .as("Le Rover est orienté vers le nord, après avoir utilisé la commande r").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.NORTH));
    }

    /* Orientation Est */
    @Test
    void move_right_east() {
        Position newPosition = roverEast.move("r");
        assertThat(newPosition)
            .as("Le Rover est orienté vers le sud, après avoir utilisé la commande r").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.SOUTH));
    }

    /* Utilisation de la commande l (left) */
    /* Orientation Nord */
    @Test
    void move_left_north() {
        Position newPosition = roverNorth.move("l");
        assertThat(newPosition)
            .as("Le Rover est orienté vers l'ouest, après avoir utilisé la commande l").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.WEST));
    }

    /* Orientation Sud */
    @Test
    void move_left_south() {
        Position newPosition = roverSouth.move("l");
        assertThat(newPosition)
            .as("Le Rover est orienté vers l'est, après avoir utilisé la commande l").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.EAST));
    }

    /* Orientation Ouest */
    @Test
    void move_left_west() {
        Position newPosition = roverWest.move("l");
        assertThat(newPosition)
            .as("Le Rover est orienté vers le sud, après avoir utilisé la commande l").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.SOUTH));
    }

    /* Orientation Est */
    @Test
    void move_left_east() {
        Position newPosition = roverEast.move("l");
        assertThat(newPosition)
            .as("Le Rover est orienté vers le nord, après avoir utilisé la commande l").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, 0, Direction.NORTH));
    }
    /* test de plusieurs deplacement*/
    @Test
    void give_order_move() {
    	char command[] = {'f','f','l','b'};
    	Position newPosition = roverNorth.give_order(command);
        assertThat(newPosition)
            .as("Le Rover est a la position (1, 2, W), après avoir utilisé les commande [f, f, l, b]").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(1, 2, Direction.WEST));
    }
    
    /* Deplacement sur un plateau spherique*/
    @Test
    void move_forward_sphere() {
    	plateau.setTaille(100);roverSphere.setPlateau(plateau);
    	Position newPosition = roverSphere.move("f");
        assertThat(newPosition)
            .as("Le Rover est orienté vers le nord a l'opposer, après avoir utilisé la commande f").extracting(Position::getX, Position::getY, Position::getDirection)
            .isEqualTo(List.of(0, -49, Direction.NORTH));
    }
}