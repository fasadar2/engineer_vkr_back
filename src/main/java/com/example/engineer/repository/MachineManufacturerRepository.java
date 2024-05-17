package com.example.engineer.repository;

import com.example.engineer.entity.Manufacturer;
import com.example.engineer.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MachineManufacturerRepository extends JpaRepository<Manufacturer, Integer>, JpaSpecificationExecutor<Manufacturer> {
Manufacturer getManufacturerById(int id);
}
