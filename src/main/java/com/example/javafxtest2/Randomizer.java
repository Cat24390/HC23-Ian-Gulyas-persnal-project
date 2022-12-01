package com.example.javafxtest2;


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
