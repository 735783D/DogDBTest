package com.example.dogdbtest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DBController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}