package com.testProject.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    private Long idOrganization;

    @Column(name = "nameOrg")
    private String nameOrg;

    @Column(name = "fizAdressOrg")
    private String fizAdressOrg;

    @Column(name = "urAdressOrg")
    private String urAdressOrg;

    @OneToOne(cascade = CascadeType.ALL)
    private Long supervisorOrg;
}
