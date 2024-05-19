package com.example.engineer.repository;

import com.example.engineer.entity.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DiagnosticRepository extends JpaRepository<Diagnostic, Integer>, JpaSpecificationExecutor<Diagnostic> {
}
