package com.esiea.tp4A.domain;

public interface Position {

    int getX();
    int getY();
    int getD();

    static Position of(int x, int y, int D) {
        return new FixedPosition(x, y, D);
    }

    final class FixedPosition implements Position {

        private final int x;
        private final int y;
        private final int D;

        public FixedPosition(int x, int y, int D) {
            this.x = x;
            this.y = y;
            this.D = D;
        }

        @Override
        public int getX() {
            return x;
        }

        @Override
        public int getY() {
            return y;
        }

        @Override
        public int getD(){
            return D;
        }
    }
}