package com.example.engineer.services;

import com.example.engineer.dto.request.MachineTypeAddRequest;
import com.example.engineer.entity.MachineType;
import com.example.engineer.repository.MachineTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineTypeService {
    private final MachineTypeRepository machineTypeRepos;


    public List<MachineType> GetAllMachineType(){
        return machineTypeRepos.findAll();
    }
    public MachineType AddNewMachineType(MachineTypeAddRequest machineTypeAddRequest)
    {
        MachineType machineType = new MachineType();
        machineType.setType(machineTypeAddRequest.getMachineType());
        machineTypeRepos.save(machineType);
        return machineType;
    }
}
