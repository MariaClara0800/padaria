package com.javaLoja.Loja_projeto.business;

import com.javaLoja.Loja_projeto.DTO.CompraRequestDTO;
import com.javaLoja.Loja_projeto.infrastructure.entitys.Compra;
import com.javaLoja.Loja_projeto.infrastructure.entitys.Padaria;
import com.javaLoja.Loja_projeto.infrastructure.entitys.Usuario;
import com.javaLoja.Loja_projeto.infrastructure.repository.CompraRepository;
import com.javaLoja.Loja_projeto.infrastructure.repository.PadariaRepository;
import com.javaLoja.Loja_projeto.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;
    private final UsuarioRepository usuarioRepository;
    private final PadariaRepository padariaRepository;

    public Compra criarCompraComDTO(CompraRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<Padaria> produtos = padariaRepository.findAllById(dto.getProdutosIds());

        Compra compra = Compra.builder()
                .usuario(usuario)
                .produtos(produtos)
                .dataCompra(LocalDateTime.now())
                .valorTotal(calcularValorTotal(produtos))
                .build();

        return compraRepository.save(compra);
    }

    private Double calcularValorTotal(List<Padaria> produtos) {
        return produtos.stream()
                .mapToDouble(p -> p.getPreco() != null ? p.getPreco() : 0.0)
                .sum();
    }
}
