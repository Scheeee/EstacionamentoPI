package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter //id n utiliza o @Setter... n utilizar diretamente na classe (boa pratica).
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Getter @Setter
    @Column( name = "Cadastro")//, nullable = false
    private LocalDateTime cadastro;
    @Getter @Setter
    @Column(name = "edicao")
    private LocalDateTime edicao;
    @Getter @Setter
    @Column (name = "Ativo", nullable = false)
    private boolean ativo;

    @PrePersist
    private void prePersist(){
        this.cadastro = LocalDateTime.now();
        this.ativo = true;
    }
    @PreUpdate
    private void preUpdate(){
        this.edicao = LocalDateTime.now();
    }

}
