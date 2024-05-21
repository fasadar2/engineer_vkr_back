package com.example.engineer.repository;

import com.example.engineer.entity.Diagnostic;
import com.example.engineer.entity.Machine;
import com.example.engineer.entity.Repair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServiceRepository extends JpaRepository<Repair, Integer>, JpaSpecificationExecutor<Repair> {
    long countAll();
    Page<Repair> findAll(Pageable pageable);
}
