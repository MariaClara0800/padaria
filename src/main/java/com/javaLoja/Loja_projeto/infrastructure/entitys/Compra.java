package com.javaLoja.Loja_projeto.infrastructure.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "compras")
public class Compra {

    @Id
    private String id;

    @DBRef
    private Usuario usuario;

    @DBRef
    private List<Padaria> produtos;

    private LocalDateTime dataCompra;
    private Double valorTotal;
}