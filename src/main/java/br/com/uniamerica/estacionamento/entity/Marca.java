package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Marcas", schema = "public")
public class Marca extends AbstractEntity{
    @NotBlank
    @Getter
    @Setter
    @Column(name = "nome", nullable = false, unique = true, length = 50)
    private String nome;

}
