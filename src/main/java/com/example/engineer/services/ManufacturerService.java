package com.example.engineer.services;

import com.example.engineer.dto.request.MachineModelRequest;
import com.example.engineer.dto.request.ManufacturerRequest;
import com.example.engineer.entity.Country;
import com.example.engineer.entity.Manufacturer;
import com.example.engineer.entity.Model;
import com.example.engineer.repository.CountryRepository;
import com.example.engineer.repository.MachineManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerService {
    private final MachineManufacturerRepository machineManufacturerRepository;
    private final CountryRepository countryRepository;
    public List<Manufacturer> GetAllManufacturer(){
        return machineManufacturerRepository.findAll();
    }
    public Manufacturer AddNewManufacturer(ManufacturerRequest manufacturerRequest)
    {
        Manufacturer manufacturer  = new Manufacturer();
        manufacturer.setName(manufacturerRequest.getName());
        manufacturer.setCountryByCountryId(countryRepository.getCountryById(manufacturerRequest.getCountry_id()));
        machineManufacturerRepository.save(manufacturer);
        return manufacturer;
    }
}
