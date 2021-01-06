package com.express.cadastro.domain;

import com.express.cadastro.domain.enums.Level;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Table(name = "course")
@Entity
public class CourseEntity {

    public static final String SEQUENCE_NAME = "COURSESEQUENCE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME)
    private Long id;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(nullable = false)
    private BigDecimal monthlyFee;

    @Column(nullable = false)
    private Boolean active = true;
}
