package com.example.engineer.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Timetable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "cabinet", nullable = false, length = 20)
    private String cabinet;
    @Basic
    @Column(name = "date_start", nullable = false)
    private Date dateStart;
    @Basic
    @Column(name = "date_end", nullable = false)
    private Date dateEnd;
    @Basic
    @Column(name = "time_start", nullable = false)
    private Time timeStart;
    @Basic
    @Column(name = "time_end", nullable = false)
    private Time timeEnd;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userByUserId;
    @ManyToOne
    @JoinColumn(name = "machine_id", referencedColumnName = "id", nullable = false)
    private Machine machineByMachineId;

}
