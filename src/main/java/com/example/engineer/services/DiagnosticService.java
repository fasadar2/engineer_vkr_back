package com.example.engineer.services;

import com.example.engineer.dto.request.DiagnosticRequestDto;
import com.example.engineer.dto.request.ReturnWithoutProblemRequestDTO;
import com.example.engineer.entity.Diagnostic;
import com.example.engineer.entity.Machine;
import com.example.engineer.methods.DateConvertor;
import com.example.engineer.repository.DiagnosticRepository;
import com.example.engineer.repository.MachineRepository;
import com.example.engineer.repository.StatusRepository;
import com.example.engineer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DiagnosticService {
    private final DiagnosticRepository diagnosticRepository;
    private final UserRepository userRepository;
    private final MachineRepository machineRepository;

    @Autowired
    StatusService statusService;
    @Autowired
    ResultService resultService;
    public Diagnostic AddNewDiagnostic(DiagnosticRequestDto diagnosticRequestDto)
    {

        statusService.SetStatusByIdOnMachineByMachineId(diagnosticRequestDto.getMachine_id(),3);
        Diagnostic diagnostic = new Diagnostic();
        diagnostic.setUserByUserId(userRepository.getUserById(diagnosticRequestDto.getUser_id()));
        diagnostic.setMachineByMachineId(machineRepository.findMachineById(diagnosticRequestDto.getMachine_id()));
        diagnostic.setDateStart(LocalDate.now());
        diagnostic.setDateEnd(DateConvertor.ConvertDate(diagnosticRequestDto.getDate_end()));
        diagnostic.setDiagnosticOut(false);
        diagnosticRepository.save(diagnostic);
        return diagnostic;
    }
    public Diagnostic GetDiagnositcByDiagnosticID(int diagnostic_id)
    {
        return diagnosticRepository.findDiagnosticById(diagnostic_id);
    }
    public long GetPageCounter() {
        return diagnosticRepository.countAllByDiagnosticOutFalse();
    }

    public Page<Diagnostic> GetAllDiagnostic(int page, int size) {
        return diagnosticRepository.findAllByDiagnosticOutFalse(PageRequest.of(page, size));
    }

    public Diagnostic ReturnWithOutProblems(ReturnWithoutProblemRequestDTO returnWithoutProblemRequestDTO) {
        Diagnostic diagnostic = diagnosticRepository.findDiagnosticById(returnWithoutProblemRequestDTO.getDiagnostic_id());
        diagnostic.setDiagnosticOut(true);
        statusService.SetStatusByIdOnMachineByMachineId(diagnostic.getMachineByMachineId().getId(),4);
        diagnostic.setResultByResultId(resultService.CreateNewResult(returnWithoutProblemRequestDTO.getResult_text(),"Прблем не выявлено"));
        diagnosticRepository.save(diagnostic);
        return diagnostic;
    }
}
