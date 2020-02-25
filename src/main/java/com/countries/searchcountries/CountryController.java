package com.countries.searchcountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //    localhost:2019/names/size/{number}
    //    localhost:2019/population/size/{people}
    //    localhost:2019/population/min
    //    localhost:2019/population/max
}
