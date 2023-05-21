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

    @NotBlank
    @Size(min = 2, max = 50)
    @Getter
    @Setter
    @Column(name = "nome", nullable = false, unique = true,length = 50)
    private String nome;
    @Valid
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "veiculo", nullable = false)
    private Marca marca;

}
