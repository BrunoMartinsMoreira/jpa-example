package com.moreira.jpa_example.DAO;

import com.moreira.jpa_example.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioDAO extends JpaRepository<Funcionario, Integer> {
}
