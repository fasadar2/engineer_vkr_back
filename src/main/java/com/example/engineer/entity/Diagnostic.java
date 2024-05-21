package com.example.engineer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Diagnostic {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;
    @Basic
    @Column(name = "date_end", nullable = false)
    private LocalDate dateEnd;
    @ManyToOne
    @JoinColumn(name = "machine_id", referencedColumnName = "id", nullable = false)
    private Machine machineByMachineId;
    @ManyToOne
    @JoinColumn(name = "result_id", referencedColumnName = "id")
    private Result resultByResultId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userByUserId;
    @Basic
    @Column(name = "diagnostic_out", nullable = false)
    private boolean diagnosticOut;

}
