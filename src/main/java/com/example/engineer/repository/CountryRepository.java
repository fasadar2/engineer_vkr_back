package com.example.engineer.repository;

import com.example.engineer.entity.Country;
import com.example.engineer.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country> {
Country getCountryById(int id);
}
