package com.esiea.tp4A.api;

import com.esiea.tp4A.code.Obstacle;
import com.esiea.tp4A.code.Plateau;
import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;
import com.esiea.tp4A.code.Rover;
import com.esiea.tp4A.domain.Direction;


import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Api{

    private Plateau map;
    private int taille;
    private Scanner scan;
    private Position position;
    private List<Rover> lstRover;
    private int numeroJoueur;
    private List<Position> setObstaclesPositions = new ArrayList<Position>();


    public Api() {
        scan = new Scanner (System.in);
        // initialisation obstacle + laser
        System.out.println(" Bienvenue sur notre jeu de l'espace!");
        //############# Génération aléatoire de la tailles de la CARTE #######
        generationAleaCarte();
        //######################## Génération des 50 joueurs ###########################
        System.out.println("Génération des 50 joueurs....");
        generationAleaJoueurs();
        System.out.println("Bravo, nous avons maintenant généré nos 50 joueurs!!\n");
        //####################### Choix numéro de joueur ##############################
        System.out.println("Veuillez choisir un numéro de joueur entre 1 et 50");
        numeroJoueur = scan.nextInt();
        while((numeroJoueur <1)|| (numeroJoueur >50)){
            System.out.println("Il faut impérativement entrer un nombre entre 1 et 50, sinon on ne peut pas vous attribuer de rover");
            numeroJoueur = scan.nextInt();
        }
        System.out.println("Vous avez choisi le Rover numéro " + numeroJoueur + "\nVoici ses coordonnées: " + lstRover.get(numeroJoueur -1).getPosition().getX() +" , " + lstRover.get(numeroJoueur-1).getPosition().getY() + ", " + lstRover.get(numeroJoueur -1).getPosition().getDirection() + "\n");
        //############# Génération aléatoire de la portée du LASER #######
        int portee = porteeLaser();
        String dist = "";
        if(portee == 5){
            dist = "courte";
        }
        else if(portee == 30){
            dist = "moyenne";
        }
        else{
            dist = "longue (infinie)";
        }
        System.out.println("La portée du laser sera de... " + portee + ", " + dist + "distance");
        //###################### Génération des obstacles #########################################""
        System.out.println("Maintenant cow-boy, l'heure est venue de rajouter des obstacles sur la carte!!!\n....Génération...");
        generationSetObstaclesPositions();
        System.out.println("C'est tout bon!\nRentrons maintenant dans le vif du sujet !");
        //############################ MENU UTILISATEUR #####################################
        System.out.println("################### MENU ###################\nQue voulez-vous faire ? [h for help]\n");
        String choice;
        boolean stop = false;
        choice = scan.next();
        while(!stop){
            switch (choice.charAt(0)){
                case 'h':
                    System.out.println("h: Afficher cet écran d'aide\np: Afficher la position des 50 joueurs\nc: Changer de rover\no: Connaitre la position des obstacles et joueurs adverses dans un carré de 30x30(par défaut) autour du joueur (radar)\nl: Connaitre la portée du laser\nd: Se déplacer\ns: Tirer avec le laser\na: Savoir si son personnage est vivant ou mort\nm: Afficher mes informations (numéro de rover et position\nr: Afficher la position des obstacles\nq: Quitter le programme\nQue voulez-vous faire? [h for help] \n");
                    choice = scan.next();
                    break;
                case 'p':
                    System.out.println("Affichage de la position des joueurs");
                    for(Rover r: lstRover){
                        System.out.println(" Rover numéro " + r.getNumeroRover() + " :  ("+r.getPosition().getX() + ", "+ r.getPosition().getY() +  ", " + r.getPosition().getDirection() + " )");
                    }
                    System.out.println("Que voulez-vous faire? [h for help] \n");
                    choice = scan.next();
                    break;
                case 'c':
                    System.out.println("Changer de joueur\nVeuillez entrer le numéro du rover que vous voulez désormais incarner\nVeuillez choisir un numéro de joueur entre 1 et 50");
                    numeroJoueur = scan.nextInt();
                    while((numeroJoueur <1)|| (numeroJoueur >50)){
                        System.out.println("Il faut impérativement entrer un nombre entre 1 et 50, sinon on ne peut pas vous attribuer de rover");
                        numeroJoueur = scan.nextInt();
                    }
                    System.out.println("Que voulez-vous faire? [h for help] \n");
                    choice = scan.next();
                    break;
                case 'o':
                    System.out.println("Connaitre la position des obstacles et joueurs adverses dans un carré de 30x30(par défaut) autour du joueur (radar)");
                    //APPEL AUX FONCTIONS REQUISES
                    System.out.println("Que voulez-vous faire? [h for help] \n");
                    choice= scan.next();
                    break;
                case 'l':
                    System.out.println("Connaitre la portée du laser\n");
                    System.out.println("La portée du laser est de " + portee + ", " + dist + "distance");
                    if(portee == (int) Double.POSITIVE_INFINITY){
                        System.out.println("Attention, la porée étant infinie il y a un risque d'auto destruction !");
                    }
                    System.out.println("Que voulez-vous faire? [h for help] \n ");
                    choice= scan.next();
                    break;
                case 'd':
                    System.out.println("Se déplacer :\n'f' : le rover avance dans la direction à laquelle il fait face\n'b' : le rover recule\n'l' : le rover pivote sur la gauche\n'r' : le rover pivote sur la droite\nTapez votre commande :");
                    String move = scan.next();
                    char tabMove[] = move.toCharArray();
                    lstRover.get(numeroJoueur-1).give_order(tabMove);
                    System.out.println("Nouvelle position du rover " + numeroJoueur + ": ("+lstRover.get(numeroJoueur-1).getPosition().getX() + ", "+ lstRover.get(numeroJoueur-1).getPosition().getY() +  ", " + lstRover.get(numeroJoueur-1).getPosition().getDirection() + " )");
                    move="";
                    System.out.println("Que voulez-vous faire? [h for help] \n ");
                    choice= scan.next();
                    break;
                case 's':
                    System.out.println("Tirer avec le laser :\nVous devez utiliser la commande 's', le tir se fait dans la direction du rover\nEXEMPLE : le rover a une position (0, 0, N) avec un laser de portée courte 5 et un obstacle à (0,2)\nAvec la commande [s, f, f], le rover détruit l'obstacle et se retrouve à une position de (0, 2, N)\nTapez votre commande :");
                    String tir = scan.next();
                    //APPEL DES FONCTIONS CORRESPONDANTES//
                    choice= scan.next();
                    break;
                case 'a':
                    System.out.println("Savoir si son personnage est vivant ou mort :");
                    boolean roverAlive =  lstRover.get(numeroJoueur).isAlive();
                    String personnage = "";
                    if(roverAlive == false){
                        personnage = "mort";
                    }
                    else {
                        personnage = "vivant";
                    }
                    System.out.println("Votre personnage (numéro " + numeroJoueur + ") est : " + personnage + "\nQue voulez-vous faire? [h for help] \n");
                    choice= scan.next();
                    break;
                case 'm':
                    System.out.println("Afficher mes informations:\nVous êtes le rover numéro " + numeroJoueur + "\nVous êtes actuellement situé en ("+lstRover.get(numeroJoueur-1).getPosition().getX() + ", "+ lstRover.get(numeroJoueur-1).getPosition().getY() +  ", " + lstRover.get(numeroJoueur-1).getPosition().getDirection() + " )\nQue voulez-vous faire? [h for help]\n");
                    choice= scan.next();
                    break;
                case 'r':
                    System.out.println("Afficher la position des obstacles");
                    Position[] tabPositionsOstacles = new Position[setObstaclesPositions.size()];
                    setObstaclesPositions.toArray(tabPositionsOstacles);
                    for(int i = 0; i < tabPositionsOstacles.length; i++) {
                        System.out.println("Obstacle " + (i+1) + ": (" + tabPositionsOstacles[i].getX() + ", " + tabPositionsOstacles[i].getY() + ")");
                    }
                    System.out.println("Que voulez-vous faire? [h for help] \n");
                    choice= scan.next();
                    break;
                case 'q':
                    System.out.println("Merci de votre venue et à bientôt! Au revoir! ");
                    stop = true;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Commande inconnue\nQue voulez-vous faire? [h for help]\n");
                    choice= scan.next();
                    break;
            }
        }
        scan.close();
    }

    // Fonction qui génère aléatoirement la taille de la carte */
    public void generationAleaCarte(){
        map = new Plateau(randomNumber(0,100));
        System.out.println("Voici la taille de la carte, choisie aléatoirement :");
        taille = map.getTaille();
        System.out.println(taille + "x" + taille +"\n");
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

    /*Fonction qui gènère 50 joueurs*/
    public List<Rover> generationAleaJoueurs(){
        lstRover = new ArrayList<Rover>();
        Position p = null;
        for(int i = 1; i<51; i++){
            Rover r= new Rover(p); // création Rover
            p = aleaPosition(); // génération position aléatoire
            r.setPosition(p); //on fixe la position aléatoire du Rover
            r.setNumeroRover(i);
            r.setPlateau(map);
            //AJOUTER PORTEE DU LASER QUAND ELLE SERA DISPO
            lstRover.add(r);//ajout à la liste de Rovers
        }
        return lstRover;
    }

    //Création du set des positions  obstacles --> doivent occuper 15% du terrain
    public List<Position> generationSetObstaclesPositions(){
        int nbPositionsMap = (taille + (taille+1)) * (taille*2); //nombres total de positions possibles sur la map
        int nbPositionObstacle = (int) Math.round(0.15 * nbPositionsMap); //15% des positions sont prises par des obstacles
        List<Obstacle> lstObstacles = new ArrayList<Obstacle>();
        for(int i = 0; i< nbPositionObstacle ; i++) { // on génère les 15 % de positions aléatoires
            Position p = aleaPosition();
            Obstacle o = new Obstacle(p.getX(),p.getY(),Direction.NORTH);
            lstObstacles.add(o);
        }
        for(Obstacle o: lstObstacles) {
            setObstaclesPositions.add(o.getPosition());
        }
        for(Rover r: lstRover) { // on ajoute cette liste d'obstacles à chaque Rover
            r.setObstaclesMap(setObstaclesPositions);
        }
        return setObstaclesPositions;
    }

    /* Fonction qui génère aléatoirement la portée du laser */
    public int porteeLaser(){
        int laser;
        int tab_range[] = {5, 30, (int) Double.POSITIVE_INFINITY};
        int rand = (int) (Math.random() * tab_range.length);
        laser = tab_range[rand];
        return laser;
    }

    public static void main(String[] args) {
        new Api();
    }
}
