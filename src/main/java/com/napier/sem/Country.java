package com.napier.sem;

public class Country {


    private String code;
    private String name;
    private String continent;
    private String region;
    private int population;
    private String capital;


    //Default constructor
    public Country() {
    }


    //Accessor methods for properties
    public String getCode() {
        return code;
    }
    public void setCode(String code) throws InputValidationException {
        if (code.matches("\\b[A-Z]{3}\\b")) {
            this.code = code;
        } else throw new InputValidationException();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) throws InputValidationException {
        if (name.matches("^(?=.{2,35}$)[a-zA-Z]+(?:[-'\\s][a-zA-Z]+)*$")) {
            this.name = name;
        } else throw new InputValidationException();
    }

    public String getContinent() {
        return continent;
    }
    public void setContinent(String continent) throws InputValidationException {
        if (continent.matches("^(?=.{2,20}$)[a-zA-Z]+(?:[-'\\s][a-zA-Z]+)*$")) {
            this.continent = continent;
        } else throw new InputValidationException();
    }

    public String getRegion() {
        return region;
    }
    public void setRegion(String region) throws InputValidationException {
        if (region.matches("^(?=.{2,30}$)[a-zA-Z]+(?:[-'\\s][a-zA-Z]+)*$")) {
            this.region = region;
        } else throw new InputValidationException();
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


}
