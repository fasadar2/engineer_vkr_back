package com.example.engineer.controller;

import com.example.engineer.dto.request.MachineTypeAddRequest;
import com.example.engineer.entity.MachineType;
import com.example.engineer.services.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin(origins = "http://localhost:4403")
public class MachineTypeController {
    @Autowired
    MachineTypeService machineTypeService;

    @GetMapping(path = "/get-all")
    public List<MachineType> GetAllMachineTypes()
    {
        return machineTypeService.GetAllMachineType();
    }
    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    public MachineType AddNewMachineTypes(@RequestBody MachineTypeAddRequest machineTypeAddRequest)
    {
        return machineTypeService.AddNewMachineType(machineTypeAddRequest);
    }

}
