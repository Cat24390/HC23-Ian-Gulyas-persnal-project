package com.example.javafxtest2;

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
// This is where the UI is created and set up.

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        int width = options.width;
        int height = options.height;
        TextField battleValue = new TextField("Enter Battle Value");
        TextField result_field = new TextField();
        ChoiceBox Factions = new ChoiceBox(FXCollections.observableArrayList(options.fac));
        ChoiceBox Eras = new ChoiceBox(FXCollections.observableArrayList(options.era));
        Button exit = new Button("Exit");
        Button generate =new Button("Generate Force");
        Button SaveButton = new Button("Save");
        generate.setOnAction(e -> {String val = battleValue.getText();
        String fact = String.valueOf(Factions.getValue());
        String age = String.valueOf(Eras.getValue());
        Randomizer randomizer = new Randomizer(fact,val,age);
        String result = randomizer.getResult();
        result_field.setText(result);
        });
        exit.setOnAction(e -> Platform.exit());
        SaveButton.setOnAction(e ->
        {
            String val = battleValue.getText();
            String fact = String.valueOf(Factions.getValue());
            String age = String.valueOf(Eras.getValue());
            Randomizer randomizer = new Randomizer(fact,val,age);
            String result = randomizer.getResult();
            Save.SaveData(result);
        });
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(Factions,exit,generate,Eras,battleValue,result_field,SaveButton);
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Random Force Generator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}