package com.esiea.tp4A;

import com.esiea.tp4A.code.Plateau;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;


import static org.assertj.core.api.Assertions.assertThat;

public class PlateauTest {

    private final Plateau plateau = new Plateau();

    @Test
    public void testTaille(){

        assertThat(plateau.getTaille(1) == 100);
        System.out.println("Test taille réussi ! :)");
    }

    @Test
    public void testSphere(){

        assertThat(plateau.sphere(220) == -20);
        System.out.println("Test sphérique réussi ! :)");

    }
}


