package com.esiea.tp4A.api.Online;

import com.esiea.tp4A.code.Rover;

public final class player{

    public player(String playerName, int Id){
        this.nameJoueur = playerName;
        this.IdJoueur = Id;
    }

    public void setRover(Rover rover){
        this.roverJoueur = rover;
    }

    public String getNameJoueur(){
        return nameJoueur;
    }

    public Rover getRoverJoueur(){
        return roverJoueur;
    }

    public int getIdJoueur(){
        return IdJoueur;
    }

    private Rover roverJoueur;
    private String nameJoueur;
    private int IdJoueur;

    @Override
    public String toString(){
        return "Name : " + getNameJoueur() + " " + "Position : X: " + getRoverJoueur().getPosition().getX() +  "Position : Y: " + getRoverJoueur().getPosition().getY() +  "Dir: " + getRoverJoueur().getPosition().getDirection();
    }
}
