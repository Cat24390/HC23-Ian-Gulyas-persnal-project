package com.example.RandomForceGenerator;
//At the moment this is where the options are combined into one string
// but in the future, this is where the Input file stream, randomisation and selection algorithm will be happening

public class Randomizer{
    private String Faction;
    private String Era;
    private String battleValue;
    private String Result;
    public Randomizer(String faction, String battlevalue, String era){
                Faction = faction;
                battleValue=battlevalue;
                Era = era;
                Result = Faction + " " + battleValue+ " "+ Era;

    }
    public String getResult(){
        return Result;
    }

}
