Fonctionnement du système :
-

1. Les joueurs intéragiront en temps réel dans notre jeu. Nous trouvons que ce jeu de stratégie sera plus sympa pour les utilisateurs s'il est géré de manière synchrone (schéma).
En effet, il y aura plus de fluidité dans le jeu, les joueurs n'auront pas besoin d'attendre, ce qui créera plus de compétitivité. 
Par exemple : lorsqu'un rover tire sur un autre rover, celui-ci sera directement en état "mort".

2. Toutes les données permettant de représenter le jeu seront stockées par partie jouée dans une base de donnée, accessible par un id.

3. Les informations confidentielles des joueurs seront stockées dans  une base de données, accessible par un mot de passe changé régulièrement.
Les données seront chiffrées avec un certificat SSL. (schéma)

4. Gestion de plusieurs parties jouées en même temps : Il y a une liste de partie sur le serveur.
On génèrera plusieurs plateaux et dès qu'un plateeau est plein, on passe au suivant.

5. Gestion de plusieurs parties jouées par joueur en même temps : Chaque joueur a une liste de parties identifiables avec un id.

6. Si un serveur plante, un logiciel qui pilote le cluter bascule d'une machine à une autre
 et fait de la réplication en parallèle.(serveur de secours prend le relai, redondance serveur, clustering)
 
7. Les joueurs s'authentifiront avec une authentification à deux facteurs grâce à une adresse mail et un mot de passe respectant les exigences de la CNIL et l'identité du joueur sera vérifié par sms.
La sauvegarde de la progression du jeu se fera avec une base de données, en fonction du joueur grâce à un id.

8. Pour éviter une surcharge imprévue, on répartit les adresses IP sur les différents serveurs.
(équilibrage de charges) On limite le nombre de requêtes en simultané pour éviter un surcharge au niveau du serveur de base de données. 
On peut également faire des pages de refus qui vont refuser le client supplémentaire s'il y a trop de monde et le rediriger vers une page d'attente.

9. Comment les utilisateurs pourraient communiquer entre eux ? Grâce à la création d'une chatbox, avec des sockets qui permettraient d'avoir une connexion en temps réelle.

10. Comment on pourrait supprimer un joueur d'une partie ? On supprimerait un joueur au bout d'un certain temps d'inactivité ou alors on le remplacerait pas un bot.

11. Comment un joueur pourrait avoir un historique contenant son nombre de parties gagnées et son nombre de tirs réussis ?
Pour cela il faut faire une base de données "utilisateurs" avec une colonne joueur qui va prendre comme information le nom d'utilisateur du joueur et une base de données "historique"
qui permettra de faire un historique de chaque partie du joueur. Il faudra faire une référence à cette base de données "historique" depuis la base de données "utilisateurs", grâce à un id.
