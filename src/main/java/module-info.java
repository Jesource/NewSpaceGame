module com.example.spacgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.spacgame to javafx.fxml;
    exports com.example.spacgame;

    opens com.example.spacgame.spaceship to javafx.fxml;
    exports com.example.spacgame.spaceship;
}