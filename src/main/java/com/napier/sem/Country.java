package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class Country {


    private String code;
    private String name;
    private String continent;
    private String region;
    private int population;
    private String capital;
    private ArrayList<Country> countryList = new ArrayList<Country>();


    //Default constructor
    public Country() {
    }


    //Accessor methods for properties
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
            this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
            this.name = name;
    }

    public String getContinent() {
        return continent;
    }
    public void setContinent(String continent) {
           this.continent = continent;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
       this.region = region;
    }

    public double getPopulation() {
        return population;
    }
    public void setPopulation(int population){
            this.population = population;
    }

    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }


    /**
     * @return A list of all countries
     */
    public ArrayList<Country> getAllCountries()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = App.con.createStatement();
            // Query to select all countries
            String SQL = "SELECT * FROM country";
            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(SQL);

            // Extract employee information
            ArrayList<Country> countryList = new ArrayList<Country>();

            while (rs.next())
            {

                Country count = new Country();
                count.setCode(rs.getString("Code"));
                count.setName(rs.getString("Name"));
                count.setContinent(rs.getString("Continent"));
                count.setRegion(rs.getString("Region"));
                count.setPopulation(rs.getInt("Population"));
                count.setCapital(rs.getString("Capital"));

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
