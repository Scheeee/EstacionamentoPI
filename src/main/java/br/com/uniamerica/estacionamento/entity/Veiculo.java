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
    @NotBlank(message = "Campo não informado")
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "cor")
     private Cor cor;
    @NotBlank(message = "Campo não informado")
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
     private Tipo tipo;
    @NotNull(message = "campo não informado")
    @Getter
    @Setter
    @Column(name = "ano")
     private int ano;

}
