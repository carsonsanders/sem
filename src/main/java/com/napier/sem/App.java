package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();
        System.out.println("this is a string");

        // Connect to database
        a.connect("db:33060");

        // Extract employee salary information
        ArrayList<Country> countries = a.getAllCountries();

        // Test the size of the returned data - should be 240124
        System.out.println(countries.size());


        // Disconnect from database
        a.disconnect();
    }
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
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
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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
    public void disconnect()
    {
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

    /**
     * Gets all the current employees and salaries.
     * @return A list of all employees and salaries, or null if there is an error.
     */

    public ArrayList<Country> getAllCountries()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Query to select all countries
            String SQL = "SELECT * FROM country";
            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(SQL);

            // Extract employee information
            ArrayList<Country> countryList = new ArrayList<Country>();

            while (rs.next())
            {

                Country count = new Country();
                count.setCode(rs.getString("country.Code"));
                count.setName(rs.getString("country.Name"));
                count.setContinent(rs.getString("country.Continent"));
                count.setRegion(rs.getString("country.Region"));
                count.setPopulation(rs.getInt("country.Population"));
                count.setCapital(rs.getString("country.Capital"));

                //Add country to Arraylist
                countryList.add(count);
            }
            return countryList;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to extract data");
            return null;
        }
    }





}