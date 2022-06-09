package com.example.spacgame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LightStart {
    public LightStart(Stage stage) {
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(Stage stage) throws Exception {
        //   setting parameters for "START" window
        Group groupPlay = new Group();
        Scene scene = new Scene(groupPlay, 600, 400);
        stage.setTitle("PLAY");
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                System.out.println("CLOSING");
            }
        });

        //adding background
        scene.setFill(new RadialGradient(
                2, 1, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("086208FF")),
                new Stop(1, Color.web("010546FF"))
        ));

        //adding score
        Label score = new Label("SCORE: 0");
        Font font = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 25);
        score.setFont(font);
        score.setTextFill(Color.WHITE);
        score.setTranslateX(500);
        score.setTranslateY(30);
        groupPlay.getChildren().add(score);

        //adding buttons of actions
        Button buttonPlay = new Button("  ▶ ");
        buttonPlay.setLayoutX(10);
        buttonPlay.setLayoutY(10);
        buttonPlay.setStyle("-fx-background-color: #fff300; -fx-text-fill: #fbfcff;-fx-font-size: 2em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonPlay.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
            }
        });
        groupPlay.getChildren().add(buttonPlay);
        buttonPlay.setVisible(true);

        Button buttonRestart = new Button(" ⟳ ");
        buttonRestart.setLayoutX(10);
        buttonRestart.setLayoutY(110);
        buttonRestart.setStyle("-fx-background-color: #fff300; -fx-text-fill: #eef0f5;-fx-font-size: 2em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonRestart.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
            }
        });
        groupPlay.getChildren().add(buttonRestart);
        buttonRestart.setVisible(true);

        Button buttonPause = new Button("⏸");
        buttonPause.setLayoutX(10);
        buttonPause.setLayoutY(60);
        buttonPause.setStyle("-fx-background-color: #fff300; -fx-text-fill: #fdfdff;-fx-font-size: 2em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonPause.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
            }
        });
        groupPlay.getChildren().add(buttonPause);
        buttonPause.setVisible(true);

        Button buttonBack = new Button("BACK");
        buttonBack.setLayoutX(490);
        buttonBack.setLayoutY(330);
        buttonBack.setStyle("-fx-background-color: #e093f8; -fx-text-fill: #fefffe;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonBack.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                stage.close();
                try {
                    new MainMenu().closingWindow(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        groupPlay.getChildren().add(buttonBack);
        buttonBack.setVisible(true);
        stage.show();

    }
}
