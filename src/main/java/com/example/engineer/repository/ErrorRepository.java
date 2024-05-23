package com.example.engineer.repository;

import com.example.engineer.entity.Error;
import com.example.engineer.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ErrorRepository extends JpaRepository<Error, Integer>, JpaSpecificationExecutor<Error> {
}
