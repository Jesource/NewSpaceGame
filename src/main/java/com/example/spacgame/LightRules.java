package com.example.spacgame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.text.Text;

public class LightRules extends Application {
    public LightRules(Stage stage) {
        try {
            start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(Stage stage) throws Exception {
        //   setting parameters for "RULES" window
        Group rules = new Group();
        Scene scene = new Scene(rules, 600, 400);
        stage.setTitle("RULES");
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

        //adding description of rules
        Text t = new Text();
        Font font = Font.loadFont("file:src/main/resources/Pixeboy-z8XGD.ttf", 25);
        t.setFont(font);
        t.setText("HI THERE! HERE IS A SIMPLE GUIDE:\n>>> USE ARROW KEYS TO NAVIGATE THE SPACE SHIP.\n>>> PRESS \'SPACE\' TO SHOOT BULLETS AND DESTROY\nASTEROIDS.\n>>> THE MORE ASTEROIDS DESTROYED - THE HIGHER YOUR\nSCORE!");
        t.setLayoutX(20);
        t.setLayoutY(100);
        t.setFill(Color.WHITE);
        rules.getChildren().add(t);

        //adding stars
        Text stars = new Text();
        stars.setFont(Font.font ("Verdana", 20));
        stars.setText("✱✱✱✱✱✱✱✱✱✱✱");
        stars.setLayoutX(20);
        stars.setLayoutY(70);
        stars.setFill(Color.WHITE);
        rules.getChildren().add(stars);

        //adding button "BACK"
        Button buttonBack = new Button("BACK");
        buttonBack.setLayoutX(490);
        buttonBack.setLayoutY(330);
        buttonBack.setStyle("-fx-background-color: #e093f8; -fx-text-fill: #fdfdfd;-fx-font-size: 1.75em;-fx-font: normal bold 25px 'Pixeboy';-fx-background-radius: 15px;");
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
        rules.getChildren().add(buttonBack);
        buttonBack.setVisible(true);
        stage.show();
    }

}
