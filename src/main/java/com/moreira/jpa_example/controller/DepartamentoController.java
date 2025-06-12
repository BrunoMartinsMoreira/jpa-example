package com.moreira.jpa_example.controller;

import com.moreira.jpa_example.DAO.DepartamentoDAO;
import com.moreira.jpa_example.model.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class DepartamentoController {
  @Autowired
  private DepartamentoDAO dao;

  @PostMapping("/departamentos")
  public ResponseEntity<Departamento> criarDepartamento(@RequestBody Departamento dep) {
    try {
      Departamento deptoCriado = dao.save(dep);

      return ResponseEntity.status(HttpStatus.CREATED).body(deptoCriado);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @GetMapping("/departamentos/{numeroId}")
  public ResponseEntity<Optional<Departamento>> buscarDepartamento(@PathVariable int numeroId) {
    try {
      Optional<Departamento> dpto = dao.findById(numeroId);
      return ResponseEntity.status(HttpStatus.OK).body(dpto);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @GetMapping("/departamentos/nome/{nome}")
  public ResponseEntity<Optional<Departamento>> buscarDepartamentoPorNome(@PathVariable String nome) {
    try {
      Optional<Departamento> dpto = dao.findByNome(nome);
      return ResponseEntity.status(HttpStatus.OK).body(dpto);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @GetMapping("/departamentos/listar")
  public ResponseEntity<ArrayList<Departamento>> listarDepartamentos() {
   try {
     ArrayList<Departamento> lista = dao.findByOrderByNomeDesc();
     return ResponseEntity.status(HttpStatus.OK).body(lista);
   } catch (Exception e) {
     throw new RuntimeException(e);
   }
  }


  @DeleteMapping("/departamentos/{numeroId})")
  public ResponseEntity<Void> deletarDepartamento(@PathVariable int numeroId) {
    try {
      dao.deleteById(numeroId);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
