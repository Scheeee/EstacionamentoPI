package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "Configs", schema = "public")

public class Config extends AbstractEntity{


    @Getter @Setter
    @Column(name = "Valor Hora")
    private BigDecimal valorHora;
    @Getter @Setter
    @Column(name = "Valor Minuto Multa")
    private BigDecimal valorMinutoMulta;
    @Getter @Setter
    @Column(name = "Inicio Expediente")
    private LocalTime inicioExpediente;
    @Getter @Setter
    @Column(name = "Fim expediente")
    private LocalTime fimExpediente;
    @Getter @Setter
    @Column(name = "Tempo para Desconto")
    private LocalTime tempoParaDesconto;
    @Getter @Setter
    @Column(name = "Tempo de desconto")
    private LocalTime tempoDeDesconto;
    @Getter @Setter
    @Column(name = "gerar desconto")
    private boolean gerarDesconto;
    @Getter @Setter
    @Column(name = "Vagas Moto")
    private int vagasMoto;
    @Getter @Setter
    @Column(name = "Vagas Carro")
    private int vagasCarro;
    @Getter @Setter
    @Column(name = "Valor Van")
     private int vagasVan;

}
