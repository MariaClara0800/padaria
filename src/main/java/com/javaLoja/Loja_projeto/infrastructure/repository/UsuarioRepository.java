package com.javaLoja.Loja_projeto.infrastructure.repository;

import com.javaLoja.Loja_projeto.infrastructure.entitys.Usuario;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Optional<Usuario> findByCpf(String cpf);

    @Transactional
    void deleteByCpf(String cpf);
}