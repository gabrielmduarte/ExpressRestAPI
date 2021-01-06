package com.express.cadastro.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Table(name = "student")
@Entity
public class StudentEntity {

    public static final String SEQUENCE_NAME = "STUDENTSEQUENCE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String phone;

    private String email;

    private Boolean active;

}
