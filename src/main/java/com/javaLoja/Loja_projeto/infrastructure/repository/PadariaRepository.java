package com.javaLoja.Loja_projeto.infrastructure.repository;

import com.javaLoja.Loja_projeto.infrastructure.entitys.Padaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadariaRepository extends JpaRepository<Padaria, Long> {
}
