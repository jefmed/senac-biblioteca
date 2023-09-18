package com.jefmed.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LivroDTO {

    private Long isbn;
    private String nome;
    private String autor;

}
