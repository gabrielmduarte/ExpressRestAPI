package com.express.cadastro.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "classroom")
@Entity
@ToString(of = "id")
public class ClassroomEntity {

    public static final String SEQUENCE_NAME = "CLASSROOMSEQUENCE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacherId", referencedColumnName = "id")
    private TeacherEntity teacher;

    @ManyToOne
    @JoinColumn(name = "courseId",referencedColumnName = "id")
    private CourseEntity course;

    @ManyToMany
    private List<StudentEntity> studentsEnrolled = new ArrayList<>();

    private Boolean active;
}
