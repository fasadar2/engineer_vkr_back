package com.example.engineer.controller;

import com.example.engineer.dto.request.MachineTypeAddRequest;
import com.example.engineer.dto.request.ManufacturerRequest;
import com.example.engineer.entity.MachineType;
import com.example.engineer.entity.Manufacturer;
import com.example.engineer.services.MachineTypeService;
import com.example.engineer.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturer")
@CrossOrigin(origins = "http://localhost:4403")
public class ManufacturerController {
    @Autowired
    ManufacturerService manufacturerService;
    @GetMapping(path = "/get-all")
    public List<Manufacturer> GetAllManufacturers()
    {
        return manufacturerService.GetAllManufacturer();
    }
    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    public Manufacturer AddNewManufacturer(@RequestBody ManufacturerRequest manufacturerRequest)
    {
        return manufacturerService.AddNewManufacturer(manufacturerRequest);
    }
}
