package com.express.cadastro.repository;

import com.express.cadastro.domain.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    Page<CourseEntity> findAllByActiveTrue(Pageable pageable);

    Optional<CourseEntity> findByIdAndActiveTrue(Long id);
}
