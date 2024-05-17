package com.example.engineer.repository;

import com.example.engineer.entity.MachineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MachineTypeRepository extends JpaRepository<MachineType, Integer>, JpaSpecificationExecutor<MachineType> {
    MachineType getMachineTypeById(int id);

}