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
class RandomiserandSaveTest {
    String result;
    String saveTestData = "Draconis Combine 2000 Succession wars";
    String saveResult;

    @Test
    public void selectOptions()
    {
       Randomizer randomizer = new Randomizer("Draconis Combine","2000","Succession wars","2040");
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

    public void main(){}

}