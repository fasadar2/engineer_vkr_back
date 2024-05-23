package com.example.engineer.repository;

import com.example.engineer.entity.Repair;
import com.example.engineer.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResultRepository extends JpaRepository<Result, Integer>, JpaSpecificationExecutor<Result> {
}
