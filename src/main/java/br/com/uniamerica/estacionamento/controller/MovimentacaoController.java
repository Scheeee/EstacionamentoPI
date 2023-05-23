package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import br.com.uniamerica.estacionamento.service.MovimentacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
    @RequestMapping(value = "/api/movimentacao")

    public class MovimentacaoController {
        @Autowired
        private MovimentacaoRepository movimentacaoRep;
        @Autowired
        final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")  Long id){
        Optional<Movimentacao> movimentacaoOptional = movimentacaoService.findById(id);
        if(!movimentacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movimentaçâo não encontrada");
        }
        return ResponseEntity.ok(movimentacaoService.findById(id));
    }

    @GetMapping("/lista")
    public ResponseEntity <?> getALlMovimetacao(){

        if(movimentacaoService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há nenhuma movimentação");
        }
        else {
            return ResponseEntity.ok(movimentacaoService.findAll());
        }
    }
    @GetMapping("/ativo")
    public ResponseEntity<?> getByAtivo(){
        if(movimentacaoService.findByAtivo().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há nenhuma movimentação ativa");
        }
        else {
            return ResponseEntity.ok(movimentacaoService.findByAtivo());
        }
    }
    @PostMapping
    public ResponseEntity<Object> saveMovimentacao(@RequestBody @Valid Movimentacao movimentacao){

            return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoService.save(movimentacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMovimentacao(@PathVariable(value = "id")Long id,@RequestBody @Valid Movimentacao movimentacao){
        Optional<Movimentacao> movimentacaoOptional = movimentacaoService.findById(id);
        if(!movimentacaoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movimentação não encontrada");
        }

        var movimentacaoNovo = movimentacaoOptional.get();

        movimentacaoNovo.setVeiculo(movimentacao.getVeiculo());
        movimentacaoNovo.setCondutor(movimentacao.getCondutor());
        movimentacaoNovo.setSaida(movimentacao.getSaida());
        movimentacaoNovo.setEntrada(movimentacao.getEntrada());
        movimentacaoNovo.setTempo(movimentacao.getTempo());
        movimentacaoNovo.setTempoDesconto(movimentacao.getTempoDesconto());
        movimentacaoNovo.setTempoMulta(movimentacao.getTempoMulta());
        movimentacaoNovo.setValorMulta(movimentacao.getValorMulta());
        movimentacaoNovo.setValorHora(movimentacao.getValorHora());
        movimentacaoNovo.setValorHoraMulta(movimentacao.getValorHoraMulta());
        movimentacaoNovo.setValorTotal(movimentacao.getValorTotal());
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoService.save(movimentacao));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovimentacao(@PathVariable(value = "id") Long id){
        Optional<Movimentacao> movimentacaoOptional = movimentacaoService.findById(id);
        if(!movimentacaoOptional.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(("Movimentação não encontrada"));
        }
        movimentacaoService.delete(movimentacaoOptional.get());
        return  ResponseEntity.status(HttpStatus.OK).body("Movimentação deletada com sucesso");

    }

    }