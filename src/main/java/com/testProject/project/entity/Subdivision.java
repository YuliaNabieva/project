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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "subdivision")
public class Subdivision {
    @Id
    @SequenceGenerator(name = "subdivision_sequence", sequenceName = "subdivision_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subdivision_sequence")
    private Long id;

    @Column(name = "nameSubdivision")
    private String nameSubdivision;

    @Column(name = "contactsSubdivision")
    private String contactsSubdivision;

    @OneToOne(cascade = CascadeType.ALL)
    private Long supervisorSubdivisionsupervisorSubdivision;
}
