package com.javaLoja.Loja_projeto.business;

import com.javaLoja.Loja_projeto.infrastructure.entitys.Padaria;
import com.javaLoja.Loja_projeto.infrastructure.repository.PadariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PadariaService {

    private final PadariaRepository padariaRepository;

    public PadariaService(PadariaRepository padariaRepository) {
        this.padariaRepository = padariaRepository;
    }

    public void salvarPadaria(Padaria padaria) {
        padariaRepository.save(padaria);
    }

    public Padaria buscarPorId(String id) {
        return padariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de padaria nao encontrado com ID: " + id));
    }

    public List<Padaria> listarTodos() {
        return padariaRepository.findAll();
    }


    public void atualizarPadaria(String id, Padaria novaPadaria) {
        Padaria existente = padariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de padaria nao encontrado com ID:" + id));
existente.setImagens(novaPadaria.getImagens());

        existente.setNome(novaPadaria.getNome());
        existente.setPreco(novaPadaria.getPreco());
        existente.setQuantidade(novaPadaria.getQuantidade());

        padariaRepository.save(existente);
    }

    public void deletarPorId(String id) {
        if (!padariaRepository.existsById(id)) {
            throw new RuntimeException("Padaria não encontrada com id: " + id);
        }
        padariaRepository.deleteById(id);
    }
}