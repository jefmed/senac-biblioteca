package com.jefmed.biblioteca.service;

import com.jefmed.biblioteca.model.LivroDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LivroService {

    private final List<LivroDTO> livros = new ArrayList<>();

    public LivroDTO adicionar(LivroDTO novoLivro) {
        livros.add(novoLivro);
        log.info("{} adicionado a biblioteca", novoLivro.getNome());
        log.info("Biblioteca atual: {}", livros);
        return novoLivro;
    }

    public LivroDTO buscar(String nomeLivro) {
        for (LivroDTO livro: livros) {
            if (livro.getNome().equalsIgnoreCase(nomeLivro)) {
                log.info("Livro {} encontrado!", livro.getNome());
                return livro;
            }
        }
        throw new RuntimeException("Nenhum livro encontrado!");
    }

    public LivroDTO alterar(String velhorNome, String novoNome) {
        for (LivroDTO livro: livros) {
            if (livro.getNome().equalsIgnoreCase(velhorNome)) {
                log.info("Livro {} encontrado!", livro.getNome());
                livro.setNome(novoNome);
                log.info("Nome alterado para: {} !", livro.getNome());
                log.info("Biblioteca atual: {}", livros);
                return livro;
            }
        }
        throw new RuntimeException("Nenhum livro encontrado!");
    }

    public String deletar(String nome) {
        for (LivroDTO livro: livros) {
            if (livro.getNome().equalsIgnoreCase(nome)) {
                log.info("Livro {} encontrado!", livro.getNome());
                livros.remove(livro);
                log.info("Nome {} removido!", nome);
                log.info("Biblioteca atual: {}", livros);
                return nome;
            }
        }
        throw new RuntimeException("Nenhum livro encontrado!");
    }

}
