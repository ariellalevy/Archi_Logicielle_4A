package com.esiea.tp4A;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class plateauTest {

    private final Plateau plateau = new plateau();

    @ParameterizedTest

    void plateauSize (int expectedResult) {
        assertThat(plateau.getSize().isEqualTo(expectedResult));
    }
}
