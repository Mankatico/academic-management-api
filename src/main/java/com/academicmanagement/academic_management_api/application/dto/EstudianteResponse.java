package com.academicmanagement.academic_management_api.application.dto;

import java.time.LocalDate;

import com.academicmanagement.academic_management_api.domain.model.Estudiante;

public record EstudianteResponse(
    Integer id,
    String nombre,
    String apellido,
    String documento,
    String email,
    LocalDate fechaNacimiento) {

  public static EstudianteResponse desde(Estudiante estudiante) {
    return new EstudianteResponse(
        estudiante.id(),
        estudiante.nombre(),
        estudiante.apellido(),
        estudiante.documento(),
        estudiante.email(),
        estudiante.fechaNacimiento());
  }

}
