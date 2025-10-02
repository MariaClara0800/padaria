package com.javaLoja.Loja_projeto.DTO;
import lombok.Data;
import java.util.List;

@Data
public class CompraRequestDTO {
    private Long usuarioId;
    private List<Long> produtosIds;
}
