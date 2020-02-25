package com.countries.searchcountries;

public class Country
{
    private String name;
    private long population;
    private long landSize;
    private long medianAge;

    public Country(String name, long population, long landSize, long medianAge)
    {
        this.name = name;
        this.population = population;
        this.landSize = landSize;
        this.medianAge = medianAge;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public long getLandSize()
    {
        return landSize;
    }

    public void setLandSize(long landSize)
    {
        this.landSize = landSize;
    }

    public long getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(long medianAge)
    {
        this.medianAge = medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" + "name='" + name + '\'' + ", population=" + population + ", landSize=" + landSize + ", medianAge=" + medianAge + '}';
    }
}
