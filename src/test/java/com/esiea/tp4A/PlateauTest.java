package com.esiea.tp4A;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PlateauTest {

    private final Plateau plateau = new Plateau();

    @ParameterizedTest

    void testTaille(int expectedResult) {
        assertThat(plateau.getTaille()).isEqualTo(expectedResult);
    }
}


