package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Config;
import br.com.uniamerica.estacionamento.repository.ConfigRepository;
import br.com.uniamerica.estacionamento.service.ConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

    @Controller
    @RequestMapping(value = "/api/Config")
    public class ConfigController {
        

        @Autowired
        private  ConfigRepository configRep;
        @Autowired
        private ConfiguracaoService configuracaoService;

        @GetMapping("/{id}")
        public ResponseEntity<Config> findById(@PathVariable("id") final Long id){
            return ResponseEntity.ok(new Config());
        }

        @GetMapping("/lista")
        public ResponseEntity <?> ListaCompleta(){
            return ResponseEntity.ok(this.configRep.findAll());

        }




    }
