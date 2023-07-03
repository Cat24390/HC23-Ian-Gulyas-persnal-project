package com.example.RandomForceGenerator;

/**
 * This is where the data for the RandomForceGenerator is being stored, just looks better if it's not clogging up the
 *  main class.
 */
public class RandomForceGeneratorData {
    static public int width = 500;
    static public int height = 700;
    static public int spacing = 10;
    static public String factions[] = {"Inner Sphere", "Clan"};
    static public String era[] = {"Pre StarLeague", "StarLeague", "The Succession wars", "Clan Invasion", "Dark Age", "Ilclan"};
    static Mech mech1 = new Mech(1, "StarLeague", "Inner Sphere");
    static Mech mech2 = new Mech(1, "The Succession wars", "Inner Sphere");
    static Mech mech3 = new Mech(1, "Clan Invasion", "Inner Sphere");
    static Mech mech4 = new Mech(1, "Dark Age", "Inner Sphere");
    static Mech mech5 = new Mech(1, "Clan Invasion", "Clan");
    static Mech mech6 = new Mech(1, "Dark Age", "Clan");
    static public Mech Testmech[]= {mech1,mech2,mech3,mech4,mech5,mech6,};
}
