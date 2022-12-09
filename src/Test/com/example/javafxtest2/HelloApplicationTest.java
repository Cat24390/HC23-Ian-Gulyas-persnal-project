package com.example.javafxtest2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;
//import org.testfx.assertions.api.Assertions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
//import static org.testfx.api.FxAssert.verifyThat;
//import static org.testfx.util.NodeQueryUtils.hasText;

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

       /* public void main(String[] args) {
            launch();
        }
        @Test
        public void allUIButtonsAreHere()
        {
            verifyThat(".exit", hasText("Exit"));
            verifyThat(".generate", hasText("Generate Force"));
            verifyThat(".SaveButton", hasText("Save"));

        }

        */
    }




}