package com.esiea.tp4A;

import com.esiea.tp4A.code.Plateau;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PlateauTest {

    private final Plateau plateau = new Plateau(100, 100);

    @ParameterizedTest

    void testTaille(ArrayList<Integer> expectedResult){
        assertThat(plateau.getTaille().equals(expectedResult));
    }
}


