package com.example.engineer.services;

import com.example.engineer.dto.request.DiagnosticRequestDto;
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

    public long GetPageCounter() {
        return diagnosticRepository.countAllByDiagnosticOutFalse();
    }

    public Page<Diagnostic> GetAllDiagnostic(int page, int size) {
        return diagnosticRepository.findAllByDiagnosticOutFalse(PageRequest.of(page, size));
    }
}
