package com.example.spacgame.game;

import java.awt.*;
import java.awt.event.*;

public class Asteroids extends Game {
    static int start = 0;
    static int score = 0;
    //change this later to txt file to save previous games
    static int topScore = 0;
    static int rot = 0;
    //you have 3 lives, this will go from 0-2, meaning 0 then 1 then 2
    //still trying to fix the lives. so far it gives me 2 lives
    Ship[] ships = Ship.lives(4);
    int live = 0;
    Asteroid[] asArr = Asteroid.arrAst(1000);
//	boost thrust = new boost();


    public Asteroids() {
        super("Asteroids!", 800, 600);
        this.setFocusable(true);
        this.requestFocus();
        for (int i = 0; i < ships.length; i++) {
            this.addKeyListener(ships[i]);
        }
//        KeyListener thrust;
        this.addKeyListener();
    }

    private void addKeyListener() {
    }

    public void paint(Graphics brush) {
        brush.setColor(Color.black);
        brush.fillRect(0, 0, width, height);
        brush.setColor(Color.white);

        //start the game by pressing down
        if (start < 1) {
            brush.drawString("ASTEROIDS", 360, 270);
            brush.drawString("Avoid collision...", 350, 290);
            brush.drawString("Press space key to begin", 330, 310);
            if (ships[0].space) {
                start = 1;
            }

        }
        //counter starts along with the paint of ship and asteroids
        else {
            //as long as you have lives, keep on playing
            if (live + 1 < ships.length) {
                //since it is dangerous traveling super fast, I increased the points.
                if (ships[live].space) {
                    score = score + 5;
                    if (ships[live].upKey) {
                        ships[live].move();
                        ships[live].thrust.paint(brush);
                    } else {
                        ships[live].move();
                        ships[live].paint(brush);
                    }
                } else {
                    ships[live].move();
                    ships[live].paint(brush);
                    score++;
                }
                brush.drawString("Score:" + score, 10, 20);
                brush.drawString("Lives " + (ships.length - live - 1), 10, 40);
                //loop for showing asteroids
                //start with 5 asteroids
                if (score < 2501) {
                    brush.drawString("Level: 1", 10, 60);
                    for (int i = 0; i < 5; i++) {
                        asArr[i].paint(brush);
                        asArr[i].move();
                        if (ships[live].intersection(asArr[i])) {
                            live++;
                        }
                    }
                }
                //increase asteroids until it reaches max
                else if (score < 500000 && score > 2501) {
                    brush.drawString("Level: " + (score / 1000), 10, 60);
                    for (int i = 0; i < score / 500; i++) {
                        if (ships[live].intersection(asArr[i])) {
                            live++;
                        }
                        asArr[i].paint(brush);
                        asArr[i].move();
                    }
                }
                //max asteroids displayed
                else {
                    for (int i = 0; i < asArr.length; i++) {
                        brush.drawString("Level: Impossible", 10, 60);
                        if (ships[live].intersection(asArr[i])) {
                            live++;
                        }
                        asArr[i].paint(brush);
                        asArr[i].move();
                    }
                }
            } else {
                brush.drawString("GAME", 360, 260);
                brush.drawString("OVER", 360, 280);
                brush.drawString("Score:" + score, 350, 300);
                brush.drawString("Press enter(or any key) to start again", 300, 340);
                if (score > topScore) {
                    brush.drawString("New High Score:" + score, 330, 320);
                } else {
                    brush.drawString("High Score:" + topScore, 330, 320);
                }
                //reset game
                if (ships[0].otherKey) {
                    topScore = score;
                    live = 0;
                    score = 0;
                    start = 0;
                    for (int i = 0; i < ships.length; i++) {
                        ships[i].reset();
                    }

                    for (int j = 0; j < asArr.length; j++) {
                        asArr[j].reset();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Asteroids a = new Asteroids();
        a.repaint();
    }
}