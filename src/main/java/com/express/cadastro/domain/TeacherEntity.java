package com.express.cadastro.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Table(name = "Teacher")
@Entity
@ToString(of = "id")
public class TeacherEntity {

    public static final String SEQUENCE_NAME = "TEACHERSEQUENCE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean active = true;

    private String document;

    private String email;

    @OneToOne(cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(referencedColumnName = "id", name = "bankInfoId")
    private BankInfoEntity bankInfo;

    @OneToOne(cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(referencedColumnName = "id", name = "addressId")
    private AddressEntity address;

}
