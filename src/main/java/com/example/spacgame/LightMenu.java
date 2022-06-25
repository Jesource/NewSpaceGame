package com.example.spacgame;
import com.example.spacgame.game.Asteroids;
import javafx.application.Application;
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

public class LightMenu extends Application{
    public LightMenu(Stage stage) {
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        //setting parameters for the main window
        Group group = new Group();
        Scene scene = new Scene(group, 600, 400);
        stage.setTitle("Space Game");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                System.out.println("CLOSING");
            }
        });

        //adding background
        scene.setFill(new RadialGradient(
                10, 1, 1, 1, 1.25, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#D8BFD8")),
                new Stop(1, Color.web("#E0B0FF"))
        ));

        //adding label
        Label label = new Label("Space Game");
        Font font = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 45);
        label.setFont(font);
        label.setTextFill(Color.WHITE);
        label.setTranslateX(200);
        label.setTranslateY(40);
        group.getChildren().add(label);
        stage.show();

        //setting parameters for button 'START'
        Button buttonStart = new Button("     PLAY     ");
        buttonStart.setFont(font);
        buttonStart.setStyle("-fx-background-color: #fff300; -fx-text-fill: #ffffff;-fx-font-size: 1.75em; -fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonStart.setLayoutX(240);
        buttonStart.setLayoutY(90);
        group.getChildren().add(buttonStart);
        buttonStart.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
//                To see Darja's start window:
//                new Start(stage);

//                To see Sandra's SpaceShip:
//                try {
//                    new AsteroidsApplication().start(stage);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

//                To see Nikita's asteroids + game
                new Asteroids().repaint();
            }
        });

        //setting parameters for button 'RULES'
        Button buttonRules = new Button("    RULES    ");
        buttonRules.setStyle("-fx-background-color: #e093f8; -fx-text-fill: #f8fff8;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonRules.setLayoutX(240);
        buttonRules.setLayoutY(145);
        group.getChildren().add(buttonRules);
        buttonRules.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new LightRules(stage);
            }
        });

        //setting parameters for button 'SETTINGS'
        Button buttonSettings = new Button("SETTINGS");
        buttonSettings.setStyle("-fx-background-color: #e093f8; -fx-text-fill: #ffffff;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonSettings.setLayoutX(240);
        buttonSettings.setLayoutY(200);
        group.getChildren().add(buttonSettings);
        buttonSettings.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                new LightSettings(stage);
            }
        });

        //setting parameters for button 'QUIT'
        Button buttonQuit = new Button("     QUIT     ");
        buttonQuit.setStyle("-fx-background-color: #e093f8; -fx-text-fill: #ffffff;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
        buttonQuit.setLayoutX(240);
        buttonQuit.setLayoutY(255);
        group.getChildren().add(buttonQuit);
        buttonQuit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                {
                    System.exit(0);
                }
            }
        });

    }

    public static void main(String args[]) {
        launch(args);
    }
}
