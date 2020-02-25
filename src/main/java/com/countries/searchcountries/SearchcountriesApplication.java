package com.countries.searchcountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchcountriesApplication
{
    static CountryList myCountryList;
    public static void main(String[] args)
    {
        myCountryList = new CountryList();
        SpringApplication.run(SearchcountriesApplication.class, args);
    }

}
