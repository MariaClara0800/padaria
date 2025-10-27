package com.javaLoja.Loja_projeto.infrastructure.repository;

import com.javaLoja.Loja_projeto.infrastructure.entitys.Padaria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadariaRepository extends MongoRepository<Padaria, String> {
}
