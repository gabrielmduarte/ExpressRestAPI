package com.express.cadastro.service;

import com.express.cadastro.domain.ClassroomEntity;
import com.express.cadastro.domain.CourseEntity;
import com.express.cadastro.domain.StudentEntity;
import com.express.cadastro.domain.TeacherEntity;
import com.express.cadastro.exception.NotFound;
import com.express.cadastro.repository.ClassroomRepository;
import com.express.cadastro.repository.CourseRepository;
import com.express.cadastro.repository.StudentRepository;
import com.express.cadastro.repository.TeacherRepository;
import com.express.cadastro.request.ClassroomRequest;
import com.express.cadastro.response.ClassroomResponse;
import com.express.cadastro.specification.ClassroomSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassroomService {

    private final ClassroomRepository repository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;


    public ClassroomService(ClassroomRepository repository, TeacherRepository teacherRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
        this.repository = repository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public Page<ClassroomResponse> findAll(String teacherName, String courseLanguage, Pageable pageable) {
        Specification<ClassroomEntity> specification = ClassroomSpecification.getSpecification(teacherName, courseLanguage);
        Page<ClassroomEntity> page = repository.findAll(specification, pageable);

        return page.map(ClassroomResponse::toResponse);
    }

    public ClassroomResponse findOne(Long id) {
        ClassroomEntity entity = repository.findByIdAndActiveTrue(id).orElseThrow(NotFound::new);

        return ClassroomResponse.toResponse(entity);
    }

    public void create(ClassroomRequest request) {
        TeacherEntity teacher = teacherRepository.findByIdAndActiveTrue(request.getTeacherId()).orElseThrow(NotFound::new);
        CourseEntity course = courseRepository.findByIdAndActiveTrue(request.getCourseId()).orElseThrow(NotFound::new);
        List<StudentEntity> students = request.getStudentsId().stream()
                .map(studentRepository::findByIdAndActiveTrue)
                .map(Optional::orElseThrow)
                .collect(Collectors.toList());

        ClassroomEntity classroomEntity = new ClassroomEntity();
        classroomEntity.setActive(true);
        classroomEntity.setCourse(course);
        classroomEntity.setTeacher(teacher);
        classroomEntity.setStudentsEnrolled(students);

        repository.save(classroomEntity);
    }

    public void update(Long id, ClassroomRequest request) {
        ClassroomEntity entity = repository.findByIdAndActiveTrue(id).orElseThrow(NotFound::new);
        TeacherEntity teacher = teacherRepository.findByIdAndActiveTrue(request.getTeacherId()).orElseThrow(NotFound::new);
        CourseEntity course = courseRepository.findByIdAndActiveTrue(request.getCourseId()).orElseThrow(NotFound::new);
        List<StudentEntity> students = request.getStudentsId().stream()
                .map(studentRepository::findByIdAndActiveTrue)
                .map(Optional::orElseThrow)
                .collect(Collectors.toList());

        entity.setTeacher(teacher);
        entity.setCourse(course);
        entity.setStudentsEnrolled(students);

        repository.save(entity);
    }

    public void delete(Long id) {
        ClassroomEntity entity = repository.findByIdAndActiveTrue(id).orElseThrow(NotFound::new);
        entity.setActive(false);
        repository.save(entity);
    }
}
