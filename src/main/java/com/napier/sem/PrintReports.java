package com.napier.sem;

public class PrintReports {


    public void countriesInWorldReport() {

        Country cou = new Country();
        //Check that there is data to display
        if (cou.getCountries("world") != null) {
            //If there is data to display, display data in table format
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %40s %30s %35s %25s %15s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < cou.getCountries("world").size(); i++) {
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

        public void citiesInWorldReport() {

            City ci = new City();
            //Check that there is data to display
            if (ci.getCities("world") != null) {
                //If there is data to display, display data in table format
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%s %40s %30s %30s", "Name", "Country Code", "District", "Population");
                System.out.println();
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
                for (int i = 0; i < ci.getCities("world").size(); i++) {
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

    }

