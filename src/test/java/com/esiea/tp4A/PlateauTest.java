package com.esiea.tp4A;

import com.esiea.tp4A.code.Obstacle;
import com.esiea.tp4A.code.Plateau;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;


import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlateauTest {

    private List<Obstacle> obstacles = Arrays.asList(new Obstacle(10,20), new Obstacle(34,45),new Obstacle(34,48));;
    private final Plateau plateau = new Plateau(obstacles);


    @Test
    public void testTaille(){

        assertThat(plateau.getTaille() == 100 || plateau.getTaille() == 300 || plateau.getTaille() == 600);
        System.out.println("Test taille réussi ! :)");
    }

    @Test
    public void testObstacles(){
        assertThat(plateau.getObstacles()).hasSameElementsAs(obstacles);
    }

    @Test
    public void testSphere(){

        assertThat(plateau.sphere(220) == -20);
        System.out.println("Test sphérique réussi ! :)");

    }
}


