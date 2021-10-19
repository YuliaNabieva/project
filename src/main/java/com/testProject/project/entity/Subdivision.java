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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "subdivision")
public class Subdivision {
    @Id
    private Long idSubdivision;

    @Column(name = "nameSubdivision")
    private String nameSubdivision;

    @Column(name = "contactsSubdivision")
    private String contactsSubdivision;

    @OneToOne(cascade = CascadeType.ALL)
    private Long supervisorSubdivision;
}
