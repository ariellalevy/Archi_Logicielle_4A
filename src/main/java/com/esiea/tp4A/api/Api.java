package com.esiea.tp4A.domain;

public class Api {


    public static main void(String[] args){

        Plateau map = new Plateau();
        int taille;
        Scanner scan = new Scanner (System.in);
        // initialisation obstacle + laser

        System.out.println(" Bienvenue sur notre jeu de l'espace!");
        //CARTE
        System.out.println("Voici la taille de la carte, choisie aléatoirement :");
        taille = map.getTaille();
        System.out.println(taille + "x" + taille);

        // APPEL DES FONCTIONS GENERANT LES OBSTACLES ALEATOIRES SUR LA CARTE

        System.out.println("Génération des 50 joueurs");
        Rover tabRover[] ;

        for(int i = 0; i < 50; i++){
            tab[i]= new Rover();
            tab[i].initialize(); // Introduire la notion de position de départ aléatoire
        }

        System.out.println("La portée du laser définie aléatoirement correspond à :");
        // APPEL DES FONCTIONS GENERANT PORTEE DU LASER


        System.out.println("Rentrons maintenant dans le vif du sujet !");
        //// Menu utilisateur
        System.out.println("################### MENU ###################");
        System.out.println("Que voulez-vous faire ? [h for help]");
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
                    for(int i = 0; i < 50; i++){
                        //APPEL AUX FONCTIONS REQUISES
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
                    char move = scan.next();
                    RoverMove.give_order(move); // ??

                    System.out.println("Que voulez-vous faire? [h for help]");
                    choice= scan.next();
                    break;

                case 's':
                    System.out.println("Tirer avec le laser :");
                    System.out.println("Vous devez utiliser la commande 's', le tir se fait dans la direction du rover");
                    System.out.println("EXEMPLE : le rover a une position (0, 0, N) avec un laser de portée courte 5 et un obstacle à (0,2)");
                    System.out.println("Avec la commande [s, f, f], le rover détruit l'obstacle et se retrouve à une position de (0, 2, N)")

                    System.out.println("Que voulez-vous faire? [h for help]");
                    choice= scan.next();
                    break;

                case 'a':
                    System.out.println("Savoir si son personnage est vivant ou mort :");
                    boolean roveralive = Rover.isAlive();
                    String personnage = "";
                    if(roveralive == true){
                        personnage = "mort";
                    }
                    else {
                        personnage = "vivant";
                    }
                    System.out.println("Votre personnage est : " + personnage);

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
