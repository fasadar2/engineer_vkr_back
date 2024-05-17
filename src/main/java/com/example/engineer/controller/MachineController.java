package com.example.engineer.controller;

import com.example.engineer.dto.request.CountryRequest;
import com.example.engineer.dto.request.MachineRequest;
import com.example.engineer.entity.Country;
import com.example.engineer.entity.Machine;
import com.example.engineer.services.CountryService;
import com.example.engineer.services.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/machine")
@CrossOrigin(origins = "http://localhost:4403")
public class MachineController {
    @Autowired
    MachineService machineService;
    @GetMapping(path = "/get-page")
    public Page<Machine> GetAllMachines(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size)
    {
        return machineService.GetAllMachine(page,size);
    }
    @GetMapping(path = "/get-page-counter")
    public long GetPageCounter(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size)
    {
        return machineService.GetPageCounter();
    }
    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    public Machine AddNewMachine(@RequestBody MachineRequest machineRequest)
    {
        return machineService.AddNewMachine(machineRequest);
    }
}
