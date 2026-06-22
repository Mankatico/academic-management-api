
package com.academicmanagement.academic_management_api.domain.model;

import java.time.LocalDate;

public record Estudiante(
    Integer id,
    String nombre,
    String apellido,
    String documento,
    String email,
    LocalDate fechaNacimiento) {

  public Estudiante {
    if (nombre == null || nombre.isBlank()) {
      throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
    }
    if (apellido == null || apellido.isBlank()) {
      throw new IllegalArgumentException("El apellido no puede ser nulo o vacío");
    }
    if (documento == null || documento.isBlank()) {
      throw new IllegalArgumentException("El documento no puede ser nulo o vacío");
    }
    if (email == null || email.isBlank()) {
      throw new IllegalArgumentException("El email no puede ser nulo o vacío");
    }
    if (fechaNacimiento == null) {
      throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
    }
  }

  public static Estudiante crear(String nombre, String apellido, String documento, String email,
      LocalDate fechaNacimiento) {
    return new Estudiante(null, nombre, apellido, documento, email, fechaNacimiento);
  }

  public Estudiante actualizar(String nombre, String apellido, String email,
      LocalDate fechaNacimiento) {
    return new Estudiante(this.id, nombre, apellido, this.documento, email, fechaNacimiento);
  }

}
