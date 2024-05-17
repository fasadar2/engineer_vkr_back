package com.example.engineer.repository;

import com.example.engineer.entity.FunctionalType;
import com.example.engineer.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MachineModelRepository extends JpaRepository<Model, Integer>, JpaSpecificationExecutor<Model> {
    Model getModelById(int id);
}