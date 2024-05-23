package com.example.engineer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Data
public class Machine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "inventory_number", nullable = false, length = 255)
    private String inventoryNumber;
    @Basic
    @Column(name = "serial_number", nullable = false, length = 255)
    private String serialNumber;
    @Basic
    @Column(name = "corruption", nullable = false, length = 3)
    private String corruption;
    @Basic
    @Column(name = "date_of_relase", nullable = false)
    private LocalDate dateOfRelase;
    @Basic
    @Column(name = "date_of_recive", nullable = false)
    private LocalDate dateOfRecive;
    @Basic
    @Column(name = "wrriten_of", nullable = false)
    private boolean wrritenOf;
    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false)
    private Organization organizationByOrganizationId;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private MachineType machineTypeByTypeId;
    @ManyToOne
    @JoinColumn(name = "functional_id", referencedColumnName = "id", nullable = false)
    private FunctionalType functionalTypeByFunctionalId;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private Status statusByStatusId;
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    private Model modelByModelId;

}
