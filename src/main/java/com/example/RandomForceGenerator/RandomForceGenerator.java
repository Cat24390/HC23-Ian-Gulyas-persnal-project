package com.example.RandomForceGenerator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This is the main class, this is where the UI is created and implemented right now it is the only scene
 * for my app but eventually there will be a start page, and page for loading save configurations.
 */

public class RandomForceGenerator extends Application {

    @Override
    /**
     * This methods puts everything to together after getting it created and sets the scene
     */
    public void start(Stage stage) {
        RandomForceGeneratorBuilder RD = new RandomForceGeneratorBuilder();
        VBox UIroot = RD.getUIRoot();
        Scene Mainscene = new Scene(UIroot, RandomForceGeneratorData.width, RandomForceGeneratorData.height);
        stage.setTitle("Random Force Generator");
        stage.setScene(Mainscene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}