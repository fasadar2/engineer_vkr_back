package com.example.engineer.controller;

import com.example.engineer.dto.request.MachineFunctionalTypeAddRequest;
import com.example.engineer.dto.request.MachineTypeAddRequest;
import com.example.engineer.entity.FunctionalType;
import com.example.engineer.entity.MachineType;
import com.example.engineer.services.MachineFunctionalTypeService;
import com.example.engineer.services.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/functional-type")
@CrossOrigin(origins = "http://localhost:4403")
public class MachineFunctionaltypeController {
    @Autowired
    MachineFunctionalTypeService machineFunctionalTypeService;
    @GetMapping(path = "/get-all")
    public List<FunctionalType> GetAllMachineTypes()
    {
        return machineFunctionalTypeService.GetAllMachineFunctionalType();
    }
    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    public FunctionalType AddNewMachineFunctionalTypes(@RequestBody MachineFunctionalTypeAddRequest machineFunctionalTypeAddRequest)
    {
        return machineFunctionalTypeService.AddNewMMachineFunctionalType(machineFunctionalTypeAddRequest);
    }
}
