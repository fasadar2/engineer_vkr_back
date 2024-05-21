package com.example.engineer.services;

import com.example.engineer.dto.request.ServiceRequestDTO;
import com.example.engineer.entity.Diagnostic;
import com.example.engineer.entity.Repair;
import com.example.engineer.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.security.Provider;

@Service
@RequiredArgsConstructor
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;
    public Repair AddNewService(ServiceRequestDTO serviceRequestDTO) {

    }

    public long GetPageCounter() {
        return serviceRepository.countAll();
    }

    public Page<Repair> GetAllRepair(int page, int size) {
        return serviceRepository.findAll(PageRequest.of(page, size));
    }
}
