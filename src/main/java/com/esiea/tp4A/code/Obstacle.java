package com.esiea.tp4A.code;

public class Obstacle {
        private int positionX;//correspond à l'origine (gauche) en X
        private int positionY;//correspond à l'origine (gauche) en Y

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
