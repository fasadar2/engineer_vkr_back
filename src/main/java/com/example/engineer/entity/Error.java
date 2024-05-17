package com.example.engineer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Error {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "type_error", nullable = false, length = 200)
    private String typeError;
    @Basic
    @Column(name = "repair_method", nullable = false, length = -1)
    private String repairMethod;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @ManyToOne
    @JoinColumn(name = "machine_model_id", referencedColumnName = "id", nullable = false)
    private Model modelByMachineModelId;
    @ManyToOne
    @JoinColumn(name = "machine_type_id", referencedColumnName = "id", nullable = false)
    private MachineType machineTypeByMachineTypeId;

}
