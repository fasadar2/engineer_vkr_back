package com.example.engineer.repository;

import com.example.engineer.entity.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StatusRepository extends JpaRepository<Status, Integer>, JpaSpecificationExecutor<Status> {
    Status getStatusById(int id);
}
