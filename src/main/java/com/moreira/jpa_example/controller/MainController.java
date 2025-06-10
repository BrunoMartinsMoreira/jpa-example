package com.moreira.jpa_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class MainController {
  @Autowired
  private DataSource dataSource;

  @GetMapping("/")
  public String getHello() {
    try (Connection conn = dataSource.getConnection()) {
      return "Conexão OK! Banco: " + conn.getMetaData();
    } catch (SQLException e) {
      return "Erro ao conectar no banco de dados";
    }
  }
}
