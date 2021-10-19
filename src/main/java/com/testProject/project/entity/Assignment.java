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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignment")
public class Assignment {


    @Id
    @SequenceGenerator(name = "assignment_sequence", sequenceName = "assignment_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assignment_sequence")
    private Long id;


    @Column(name = "subject")
    private String subject;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "controlSign")
    private String controlSign;

    @Column(name = "executionSign")
    private String executionSign;

    @Column(name = "textOfAssigment")
    private String textOfAssigment;

    @OneToOne(cascade = CascadeType.ALL)
    private Long authorOfAssigment;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employeeAssinment",
            joinColumns = @JoinColumn(name = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "assignmentId")
    )
    private Long performersOfAssigment;

}
