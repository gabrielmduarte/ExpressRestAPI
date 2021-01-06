package com.express.cadastro.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Table(name = "ADDRESS")
@Entity
public class AddressEntity {

    public static final String SEQUENCE_NAME = "ADDRESSSEQUENCE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME)
    private Long id;

    private String address;

    private String city;

    private String state;

    private String country;

    private String postalCode;
}
