package com.example.RandomForceGenerator;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * This is where The Vbox for Random Force Generator is set up as well as all the
 * buttons, ChoiceBoxes, and Testfeilds are implemented
 */

public class RandomForceGeneratorBuilder {
    public VBox UIRoot;
    public Button ExitButton;
    public Button GenerateButton;
    public Button SaveButton;
    public ChoiceBox FactionsChoiceBox;
    public ChoiceBox ErasChoiceBox;
    public TextField BattleValueField;
    public TextField Result_field;

    public RandomForceGeneratorBuilder() {
        UIRoot = createAndInitializeUI();
    }


    /**
     * this is where the Vbox is created and set up, had to do this before the creation of the main scene as the
     * elements of the Vbox can not be modified after its creation.
     * @return this returns the Vbox after is has been set up and all the elements added to it.
     */

    public VBox createAndInitializeUI() {
        VBox UIRoot = new VBox();
        UIRoot.setAlignment(Pos.CENTER);
        UIRoot.setSpacing(RandomForceGeneratorData.spacing);
        AddUIelements(UIRoot);
        return UIRoot;
    }

    /**
     * This method calls all the methods for creating the UI elements and gets them set up in the right order
     * @param UIroot This methods expects an empty Vbox that has already had the spacing and Alignment set up
     */

    public void AddUIelements(VBox UIroot) {
        createButtons();
        createTextFields();
        createChoiceBoxes();
        UIroot.getChildren().addAll(FactionsChoiceBox,ErasChoiceBox,BattleValueField,GenerateButton,Result_field,SaveButton,ExitButton);

    }

    /**
     * This method creates and assigns data to the choiceboxes
     */

    public void createChoiceBoxes() {
        FactionsChoiceBox = new ChoiceBox(FXCollections.observableArrayList(RandomForceGeneratorData.factions));
        ErasChoiceBox = new ChoiceBox(FXCollections.observableArrayList(RandomForceGeneratorData.era));
    }

    /**
     * This method creates the text fields
     */

    public void createTextFields() {
        BattleValueField = new TextField("Enter Battle Value");
        Result_field = new TextField();
    }

    /**
     * This method creates the buttons and calls the methods to add functionality to them
     */

    public void createButtons() {
        ExitButton = new Button("Exit");
        GenerateButton =new Button("Generate Force");
        SaveButton = new Button("Save");
        createExitButton(ExitButton);
        createGenerateButton(GenerateButton);
        createSaveButton(SaveButton);
    }

    /**
     * This method adds functionality to the Generate Button
     * @param generateButton this is made for the generate button using it for anything else
     *                       would be confusing
     */

    public void createGenerateButton(Button generateButton) {
        generateButton.setOnAction(e -> {String val = BattleValueField.getText();
            String fact = String.valueOf(FactionsChoiceBox.getValue());
            String age = String.valueOf(ErasChoiceBox.getValue());
            Randomizer randomizer = new Randomizer(fact,val,age);
            String result = randomizer.getResult();
            Result_field.setText(result);
        });
    }

    /**
     * This method adds functionality to the exit button
     * @param exitButton don't use this for any other button as that would be frustrating
     */

    public void createExitButton(Button exitButton) { exitButton.setOnAction(e -> Platform.exit());}

    /**
     * this method adds functionality to the save button
     * @param saveButton
     */

    public void createSaveButton(Button saveButton) {
        saveButton.setOnAction(e ->
        {
            String val = BattleValueField.getText();
            String fact = String.valueOf(FactionsChoiceBox.getValue());
            String age = String.valueOf(ErasChoiceBox.getValue());
            Randomizer randomizer = new Randomizer(fact,val,age);
            String result = randomizer.getResult();
            Save.SaveData(result);
        });
    }
    public VBox getUIRoot()
    {
        return UIRoot;
    }

}
