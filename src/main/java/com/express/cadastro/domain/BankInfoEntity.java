package com.express.cadastro.domain;

import com.express.cadastro.domain.enums.AccountType;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Table(name = "bankInfo")
public class BankInfoEntity {

    public static final String SEQUENCE_NAME = "BANKSEQUENCE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME)
    private Long id;

    private String bankName;

    private String bankCode;

    private String accountNumber;

    private String agency;

    private AccountType accountType;

}
