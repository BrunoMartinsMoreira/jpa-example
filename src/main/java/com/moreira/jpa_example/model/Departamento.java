package com.moreira.jpa_example.model;


import jakarta.persistence.*;

@Entity
@Table(name="departamento")
public class Departamento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="numero_id")
  private int numeroId;

  @Column(name="nome", length = 100, nullable = false)
  private String nome;

  @Column(name="andar", nullable = false)
  private int andar;

  public int getNumeroId() {
    return numeroId;
  }

  public void setNumeroId(int numeroId) {
    this.numeroId = numeroId;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getAndar() {
    return andar;
  }

  public void setAndar(int andar) {
    this.andar = andar;
  }
}
