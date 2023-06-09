package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "veiculos", schema = "public")

public class Veiculo extends AbstractEntity{
    @Size(min = 10, max = 10, message = "placa inválida")//verificar essa validação
    @NotBlank(message = "campo não informado")
    @Getter
    @Setter
    @Column(name = "placa")
    private String placa;

    @Valid
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "modelo")
     private Modelo modelo;
    @NotNull(message = "Campo não informado")
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "cor")
     private Cor cor;
    @NotNull(message = "Campo não informado")
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
     private Tipo tipo;
    @NotNull(message = "campo não informado")
    @Min(value = 1900, message = "Ano inválido")
    @Getter
    @Setter
    @Column(name = "ano")
     private int ano;

}
