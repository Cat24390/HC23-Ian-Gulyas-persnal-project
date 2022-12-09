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

public class RandomForceGenerator extends Application {
    Button ExitButton;
    Button generateButton;
    Button SaveButton;
    ChoiceBox FactionsChoiceBox;
    ChoiceBox ErasChoiceBox;
    TextField battleValueField;
    TextField result_field;
    @Override
    public void start(Stage stage) {
        VBox UIroot = createAndIntiateUI();
        Scene Mainscene = new Scene(UIroot, options.width,options.height);
        stage.setTitle("Random Force Generator");
        stage.setScene(Mainscene);
        stage.show();
    }

    private VBox createAndIntiateUI() {
        VBox UIroot = new VBox();
        UIroot.setAlignment(Pos.CENTER);
        UIroot.setSpacing(options.spacing);
        AddUIelements(UIroot);
        return UIroot;
    }

    private void AddUIelements(VBox UIroot) {
        createButtons();
        createTextFields();
        createChoiceBoxes();
        UIroot.getChildren().addAll(FactionsChoiceBox,ErasChoiceBox,battleValueField,generateButton,result_field,SaveButton,ExitButton);

    }

    private void createChoiceBoxes() {
        FactionsChoiceBox = new ChoiceBox(FXCollections.observableArrayList(options.fac));
        ErasChoiceBox = new ChoiceBox(FXCollections.observableArrayList(options.era));
    }


    private void createTextFields() {
        battleValueField = new TextField("Enter Battle Value");
        result_field = new TextField();
    }

    private void createButtons() {
        ExitButton = new Button("Exit");
        generateButton =new Button("Generate Force");
        SaveButton = new Button("Save");
        createExitButton(ExitButton);
        createGenerateButton(generateButton);
        createSaveButton(SaveButton);
    }

    private void createGenerateButton(Button generateButton) {
        generateButton.setOnAction(e -> {String val = battleValueField.getText();
            String fact = String.valueOf(FactionsChoiceBox.getValue());
            String age = String.valueOf(ErasChoiceBox.getValue());
            Randomizer randomizer = new Randomizer(fact,val,age);
            String result = randomizer.getResult();
            result_field.setText(result);
        });
    }

    private void createExitButton(Button exitButton) { exitButton.setOnAction(e -> Platform.exit());}

    private void createSaveButton(Button saveButton) {
        saveButton.setOnAction(e ->
        {
            String val = battleValueField.getText();
            String fact = String.valueOf(FactionsChoiceBox.getValue());
            String age = String.valueOf(ErasChoiceBox.getValue());
            Randomizer randomizer = new Randomizer(fact,val,age);
            String result = randomizer.getResult();
            Save.SaveData(result);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}