package com.example.engineer.controller;

import com.example.engineer.dto.request.MachineModelRequest;
import com.example.engineer.dto.request.MachineTypeAddRequest;
import com.example.engineer.entity.MachineType;
import com.example.engineer.entity.Model;
import com.example.engineer.services.MachineModelService;
import com.example.engineer.services.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
@CrossOrigin(origins = "http://localhost:4403")
public class MachineModelController {
    @Autowired
    MachineModelService machineModelService;
    @GetMapping(path = "/get-all")
    public List<Model> GetAllMachineModels()
    {
        return machineModelService.GetAllMachineModel();
    }
    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    public Model AddNewMachineModels(@RequestBody MachineModelRequest machineModelRequest)
    {
        return machineModelService.AddNewMachineModel(machineModelRequest);
    }
}
