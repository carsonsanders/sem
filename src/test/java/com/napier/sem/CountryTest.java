package com.napier.sem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class CountryTest {

    static Country cou;

    @BeforeAll
    static void init()
    {
        cou = new Country();
        cou.setName("Scotland");
        cou.setCode("SCO");
        cou.setContinent("Europe");
        cou.setRegion("Western Europe");
        cou.setCapital("Edinburgh");
        cou.setPopulation(6000000);
    }


    @Test
    public void test_getCode(){
        assertEquals("SCO", cou.getCode());
    }

    @Test
    public void test_getName(){
        assertEquals("Scotland", cou.getName());
    }
    @Test
    public void test_getContinent(){
        assertEquals("Europe", cou.getContinent());
    }
    @Test
    public void test_getRegionl(){
        assertEquals("Western Europe", cou.getRegion());
    }
    @Test
    public void test_getPopulation(){
        assertEquals(6000000, cou.getPopulation());
    }
    @Test
    public void test_getCapital(){
        assertEquals("Edinburgh", cou.getCapital());
    }
}