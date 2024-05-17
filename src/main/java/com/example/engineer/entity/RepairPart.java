package com.example.engineer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "repair_part", schema = "public", catalog = "medicalservice_db")
public class RepairPart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "part_id", referencedColumnName = "id", nullable = false)
    private Part partByPartId;
    @ManyToOne
    @JoinColumn(name = "repair_id", referencedColumnName = "id", nullable = false)
    private Repair repairByRepairId;

}
