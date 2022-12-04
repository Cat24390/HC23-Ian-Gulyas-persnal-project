package com.example.javafxtest2;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    public void UITest()
    {

    }


}