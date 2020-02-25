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
    public ResponseEntity<?> getCountryByFirstLetter(@PathVariable char letter)
    {
        ArrayList<Country> rtnCountry = SearchcountriesApplication.myCountryList
                .findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
    //    localhost:2019/names/size/{number}
    //    localhost:2019/population/size/{people}
    //    localhost:2019/population/min
    //    localhost:2019/population/max
}
