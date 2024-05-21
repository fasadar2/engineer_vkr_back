package com.example.engineer.repository;

import com.example.engineer.entity.Diagnostic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DiagnosticRepository extends JpaRepository<Diagnostic, Integer>, JpaSpecificationExecutor<Diagnostic> {
    long countAllByDiagnosticOutFalse();
    Page<Diagnostic> findAllByDiagnosticOutFalse(Pageable pageable);
}
