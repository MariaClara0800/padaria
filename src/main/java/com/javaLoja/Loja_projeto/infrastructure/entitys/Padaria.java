package com.javaLoja.Loja_projeto.infrastructure.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "padarias")
public class Padaria {

  @Id
  private String id;

  private String nome;
  private Double preco;
  private Integer quantidade;

  public String getId() { return id; }

  public void setId(String id) { this.id = id; }

  public String getNome() { return nome; }

  public void setNome(String nome) { this.nome = nome; }

  public Double getPreco() { return preco; }

  public void setPreco(Double preco) { this.preco = preco; }

  public Integer getQuantidade() { return quantidade; }

  public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
}