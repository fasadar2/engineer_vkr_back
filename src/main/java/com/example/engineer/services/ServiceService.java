package com.example.engineer.services;

import com.example.engineer.dto.request.ServiceRequestDTO;
import com.example.engineer.entity.Diagnostic;
import com.example.engineer.entity.Machine;
import com.example.engineer.entity.Repair;
import com.example.engineer.methods.DateConvertor;
import com.example.engineer.repository.DiagnosticRepository;
import com.example.engineer.repository.ErrorRepository;
import com.example.engineer.repository.ServiceRepository;
import com.example.engineer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.Provider;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ServiceService {
        @Autowired
        ServiceRepository serviceRepository;
        @Autowired
        DiagnosticService diagnosticService;
        @Autowired
        DiagnosticRepository diagnosticRepository;
        @Autowired
        UserRepository userRepository;
        @Autowired
        ResultService resultService;
        @Autowired
        ErrorService errorService;
    public Repair AddNewService(ServiceRequestDTO serviceRequestDTO) {
        Repair repair = new Repair();
        repair.setDateStart(LocalDate.now());
        repair.setPrice(BigInteger.valueOf(100));
        repair.setDateEnd(DateConvertor.ConvertDate(serviceRequestDTO.getDate_end()));
        repair.setMachineByMachineId(diagnosticService.GetDiagnositcByDiagnosticID(serviceRequestDTO.getDiagnostic_id()).getMachineByMachineId());
        repair.setUserByUserId(userRepository.getUserById(serviceRequestDTO.getUser_id()));
        repair.setErrorByErrorId(errorService.CreateNewError(serviceRequestDTO.getResult_text()));
        serviceRepository.save(repair);
        Diagnostic diagnostic = diagnosticService.GetDiagnositcByDiagnosticID(serviceRequestDTO.getDiagnostic_id());
        diagnostic.setDiagnosticOut(true);
        diagnostic.setResultByResultId(resultService.CreateNewResult(serviceRequestDTO.getResult_text(),"Результат диагностики"));
        diagnosticRepository.save(diagnostic);
        return repair;
    }
    public Page<Repair> GetAllService(int page, int size)
    {

        return serviceRepository.findAllByRepairOutFalse(PageRequest.of(page, size));
    }
    public long GetPageCounter()
    {

        return serviceRepository.countAllByRepairOutFalse();
    }
}
