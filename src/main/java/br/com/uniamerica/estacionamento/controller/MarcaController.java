package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Marca;
import br.com.uniamerica.estacionamento.repository.MarcaRepository;
import br.com.uniamerica.estacionamento.service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/api/marca")
public class MarcaController {

    @Autowired
    private  MarcaRepository marcaRep;
    @Autowired
    final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")  Long id){
        Optional<Marca> marcaOptional = marcaService.findById(id);
        if(!marcaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada");
        }
        return ResponseEntity.ok(marcaService.findById(id));
    }

    @GetMapping("/lista")
    public ResponseEntity <?> getAllMarca(){
        return ResponseEntity.ok(marcaService.findAll());
    }
    @PostMapping
    public ResponseEntity<Object> saveMarca(@RequestBody @Valid Marca marca){
        //try {
            return ResponseEntity.status(HttpStatus.CREATED).body(marcaService.save(marca));
        //}
        //catch (DataIntegrityViolationException e){
            //return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
       // }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMarca(@PathVariable(value = "id")Long id,@RequestBody @Valid Marca marca){
        Optional<Marca> marcaOptional = marcaService.findById(id);
        if(!marcaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca não encontrada");
        }

        var marcaNovo = marcaOptional.get();
        marcaNovo.setNome(marca.getNome()); //fazer uma validação para o id
        return ResponseEntity.status(HttpStatus.OK).body(marcaService.save(marca));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMarca(@PathVariable(value = "id") Long id){
        Optional<Marca> marcaOptional = marcaService.findById(id);
        if(!marcaOptional.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(("Marca não encontrada"));
        }
        marcaService.delete(marcaOptional.get());
        return  ResponseEntity.status(HttpStatus.OK).body("Marca deletada com sucesso");

    }



}


