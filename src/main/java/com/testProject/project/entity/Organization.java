package com.testProject.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @SequenceGenerator(name = "organization_sequence", sequenceName = "organization_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_sequence")
    private Long id;

    @Column(name = "nameOrg")
    private String nameOrg;

    @Column(name = "fizAdressOrg")
    private String fizAdressOrg;

    @Column(name = "urAdressOrg")
    private String urAdressOrg;

    @OneToOne(cascade = CascadeType.ALL)
    private Long supervisorOrg;
}
