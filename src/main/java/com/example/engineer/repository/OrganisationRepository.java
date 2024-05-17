package com.example.engineer.repository;

import com.example.engineer.entity.Organization;
import com.example.engineer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrganisationRepository extends JpaRepository<Organization, Integer>, JpaSpecificationExecutor<Organization> {
    Organization getOrganizationById(int id);
}
