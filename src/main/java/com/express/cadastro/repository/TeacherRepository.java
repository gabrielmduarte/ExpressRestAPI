package com.express.cadastro.repository;

import com.express.cadastro.domain.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>, JpaSpecificationExecutor<TeacherEntity> {
    Optional<TeacherEntity> findByIdAndActiveTrue(Long id);
}
