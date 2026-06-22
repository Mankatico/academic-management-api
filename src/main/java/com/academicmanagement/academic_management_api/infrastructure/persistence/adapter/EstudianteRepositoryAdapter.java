package com.academicmanagement.academic_management_api.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.academicmanagement.academic_management_api.domain.model.Estudiante;
import com.academicmanagement.academic_management_api.domain.port.EstudiantePort;
import com.academicmanagement.academic_management_api.infrastructure.persistence.mapper.EstudianteEntityMapper;
import com.academicmanagement.academic_management_api.infrastructure.persistence.repository.EstudianteJpaRepository;

@Component
public class EstudianteRepositoryAdapter implements EstudiantePort {

  private final EstudianteJpaRepository jpaRepository;
  private final EstudianteEntityMapper mapper;

  public EstudianteRepositoryAdapter(EstudianteJpaRepository jpaRepository,
      EstudianteEntityMapper mapper) {
    this.jpaRepository = jpaRepository;
    this.mapper = mapper;
  }

  @Override
  public Estudiante guardar(Estudiante estudiante) {
    return mapper.toDomain(jpaRepository.save(mapper.toEntity(estudiante)));
  }

  @Override
  public Optional<Estudiante> buscarPorId(Integer id) {
    return jpaRepository.findById(id).map(mapper::toDomain);
  }

  @Override
  public Optional<Estudiante> buscarPorDocumento(String documento) {
    return jpaRepository.findByDocumento(documento).map(mapper::toDomain);
  }

  @Override
  public Optional<Estudiante> buscarPorEmail(String email) {
    return jpaRepository.findByEmail(email).map(mapper::toDomain);
  }

  @Override
  public List<Estudiante> listarTodos() {
    return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
  }

  @Override
  public void eliminar(Integer id) {
    jpaRepository.deleteById(id);
  }

  @Override
  public boolean existePorDocumento(String documento) {
    return jpaRepository.existsByDocumento(documento);
  }

  @Override
  public boolean existePorEmail(String email) {
    return jpaRepository.existsByEmail(email);
  }
}
