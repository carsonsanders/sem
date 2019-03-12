package com.napier.sem;

import com.sun.org.apache.xalan.internal.lib.ExsltBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("db:33060");
    }

    @Test
    void testGetCountries()
    {
        try {

            ArrayList<Country> cList = app.getAllCountries();
        } catch(Exception e){

            fail("Should not throw an exception");
        }
    }



}