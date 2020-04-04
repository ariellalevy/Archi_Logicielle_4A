package com.esiea.tp4A.domain;

public class Api {//on met getPosition de obstacle dans fct X de plateau puis on crée un objet plateau pour faire un plateau.X et du coup avoir getPosition d'un obstacle


    public static main void(String[] args){


        System.out.println(" Bienvenue sur notre jeu de l'espace!");
        System.out.println("Premièrement, veuillez choisir la taille de la carte");
        System.out.println("1: petite (100x100, 2: moyenne (300x300), grande (600x600)");
        Scanner scan= new Scanner (System.in);
        int choix_taille = sc.nextInt();
        while ((choix_taille != 1)| (choix_taille !=2)| (choix_taille !=3)) {
            System.out.println("Veuillez tapez 1,2 ou 3 pour la taille de la carte");
            choix_taille = sc.nextInt();
        }

        //INSERER ICI LES FONCTIONS S'OCCUPANT DE LA GÉNÉRATION DE LA CARTE CHOISIE

        // APPEL DES FONCTIONS GENERANT LES OBSTACLES SUR LA CARTE

        System.out.println("Génération des 50 joueurs");
        Rover tabRover[] ;

        for(int i = 0; i < 50; i++){
            tab[i]= new Rover();
            tab[].initialize(); // Introduire la notion de position de départ aléatoire
        }

        System.out.println("Choisissons maintenant la portée du laser!");
        System.out.println("Tapez c pour courte (5 cases), m pour moyenne (30 cases), i pour infinie (risque d'autodestruction si le tir fait le tour de la planète");
        String choice = scan.next();
        while ((choice.charAt(0) != 'c')| (choixce.charAt(0) !='m')| (choice.charAt(0) !='i')) {
            System.out.println("Veuillez tapez c,m ou i pour choisir la portée du laser");
            choice = sc.next();
        }

        System.out.println("Rentrons maintenant dans le vif du sujet!");
        //// Menu utilisateur
        System.out.println("################### MENU #############################");
        System.out.println("Que voulez-vous faire? [h for help]");
        boolean stop = false;
        choice = scan.next();

        while(!stop){

            switch (choice.charAt(0)){

                case 'h':
                    System.out.println("h: Afficher cet écran d'aide");
                    System.out.println("p: Afficher la position des joueurs");
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
                    choice= scan.next();
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
                    for(int i = 0; i < 50; i++){
                        //APPEL AUX FONCTIONS REQUISES
                    }
                    System.out.println("Que voulez-vous faire? [h for help]");
                    choice= scan.next();
                    break;

                case 'd':
                    System.out.println("Se déplacer");
                    for(int i = 0; i < 50; i++){
                        //APPEL AUX FONCTIONS REQUISES
                    }
                    System.out.println("Que voulez-vous faire? [h for help]");
                    choice= scan.next();
                    break;

                case 's':
                    System.out.println("Tirer avec le laser");
                    for(int i = 0; i < 50; i++){
                        //APPEL AUX FONCTIONS REQUISES
                    }
                    System.out.println("Que voulez-vous faire? [h for help]");
                    choice= scan.next();
                    break;

                case 'a':
                    System.out.println("Savoir si son personnage est vivant ou mort");
                    for(int i = 0; i < 50; i++){
                        //APPEL AUX FONCTIONS REQUISES
                    }
                    System.out.println("Que voulez-vous faire? [h for help]");
                    choice= scan.next();
                    break;

                case 'q':
                    System.out.println("Merci de votre venue et à bientôt! Au revoir! ");
                    stop=true;
                    break;

                default:
                    System.out.println("Erreur");
                    break;
            }

        }


    }



}
