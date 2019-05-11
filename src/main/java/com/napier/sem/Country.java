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
    public ArrayList<Country> getCountries(String category) {

        countryList.clear();

        if(category=="world") {
        try
        {
            // Create an SQL statement
            Statement stmt = App.con.createStatement();
            // Query to select all countries
            String query = "SELECT * FROM country"
                         +"ORDER BY population DESC;";
            // Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next())
            {
                //Add country to countrylist
                countryList.add(newCountry(rs));
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

        else if(category=="region"){

            try
            {
                // Create an SQL statement
                Statement stmt = App.con.createStatement();
                // Query to select all countries
                String query = "SELECT * FROM country"
                        +"ORDER BY population DESC;";
                // Execute SQL statement
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {
                    //Add country to countrylist
                    countryList.add(newCountry(rs));
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
        return null;
    }


    //Returns country object created from result set data
    public Country newCountry(ResultSet rs) throws SQLException {

        Country cout = new Country();
        cout.setCode(rs.getString("Code"));
        cout.setName(rs.getString("Name"));
        cout.setContinent(rs.getString("Continent"));
        cout.setRegion(rs.getString("Region"));
        cout.setPopulation(rs.getInt("Population"));
        cout.setCapital(rs.getString("Capital"));
        return cout;

    }
}
