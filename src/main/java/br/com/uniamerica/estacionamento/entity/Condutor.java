package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalTime;
@Entity
@Table(name = "Condutores", schema = "public")
public class Condutor extends AbstractEntity {


    @NotBlank(message = "Campo não informado")
    @Size(max = 50, message = "A quantidade de caracteres é inválida")
    @Getter @Setter
    @Column(name = "nome")
    private String nome;
    @CPF(message = "CPF inválido")
    @NotBlank(message = "campo não informado")
    @Getter @Setter
    @Column(name = "cpf")
    private String cpf;
    @Pattern(regexp = "\\d{2}-\\d{4,5}-\\d{4}", message = "Telefone inválido")
    @Size(min = 12, max = 13, message = "A quantidade de caracteres é inválida")
    @Getter @Setter
    @Column(name = "telefone")
    private String telefone;

    @NotNull(message = "O tempo pago não pode ser nulo!")
    @Getter @Setter
    @Column(name = "Tempo gasto")
    private LocalTime tempoPago;
    @NotNull(message = "O tempo de desconto não pode ser nulo!")
    @Getter @Setter
    @Column(name = "Tempo desconto")
    private LocalTime tempoDesconto;



}
