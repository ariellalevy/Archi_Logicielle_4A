package com.esiea.tp4A.code;

<<<<<<< HEAD
public class Obstacle {
        private int positionX;//correspond à l'origine (gauche) en X
        private int positionY;//correspond à l'origine (gauche) en Y
=======
public class Obstacle { //Implement Planet MAP ?
        public int positionX;//correspond à l'origine (gauche) en X
        public int positionY;//correspond à l'origine (gauche) en Y
        public int hauteur;//correspond à la surface sur les Y de l'obstacle
        public int largeur;//correspond à la surface sur les X de l'obstacle
>>>>>>> api

        private void setPositionX(int posX){
            positionX = posX;
        }

        private void setPositionY(int posY) {
            positionY = posY;
        }

        public Obstacle(int posX,int posY){
            setPositionX(posX);
            setPositionY(posY);
        }

        public int getPositionX(){
            return positionX;
        }

        public int getPositionY(){
            return positionY;
        }
}
