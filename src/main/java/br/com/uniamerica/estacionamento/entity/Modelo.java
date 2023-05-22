package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "Modelos", schema = "public")
public class Modelo extends AbstractEntity  {

    @NotBlank(message = "Campo não informado")
    @Size(min = 2, max = 50, message = "Tamanho inválido")
    @Getter
    @Setter
    @Column(name = "nome")
    private String nome;
    @Valid
    @NotBlank(message = "Campo não informado")
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "veiculo")
    private Marca marca;

}
