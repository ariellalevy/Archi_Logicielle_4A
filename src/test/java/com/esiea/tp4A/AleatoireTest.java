package com.esiea.tp4A;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.esiea.tp4A.code.Aleatoire;
import com.esiea.tp4A.code.Plateau;
import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;

class AleatoireTest {
	private final Plateau plateau = new Plateau(100);
	private final Aleatoire aleatoire = new Aleatoire(plateau);
	
	@Test
	void aleatoire_Test() {
		int randomNumber = aleatoire.randomNumber(1, 50);
        assertThat(randomNumber != 0).isEqualTo(true);
        Position position = aleatoire.aleaPosition();
        assertThat(position != null).isEqualTo(true);
        Direction direction = aleatoire.aleaDirection();
        assertThat(direction != null).isEqualTo(true);
        int aleaPorteeLaser = aleatoire.aleaPorteeLaser();
        assertThat(aleaPorteeLaser != 0).isEqualTo(true);
    }

}
