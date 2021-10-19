package com.testProject.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Long Id;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "patronymicName")
    private String patronymicName;

    @Column(name = "job")
    private String job;
}
