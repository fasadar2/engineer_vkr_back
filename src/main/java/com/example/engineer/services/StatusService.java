package com.example.engineer.services;

import com.example.engineer.entity.Machine;
import com.example.engineer.repository.MachineRepository;
import com.example.engineer.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepository statusRepository;
    private final MachineRepository machineRepository;
    public void SetStatusByIdOnMachineByMachineId(int machine_id,int status_id)
    {
        Machine machine = machineRepository.findMachineById(machine_id);
        machine.setStatusByStatusId(statusRepository.getStatusById(status_id));
        machineRepository.save(machine);

    }
}
