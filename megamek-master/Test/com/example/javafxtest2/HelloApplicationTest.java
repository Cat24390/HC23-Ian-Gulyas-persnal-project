package com.example.javafxtest2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloApplicationTest {
    String result;

    @Test
    public void selectOptions()
    {
       Randomizer randomizer = new Randomizer("Draconis Combine","2000","Succession wars");
         result = randomizer.getResult();
         assertEquals("Draconis Combine 2000 Succession wars",result);
    }
}