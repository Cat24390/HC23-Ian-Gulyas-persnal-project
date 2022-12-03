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
        File myObj = new File("Save.txt");
        try {
            Scanner myReader = new Scanner(myObj);
            assertEquals(saveTestData,myReader.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}