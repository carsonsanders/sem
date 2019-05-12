package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CityTest {

    static City ci;

    @BeforeAll
    static void init()
    {
        ci = new City();
        ci.setName("Edinburgh");
        ci.setCountry("Scotland");
        ci.setPopulation(400000);
    }




    @Test
    public void test_getName(){
        assertEquals("Edinburgh", ci.getName());
    }
    @Test
    public void test_getPopulation(){
        assertEquals(400000, ci.getPopulation());
    }
    @Test
    public void test_getCountry(){
        assertEquals("Scotland", ci.getCountry());
    }
}