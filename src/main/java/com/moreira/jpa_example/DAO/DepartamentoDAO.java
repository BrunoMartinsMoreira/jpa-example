package com.moreira.jpa_example.DAO;

import com.moreira.jpa_example.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;


public interface DepartamentoDAO extends JpaRepository<Departamento, Integer> {
  public ArrayList<Departamento> findByOrderByNomeDesc();
  public Optional<Departamento> findByNome(String nome);
}
