package com.esiea.tp4A.domain;

import com.esiea.tp4.code.Plateau;
import com.esiea.tp4.code.Position;
import com.esiea.tp4.code.Rover;
import com.esiea.tp4.domain.Direction;
import com.esiea.tp4.domain.Position;

import java.util.Scanner;
import java.util.ArrayList;


public class Api {

    private Plateau map;
    private int taille;
    private Scanner scan;
    private Position position;
    private List<Rover> lstRover;
    private int numeroJoueur;




    /* Fonction qui génère aléatoirement la taille de la carte */
    public void generationAleaCarte(){
        map = new Plateau();
        System.out.println("Voici la taille de la carte, choisie aléatoirement :");
        taille = map.getTaille();
        System.out.println(taille + "x" + taille);
    }


    /* Fonction qui génère aléatoirement un nombre */
    public int randomNumber(int min, int max){
        int range = max - min + 1;
        int res;
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
        lstRover = new ArrayList<Rover>;
        Position p;
        for(int i = 0; i<50; i++){
            Rover r= new Rover()); // création Rover
            p = aleaPosition(); // génération position aléatoire
            r.setPosition(p); //on fixe la position aléatoire du Rover
            //AJOUTER PORTEE DU LASER QUAND ELLE SERA DISPO
            lstRover.add(r);//ajout à la liste de Rovers
        }
    }


//DANS CHAQUE CASE APPELE IL FAUT TROUVER LE MOYEN DE SELECTIONNER UN ROVER PRECIS POUR LES APPELS DE FONCTION
    public static void main(String[] args){


        Scanner scan = new Scanner (System.in);



        // initialisation obstacle + laser

        System.out.println(" Bienvenue sur notre jeu de l'espace!");

        //############# Génération aléatoire de la tailles de la CARTE #######
        generationAleaCarte();

        // APPEL DES FONCTIONS GENERANT LES OBSTACLES ALEATOIRES SUR LA CARTE




        //######################## Génération des 50 joueurs ###########################
        System.out.println("Génération des 50 joueurs....");
        generationAleaJoueurs();
        System.out.println("Bravo, nous avons maintenant généré nos 50 joueurs!!")
        //####################### Choix numéro de joueur ##############################
        System.out.println("Veuillez choisir un numéro de joueur entre 1 et 50");
        numeroJoueur = scan.nextInt() -1; // on retire 1 pour être raccord avec notre liste qui va de 0 à 49
       // System.out.println("La portée du laser définie aléatoirement correspond à :");
        // APPEL DES FONCTIONS GENERANT PORTEE DU LASER
        System.out.println("Rentrons maintenant dans le vif du sujet !");

        //############################ MENU UTILISATEUR #####################################
        System.out.println("################### MENU ###################");
        System.out.println("Que voulez-vous faire ? [h for help]");
        String choice;
        boolean stop = false;
        choice = scan.next();

        while(!stop){

            switch (choice.charAt(0)){

                case 'h':
                    System.out.println("h: Afficher cet écran d'aide");
                    System.out.println("p: Afficher la position des 50 joueurs");
                    System.out.println("o: Connaitre la position des obstacles et joueurs adverses dans un carré de 30x30(par défaut) autour du joueur (radar)");
                    System.out.println("l: Connaitre la portée du laser");
                    System.out.println("d: Se déplacer");
                    System.out.println("s: Tirer avec le laser");
                    System.out.println("a: Savoir si son personnage est vivant ou mort");
                    System.out.println("q: Quitter le programme");
                    break;

                case 'p':
                    System.out.println("Affichage de la position des joueurs");
                    for(Rover r: lstRover){
                        System.out.println("( " +r.position.getX() + " , " + r.position.getY() + " , " + r.position.getDirection() + " )");
                    }
                    System.out.println("Que voulez-vous faire? [h for help]");
                    choice = scan.next();
                    break;

                case 'o':
                    System.out.println("Connaitre la position des obstacles et joueurs adverses dans un carré de 30x30(par défaut) autour du joueur (radar)");
                    for(int i = 0; i < 50; i++){
                        //APPEL AUX FONCTIONS REQUISES
                    }
                    System.out.println("Que voulez-vous faire? [h for help]");
                    choice= scan.next();
                    break;

                case 'l':
                    System.out.println("Connaitre la portée du laser");

                        //APPEL AUX FONCTIONS REQUISES

                    System.out.println("Que voulez-vous faire? [h for help]");
                    choice= scan.next();
                    break;

                case 'd':
                    System.out.println("Se déplacer :");
                    System.out.println("'f' : le rover avance dans la direction à laquelle il fait face");
                    System.out.println("'b' : le rover recule");
                    System.out.println("'l' : le rover pivote sur la gauche");
                    System.out.println("'r' : le rover pivote sur la droite");
                    System.out.println("Tapez votre commande :");
                    String move = scan.next();
                    lstRover.get(numeroJoueur).give_order(move);

                    System.out.println("Que voulez-vous faire? [h for help]");
                    choice= scan.next();
                    break;

                case 's':
                    System.out.println("Tirer avec le laser :");
                    System.out.println("Vous devez utiliser la commande 's', le tir se fait dans la direction du rover");
                    System.out.println("EXEMPLE : le rover a une position (0, 0, N) avec un laser de portée courte 5 et un obstacle à (0,2)");
                    System.out.println("Avec la commande [s, f, f], le rover détruit l'obstacle et se retrouve à une position de (0, 2, N)");

                    System.out.println("Que voulez-vous faire? [h for help]");
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
                    System.out.println("Votre personnage (numéro " + numeroJoueur ") est : " + personnage);

                    System.out.println("Que voulez-vous faire? [h for help]");
                    choice= scan.next();
                    break;

                case 'q':
                    System.out.println("Merci de votre venue et à bientôt! Au revoir! ");
                    stop = true;
                    break;

                default:
                    System.out.println("Erreur");
                    break;
            }

        }

    scan.close();
    }



}
