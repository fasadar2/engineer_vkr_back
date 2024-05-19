package com.example.engineer.repository;

import com.example.engineer.entity.FunctionalType;
import com.example.engineer.entity.Machine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MachineRepository extends JpaRepository<Machine, Integer>, JpaSpecificationExecutor<Machine> {
    Page<Machine> findAllByWrritenOfFalse(Pageable pageable);
    long countAllByWrritenOf(boolean written_of);
    Machine findMachineById(int id);

}
