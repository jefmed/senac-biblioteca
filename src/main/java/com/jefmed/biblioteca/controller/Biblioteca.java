package com.jefmed.biblioteca.controller;

import com.jefmed.biblioteca.controller.request.RequestData;
import com.jefmed.biblioteca.model.LivroDTO;
import com.jefmed.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Biblioteca {

    private final LivroService livroService;

    public Biblioteca(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/livro")
    public LivroDTO adicionarLivro(@RequestBody LivroDTO novoLivro) {
        return livroService.adicionar(novoLivro);
    }

    @GetMapping("/livro/{nome}")
    public LivroDTO buscarLivro(@PathVariable String nome) {
        return livroService.buscar(nome);
    }

    @PatchMapping("/livro")
    public LivroDTO alterarNomeLivro(@RequestBody RequestData requestData) {
        return livroService.alterar(requestData.getVelhoNome(), requestData.getNovoNome());
    }

    @DeleteMapping("/livro/{nome}")
    public String deletarLivro(@PathVariable String nome) {
        return "Livro " + livroService.deletar(nome) + " Removido!" ;
    }

}
