package com.example.engineer.controller;

import com.example.engineer.dto.request.DiagnosticRequestDto;
import com.example.engineer.dto.request.ServiceRequestDTO;
import com.example.engineer.entity.Diagnostic;
import com.example.engineer.entity.Machine;
import com.example.engineer.entity.Repair;
import com.example.engineer.services.DiagnosticService;
import com.example.engineer.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "http://localhost:4403")
public class ServiceController {
    @Autowired
    ServiceService serviceService;
    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    public Repair AddNewRepair(@RequestBody ServiceRequestDTO serviceRequestDTO)
   {
       return serviceService.AddNewService(serviceRequestDTO);
    }
    @GetMapping(path = "/get-page-counter")
    public long GetPageCounter()
    {
        return serviceService.GetPageCounter();
    }
    @GetMapping(path = "/get-page")
    public Page<Repair> GetAllServices(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size)
    {
        return serviceService.GetAllService(page,size);
    }
}
