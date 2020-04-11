package com.esiea.tp4A;

import com.esiea.tp4A.code.Laser;
import com.esiea.tp4A.code.Obstacle;
import com.esiea.tp4A.code.Plateau;
import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LaserTest {
    private final Laser laser = new Laser(5);
    private final Set<Position> posList = new HashSet<>();


    void init(){
        posList.add(Position.of(2,3,Direction.NORTH));
        posList.add(Position.of(1,4,Direction.NORTH));
        posList.add(Position.of(2,6,Direction.NORTH));
        posList.add(Position.of(4,7,Direction.NORTH));
        posList.add(Position.of(5,5,Direction.NORTH));
    }

    @Test
    void testShoot(){
        init();
        assertThat(laser.LaserShoot(posList,Position.of(1,9,Direction.SOUTH)));
        assertThat(!laser.LaserShoot(posList,Position.of(1,10,Direction.SOUTH)));
        assertThat(laser.LaserShoot(posList,Position.of(-2,4,Direction.EAST)));
        assertThat(!laser.LaserShoot(posList,Position.of(-2,9,Direction.SOUTH)));
    }


}
