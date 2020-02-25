package com.esiea.tp4A.code;

public class Obstacle {
        int positionX;//correspond à l'origine (gauche) en X
        int positionY;//correspond à l'origine (gauche) en Y
        int hauteur;//correspond à la surface sur les Y de l'obstacle
        int largeur;//correspond à la surface sur les X de l'obstacle

        public Obstacle(int posX,int posY,int h,int l){
            this.positionX = posX;
            this.positionY = posY;
            this.hauteur = h;
            this.largeur = l;
        }


       public boolean isOnSquare(int posX, int posY) {
                if((posX >= positionX) && (posX <= positionX + largeur) && (posY >= positionY) && (posY <= positionY + hauteur) ){
                    return true;
                } else {
                    return  false;
                }
        }
}
