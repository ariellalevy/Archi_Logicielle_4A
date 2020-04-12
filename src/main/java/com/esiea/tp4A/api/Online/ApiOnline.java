package com.esiea.tp4A.api.Online;

import com.esiea.tp4A.code.Obstacle;
import com.esiea.tp4A.code.Plateau;
import com.esiea.tp4A.domain.Position;
import com.esiea.tp4A.code.Rover;
import com.esiea.tp4A.domain.Direction;


import java.awt.desktop.SystemEventListener;
import java.util.*;


public class ApiOnline {

    private Scanner scan;
    private Position position;
    private List<game> Games = new ArrayList<game>();
    private Map<String,Integer> listPlayer = new HashMap<String, Integer>();;

    public ApiOnline() {
        createNewGame();
    }

    public void createNewGame(){
        Games.add(new game(Games.size()));
    }

    public player getPlayerData(String nickname){
        var retur = Games.get(listPlayer.get(nickname)).getPlayerData(nickname);
        if (retur != null){
            return retur;
        }else{
            return null;
        }

    }

    private boolean gameIsFull(){
       return  Games.get(Games.size()-1).gameIsFull();
    }

    public player command(String playerName, String command){
        System.out.println(command);
        System.out.println(playerName);
       return Games.get(listPlayer.get(playerName)).gamecommand(playerName,command);
    }

    public List<player> getGamePalyers(String playerName){
        return Games.get(listPlayer.get(playerName)).getPlayers(playerName);
    }

    public List<Position> getGameObstacles(String playerName){
        return  Games.get(listPlayer.get(playerName)).getObstacles(playerName);
    }

    public player joingame(String playerName){
        if (gameIsFull()){
            createNewGame();
        }
        listPlayer.put(playerName,Games.size()-1);
        return Games.get(Games.size()-1).joinAGame(playerName);
    }
}
