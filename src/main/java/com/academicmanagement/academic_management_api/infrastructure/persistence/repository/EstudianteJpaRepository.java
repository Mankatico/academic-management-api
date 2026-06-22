package com.academicmanagement.academic_management_api.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academicmanagement.academic_management_api.infrastructure.persistence.entity.EstudianteEntity;

public interface EstudianteJpaRepository extends JpaRepository<EstudianteEntity, Integer> {
  Optional<EstudianteEntity> findByDocumento(String documento);

  Optional<EstudianteEntity> findByEmail(String email);

  boolean existsByDocumento(String documento);

  boolean existsByEmail(String email);

}
