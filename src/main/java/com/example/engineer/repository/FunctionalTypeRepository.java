package com.example.engineer.repository;

import com.example.engineer.entity.FunctionalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FunctionalTypeRepository extends JpaRepository<FunctionalType, Integer>, JpaSpecificationExecutor<FunctionalType> {
    FunctionalType getFunctionalTypeById(int id);
}