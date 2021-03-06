package com.esiea.tp4A;

import com.esiea.tp4A.code.Plateau;
import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class PlateauTest {
    private final Plateau plateauTest = new Plateau(100);

    @Test
    public void testTaille(){
        assertThat(plateauTest.getTaille() == 50 || plateauTest.getTaille() == 150 || plateauTest.getTaille() == 300).isEqualTo(true);
        System.out.println("Test taille réussi ! :)");
    }

    @Test
    public void testSphere(){
    	plateauTest.setTaille(100);
        assertThat(plateauTest.sphere(160)).isEqualTo(-40);
        System.out.println("Test sphérique réussi ! :)");
    }
    
    @Test
    public void get_Obstacle_List(){
        assertThat(plateauTest.getObstacleList()).isEqualTo(null);
    }
    
    @Test
    public void is_Present(){
        assertThat(plateauTest.isPresent(Position.of(0, 0, Direction.NORTH))).isEqualTo(false);
    }
}