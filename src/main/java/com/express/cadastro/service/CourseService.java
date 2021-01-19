package com.express.cadastro.service;

import com.express.cadastro.domain.CourseEntity;
import com.express.cadastro.domain.dto.CourseDTO;
import com.express.cadastro.exception.NotFound;
import com.express.cadastro.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public Page<CourseDTO> findAll(Pageable pageable) {
        Page<CourseEntity> page = repository.findAllByActiveTrue(pageable);

        return page.map(CourseDTO::toDTO);
    }

    public CourseDTO findOne(Long id) {
        CourseEntity entity = repository.findByIdAndActiveTrue(id).orElseThrow(NotFound::new);

        return CourseDTO.toDTO(entity);
    }

    public void create(CourseDTO dto) {
        CourseEntity entity = CourseDTO.toEntity(dto);

        repository.save(entity);
    }

    public void update(Long id, CourseDTO dto) {
        CourseEntity beforeUpdate = repository.findByIdAndActiveTrue(id).orElseThrow(NotFound::new);
        CourseEntity newValues = CourseDTO.toEntity(dto);

        CourseEntity entity = updateCourse(beforeUpdate, newValues);
        repository.save(entity);
    }

    public void delete(Long id) {
        CourseEntity entity = repository.findByIdAndActiveTrue(id).orElseThrow(NotFound::new);
        entity.setActive(false);

        repository.save(entity);
    }

    private CourseEntity updateCourse(CourseEntity beforeUpdate, CourseEntity newValues) {
        beforeUpdate.setLanguage(newValues.getLanguage());
        beforeUpdate.setMonthlyFee(newValues.getMonthlyFee());
        beforeUpdate.setLevel(newValues.getLevel());

        return beforeUpdate;
    }
}
