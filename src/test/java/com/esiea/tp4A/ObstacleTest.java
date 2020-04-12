package com.esiea.tp4A;

import com.esiea.tp4A.code.Obstacle;
import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class ObstacleTest {

private final Obstacle obstacle = new Obstacle(20,36, Direction.NORTH);
    @Test
    void testPosition(){
        assertThat(obstacle.getPositionX()).isEqualTo(20);
        assertThat(obstacle.getPositionY()).isEqualTo(36);
        assertThat(obstacle.getDirection()).isEqualTo(Direction.NORTH);
        assertThat("[" + obstacle.getPosition().getX() + "," + obstacle.getPosition().getY() + "," + obstacle.getPosition().getDirection() + "]")
        	.isEqualTo("[20,36,NORTH]");
    }
    
}
