package com.express.cadastro.repository;

import com.express.cadastro.domain.ClassroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ClassroomRepository extends JpaRepository<ClassroomEntity, Long>,
                                                    JpaSpecificationExecutor<ClassroomEntity> {

    Optional<ClassroomEntity> findByIdAndActiveTrue(Long id);
}
