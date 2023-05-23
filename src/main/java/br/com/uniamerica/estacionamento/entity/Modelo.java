package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

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
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "veiculo")
    private Marca marca;

}
