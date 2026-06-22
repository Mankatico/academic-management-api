package com.academicmanagement.academic_management_api.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.academicmanagement.academic_management_api.domain.model.Estudiante;
import com.academicmanagement.academic_management_api.infrastructure.persistence.entity.EstudianteEntity;

@Component
public class EstudianteEntityMapper {

  public Estudiante toDomain(EstudianteEntity estudianteEntity) {
    return new Estudiante(
        estudianteEntity.getId(),
        estudianteEntity.getNombre(),
        estudianteEntity.getApellido(),
        estudianteEntity.getDocumento(),
        estudianteEntity.getEmail(),
        estudianteEntity.getFechaNacimiento());
  }

  public EstudianteEntity toEntity(Estudiante estudiante) {
    return EstudianteEntity.builder()
        .id(estudiante.id())
        .nombre(estudiante.nombre())
        .apellido(estudiante.apellido())
        .documento(estudiante.documento())
        .email(estudiante.email())
        .fechaNacimiento(estudiante.fechaNacimiento())
        .build();
  }
}
