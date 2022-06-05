package com.example.spacgame.game;

class Point implements Cloneable {
    double x;
    double y;

    public Point(double inX, double inY) {
        this.x = inX;
        this.y = inY;
    }

    public Point clone() {
        return new Point(this.x, this.y);
    }
}
