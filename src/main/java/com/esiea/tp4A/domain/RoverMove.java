package com.esiea.tp4A.domain;

import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;

public class RoverMove implements MarsRover {

    @java.lang.Override
    public MarsRover initialize(Position position) {
        return null;
    }

    @java.lang.Override
    public MarsRover updateMap(PlanetMap map) {
        return null;
    }

    @java.lang.Override
    public MarsRover configureLaserRange(int range) {
        return null;
    }

    @java.lang.Override
    public Position move(String command) {

        char[] ch = command.toCharArray();
        reading_commands(ch);
        //ajout retourner position


    }



    public void reading_commands(char[] commands) {
        int size = commands.length;
        for (int i = 0; i < size; i ++) {
            switch(commands[i]) {
                case 'f': forward();
                    break;

                case 'b': back();
                    break;

                case 'l': left();
                    break;

                case 'r': right();
                    break;

                default:	System.out.println("Error!");
                        break;

            }
        }
    }


    public void forward(){

    }

    public void back(){

    }

    public void left(){

    }

    public void right(){

    }
}
