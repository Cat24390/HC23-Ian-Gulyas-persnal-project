package com.example.javafxtest2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Save {

    public static void SaveData(String data) {
        try {
            Files.write(Paths.get("/Users/iangulyas/Desktop/SoftwareDeveloupment/HC23-Ian-Gulyas-Senior-Project/src/main/java/Save.txt"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
