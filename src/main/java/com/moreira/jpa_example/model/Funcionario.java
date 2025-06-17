package com.moreira.jpa_example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="num_funcional")
  private int numFuncional;

  @Column(name="nome", length = 100, nullable = false)
  private String nome;

  @Column(name="email", length = 50, nullable = false)
  private String email;

  @Column(name = "salario", nullable = false)
  private double salario;

  @ManyToOne
  @JoinColumn(name="numero_id")
  @JsonIgnoreProperties("funcionarios")
  private Departamento depto;

  public int getNumFuncional() {
    return numFuncional;
  }

  public void setNumFuncional(int numFuncional) {
    this.numFuncional = numFuncional;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public Departamento getDepto() {
    return depto;
  }

  public void setDepto(Departamento depto) {
    this.depto = depto;
  }
}
