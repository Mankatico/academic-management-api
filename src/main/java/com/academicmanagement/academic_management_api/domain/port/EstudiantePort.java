package com.academicmanagement.academic_management_api.domain.port;

import java.util.List;
import java.util.Optional;

import com.academicmanagement.academic_management_api.domain.model.Estudiante;

public interface EstudiantePort {
  Estudiante guardar(Estudiante estudiante);

  Optional<Estudiante> buscarPorId(Integer id);

  Optional<Estudiante> buscarPorDocumento(String documento);

  Optional<Estudiante> buscarPorEmail(String email);

  List<Estudiante> listarTodos();

  void eliminar(Integer id);

  boolean existePorDocumento(String documento);

  boolean existePorEmail(String email);

}
