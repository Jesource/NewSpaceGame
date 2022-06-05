package com.example.spacgame.spaceship;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import static java.lang.Math.*;

public class Ship extends Node {

    private Polygon character;
    private Point2D movement;
    private double SPEED = 0.08;
    private double SIZE = 1;



    public Ship(int x, int y) {
        this.character = new Polygon(-5 * SIZE, -5 * SIZE, 10 * SIZE, 0 * SIZE, -5 * SIZE, 5 * SIZE);
        this.character.setFill(Color.RED);
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);

        this.movement = new Point2D(0, 0);
    }

    public Polygon getCharacter() {
        return character;
    }

    public void turnLeft() {
        this.character.setRotate(this.character.getRotate() - 5);
    }

    public void turnRight() {
        this.character.setRotate(this.character.getRotate() + 5);
    }

    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());
    }

    public void accelerate() {
        double changeX = cos(toRadians(this.character.getRotate()));
        double changeY = sin(toRadians(this.character.getRotate()));

        changeX *= SPEED;
        changeY *= SPEED;

        this.movement = this.movement.add(changeX, changeY);
//        System.out.println("Change X; Y:" + changeX + ", " + changeY);
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}