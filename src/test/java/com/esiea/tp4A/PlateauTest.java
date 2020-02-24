package com.esiea.tp4A;

import com.esiea.tp4A.code.Plateau;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PlateauTest {

    private final Plateau plateau = new Plateau(100, 100);


    @Test
    void testTaille(){
        ArrayList<Integer> taille = new ArrayList<Integer>();
        taille.add(100);
        taille.add(100);
        assertThat(plateau.getTaille().equals(taille));
        System.out.println("Test réussi ! :)");
    }
}


