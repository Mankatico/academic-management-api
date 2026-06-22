package com.academicmanagement.academic_management_api.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academicmanagement.academic_management_api.application.dto.ActualizarEstudianteRequest;
import com.academicmanagement.academic_management_api.application.dto.CrearEstudianteRequest;
import com.academicmanagement.academic_management_api.application.dto.EstudianteResponse;
import com.academicmanagement.academic_management_api.domain.exception.DomainException;
import com.academicmanagement.academic_management_api.domain.exception.EstudianteNoEncontradoException;
import com.academicmanagement.academic_management_api.domain.model.Estudiante;
import com.academicmanagement.academic_management_api.domain.port.EstudiantePort;

@Service
public class EstudianteService {

  private final EstudiantePort estudiantePort;

  public EstudianteService(EstudiantePort estudiantePort) {
    this.estudiantePort = estudiantePort;
  }

  public EstudianteResponse crear(CrearEstudianteRequest request) {
    if (estudiantePort.existePorDocumento(request.documento())) {
      throw new DomainException("Ya existe un estudiante con el documento: " + request.documento());
    }
    if (estudiantePort.existePorEmail(request.email())) {
      throw new DomainException("Ya existe un estudiante con el email: " + request.email());
    }

    Estudiante estudiante = Estudiante.crear(
        request.nombre(),
        request.apellido(),
        request.documento(),
        request.email(),
        request.fechaNacimiento());

    Estudiante estudianteGuardado = estudiantePort.guardar(estudiante);
    return EstudianteResponse.desde(estudianteGuardado);
  }

  public EstudianteResponse buscarPorId(Integer id) {
    Estudiante estudiante = estudiantePort.buscarPorId(id)
        .orElseThrow(() -> EstudianteNoEncontradoException.porId(id));
    return EstudianteResponse.desde(estudiante);
  }

  public List<EstudianteResponse> listarTodos() {
    return estudiantePort.listarTodos().stream()
        .map(EstudianteResponse::desde)
        .toList();
  }

  public EstudianteResponse actualizar(Integer id, ActualizarEstudianteRequest request) {
    Estudiante estudianteExistente = estudiantePort.buscarPorId(id)
        .orElseThrow(() -> EstudianteNoEncontradoException.porId(id));

    Estudiante estudianteActualizado = estudianteExistente.actualizar(
        request.nombre(),
        request.apellido(),
        request.email(),
        request.fechaNacimiento());

    Estudiante estudianteGuardado = estudiantePort.guardar(estudianteActualizado);
    return EstudianteResponse.desde(estudianteGuardado);
  }

  public void eliminar(Integer id) {
    estudiantePort.buscarPorId(id).orElseThrow(() -> EstudianteNoEncontradoException.porId(id));
    estudiantePort.eliminar(id);
  }

}
