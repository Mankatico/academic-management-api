package com.academicmanagement.academic_management_api.domain.exception;

public class EstudianteNoEncontradoException extends DomainException {

  private EstudianteNoEncontradoException(String message) {
    super(message);
  }

  public static EstudianteNoEncontradoException porId(Integer id) {
    return new EstudianteNoEncontradoException("No se encontró un estudiante con el ID: " + id);
  }

  public static EstudianteNoEncontradoException porDocumento(String documento) {
    return new EstudianteNoEncontradoException("No se encontró un estudiante con el documento: " + documento);
  }

  public static EstudianteNoEncontradoException porEmail(String email) {
    return new EstudianteNoEncontradoException("No se encontró un estudiante con el email: " + email);
  }

}
