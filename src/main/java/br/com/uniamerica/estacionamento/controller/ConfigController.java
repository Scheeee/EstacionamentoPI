package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Config;
import br.com.uniamerica.estacionamento.repository.ConfigRepository;
import br.com.uniamerica.estacionamento.service.ConfiguracaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
    @RequestMapping(value = "/api/config")
    public class ConfigController {
        

        @Autowired
        private  ConfigRepository configRep;
        @Autowired
        final ConfiguracaoService configService;

        public ConfigController(ConfiguracaoService configService) {
            this.configService = configService;
        }


        @GetMapping("/{id}")
        public ResponseEntity<?> findById(@PathVariable("id") Long id){
            Optional<Config> configOptional = configService.findById(id);
            if(!configOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuração não encontrada");
            }
            return ResponseEntity.ok(configService.findById(id));
        }
        @GetMapping("/ativo")
            public ResponseEntity<?> getByAtivo(){

            return ResponseEntity.ok(configService.findByAtivo());
        }

        @GetMapping("/lista")
        public ResponseEntity <?> getAllConfig(){
            return ResponseEntity.ok(configService.findAll());
        }


    @PostMapping
    public ResponseEntity<Object> saveConfig(@RequestBody Config config){

            return ResponseEntity.status(HttpStatus.CREATED).body(configService.save(config));

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateConfig(@PathVariable(value = "id")Long id,@RequestBody @Valid Config config){
        Optional<Config> configOptional = configService.findById(id);
        if(!configOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuração não encontrada");
        }

        var configNovo = configOptional.get();

        configNovo.setValorHora(config.getValorHora());
        configNovo.setValorMinutoMulta(config.getValorMinutoMulta());
        configNovo.setInicioExpediente(config.getInicioExpediente());
        configNovo.setFimExpediente(config.getFimExpediente());
        configNovo.setTempoDeDesconto(config.getTempoDeDesconto());
        //configNovo.setGerarDesconto(config.getGerarDesconto());
        configNovo.setVagasCarro(config.getVagasCarro());
        configNovo.setVagasMoto(config.getVagasMoto());
        configNovo.setVagasVan(config.getVagasVan());


        return ResponseEntity.status(HttpStatus.OK).body(configService.save(config));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteConfig(@PathVariable(value = "id") Long id){
        Optional<Config> configOptional = configService.findById(id);
        if(!configOptional.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(("Configuração não encontrada"));
        }
        configService.delete(configOptional.get());
        return  ResponseEntity.status(HttpStatus.OK).body("Configuração desativada/deletada com sucesso");

    }




    }
