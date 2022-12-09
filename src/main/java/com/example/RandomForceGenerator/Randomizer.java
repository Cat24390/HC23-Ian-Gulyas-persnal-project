package com.example.RandomForceGenerator;

/**
 * This is the Randomizer class Right now all it does it combine strings but this will be where the algorithm for
 * selecting the mechs will be.
 */

public class Randomizer{
    private String Faction;
    private String Era;
    private String battleValue;
    private String Result;

    /**
     * this is where the afformentioned string combining happens
     * @param faction
     * @param battlevalue these parameters are just normal strings
     * @param era
     */
    public Randomizer(String faction, String battlevalue, String era){
                Faction = faction;
                battleValue=battlevalue;
                Era = era;
                Result = Faction + " " + battleValue+ " "+ Era;

    }

    /**
     * just a getter nothing much to see
     * @return returns the result of the Randomiser class
     */
    public String getResult(){
        return Result;
    }

}
