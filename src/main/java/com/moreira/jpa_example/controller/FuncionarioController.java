package com.moreira.jpa_example.controller;

import com.moreira.jpa_example.DAO.DepartamentoDAO;
import com.moreira.jpa_example.DAO.FuncionarioDAO;
import com.moreira.jpa_example.model.Departamento;
import com.moreira.jpa_example.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FuncionarioController {
  @Autowired
  private FuncionarioDAO funcDAO;

  @Autowired
  private DepartamentoDAO deptoDAO;

  @PostMapping("/funcionarios")
  public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario func) {
    try {
      Departamento dpto = deptoDAO.findById(func.getDepto().getNumeroId())
          .orElseThrow(() -> new RuntimeException("Departamento não encontrado com ID: " + func.getDepto().getNumeroId()));

      func.setDepto(dpto);
      Funcionario f = funcDAO.save(func);
      return  ResponseEntity.status(HttpStatus.CREATED).body(f);
    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }
  }

  @GetMapping("/funcionarios")
  public ResponseEntity<ArrayList<Funcionario>> listarFuncionarios() {
    try {
      ArrayList<Funcionario> funcs = (ArrayList<Funcionario>)funcDAO.findAll();
      return ResponseEntity.status(HttpStatus.OK).body(funcs);
    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }
  }
}
