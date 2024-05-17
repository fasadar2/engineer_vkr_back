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
public class Repair {
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
    @Column(name = "price", nullable = false, precision = 0)
    private BigInteger price;
    @ManyToOne
    @JoinColumn(name = "machine_id", referencedColumnName = "id", nullable = false)
    private Machine machineByMachineId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userByUserId;
    @ManyToOne
    @JoinColumn(name = "dispatcher_request_id", referencedColumnName = "id")
    private DispatcherRequest dispatcherRequestByDispatcherRequestId;
    @ManyToOne
    @JoinColumn(name = "error_id", referencedColumnName = "id", nullable = false)
    private Error errorByErrorId;
    @ManyToOne
    @JoinColumn(name = "result_id", referencedColumnName = "id", nullable = false)
    private Result resultByResultId;
}
