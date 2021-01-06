package com.express.cadastro.service;

import com.express.cadastro.domain.TeacherEntity;
import com.express.cadastro.domain.dto.TeacherDTO;
import com.express.cadastro.exception.NotFound;
import com.express.cadastro.repository.TeacherRepository;
import com.express.cadastro.specification.TeacherSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(final TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Page<TeacherDTO> findAll(final String name, final String document, final String email, final Pageable pageable) {
        final Specification<TeacherEntity> specification = TeacherSpecification.getSpecification(name, document, email);
        final Page<TeacherEntity> entityPage = teacherRepository.findAll(specification, pageable);

        return entityPage.map(TeacherDTO::toDto);
    }

    public TeacherDTO findOne(final Long id) {
        final TeacherEntity teacher = teacherRepository.findByIdAndActiveTrue(id)
                .orElseThrow(NotFound::new);

        return TeacherDTO.toDto(teacher);
    }

    public void create(final TeacherDTO dto) {
        final TeacherEntity teacherEntity = dto.toEntity();

        teacherRepository.save(teacherEntity);
    }

    public void update(final Long id, final TeacherDTO dto) {
        final TeacherEntity beforeUpdateTeacherEntity = teacherRepository.findByIdAndActiveTrue(id)
                                                        .orElseThrow(NotFound::new);
        final TeacherEntity newTeacherEntity = dto.toEntity();
        final TeacherEntity updatedTeacherEntity = updateTeacher(beforeUpdateTeacherEntity, newTeacherEntity);

        teacherRepository.save(updatedTeacherEntity);
    }

    public void delete(final Long id) {
        final TeacherEntity teacherEntity = teacherRepository.findByIdAndActiveTrue(id).orElseThrow(NotFound::new);
        teacherEntity.setActive(false);

        teacherRepository.save(teacherEntity);
    }

    private TeacherEntity updateTeacher(final TeacherEntity beforeUpdateTeacherEntity, final TeacherEntity newTeacherEntity) {
        beforeUpdateTeacherEntity.setName(newTeacherEntity.getName());
        beforeUpdateTeacherEntity.setEmail(newTeacherEntity.getEmail());
        beforeUpdateTeacherEntity.setDocument(newTeacherEntity.getDocument());
        beforeUpdateTeacherEntity.setAddress(newTeacherEntity.getAddress());
        beforeUpdateTeacherEntity.setBankInfo(newTeacherEntity.getBankInfo());

        return beforeUpdateTeacherEntity;
    }
}
