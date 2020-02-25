package com.countries.searchcountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class CountryController
{
    //    localhost:2019/names/all
    @GetMapping(value = "/names/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        return new ResponseEntity<>(SearchcountriesApplication.myCountryList.countryList, HttpStatus.OK);
    }

    //    localhost:2019/names/start/{letter}
    @GetMapping(value = "/names/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByFirstLetter(
            @PathVariable
                    char letter)
    {
        ArrayList<Country> rtnCountry = SearchcountriesApplication.myCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    //    localhost:2019/names/size/{number}
    @GetMapping(value = "names/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountrySize(
            @PathVariable
                    int number)
    {
        ArrayList<Country> rtnCountrySize = SearchcountriesApplication.myCountryList.findCountries(c -> c.getName().length() >= number);
        rtnCountrySize.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountrySize, HttpStatus.OK);
    }

    //    localhost:2019/population/size/{people}
    @GetMapping(value = "/population/size/{people}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulation(
            @PathVariable
                    long people)
    {
        ArrayList<Country> rtnCountriesByPopulation = SearchcountriesApplication.myCountryList.findCountries(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(rtnCountriesByPopulation, HttpStatus.OK);
    }
    //    localhost:2019/population/min

    @GetMapping(value = "/population/min",
                produces = {"application/json"})
    public ResponseEntity<?> getLowestPopulation()
    {
        SearchcountriesApplication.myCountryList.countryList.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(SearchcountriesApplication.myCountryList.countryList.get(0), HttpStatus.OK);
    }

    //    localhost:2019/population/max
    @GetMapping(value = "/population/max",
                produces = {"application/json"})
    public ResponseEntity<?> getMostPopulation()
    {
        SearchcountriesApplication.myCountryList.countryList.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(SearchcountriesApplication.myCountryList.countryList.get(0), HttpStatus.OK);
    }

    // localhost:2019/population/median
    @GetMapping(value = "/population/median",
                produces = {"application/json"})
    public ResponseEntity<?> getPopulationMedian()
    {
        ArrayList<Country> tempCountry = SearchcountriesApplication.myCountryList.countryList;
        tempCountry.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        if(tempCountry.size()% 2 == 1)
        {
            return new ResponseEntity<>(tempCountry.get((tempCountry.size()/2)+1), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(tempCountry.get(tempCountry.size()/2), HttpStatus.OK);
        }
    }

//    localhost:2019/age/age/{age}
    @GetMapping(value = "/age/age/{age}",
                produces = {"application/json"})
    public ResponseEntity<?> getAgeByInput(@PathVariable int age)
    {
        ArrayList<Country> rtnCountries = SearchcountriesApplication.myCountryList
                .findCountries(c -> c.getMedianAge() >= age);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    //    localhost:2019/age/min

    @GetMapping(value = "/age/min",
                produces = {"application/json"})
    public ResponseEntity<?> getLowestMedianAge()
    {
        SearchcountriesApplication.myCountryList.countryList.sort((c1, c2) -> (int) (c1.getMedianAge() - c2.getMedianAge()));
        return new ResponseEntity<>(SearchcountriesApplication.myCountryList.countryList.get(0), HttpStatus.OK);
    }

    //    localhost:2019/age/max
    @GetMapping(value = "/age/max",
                produces = {"application/json"})
    public ResponseEntity<?> getMostMedianAge()
    {
        SearchcountriesApplication.myCountryList.countryList.sort((c1, c2) -> (int) (c2.getMedianAge() - c1.getMedianAge()));
        return new ResponseEntity<>(SearchcountriesApplication.myCountryList.countryList.get(0), HttpStatus.OK);
    }



}
