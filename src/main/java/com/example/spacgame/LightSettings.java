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

public class LightSettings {
    public LightSettings(Stage stage) {
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(Stage stage) throws Exception {
        Group settings = new Group();
        Scene scene = new Scene(settings, 600,400);
        stage.setTitle("Settings");
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override public void handle(WindowEvent t) {
                System.out.println("CLOSING");
            }
        });


        //adding background
        scene.setFill(new RadialGradient(
                2, 1, 0, 0, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#D8BFD8")),
                new Stop(1, Color.web("#E0B0FF"))
        ));

        //adding button "BACK"
        Button buttonBack = new Button("BACK");
        buttonBack.setLayoutX(490);
        buttonBack.setLayoutY(330);
        Font font = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 45);
        buttonBack.setStyle("-fx-background-color: #e093f8; -fx-text-fill: #ffffff;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
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
        settings.getChildren().add(buttonBack);
        buttonBack.setVisible(true);

        //adding label
        Label labelSettings = new Label("CHOOSE A MODE");
        labelSettings.setFont(font);
        labelSettings.setTextFill(Color.WHITE);
        labelSettings.setTranslateX(175);
        labelSettings.setTranslateY(40);
        settings.getChildren().add(labelSettings);

        //adding buttons to select dork/light mode
        Button buttonDark = new Button("  DARK MODE ");
        buttonDark.setLayoutX(220);
        buttonDark.setLayoutY(100);
        buttonDark.setStyle("-fx-background-color: #6544c7; -fx-text-fill: #ffffff;-fx-font-size: 2em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonDark.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
            }
        });
        settings.getChildren().add(buttonDark);
        buttonDark.setVisible(true);
        stage.show();


        Button buttonLight = new Button("LIGHT MODE");
        buttonLight.setLayoutX(220);
        buttonLight.setLayoutY(160);
        buttonLight.setStyle("-fx-background-color: #e093f8; -fx-text-fill: #fefeff;-fx-font-size: 2em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonLight.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                new LightMenu(stage);
            }
        });
        settings.getChildren().add(buttonLight);
        buttonLight.setVisible(true);

        stage.show();

    }
}
