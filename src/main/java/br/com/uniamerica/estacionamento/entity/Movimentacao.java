package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Movimentacaos", schema = "public")
public class Movimentacao extends AbstractEntity {

    //@Valid
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "veiculo")
    private Veiculo veiculo;


    //@Valid
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "condutor")
    private Condutor  condutor;
    @NotNull(message = "O Tempo de saída não pode ser nulo")
    @Getter @Setter
    @Column(name = "saida")
    LocalDateTime saida;
    @NotNull(message = "O Tempo de entrada não pode ser nulo")
    @Getter @Setter
    @Column(name = "entrada", nullable = false)
    LocalDateTime entrada;

    @Getter
    @Setter
    @Column(name = "tempo")
    LocalTime tempo;
    @Getter
    @Setter
    @Column(name = "tempo Desconto")
    LocalTime tempoDesconto;
    @Getter
    @Setter
    @Column(name = "tempo Multa")
    LocalTime tempoMulta;
    @Getter
    @Setter
    @Column(name = "valor Multa")
    BigDecimal valorMulta;
    @Getter
    @Setter
    @Column(name = "valor Total")
    BigDecimal valorTotal;
    @Getter
    @Setter
    @Column(name = "valor Hora")
    BigDecimal valorHora;

    @Getter
    @Setter
    @Column(name = "valor hora multa")
    BigDecimal valorHoraMulta;

}
