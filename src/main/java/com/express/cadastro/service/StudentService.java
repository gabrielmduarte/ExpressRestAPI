package com.express.cadastro.service;

import com.express.cadastro.domain.StudentEntity;
import com.express.cadastro.domain.dto.StudentDTO;
import com.express.cadastro.exception.NotFound;
import com.express.cadastro.repository.StudentRepository;
import com.express.cadastro.specification.StudentSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Page<StudentDTO> findAll(String name, String email, Pageable pageable) {
        Specification<StudentEntity> specification = StudentSpecification.getSpecification(name, email);
        Page<StudentEntity> entities = repository.findAll(specification, pageable);

        return entities.map(StudentDTO::toDto);
    }

    public StudentDTO findOne(Long id) {
        StudentEntity student = repository.findByIdAndActiveTrue(id).orElseThrow(NotFound::new);

        return StudentDTO.toDto(student);
    }

    public void create(StudentDTO dto) {
        StudentEntity studentEntity = StudentDTO.toEntity(dto);

        repository.save(studentEntity);
    }

    public void update(Long id, StudentDTO dto) {
        StudentEntity beforeUpdateStudent = repository.findByIdAndActiveTrue(id).orElseThrow(NotFound::new);
        StudentEntity newStudentEntity = StudentDTO.toEntity(dto);
        StudentEntity updatedStudent = updateStudent(beforeUpdateStudent, newStudentEntity);

        repository.save(updatedStudent);
    }

    public void delete(Long id) {
        StudentEntity student = repository.findByIdAndActiveTrue(id).orElseThrow(NotFound::new);
        student.setActive(false);

        repository.save(student);
    }

    private StudentEntity updateStudent(StudentEntity beforeUpdateStudent, StudentEntity newStudentEntity) {
        beforeUpdateStudent.setName(newStudentEntity.getName());
        beforeUpdateStudent.setEmail(newStudentEntity.getEmail());
        beforeUpdateStudent.setPhone(newStudentEntity.getPhone());

        return beforeUpdateStudent;
    }
}
