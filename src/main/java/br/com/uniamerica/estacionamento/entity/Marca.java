package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Marcas", schema = "public")
public class Marca extends AbstractEntity{
    @NotBlank(message = "Campo não informado")
    @Size(max = 50, message = "A quantidade de caracteres foi excedida")
    @Getter
    @Setter
    @Column(name = "nome")
    private String nome;

}
