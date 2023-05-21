package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "veiculos", schema = "public")

public class Veiculo extends AbstractEntity{
    @Size(min = 10, max = 10)//verificar essa validação
    @NotBlank
    @Getter
    @Setter
    @Column(name = "placa", nullable = false, unique = true, length = 10)
    private String placa;
    @Valid
    @NotBlank
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "modelo", nullable = false)
     private Modelo modelo;
    @NotBlank
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "cor", nullable = false)
     private Cor cor;
    @NotBlank
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
     private Tipo tipo;
    @NotNull
    @Getter
    @Setter
    @Column(name = "ano", nullable = false)
     private int ano;

}
