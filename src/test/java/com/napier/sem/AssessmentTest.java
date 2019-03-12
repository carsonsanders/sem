package com.napier.sem;

import com.napier.sem.Country;
import com.napier.sem.InputValidationException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class AssessmentTest

{

    private static Country testCountry = new Country();


    //testing setters and getters for Code property of the Country class
    @Test
    void countryCodeTests() {
        try {
            testCountry.setCode("COL");
            assertEquals("COL", "COL", testCountry.getCode());
        } catch (InputValidationException e) {
            fail("Should not throw an Exception");
        }

        try {
            testCountry.setCode("PAK");
        } catch (InputValidationException e) {
            fail("Should not throw an exception");
        }

        try {
            testCountry.setCode("AFGH");
            fail("Code cannot be more than 3 Characters");
        } catch (InputValidationException e) {
        }

        try {
            testCountry.setCode("SC");
            fail("Code cannot be less than 3 Characters");
        } catch (InputValidationException e) {
        }

        try {
            testCountry.setCode("Q4T");
            fail("Code cannot contain numbers");
        } catch (InputValidationException e) {
        }


    }

    //testing setters and getters for Name property of the Country class
    @Test
    public void countryNameTests() {


        //testing setters and getters
        try {
            testCountry.setName("Latvia");
            assertEquals("Latvia", "Latvia", testCountry.getName());
        } catch (InputValidationException e) {
            fail("Should not throw an Exception");
        }


        try {
            testCountry.setName("Saudi");
        }catch (InputValidationException e ) {
            fail("Should not throw an exception");
        }

        try {
            testCountry.setName("1Kenya");
            fail("Name cannot contain numbers");
        } catch (InputValidationException e) {
        }

        try {
            testCountry.setName("A");
            fail("Should not allow less than two characters");
        } catch (InputValidationException e) {

        }

        try {
            testCountry.setName("abcdefghijklmnopqrstxyzabcdefghijklmnopqrstxyz");
            fail("Should not be longer than 35 characters");
        } catch (InputValidationException e) {

        }

        try {
            testCountry.setName("United $tates of America");
            fail("Should not include special characters");
        } catch (InputValidationException e) {

        }

    }

    //testing setters and getters for Continent property for Country class
    @Test
    public void countryContinentTests() {



        try {
            testCountry.setContinent("Africa");
            assertEquals("Africa", "Africa", testCountry.getContinent());
        } catch (InputValidationException e) {
            fail("Should not throw an Exception");
        }


        try {
            testCountry.setContinent("South America");
        }catch (InputValidationException e ) {
            fail("Should not throw an exception");
        }

        try {
            testCountry.setContinent("1Asia");
            fail("Continent cannot contain numbers");
        } catch (InputValidationException e) {
        }

        try {
            testCountry.setContinent("A");
            fail("Should not allow less than two characters");
        } catch (InputValidationException e) {

        }

        try {
            testCountry.setContinent("abcdefghijklmnopqrstxyzabcdefgh");
            fail("Should not be longer than 20 characters");
        } catch (InputValidationException e) {

        }

    }

    @Test
    public void countryRegionTests() {



        try {
            testCountry.setRegion("Eastern Africa");
            assertEquals("Eastern Africa", "Eastern Africa", testCountry.getRegion());
        } catch (InputValidationException e) {
            fail("Should not throw an Exception");
        }


        try {
            testCountry.setRegion("Southern Europe");
        }catch (InputValidationException e ) {
            fail("Should not throw an exception");
        }

        try {
            testCountry.setRegion("6Middle East");
            fail("Region cannot contain numbers");
        } catch (InputValidationException e) {
        }

        try {
            testCountry.setRegion("A");
            fail("Should not allow less than two characters");
        } catch (InputValidationException e) {

        }

        try {
            testCountry.setRegion("abcdefghijklmnopqrstxyzabcdefgh");
            fail("Should not be longer than 30 characters");
        } catch (InputValidationException e) {

        }

    }



}