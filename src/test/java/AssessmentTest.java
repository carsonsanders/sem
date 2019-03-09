import com.napier.sem.Country;
import com.napier.sem.InputValidationException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class AssessmentTest

{

    private static Country testCountry = new Country();


    //testing setters and getters for Code property of the Country class
    @Test
    void countryCodeTests()
    {
        try {
            testCountry.setName("COL");
            assertEquals("COL", "COL", testCountry.getCode());
        } catch (InputValidationException e) {
            fail("Should not throw an Exception");
        }
    }

    //testing setters and getters for Name property of the Country class
    @Test
    public void countryNameTests() throws Exception {


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
            fail("Name should start with a letter");
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
    public void countryContinentTests() throws Exception {



        try {
            testCountry.setContinent("Africa");
            assertEquals("Africa", "Africa", testCountry.getContinent());
        } catch (InputValidationException e) {
            fail("Should not throw an Exception");
        }


        try {
            testCountry.setName("South America");
        }catch (InputValidationException e ) {
            fail("Should not throw an exception");
        }

        try {
            testCountry.setName("1Asia");
            fail("Name should start with a letter");
        } catch (InputValidationException e) {
        }

        try {
            testCountry.setName("A");
            fail("Should not allow less than two characters");
        } catch (InputValidationException e) {

        }

        try {
            testCountry.setName("abcdefghijklmnopqrstxyzabcdefgh");
            fail("Should not be longer than 20 characters");
        } catch (InputValidationException e) {

        }



    }






}