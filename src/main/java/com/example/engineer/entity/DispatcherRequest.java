package com.example.engineer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "dispatcher_request", schema = "public", catalog = "medicalservice_db")
public class DispatcherRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "date_open", nullable = false)
    private Date dateOpen;
    @Basic
    @Column(name = "date_close", nullable = false)
    private Date dateClose;
    @Basic
    @Column(name = "comment", nullable = false, length = -1)
    private String comment;
    @Basic
    @Column(name = "dispatcher_confirmed", nullable = false)
    private boolean dispatcherConfirmed;
    @Basic
    @Column(name = "update_date", nullable = true)
    private Date updateDate;
    @ManyToOne
    @JoinColumn(name = "dispatcher_id", referencedColumnName = "id", nullable = false)
    private User userByDispatcherId;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User userByAuthorId;
    @ManyToOne
    @JoinColumn(name = "engineer_id", referencedColumnName = "id")
    private User userByEngineerId;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private RequsetStatus requsetStatusByStatusId;

}
