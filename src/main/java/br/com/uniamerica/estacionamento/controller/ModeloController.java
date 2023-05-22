package br.com.uniamerica.estacionamento.controller;


import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import br.com.uniamerica.estacionamento.service.ModeloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloRepository modeloRep;
    @Autowired
    final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")  Long id){
        Optional<Modelo> modeloOptional = modeloService.findById(id);
        if(!modeloOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não encontrado");
        }
        return ResponseEntity.ok(modeloService.findById(id));
    }
    @GetMapping("/lista")
    public ResponseEntity <?> getAllModelo(){
        return ResponseEntity.ok(modeloService.findAll());
    }
    @PostMapping
    public ResponseEntity<Object> saveModelo(@RequestBody @Valid Modelo modelo){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(modeloService.save(modelo));
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateModelo(@PathVariable(value = "id")Long id,@RequestBody @Valid Modelo modelo){
        Optional<Modelo> modeloOptional = modeloService.findById(id);
        if(!modeloOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não encontrado");
        }

        var modeloNovo = modeloOptional.get();

        modeloNovo.setNome(modelo.getNome());
        modeloNovo.setMarca(modelo.getMarca());
        return ResponseEntity.status(HttpStatus.OK).body(modeloService.save(modelo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteModelo(@PathVariable(value = "id") Long id){
        Optional<Modelo> modeloOptional = modeloService.findById(id);
        if(!modeloOptional.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(("Modelo não encontrado"));
        }
        modeloService.delete(modeloOptional.get());
        return  ResponseEntity.status(HttpStatus.OK).body("Modelo deletado com sucesso");

    }





}
