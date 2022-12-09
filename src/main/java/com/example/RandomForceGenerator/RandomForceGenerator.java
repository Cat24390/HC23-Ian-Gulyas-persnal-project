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
    Button ExitButton;
    Button generateButton;
    Button SaveButton;
    ChoiceBox FactionsChoiceBox;
    ChoiceBox ErasChoiceBox;
    TextField battleValueField;
    TextField result_field;
    @Override
    /**
     * This is the real main method,
     */
    public void start(Stage stage) {
        VBox UIroot = createAndInitializeUI();
        Scene Mainscene = new Scene(UIroot, RandomForceGeneratorData.width, RandomForceGeneratorData.height);
        stage.setTitle("Random Force Generator");
        stage.setScene(Mainscene);
        stage.show();
    }

    /**
     * this is where the Vbox is created and set up, had to do this before the creation of the main scene as the
     * elements of the Vbox can not be modified after its creation.
     * @return this returns the Vbox after is has been set up and all the elements added to it.
     */

    private VBox createAndInitializeUI() {
        VBox UIroot = new VBox();
        UIroot.setAlignment(Pos.CENTER);
        UIroot.setSpacing(RandomForceGeneratorData.spacing);
        AddUIelements(UIroot);
        return UIroot;
    }

    /**
     * This method calls all the methods for creating the UI elements and gets them set up in the right order
     * @param UIroot This methods expects an empty Vbox that has already had the spacing and Alignment set up
     */

    private void AddUIelements(VBox UIroot) {
        createButtons();
        createTextFields();
        createChoiceBoxes();
        UIroot.getChildren().addAll(FactionsChoiceBox,ErasChoiceBox,battleValueField,generateButton,result_field,SaveButton,ExitButton);

    }

    /**
     * This method creates and assigns data to the choiceboxes
     */

    private void createChoiceBoxes() {
        FactionsChoiceBox = new ChoiceBox(FXCollections.observableArrayList(RandomForceGeneratorData.factions));
        ErasChoiceBox = new ChoiceBox(FXCollections.observableArrayList(RandomForceGeneratorData.era));
    }

    /**
     * This method creates the text fields
     */

    private void createTextFields() {
        battleValueField = new TextField("Enter Battle Value");
        result_field = new TextField();
    }

    /**
     * This method craetes the buttons and calls the methods to add functionality to them
     */

    private void createButtons() {
        ExitButton = new Button("Exit");
        generateButton =new Button("Generate Force");
        SaveButton = new Button("Save");
        createExitButton(ExitButton);
        createGenerateButton(generateButton);
        createSaveButton(SaveButton);
    }

    /**
     * This method adds functionality to the Generate Button
     * @param generateButton this is made for the generate button using it for anything else
     *                       would be confusing
     */

    private void createGenerateButton(Button generateButton) {
        generateButton.setOnAction(e -> {String val = battleValueField.getText();
            String fact = String.valueOf(FactionsChoiceBox.getValue());
            String age = String.valueOf(ErasChoiceBox.getValue());
            Randomizer randomizer = new Randomizer(fact,val,age);
            String result = randomizer.getResult();
            result_field.setText(result);
        });
    }

    /**
     * This method adds functionality to the exit button
     * @param exitButton don't use this for any other button as that would be frustrating
     */

    private void createExitButton(Button exitButton) { exitButton.setOnAction(e -> Platform.exit());}

    /**
     * this method adds functionality to the save button
     * @param saveButton
     */

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

    /**
     * this just launches the app after evrything is done
     * @param args
     */

    public static void main(String[] args) {
        launch();
    }
}