package com.example.engineer.controller;

import com.example.engineer.dto.request.CountryRequest;
import com.example.engineer.dto.request.MachineFunctionalTypeAddRequest;
import com.example.engineer.entity.Country;
import com.example.engineer.entity.FunctionalType;
import com.example.engineer.services.CountryService;
import com.example.engineer.services.MachineFunctionalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@CrossOrigin(origins = "http://localhost:4403")
public class CountryController {
    @Autowired
    CountryService countryService;
    @GetMapping(path = "/get-all")
    public List<Country> GetAllCountries()
    {
        return countryService.GetAllCountries();
    }
    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    public Country AddNewMCountry(@RequestBody CountryRequest countryRequest)
    {
        return countryService.AddNewCountry(countryRequest);
    }
}
