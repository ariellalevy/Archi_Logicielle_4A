package com.esiea.tp4A.api.Online;

import com.esiea.tp4A.code.Obstacle;
import com.esiea.tp4A.code.Plateau;
import com.esiea.tp4A.code.Rover;
import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;

import java.util.*;

public class game{
    private int taille;
    private Plateau map;
    private List<Rover> lstRover = new ArrayList<Rover>();
    private Map<String,player> listPlayer = new HashMap<String, player>();;
    private int sessionNumber;
    private List<Position> setObstaclesPositions = new ArrayList<Position>();

    game(int gamesCount){
        sessionNumber = gamesCount;
        generationAleaCarte();
        generationSetObstaclesPositions(gamesCount);
        System.out.println("fin init");
    }

    public boolean gameIsFull(){
        if (listPlayer.size() >= 50){
            return true;
        }else {
            return false;
        }
    }

    // Fonction qui génère aléatoirement la taille de la carte */
    public void generationAleaCarte(){
        System.out.println("Creation Plateau");
        map = new Plateau();
        System.out.println("Voici la taille de la carte, choisie aléatoirement :");
        map.geneTaille();
        taille = map.getTaille();
        System.out.println(taille + "x" + taille +"\n");
    }

    public List<Position> getObstacles(String playerName){
        List<Position> tmpList = new ArrayList<Position>();
        for(Position pos : setObstaclesPositions){
            if (pos.getX() <= listPlayer.get(playerName).getRoverJoueur().getPosition().getX() + 30 || pos.getY() <= listPlayer.get(playerName).getRoverJoueur().getPosition().getY() + 30){
                tmpList.add(pos);
            }
        }
        return tmpList;
    }

    public List<player> getPlayers(String playerName){
        List<player> tmpList = new ArrayList<>();
        for (Map.Entry<String, player> entry : listPlayer.entrySet()) {
            if (entry.getValue().getRoverJoueur().getPosition().getX() <= listPlayer.get(playerName).getRoverJoueur().getPosition().getX() + 30 || entry.getValue().getRoverJoueur().getPosition().getY() <= listPlayer.get(playerName).getRoverJoueur().getPosition().getY() + 30){
            tmpList.add(entry.getValue());
            }
        }
        return tmpList;
    }


    public player joinAGame(String nickname){
        System.out.println("Add player");
        System.out.println(nickname);
        System.out.println(sessionNumber);
        player newPlayer = new player(nickname,sessionNumber);
        newPlayer.setRover(generationAleaJoueur(newPlayer));
        listPlayer.put(nickname,newPlayer);
        System.out.println(" Bienvenue sur notre jeu de l'espace!");
        System.out.println("Voici ses coordonnées: " + newPlayer.getRoverJoueur().getPosition().getX() +" , " + newPlayer.getRoverJoueur().getPosition().getY()  + ", " + newPlayer.getRoverJoueur().getPosition().getDirection()  + "\n");
        System.out.println("C'est tout bon!");
        System.out.println("Rentrons maintenant dans le vif du sujet !");
        //############################ MENU UTILISATEUR #####################################
        System.out.println("################### MENU ###################");
        System.out.println("Que voulez-vous faire ? [h for help]\n");
        return listPlayer.get(nickname);
    }


    /*Fonction qui gènère 50 joueurs*/
    public Rover generationAleaJoueur(player Player){
        System.out.println("debut generation joueur");
        Position p = null;
        Rover r= new Rover(p); // création Rover
        p = aleaPosition(); // génération position aléatoire
        r.setPosition(p); //on fixe la position aléatoire du Rover
        r.setNumeroRover(Player.getIdJoueur());
        r.setPlateau(map);
        //AJOUTER PORTEE DU LASER QUAND ELLE SERA DISPO
        lstRover.add(r);//ajout à la liste de Rovers
        System.out.println("fin generation joueur");
        return r;
    }

    //Création du set des positions  obstacles --> doivent occuper 15* du terrain
    public List<Position> generationSetObstaclesPositions(int mapInArray){
        System.out.println("debut generation obs");
        int nbPositionsMap = (taille + (taille+1)) * (taille*2); //nombres total de positions possibles sur la map
        //System.out.println("nb positions carte: " + nbPositionsMap);
        int nbPositionObstacle = (int) Math.round(0.15 * nbPositionsMap); //15% des positions sont prises par des obstacles
        //System.out.println("nb positions obstacles: " + nbPositionObstacle);
        List<Obstacle> lstObstacles = new ArrayList<Obstacle>();

        for(int i = 0; i< nbPositionObstacle ; i++) { // on génère les 15 % de positions aléatoires

            Position p = aleaPosition();
            Obstacle o = new Obstacle(p.getX(),p.getY(),Direction.NORTH);
            lstObstacles.add(o);

        }
        for(Obstacle o: lstObstacles) {
            setObstaclesPositions.add(o.getPosition());
        }
        System.out.println("fin generation obs");
        return setObstaclesPositions;
    }

    public player getPlayerData(String playerName){
        System.out.println(playerName);
        if (listPlayer.containsKey(playerName)){
            return listPlayer.get(playerName);
        }else {
            return null;
        }
    }


    public player gamecommand(String playerName, String instruction){
            System.out.println("l'instr"+instruction);
        System.out.println(" position avant du rover " + listPlayer.get(playerName).getNameJoueur() + ": ("+listPlayer.get(playerName).getRoverJoueur().getPosition().getX() + ", "+ listPlayer.get(playerName).getRoverJoueur().getPosition().getY() +  ", " + listPlayer.get(playerName).getRoverJoueur().getPosition().getDirection() + " )");

            lstRover.remove(listPlayer.get(playerName).getRoverJoueur());
            listPlayer.get(playerName).getRoverJoueur().give_order(instruction.toCharArray());
            System.out.println("Nouvelle position du rover " + listPlayer.get(playerName).getNameJoueur() + ": ("+listPlayer.get(playerName).getRoverJoueur().getPosition().getX() + ", "+ listPlayer.get(playerName).getRoverJoueur().getPosition().getY() +  ", " + listPlayer.get(playerName).getRoverJoueur().getPosition().getDirection() + " )");
            lstRover.add(listPlayer.get(playerName).getRoverJoueur());
            return listPlayer.get(playerName);
    }

    /* Fonction qui génère aléatoirement un nombre */
    public int randomNumber(int min, int max){
        int range = max - min + 1;
        int res = 0;
        for(int i = min-1; i<max; i++){
            res = (int) (Math.random() * range ) +min;
        }
        return res;
    }

    /*Fonction qui génère une direction aléatoire*/
    public Direction aleaDirection(){
        Direction tabDirection[] = {Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH};
        int rand = (int) (Math.random() * tabDirection.length);
        Direction direction = tabDirection[rand];
        return direction;
    }


    /*Fonction qui génère une position aléatoire */
    public Position aleaPosition(){
        int xMax = taille; //abscise maximale
        int yMax = taille; //ordonée maximale
        //x aléatoire
        int x = randomNumber(-xMax,xMax);
        //y aléatoire
        int y = randomNumber(-yMax, yMax);
        //direction aléatoire
        Direction direction = aleaDirection();
        Position p = Position.of(x,y, direction);
        return p;
    }

}
