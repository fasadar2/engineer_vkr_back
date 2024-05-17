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
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;
    @Basic
    @Column(name = "second_name", nullable = false, length = 255)
    private String secondName;
    @Basic
    @Column(name = "third_name", nullable = false, length = 255)
    private String thirdName;
    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    @Basic
    @Column(name = "last_entry", nullable = false)
    private Date lastEntry;
    @Basic
    @Column(name = "login", nullable = false, length = 120)
    private String login;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role roleByRoleId;
    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organizationByOrganizationId;
    @ManyToOne
    @JoinColumn(name = "qualification_id", referencedColumnName = "id")
    private Qualification qualificationByQualificationId;

}
