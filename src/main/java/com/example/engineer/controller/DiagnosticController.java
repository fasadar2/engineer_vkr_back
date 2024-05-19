package com.example.engineer.controller;

import com.example.engineer.dto.request.DiagnosticRequestDto;
import com.example.engineer.dto.request.MachineRequest;
import com.example.engineer.entity.Diagnostic;
import com.example.engineer.entity.Machine;
import com.example.engineer.services.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diagnostic")
@CrossOrigin(origins = "http://localhost:4403")
public class DiagnosticController {
    @Autowired
    DiagnosticService diagnosticService;
    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    public Diagnostic AddNewMachine(@RequestBody DiagnosticRequestDto diagnosticRequestDto)
    {
        return diagnosticService.AddNewDiagnostic(diagnosticRequestDto);
    }
}
