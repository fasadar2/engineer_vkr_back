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
public class Organization {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "name_general", nullable = false, length = 765)
    private String nameGeneral;
    @Basic
    @Column(name = "phone_general", nullable = false, length = 20)
    private String phoneGeneral;
    @Basic
    @Column(name = "name_subgeneral", nullable = false, length = 765)
    private String nameSubgeneral;
    @Basic
    @Column(name = "phone_subgeneral", nullable = false, length = 20)
    private String phoneSubgeneral;
    @Basic
    @Column(name = "email_general", nullable = false, length = 256)
    private String emailGeneral;
    @Basic
    @Column(name = "email_subgeneral", nullable = false, length = 256)
    private String emailSubgeneral;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private TypeOrganization typeOrganizationByTypeId;
}
