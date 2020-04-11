Fonctionnement du système :
-

1. Les joueurs intéragiront en temps réel dans notre jeu. Nous trouvons que ce jeu de stratégie sera plus sympa pour les utilisateurs s'il est géré de manière synchrone (schéma).
En effet, il y aura plus de fluidité dans le jeu, les joueurs n'auront pas besoin d'attendre, ce qui créera plus de compétitivité. 
Par exemple : lorsqu'un rover tire sur un autre rover, celui-ci sera directement en état "mort".

2. Toutes les données permettant de représenter le jeu seront stockées par partie jouée (ou par joueur ?) et accessible par un id. 
Mise à jour constante des serveurs.

3. Les informations confidentielles des joueurs seront stockées dans  une base de données, accessible par un mot de passe changé régulièrement. (firewalls ?).
Les données seront cryptées avec un certificat SSL. (schéma)

4. Gestion de plusieurs parties jouées en même temps : (schéma)

5. Gestion de plusieurs parties jouées par joueur en même temps : (schéma)

6. Si un serveur plante, un logiciel qui pilote le cluter bascule d'une machine à une autre
 et fait de la réplication en parallèle.(serveur de secours prend le relai, redondance serveur, clustering)
 
7. Les joueurs s'authentifiront grâce à une @ mail et un mot de passe avec les exigences de la CNIL 
(ou authentification à 2 facteurs ?) Sauvegarde de la progression en fonction du joueur

8. Pour éviter une surcharge imprévue, on répartit les @IP sur les différents serveurs par exemple, en fonction du pays.
(équilibrage de charges)
 
