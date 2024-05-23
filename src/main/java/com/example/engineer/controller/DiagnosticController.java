package com.example.engineer.controller;

import com.example.engineer.dto.request.DiagnosticRequestDto;
import com.example.engineer.dto.request.MachineRequest;
import com.example.engineer.dto.request.ReturnWithoutProblemRequestDTO;
import com.example.engineer.entity.Diagnostic;
import com.example.engineer.entity.Machine;
import com.example.engineer.repository.ServiceRepository;
import com.example.engineer.services.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diagnostic")
@CrossOrigin(origins = "http://localhost:4403")
public class DiagnosticController {
    @Autowired
    DiagnosticService diagnosticService;

    @GetMapping(path = "/get-page")
    public Page<Diagnostic> GetAllDiagnostic(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size)
    {
        return diagnosticService.GetAllDiagnostic(page,size);
    }
    @GetMapping(path = "/get-page-counter")
    public long GetPageCounter()
    {
        return diagnosticService.GetPageCounter();
    }
    @PostMapping(path = "/add-new", produces = MediaType.APPLICATION_JSON_VALUE)
    public Diagnostic AddNewMachineToDiagnostic(@RequestBody DiagnosticRequestDto diagnosticRequestDto)
    {
        return diagnosticService.AddNewDiagnostic(diagnosticRequestDto);
    }
    @PostMapping(path = "/return-without-problems", produces = MediaType.APPLICATION_JSON_VALUE)
    public Diagnostic AddNewMachineToDiagnostic(@RequestBody ReturnWithoutProblemRequestDTO returnWithoutProblemRequestDTO)
    {
        return diagnosticService.ReturnWithOutProblems(returnWithoutProblemRequestDTO);
    }
}
