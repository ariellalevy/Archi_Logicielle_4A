package com.esiea.tp4A;

import com.esiea.tp4A.code.Obstacle;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class ObstacleTest {

private final Obstacle obstacle = new Obstacle(20,36, null);
    @Test
    void testPosition(){
        assertThat(obstacle.getPositionX() == 20 && obstacle.getPositionY() == 36);
        System.out.println("test Passed "+"Les positions sont :"+"X : "+ obstacle.getPositionX()+"Y : "+ obstacle.getPositionY());
    }
}
