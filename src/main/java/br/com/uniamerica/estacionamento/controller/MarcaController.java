package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Marca;
import br.com.uniamerica.estacionamento.repository.MarcaRepository;
import br.com.uniamerica.estacionamento.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/Marca")
public class MarcaController {

    @Autowired
    private  MarcaRepository marcaRep;
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/{id}")
    public ResponseEntity<Marca> findById(@PathVariable("id") final Long id){
        return ResponseEntity.ok(new Marca());
    }

    @GetMapping("/lista")
    public ResponseEntity <?> ListaCompleta(){
        return ResponseEntity.ok(this.marcaRep.findAll());

    }


}


