package com.movies.ranking.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nome;

    private String password;

    private String cpf;

    private LocalDateTime dataCriacao;

    public Usuario() {
        this.dataCriacao = LocalDateTime.now();
    }
}
