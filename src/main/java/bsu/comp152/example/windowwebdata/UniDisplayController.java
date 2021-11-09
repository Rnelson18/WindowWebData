package bsu.comp152.example.windowwebdata;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UniDisplayController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}