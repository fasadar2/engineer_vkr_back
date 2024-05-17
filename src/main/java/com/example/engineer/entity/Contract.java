package com.example.engineer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Contract {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "date_start", nullable = false)
    private Date dateStart;
    @Basic
    @Column(name = "date_end", nullable = false)
    private Date dateEnd;
    @Basic
    @Column(name = "fio_customer", nullable = false, length = 780)
    private String fioCustomer;
    @Basic
    @Column(name = "sum_repair_fond", nullable = false, precision = 0)
    private BigInteger sumRepairFond;
    @Basic
    @Column(name = "numver_cintract", nullable = false, length = 200)
    private String numverCintract;
    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false)
    private Organization organizationByOrganizationId;



}
