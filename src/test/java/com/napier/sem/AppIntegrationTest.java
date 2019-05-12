package com.napier.sem;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:3306");
    }

    //Should return null
    @Test
    void testCountry_invalidInThe_null(){

        Country count = new Country();
        List<Country> getCountryReturns = count.getCountries("jhkksa", null);
        assertNull(getCountryReturns);
    }

    //Should return null
    @Test
    void testCountry_wrongCategory_notNull(){

        Country count = new Country();
        List<Country> getCountryReturns = count.getCountries("smkwkkd", "notnull");
        assertNull(getCountryReturns);
    }

    //Should not return null (China is the first country in list)
    @Test
    void testCountry_world_null(){

        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("world", null);
        assertEquals(getCountryReturns.get(0).getName(), "China");
    }

    //Should return null
    @Test
    void testCountry_world_notNull(){

        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("world", "kakosj");
        assertNull(getCountryReturns);
    }

    //Should return null (continent requires name)
    @Test
    void testCountry_continent_null(){

        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("continent", null);
        assertNull(getCountryReturns);
    }

    //Should return countries in  asia
    @Test
    void testCountry_continent_notNull_validName(){

        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("continent", "Asia");
        assertEquals(getCountryReturns.get(0).getContinent(), "Asia");
    }

    //Should return null
    @Test
    void testCountry_region_null(){

        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("region", null);
        assertNull(getCountryReturns);
    }

    //Should return countries in Southern Europe
    @Test
    void testCountry_region_NotNull_validName(){

        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("region", "Southern Europe");
        assertEquals(getCountryReturns.get(0).getRegion(), "Southern Europe");
    }


}