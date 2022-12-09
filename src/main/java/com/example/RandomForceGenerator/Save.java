package com.example.RandomForceGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Save {

    public static void SaveData(String data) {
        try {
            Files.write(Paths.get("/Users/iangulyas/Desktop/SoftwareDeveloupment/HC23-Ian-Gulyas-Senior-Project/Save.txt"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
