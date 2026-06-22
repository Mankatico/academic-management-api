package com.academicmanagement.academic_management_api.infrastructure.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academicmanagement.academic_management_api.application.dto.ActualizarEstudianteRequest;
import com.academicmanagement.academic_management_api.application.dto.CrearEstudianteRequest;
import com.academicmanagement.academic_management_api.application.dto.EstudianteResponse;
import com.academicmanagement.academic_management_api.application.service.EstudianteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/estudiantes")
public class EstudianteController {

  private final EstudianteService estudianteService;

  public EstudianteController(EstudianteService estudianteService) {
    this.estudianteService = estudianteService;
  }

  @PostMapping
  public ResponseEntity<EstudianteResponse> crear(@Valid @RequestBody CrearEstudianteRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.crear(request));
  }

  @GetMapping("/{id}")
  public ResponseEntity<EstudianteResponse> buscarPorId(@PathVariable Integer id) {
    return ResponseEntity.ok(estudianteService.buscarPorId(id));
  }

  @GetMapping
  public ResponseEntity<List<EstudianteResponse>> listarTodos() {
    return ResponseEntity.ok(estudianteService.listarTodos());
  }

  @PutMapping("/{id}")
  public ResponseEntity<EstudianteResponse> actualizar(@PathVariable Integer id,
      @Valid @RequestBody ActualizarEstudianteRequest request) {
    return ResponseEntity.ok(estudianteService.actualizar(id, request));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    estudianteService.eliminar(id);
    return ResponseEntity.noContent().build();
  }
}
