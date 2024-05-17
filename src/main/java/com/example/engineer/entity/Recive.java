package com.example.engineer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Recive {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "date_recive", nullable = false)
    private Date dateRecive;
    @ManyToOne
    @JoinColumn(name = "organization_repair_id", referencedColumnName = "id")
    private OrganizationRepair organizationRepairByOrganizationRepairId;
    @ManyToOne
    @JoinColumn(name = "repair_id", referencedColumnName = "id", nullable = false)
    private Repair repairByRepairId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userByUserId;

}
