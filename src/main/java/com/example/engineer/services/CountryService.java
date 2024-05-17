package com.example.engineer.services;

import com.example.engineer.dto.request.CountryRequest;
import com.example.engineer.dto.request.ManufacturerRequest;
import com.example.engineer.entity.Country;
import com.example.engineer.entity.Manufacturer;
import com.example.engineer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    public List<Country> GetAllCountries(){
        return countryRepository.findAll();
    }
    public Country AddNewCountry(CountryRequest countryRequest)
    {
        Country country = new Country();
        country.setName(countryRequest.getName());
        countryRepository.save(country);
        return country;
    }
}
