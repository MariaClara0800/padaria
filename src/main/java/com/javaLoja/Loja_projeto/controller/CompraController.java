package com.javaLoja.Loja_projeto.controller;

import com.javaLoja.Loja_projeto.DTO.CompraRequestDTO;
import com.javaLoja.Loja_projeto.business.CompraService;
import com.javaLoja.Loja_projeto.infrastructure.entitys.Compra;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // ou especifique o domínio do front-end
@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> criarCompra(@RequestBody CompraRequestDTO dto) {
        Compra novaCompra = compraService.criarCompraComDTO(dto);
        return ResponseEntity.ok(novaCompra);
    }
}
