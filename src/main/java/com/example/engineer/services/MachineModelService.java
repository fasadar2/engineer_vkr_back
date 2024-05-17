package com.example.engineer.services;

import com.example.engineer.controller.MachineTypeController;
import com.example.engineer.dto.request.MachineFunctionalTypeAddRequest;
import com.example.engineer.dto.request.MachineModelRequest;
import com.example.engineer.entity.FunctionalType;
import com.example.engineer.entity.Model;
import com.example.engineer.repository.FunctionalTypeRepository;
import com.example.engineer.repository.MachineManufacturerRepository;
import com.example.engineer.repository.MachineModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineModelService {
    private final MachineModelRepository machineModelRepository;
    private final MachineManufacturerRepository machineManufacturerRepository;
    public List<Model> GetAllMachineModel(){
        return machineModelRepository.findAll();
    }
    public Model AddNewMachineModel(MachineModelRequest machineModelRequest)
    {
        Model model = new Model();
        model.setName(machineModelRequest.getModelName());
        model.setManufacturerByManufacturerId(machineManufacturerRepository.getManufacturerById(machineModelRequest.getManufacturer_id()));
        machineModelRepository.save(model);
        return model;
    }
}