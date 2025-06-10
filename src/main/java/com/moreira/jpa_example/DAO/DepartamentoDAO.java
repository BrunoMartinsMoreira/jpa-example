package com.moreira.jpa_example.DAO;

import com.moreira.jpa_example.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentoDAO extends JpaRepository<Departamento, Integer> {
}
