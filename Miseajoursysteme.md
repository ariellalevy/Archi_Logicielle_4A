Evolutions du jeu possibles :
-

Tous les 15 jours un bonus viendra enrichir notre jeu. 
Par exemple : possibilité de jouer en équipe de 2, rayon du radar étendu, nouvelle map...

**Pour cela voici les étapes de la mise à jour :**
* Pour éviter une coupure de service lors d'une mise à jour, il faut utiliser la méthode du strangler pattern.
On remplace progressivement les parties spécifiques des fonctionnalités par de nouveaux services. Le client pourra donc continuer à utiliser le système pendant la migration sans insterruptions.

    ![Image](https://image.noelshack.com/fichiers/2020/15/7/1586723959-stangler-pattern.png)

* Pour les parties en cours, il faut utiliser une interface qui permet d'aller vers le nouveau ou vers l'ancien afin de pouvoir continuer à jouer.
Une fois la partie terminée, le joueur est directement dirigé vers le nouveau système mis à jour.
* Changer l'API afin que les joueurs utilisant une vieille version du client web puissent toujours jouer : il faut utiliser une interface qui ferait la liaison entre les anciennes et les nouvelles requêtes.

    ![Image](https://image.noelshack.com/fichiers/2020/15/7/1586724840-interface.png)

* Pour avertir les joueurs d'une nouveauté une unique fois, il faut rajouter une colonne dans la base de données où on enregistre tous les joueurs.
Cette colonne sera un booléen "A vu la mise à jour" qui sera mis à false avant le commencement d'une mise à jour puis dès qu'un joueur se connecte on lui affiche un message de mise à jour et le booléen passe à true.
Ce qui permet au joueur de voir qu'une seule fois le message de mise à jour.

