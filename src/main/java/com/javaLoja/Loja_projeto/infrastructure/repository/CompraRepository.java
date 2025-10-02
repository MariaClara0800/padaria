package com.javaLoja.Loja_projeto.infrastructure.repository;

import com.javaLoja.Loja_projeto.infrastructure.entitys.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
