package com.example.javafxtest2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        String fac[] ={"Draconis Combine","Federated Suns","Outworlds Alliance"};
        String era[] ={"Third Sucession war","Clan Invasion","Illclan"};
        ChoiceBox Factions = new ChoiceBox(FXCollections.observableArrayList(fac));
        ChoiceBox Eras = new ChoiceBox(FXCollections.observableArrayList(era));
        Button exit = new Button("Exit");
        Button generate =new Button("Generate Force");
        exit.setOnAction(e -> Platform.exit());
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(Factions,exit,generate,Eras);
        Scene scene = new Scene(root, 500, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}