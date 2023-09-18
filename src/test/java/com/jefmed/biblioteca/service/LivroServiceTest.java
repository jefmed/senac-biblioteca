package com.jefmed.biblioteca.service;

import com.jefmed.biblioteca.model.LivroDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LivroServiceTest {

    private LivroService service;

    @BeforeEach
    void setUp() {
        service = new LivroService();
        LivroDTO livro = new LivroDTO(123L, "Livro teste", "Nome do Autor");
        service.adicionar(livro);
    }

    @DisplayName("Deve buscar livro com o nome informado")
    @Test
    void bucarLivro() {
        LivroDTO retorno = service.buscar("Livro teste");

        assertEquals("Livro teste", retorno.getNome());
    }
}