package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

    @Controller
    @RequestMapping(value = "/api/Movimentacao")

    public class MovimentacaoController {
        @Autowired
        private MovimentacaoRepository movimentacaoRep;

        @GetMapping("/{id}")
        public ResponseEntity<Movimentacao> findById(@PathVariable("id") final Long id){
            return ResponseEntity.ok(new Movimentacao());
        }
        @GetMapping("/lista")
        public ResponseEntity <?> ListaCompleta(){
            return ResponseEntity.ok(this.movimentacaoRep.findAll());

        }

    }