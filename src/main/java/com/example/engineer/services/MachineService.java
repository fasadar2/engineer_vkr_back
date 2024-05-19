package com.example.engineer.services;

import com.example.engineer.dto.request.MachineRequest;
import com.example.engineer.entity.Machine;
import com.example.engineer.methods.DateConvertor;
import com.example.engineer.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MachineService {
    private final MachineRepository machineRepository;
    private final FunctionalTypeRepository functionalTypeRepository;
    private final MachineModelRepository machineModelRepository;
    private final MachineTypeRepository machineTypeRepos;
    private final OrganisationRepository organisationRepository;
    private final StatusRepository statusRepository;

    @Autowired
    StatusService statusService;
    public Page<Machine> GetAllMachine(int page, int size)
    {

        return machineRepository.findAllByWrritenOfFalse(PageRequest.of(page, size));
    }
    public long GetPageCounter()
    {

        return machineRepository.countAllByWrritenOf(false);
    }
    public Machine AddNewMachine(MachineRequest machineRequest)
    {
        Machine machine = new Machine();
        machine.setWrritenOf(false);
        machine.setMachineTypeByTypeId(machineTypeRepos.getMachineTypeById(machineRequest.getMachineType_id()));
        machine.setCorruption("0");
        machine.setOrganizationByOrganizationId(organisationRepository.getOrganizationById(machineRequest.getOrganization_id()));
        machine.setInventoryNumber(machineRequest.getInventoryNumber());
        machine.setSerialNumber(machineRequest.getSerialNumber());
        machine.setFunctionalTypeByFunctionalId(functionalTypeRepository.getFunctionalTypeById(machineRequest.getFunctionalType_id()));
        machine.setModelByModelId(machineModelRepository.getModelById(machineRequest.getModel_id()));
        machine.setDateOfRecive(LocalDate.now());
        machine.setStatusByStatusId(statusRepository.getStatusById(1));
        machine.setDateOfRelase(DateConvertor.ConvertDate(machineRequest.getDateOfRelease()));

        machineRepository.save(machine);
        return machine;
    }

    public Machine WrittenOfMachine(int machine_id) {
        statusService.SetStatusByIdOnMachineByMachineId(machine_id,2);
        Machine machine = machineRepository.findMachineById(machine_id);
        machine.setWrritenOf(true);
        machineRepository.save(machine);
        return machine;
    }
}
