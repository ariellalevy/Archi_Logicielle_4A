package com.esiea.tp4A;

import com.esiea.tp4A.code.Obstacle;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ObstacleTest {

private final Obstacle obstacle = new Obstacle(20,36,5,10);
    @Test
    void testCollision(){
        assertThat(obstacle.isOnSquare(22,45));
        System.out.println("test Passed" + obstacle.isOnSquare(18,38));
    }

    void testGetPosittion(){
        int [] positions = {20,36};
        assertThat(obstacle.getPosition() == positions);
        System.out.println("test Passed" + obstacle.getPosition());

    }
}