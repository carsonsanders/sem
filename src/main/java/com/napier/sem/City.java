package com.napier.sem;


import java.sql.*;
import java.util.ArrayList;

public class City {


    private String name;
    private String country;
    private String district;
    private int population;
    private ArrayList<City> cityList = new ArrayList<City>();


    //Default constructor
    public City() {
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    /**
     * @return A list of all cities
     */
    public ArrayList<City> getCities(String inThe, String name)
    {
        cityList.clear();


        if(inThe=="world"&& (name==null)) {
            try
            {
                // Create an SQL statement
                Statement stmt = App.con.createStatement();
                // Query to select all countries
                String query = "SELECT * FROM city " +
                        "ORDER BY population DESC";
                // Execute SQL statement
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {
                    //Add country to countrylist
                    cityList.add(newCity(rs));
                }

                return cityList;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to extract data");
                return null;
            }

        }

        //if parameters are region and name is not null
        else if(inThe=="continent" && !(name==null)) {

            try {
                // Create an SQL statement
                Statement stmt = App.con.createStatement();
                // Query to select all countries
                String query = "SELECT * FROM city " +
                        "WHERE city.Continent ='" + name + "'" +
                        "ORDER BY population DESC";

                // Execute SQL statement

                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    //Add country to countrylist
                    cityList.add(newCity(rs));
                }

                return cityList;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to extract data");
                return null;
            }
        }

        //if parameters are region and name is not null
        else if(inThe=="region" && !(name==null)){

            try
            {
                // Create an SQL statement
                Statement stmt = App.con.createStatement();
                // Query to select all countries
                String query = "SELECT * FROM city " +
                        "WHERE city.Region ='" + name + "'" +
                        "ORDER BY population DESC";

                // Execute SQL statement

                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {
                    //Add country to countrylist
                    cityList.add(newCity(rs));
                }

                return cityList;
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


    //Returns city object created from result set data
    public City newCity(ResultSet rs) throws SQLException {

        City city = new City();
        city.setName(rs.getString("Name"));
        city.setCountry(rs.getString("CountryCode"));
        city.setDistrict(rs.getString("District"));
        city.setPopulation(rs.getInt("Population"));
        return city;

    }
}
