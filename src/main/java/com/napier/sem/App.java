package com.napier.sem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
@RestController

public class App {

    public static void main(String[] args) {
        // Create new Application
        App a = new App();
        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:3306");
        }
        else
        {
            a.connect(args[0]);
        }

        a.reportSelection();



    }

    public static Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public static void connect(String location) {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://"+ location +"/world?allowPublicKeyRetrieval=true&useSSL=false",
                                                  "root",
                                                  "");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public static void disconnect() {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public void reportSelection(){

        PrintReports newRep = new PrintReports();
        //print welcome screen
        welcomeScreen();

        Scanner scanner = new Scanner(System.in);

        switch(scanner.next()) {

            //All the countries in the ...
            case "1":

                clearScreen();
                countryScreen();

                //Country Switch
                switch (scanner.next()){


                    //..in the world
                    case"1":
                        System.out.println("Would you like to limit results to see a specified number of countries?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                      switch (scanner.next()){

                          case"1":

                              System.out.println("How many countries would you like to limit the report to? Enter1 Number below");
                              int limit = Integer.parseInt(scanner.next());
                              newRep.countriesInWorldReport(limit);
                              break;

                          case"2":
                              newRep.countriesInWorldReport(0);
                              break;

                          default:
                              System.out.println("Please enter 1 for Yes or 2 for No");

                      }
                        break;

                    // ..in a continent
                    //user is prompted to choose a continent
                    case"2": continentScreen();

                        //user is prompted to choose a continent
                         switch (scanner.next()){

                             case "1": newRep.countriesInContinentReport("Africa");
                                       break;
                             case "2": newRep.countriesInContinentReport("Asia");
                                       break;
                             case "3": newRep.countriesInContinentReport("Europe");
                                       break;
                             case "4": newRep.countriesInContinentReport("North America");
                                       break;
                             case "5": newRep.countriesInContinentReport("South America");
                                       break;
                             case "6": newRep.countriesInContinentReport("Oceania");
                                 break;
                         }
                         break;

                    // ..in a region
                    //user is prompted to type region name
                    case"3":

                             //limit region report to a specified number of countries
                             System.out.println("Would you like to limit results to see a specified number of countries?");
                             System.out.println("1. Yes");
                             System.out.println("2. No");

                        switch (scanner.next()){

                            case"1":

                                System.out.println("How many countries would you like to limit the report to? Enter a Number below");
                                int limit = Integer.parseInt(scanner.next());
                                System.out.println("Please type the name of the Region :");
                                String rgn = scanner.next();
                                newRep.countriesInRegionReport(rgn,limit);
                                break;

                            case"2":

                                System.out.println("Please type the name of the Region :");
                                newRep.countriesInRegionReport(scanner.next(),0);
                                break;

                            default:
                                System.out.println("Please enter 1 for Yes or 2 for No");

                        }
                        break;
                }
                break;

            //All the cities in the ...
            case "2":

                clearScreen();
                cityScreen();

                switch (scanner.next()){

                    //..in the world
                    case"1":
                        System.out.println("Would you like to limit results to see a specified number of cities?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        switch (scanner.next()){

                            case"1":

                                System.out.println("How many cities would you like to limit the report to? Enter Number below");
                                int limit = Integer.parseInt(scanner.next());
                                newRep.citiesInWorldReport(limit);
                                break;

                            case"2":
                                newRep.citiesInWorldReport(0);
                                break;

                            default:
                                System.out.println("Please enter 1 for Yes or 2 for No");

                        }
                        break;

                    //,,in the continent
                    case"2":




                }

                default:
                    System.out.println("Please enter a valid selection");



        }

    }



    public void welcomeScreen() {

        clearScreen();
        System.out.println("\n");
        System.out.println("Welcome!");
        System.out.println("\n");
        System.out.println("Would you like a population report on..");
        System.out.println("1. All the countries in...");
        System.out.println("2. All the cities in...");
        System.out.println("3. All the capital cities in...");
        System.out.println("Press 'x' to exit");

    }

    public void countryScreen() {

        //Display country menu options
        System.out.println("\n");
        System.out.println("Country report selection : ");
        System.out.println("\n");
        System.out.println("1. All the countries in the World");
        System.out.println("2. All the countries in a Continent");
        System.out.println("3. All the countries in a Region");
        System.out.println("Press 'x' to exit");

    }

    public void cityScreen() {

        //Display country menu options
        System.out.println("\n");
        System.out.println("City report selection : ");
        System.out.println("\n");
        System.out.println("1. All the cities in the World");
        System.out.println("2. All the cities in a Continent");
        System.out.println("3. All the cities in a Region");
        System.out.println("Press 'x' to exit");

    }

    public void continentScreen() {

        //Display country menu options
        System.out.println("\n");
        System.out.println("Choose a continent :");
        System.out.println("\n");
        System.out.println("1. Africa");
        System.out.println("2. Asia");
        System.out.println("3. Europe");
        System.out.println("4. North America");
        System.out.println("5. South America");
        System.out.println("6. Oceania");

    }


    public static void clearScreen() {

    }

}



