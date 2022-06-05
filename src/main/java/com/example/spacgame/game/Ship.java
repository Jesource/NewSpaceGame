package com.example.spacgame.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ship extends Polygon implements KeyListener {
    static int speed = 0;
    boolean space = false;  // space key is used for activating the boost
    boolean upKey = false;
    boolean downKey = false;
    boolean leftKey = false;
    boolean rightKey = false;
    boolean otherKey = false;
    static Point[] shipRegularModeShape = {
            new Point(0, 0), new Point(10, 10),
            new Point(0, 20), new Point(20, 10)
    };
    static Point[] shipBoostModeShape = {
            new Point(0, 0), new Point(20, 10),
            new Point(0, 20), new Point(-12, 15),
            new Point(-10, 12), new Point(-20, 10),
            new Point(-10, 8), new Point(-12, 5)
    };

    static int rot = 0;     // What is it? Rotation?
    static Point position2 = new Point(390, 290);
    // antigravity purpose
//    static boolean prevPos = false;
//    static int gravity = 0;
    //thrust image
    Polygon thrust = new Polygon(shipBoostModeShape, new Point(position2.x - 15, position2.y), rot);


    public Ship() {
        super(shipRegularModeShape, position2, rot);
    }

    public void reset() {
        // default values
        this.rotation = 0;
        this.position = new Point(390, 290);
        this.thrust = new Polygon(shipBoostModeShape, new Point(position2.x - 15, position2.y), rot);
    }

    // this method creates array of ships... this will be the lives
    public static Ship[] lives(int n) {
        // create empty array for ships
        Ship[] output = new Ship[n];
        for (int i = 0; i < n; i++) {
            output[i] = new Ship();
        }
        return output;
    }

    public void keyPressed(KeyEvent e) {
        int id = e.getKeyCode();
        switch (id) {
            case 32:
                space = true;
                break;
            case 37:
                leftKey = true;
                break;
            case 38:
                upKey = true;
                break;
            case 39:
                rightKey = true;
                break;
            // might use the downKey for something maybe rockets
            case 40:
                downKey = true;
                break;
            default:
                otherKey = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        int id = e.getKeyCode();
        switch (id) {
            case 32:
                space = false;
                break;
            case 37:
                leftKey = false;
                break;
            case 38:
                upKey = false;
                break;
            case 39:
                rightKey = false;
                break;
            case 40:
                downKey = false;
                break;
            default:
                otherKey = false;
        }
    }

    public void keyTyped(KeyEvent e) {
//        It does nothing, but is required
    }

    public void move() {
        // added to track which direction it is going
        double prevPosX = position.x;
        double prevPosY = position.y;
        int speed = 0;
        if (upKey) {
            // speed of the ship changes when space is pressed
            if (space) {
                speed = 5;
            } else {
                speed = 2;
            }

            position = new Point((int) (position.x
                    + (speed * Math.cos(Math.toRadians(rotation)))),
                    (int) (position.y + (speed * Math.sin(Math.toRadians(rotation)))));
            thrust.position = position;

            recalculatePosition(prevPosX, prevPosY);
        }
        if (leftKey) {
            rotation -= 5;
            thrust.rotation = rotation;
        }
        if (rightKey) {
            rotation += 5;
            thrust.rotation = rotation;
        }
    }

    private void recalculatePosition(double prevPosX, double prevPosY) {
        if (position.x > 800 && prevPosX < position.x) {
            position.x = -10;
        } else if (position.x < 0 && prevPosX > position.x) {
            position.x = 810;
        }

        if (position.y > 600 && prevPosY < position.y) {
            position.y = -10;
        } else if (position.y < 0 && prevPosY > position.y) {
            position.y = 610;
        }
    }
}
