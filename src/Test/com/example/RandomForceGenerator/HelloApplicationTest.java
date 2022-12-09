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
import org.junit.jupiter.api.Test;
import org.testfx.assertions.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

//Where the Automatic Testing is done
class HelloApplicationTest {
    String result;
    String saveTestData = "Draconis Combine 2000 Succession wars";
    String saveResult;

    @Test
    public void selectOptions()
    {
       Randomizer randomizer = new Randomizer("Draconis Combine","2000","Succession wars");
         result = randomizer.getResult();
         assertEquals("Draconis Combine 2000 Succession wars",result);
    }

    @Test
    public void saveTest()
    {
        Save.SaveData(saveTestData);
        File myObj = new File("/Users/iangulyas/Desktop/SoftwareDeveloupment/HC23-Ian-Gulyas-Senior-Project/src/main/java/Save.txt");
        try {
            Scanner myReader = new Scanner(myObj);
            saveResult = myReader.nextLine();
            assertEquals(saveTestData,saveResult);
            assertNotEquals("random string",saveResult);
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

   /* public class RandomForceGenerator extends ApplicationTest {
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
            Scene Mainscene = new Scene(UIroot, RandomForceGeneratorData.width, RandomForceGeneratorData.height);
            stage.setTitle("Random Force Generator");
            stage.setScene(Mainscene);
            stage.show();
        }



        private VBox createAndIntiateUI() {
            VBox UIroot = new VBox();
            UIroot.setAlignment(Pos.CENTER);
            UIroot.setSpacing(RandomForceGeneratorData.spacing);
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
            FactionsChoiceBox = new ChoiceBox(FXCollections.observableArrayList(RandomForceGeneratorData.factions));
            ErasChoiceBox = new ChoiceBox(FXCollections.observableArrayList(RandomForceGeneratorData.era));
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

        public void main(String[] args) {
            launch();
        }
        @Test
        public void allUIButtonsAreHere() {
            Assertions.assertThat(ExitButton).hasText("Exit");
            //verifyThat("ExitButton", hasText("Exit"));
            //verifyThat("generateButton", hasText("Generate Force"));
            //verifyThat("SaveButton", hasText("Save"));

        }
        @Test
        public void textFieldsAreHere()
        {
            verifyThat(".battleValueField",hasText("Enter Battle Value"));
            verifyThat(".result_field",hasText(""));
        }

    }
*/
    public void main(){}

}