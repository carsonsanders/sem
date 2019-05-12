package com.napier.sem;

public class PrintReports {


    public void countriesInWorldReport(int limit) {

        Country cou = new Country();
        //Check that there is data to display
        if (cou.getCountries("world", null) != null) {
            //If there is data to display, display data in table format
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %40s %30s %35s %25s %15s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");

            if (limit == 0) {

                for (int i = 0; i < cou.getCountries("world", null).size(); i++) {
                    System.out.format("%s %40s %30s %35s %25s %15s", cou.getCountryList().get(i).getCode(), cou.getCountryList().get(i).getName(),
                            cou.getCountryList().get(i).getContinent(), cou.getCountryList().get(i).getRegion(), cou.getCountryList().get(i).getPopulation(),
                            cou.getCountryList().get(i).getCapital());
                    System.out.println();
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            } else if (limit>0) {

                for (int i = 0; i < limit; i++) {
                    System.out.format("%s %40s %30s %35s %25s %15s", cou.getCountryList().get(i).getCode(), cou.getCountryList().get(i).getName(),
                            cou.getCountryList().get(i).getContinent(), cou.getCountryList().get(i).getRegion(), cou.getCountryList().get(i).getPopulation(),
                            cou.getCountryList().get(i).getCapital());
                    System.out.println();
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");

            }
        }
        //If there is no data to display, print error message
        else {
            System.out.println("No results to display.");
        }
    }

    public void countriesInContinentReport(String continentName) {

        Country cou = new Country();
        //Check that there is data to display
        if (cou.getCountries("continent", continentName) != null) {
            //If there is data to display, display data in table format
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %40s %30s %35s %25s %15s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < cou.getCountries("continent", continentName).size(); i++) {
                System.out.format("%s %40s %30s %35s %25s %15s", cou.getCountryList().get(i).getCode(), cou.getCountryList().get(i).getName(),
                        cou.getCountryList().get(i).getContinent(), cou.getCountryList().get(i).getRegion(), cou.getCountryList().get(i).getPopulation(),
                        cou.getCountryList().get(i).getCapital());
                System.out.println();
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        //If there is no data to display, print error message
        else {
            System.out.println("No results to display.");
        }
    }


    public void countriesInRegionReport(String regionName, int limit) {

        Country cou = new Country();
        //Check that there is data to display
        if (cou.getCountries("region", regionName) != null) {
            //If there is data to display, display data in table format
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %40s %30s %35s %25s %15s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");

            //if no limit is entered for report
            if (limit == 0) {

                for (int i = 0; i < cou.getCountries("region", regionName).size(); i++) {
                    System.out.format("%s %40s %30s %35s %25s %15s", cou.getCountryList().get(i).getCode(), cou.getCountryList().get(i).getName(),
                            cou.getCountryList().get(i).getContinent(), cou.getCountryList().get(i).getRegion(), cou.getCountryList().get(i).getPopulation(),
                            cou.getCountryList().get(i).getCapital());
                    System.out.println();
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
            // if a limit has been entered for report output
            else if (limit>0) {

                for (int i = 0; i < limit; i++) {
                    System.out.format("%s %40s %30s %35s %25s %15s", cou.getCountryList().get(i).getCode(), cou.getCountryList().get(i).getName(),
                            cou.getCountryList().get(i).getContinent(), cou.getCountryList().get(i).getRegion(), cou.getCountryList().get(i).getPopulation(),
                            cou.getCountryList().get(i).getCapital());
                    System.out.println();
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
           }
        }
        //If there is no data to display, print error message
        else {
            System.out.println("No results to display.");
        }
    }

        public void citiesInWorldReport(int limit) {

            City ci = new City();
            //Check that there is data to display
            if (ci.getCities("world",null) != null) {
                //If there is data to display, display data in table format
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%s %40s %30s %30s", "Name", "Country Code", "District", "Population");
                System.out.println();
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");

                if(limit==0) {
                    for (int i = 0; i < ci.getCities("world", null).size(); i++) {
                        System.out.format("%s %40s %30s %30s", ci.getCityList().get(i).getName(),
                                ci.getCityList().get(i).getCountry(), ci.getCityList().get(i).getDistrict(),
                                ci.getCityList().get(i).getPopulation());
                        System.out.println();
                    }
                } else if(limit>0){

                    for (int i = 0; i < limit; i++) {
                        System.out.format("%s %40s %30s %30s", ci.getCityList().get(i).getName(),
                                ci.getCityList().get(i).getCountry(), ci.getCityList().get(i).getDistrict(),
                                ci.getCityList().get(i).getPopulation());
                        System.out.println();
                    }
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
            //If there is no data to display, print error message
            else {
                System.out.println("No results to display.");
            }

        }

    public void citiesInContinentReport(String continentName) {

        City ci = new City();
        //Check that there is data to display
        if (ci.getCities("continent",continentName) != null) {
            //If there is data to display, display data in table format
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %40s %30s %30s", "Name", "Country Code", "District", "Population");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (int i = 0; i < ci.getCities("continent", continentName).size(); i++) {
                    System.out.format("%s %40s %30s %30s", ci.getCityList().get(i).getName(),
                            ci.getCityList().get(i).getCountry(), ci.getCityList().get(i).getDistrict(),
                            ci.getCityList().get(i).getPopulation());
                    System.out.println();
                }
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        //If there is no data to display, print error message
        else {
            System.out.println("No results to display.");
        }

    }


    public void citiesInRegionReport(String regionName ,int limit) {

        City ci = new City();
        //Check that there is data to display
        if (ci.getCities("region",regionName) != null) {
            //If there is data to display, display data in table format
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %40s %30s %30s", "Name", "Country Code", "District", "Population");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");

            if(limit==0) {
                for (int i = 0; i < ci.getCities("region", regionName).size(); i++) {
                    System.out.format("%s %40s %30s %30s", ci.getCityList().get(i).getName(),
                            ci.getCityList().get(i).getCountry(), ci.getCityList().get(i).getDistrict(),
                            ci.getCityList().get(i).getPopulation());
                    System.out.println();
                }
            } else if(limit>0){

                for (int i = 0; i < limit; i++) {
                    System.out.format("%s %40s %30s %30s", ci.getCityList().get(i).getName(),
                            ci.getCityList().get(i).getCountry(), ci.getCityList().get(i).getDistrict(),
                            ci.getCityList().get(i).getPopulation());
                    System.out.println();
                }
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        //If there is no data to display, print error message
        else {
            System.out.println("No results to display.");
        }

    }


    }



