package com.example.engineer.services;

import com.example.engineer.dto.request.MachineFunctionalTypeAddRequest;
import com.example.engineer.dto.request.MachineTypeAddRequest;
import com.example.engineer.entity.FunctionalType;
import com.example.engineer.entity.MachineType;
import com.example.engineer.repository.FunctionalTypeRepository;
import com.example.engineer.repository.MachineTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineFunctionalTypeService {
    private final FunctionalTypeRepository functionalTypeRepository;
    public List<FunctionalType> GetAllMachineFunctionalType(){
        return functionalTypeRepository.findAll();
    }
    public FunctionalType AddNewMMachineFunctionalType(MachineFunctionalTypeAddRequest machineFunctionalTypeAddRequest)
    {
        FunctionalType functionalType = new FunctionalType();
        functionalType.setFunctional(machineFunctionalTypeAddRequest.getFunctionalType());
        functionalTypeRepository.save(functionalType);
        return functionalType;
    }
}
