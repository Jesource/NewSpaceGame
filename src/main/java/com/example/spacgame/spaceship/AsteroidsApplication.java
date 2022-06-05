package com.example.spacgame.spaceship;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.HashMap;

public class AsteroidsApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group groupPlay = new Group();  //

        Pane pane = new Pane();
        pane.setPrefSize(600, 400);

        Scene scene = new Scene(pane);
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();

//        Polygon parallelogram = new Polygon(0, 0, 100, 0, 100, 50, 0, 50);
//        parallelogram.setTranslateX(100);
//        parallelogram.setTranslateY(20);

//        Group groupPlay = new Group();
//        Scene scene = new Scene(groupPlay, 600, 400);
//        stage.setTitle("PLAY");
//        stage.setScene(scene);

        //adding background
        scene.setFill(new RadialGradient(
                2, 1, 0, 1, 1, true,                  //sizing
                CycleMethod.NO_CYCLE,                 //cycling
                new Stop(0, Color.web("086208FF")),    //colors
                new Stop(1, Color.web("010546FF"))
        ));

        HashMap<KeyCode, Boolean> pressedKeys = new HashMap<>();

        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

//        I'm not sure, but that can be somehow used for shooting/asteroids mechanics
//          or not used at all
        Point2D movement = new Point2D(1, 0);

        Ship ship = new Ship(150, 100);

        pane.getChildren().add(ship.getCharacter());

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                if(pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }

                ship.move();
            }
        }.start();

    }

}